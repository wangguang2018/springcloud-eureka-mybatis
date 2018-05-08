package com.wgs.eurekaprovider.service.wechat;

import com.wgs.dto.wechat.AccessTokenResponse;
import com.ydd.framework.core.common.utils.HttpUtils;
import com.ydd.framework.core.common.utils.JsonMapper;
import com.ydd.framework.core.exception.ExceptionCodeTemplate;
import com.ydd.framework.core.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WechatService {
    private Logger logger = Logger.getLogger(WechatService.class);

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    /**
     * 微信全局token缓存变量
     */
    public final static String REDIS_ACCESS_TOKEN = "SZPM_ACCESS_TOKEN";


    @Value("${wechat.appId}")
    private String xcxAppId;

    @Value("${wechat.secrectKey}")
    private String xcxSecret;


    /**
     * 通过code获取openid 小程序
     * @param code
     * @return
     */
    public String getXcxOpenId(String code){
        String url = String.format(ACCESS_TOKEN_URL,xcxAppId,xcxSecret, code);
        String result = HttpUtils.get(url);
        AccessTokenResponse response = JsonMapper.nonEmptyMapper().fromJson(result, AccessTokenResponse.class);
        if (StringUtils.isBlank(response.getOpenid())) {
            logger.error("小程序openid获取失败："+result);
            throw new ServiceException(ExceptionCodeTemplate.SERVICE_EXCEPTION);
        } else {
            String openId = response.getOpenid();
            String accessToken = response.getAccess_token();
            return openId;
        }
    }

}
