package com.wgs.eurekaprovider.service.member;

import com.wgs.dto.member.MemberInfoDTO;
import com.wgs.entity.Member;
import com.wgs.entity.MemberToken;
import com.wgs.entity.enums.LiveTime;
import com.wgs.entity.exception.ExceptionCodeTemplate;
import com.wgs.eurekaprovider.service.wechat.WechatService;
import com.wgs.eurekaprovider.util.Md5Util;
import com.wgs.eurekaprovider.util.OSSHelper;
import com.wgs.mapper.MemberMapper;
import com.wgs.mapper.MemberTokenMapper;
import com.ydd.framework.core.exception.ServiceException;
import com.ydd.framework.core.interceptor.AccessTokenInterceptor;
import com.ydd.framework.core.service.CacheService;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * 用户
 */
@Service
public class MemberService extends BaseServiceImpl {

    @Resource
    private MemberTokenMapper memberTokenMapper;

    @Resource
    private WechatService wechatService;

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private CacheService cacheService;


    public static final LiveTime expireTime = LiveTime.DAYS_15;

    /**
     * 小程序登录
     *
     * @param code
     * @param nickname
     * @param avatar
     * @return
     */
    @Transactional
    public MemberToken loginWithXcx(String code, String nickname, String avatar) {
        String openId = wechatService.getXcxOpenId(code);
        if (StringUtils.isEmpty(openId)) {
            throw new ServiceException(ExceptionCodeTemplate.LOGIN_FAILED);
        }
        synchronized (openId.intern()) {
            Member member = memberMapper.findByOpenId(openId);
            if (member == null) {
                //用户不存在注册
                member = register(openId, nickname, avatar);
            }
            return login(member);
        }
    }

    private MemberToken login(Member member) {
        MemberToken token = memberTokenMapper.findByMemberId(member.getId());
        if (token == null) {
            token = new MemberToken();
            token.setCreatedTime(getCurrentTime());
            token.setAccessToken(generateAccessToken(member.getXcxOpenId()));
            token.setMemberId(member.getId());
            token.setRefreshToken(generateRefreshToken(member.getXcxOpenId(), token.getAccessToken()));
            token.setExpireTime(new Date(getCurrentTime().getTime() + expireTime.time));
            memberTokenMapper.insert(token);
        } else {
            token.setMemberId(member.getId());
            cacheService.remove(AccessTokenInterceptor.ACCESS_TOKEN_CACHE_KEY + token.getAccessToken());
            token.setAccessToken(generateAccessToken(member.getXcxOpenId()));
            token.setRefreshToken(generateRefreshToken(member.getXcxOpenId(), token.getAccessToken()));
            token.setExpireTime(new Date(getCurrentTime().getTime() + expireTime.time));
            token.setModifiedTime(getCurrentTime());
            memberTokenMapper.update(token);
        }
        // 保存新的access_token信息到缓存中
        cacheService.setEntity(AccessTokenInterceptor.ACCESS_TOKEN_CACHE_KEY + token.getAccessToken(), member.getId(), expireTime.time);
        return token;
    }

    /**
     * 注册
     *
     * @param openid
     * @param nickname
     * @param avatar
     * @return
     */
    private Member register(String openid, String nickname, String avatar) {
        Member member = new Member();
        member.setAvatar(avatar);
        member.setXcxOpenId(openid);
        member.setNickname(nickname);
        try {
            member.setAvatar(updateWxImgToOss(avatar));
        } catch (Exception e) {
            e.printStackTrace();
        }
        memberMapper.insert(member);
        return member;
    }

    //将微信头像上传到OSS
    public String updateWxImgToOss(String avatar) throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet httpget = new HttpGet(avatar);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1200).build();
        httpget.setConfig(requestConfig);
        HttpResponse response = null;
        response = client.execute(httpget);
        HttpEntity resEntity = response.getEntity();
        InputStream inputStream = resEntity.getContent();
        return OSSHelper.upload(System.currentTimeMillis() + ".png", inputStream);
    }

    /**
     * 通过accessToken获取用户ID
     *
     * @param accessToken
     * @return
     */
    public Integer getMemberIdByAccessToken(String accessToken) {
        Integer id = cacheService.getEntity(AccessTokenInterceptor.ACCESS_TOKEN_CACHE_KEY + accessToken);
        if(id == null)
            throw new ServiceException(com.ydd.framework.core.exception.ExceptionCodeTemplate.INVALID_ACCESS_TOKEN);
        boolean flag = checkMemberValid(id);
        if(!flag){
            throw new ServiceException(ExceptionCodeTemplate.MEMBER_IN_VALID);
        }
        return id;
    }

    private boolean checkMemberValid(Integer memberId){
        Member member = memberMapper.findById(memberId);
        if(member == null)
            throw new ServiceException(com.ydd.framework.core.exception.ExceptionCodeTemplate.INVALID_ACCESS_TOKEN);
        if(member.getStatus().intValue() == 1){
            //用户已经被封禁
            return false;
        }
        return true;
    }

    /**
     * 生成access_token
     *
     * @param openId openId
     * @return access_token
     */
    private String generateAccessToken(String openId) {
        // access_token 生成策略
        // md5(mobile + timestamp)
        return Md5Util.GetMD5Code(openId + System.currentTimeMillis());
    }

    /**
     * 生成置换凭证
     *
     * @param openId      openId
     * @param accessToken 接口调用凭证
     * @return 置换凭证
     */
    private String generateRefreshToken(String openId, String accessToken) {
        return Md5Util.GetMD5Code(accessToken + openId + System.currentTimeMillis());
    }


    public Member findById(Integer memberId) {
        return memberMapper.findById(memberId);
    }

    /**
     * 获取用户信息
     * @param memberId
     * @return
     */
    public MemberInfoDTO findMemberInfo(Integer memberId){
        return memberMapper.findMemberInfo(memberId);
    }
}
