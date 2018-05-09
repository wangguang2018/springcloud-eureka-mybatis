package com.wgs.eurekaprovider.service.wechat;

import com.dw.ccm.wechat.base.pay.CommonUtils;
import com.dw.ccm.wechat.base.pay.WeChatPayHelper;
import com.dw.ccm.wechat.base.pay.response.OrderResponse;
import com.google.common.collect.Maps;
import com.wgs.dto.wechat.AccessTokenResponse;
import com.wgs.dto.wechat.OrderPaySignResponse;
import com.wgs.entity.Member;
import com.wgs.eurekaprovider.service.member.MemberService;
import com.ydd.framework.core.common.utils.HttpUtils;
import com.ydd.framework.core.common.utils.JsonMapper;
import com.ydd.framework.core.exception.ExceptionCodeTemplate;
import com.ydd.framework.core.exception.ServiceException;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static com.wgs.entity.exception.ExceptionCodeTemplate.SERVER_ERROR;

@Service
public class WechatService extends BaseServiceImpl{
    private Logger logger = Logger.getLogger(WechatService.class);

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    /**
     * 微信全局token缓存变量
     */
    public final static String REDIS_ACCESS_TOKEN = "SZPM_ACCESS_TOKEN";

    @Resource
    private MemberService memberService;


    @Value("${wechat.appId}")
    private String xcxAppId;
    @Value("${wechat.secrectKey}")
    private String xcxSecret;
    @Value("${wechat.key}")
    private String key;
    @Value("${wechat.mchId}")
    private String mchId;
    @Value("${wechat.cert}")
    private String certPath;
    @Value("${wechat.notifyUrl}")
    private String notifyUrl;



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

    /**
     * 创建微信支付的统一订单
     *
     * @return
     */
    public OrderPaySignResponse.WechatPayParam createUnifiedOrder(String orderSn, BigDecimal money, String ip, String tradeType, Integer memberId) {
        OrderPaySignResponse.WechatPayParam wechatPayParam;
        try {
            // 设置过期时间
            Date current = getCurrentTime();
            Calendar expire = Calendar.getInstance();
            expire.setTime(current);
            expire.add(Calendar.SECOND, 60 * 30);
            Assert.hasText(certPath, "证书找不到");
            String nonceStr = CommonUtils.CreateNonceStr(30);
            WeChatPayHelper weChatPayHelper = new WeChatPayHelper(certPath);
            weChatPayHelper.setAppId(xcxAppId);
            weChatPayHelper.setMchId(key);
            weChatPayHelper.setKey(key);
            weChatPayHelper.setParameter("device_info", "WEB");
            weChatPayHelper.setParameter("nonce_str", nonceStr);
            weChatPayHelper.setParameter("body", "游戏币充值");
            weChatPayHelper.setParameter("detail", "游戏币充值");
            weChatPayHelper.setParameter("out_trade_no", orderSn);
            String payMoney = money.multiply(new BigDecimal(100))
                    .setScale(0, BigDecimal.ROUND_HALF_UP).toString();
            weChatPayHelper.setParameter("total_fee", payMoney); // 微信总金额为分
            weChatPayHelper.setParameter("spbill_create_ip", ip);
            weChatPayHelper.setParameter("time_start", DateFormatUtils.format(current, "yyyyMMddHHmmss"));
            weChatPayHelper.setParameter("time_expire", DateFormatUtils.format(expire.getTime(), "yyyyMMddHHmmss"));
            weChatPayHelper.setParameter("notify_url", notifyUrl);
            weChatPayHelper.setParameter("trade_type", tradeType);

            if ("APP".equals(tradeType)) {

            } else if ("JSAPI".equals(tradeType)) {
                //使用公众号的appid
                Member member = memberService.findById(memberId);
                weChatPayHelper.setAppId(xcxAppId);
                weChatPayHelper.setParameter("openid", member.getXcxOpenId());
            }else if("MWEB".equalsIgnoreCase(tradeType)){
                weChatPayHelper.setParameter("scene_info","{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \"http://h5.toy.ydd100.cn\",\"wap_name\": \"娃娃机\"}}");
            }
            logger.info("统一订单请求参数" + ToStringBuilder.reflectionToString(weChatPayHelper));
            // 调用统一下单接口
            OrderResponse response = weChatPayHelper.unifiedOrder();

            // 记录统一下单接口返回
            logger.info(ToStringBuilder.reflectionToString(response));

            if (response.isSuccess()) {
                wechatPayParam = this.createGzhBizPackage(response);
                logger.info("返回的结果为："+ToStringBuilder.reflectionToString(wechatPayParam));

            } else {
                logger.error(ToStringBuilder.reflectionToString(response));
                throw new RuntimeException("统一支付订单创建失败，请重试！");
            }
        } catch (Exception e) {
            logger.error("创建统一支持订单接口异常", e);
            throw new ServiceException(SERVER_ERROR);
        }
        return wechatPayParam;
    }



    /**
     * 创建客户端需要的支付参数，微信公众号登录
     *
     * @param response
     * @return
     */
    private OrderPaySignResponse.WechatPayParam createGzhBizPackage(OrderResponse response) {
        OrderPaySignResponse.WechatPayParam wechatPayParam = new OrderPaySignResponse.WechatPayParam();
        Map<String, String> param = Maps.newHashMap();
        param.put("appId",xcxAppId);
        param.put("nonceStr", CommonUtils.CreateNonceStr(30));
        param.put("package", "prepay_id="+response.getPrepayId());
        param.put("signType", "MD5");
        param.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
        param.put("paySign", CommonUtils.getSign(param, key));
        wechatPayParam.setAppId(param.get("appId"));
        wechatPayParam.setPrepayId(response.getPrepayId());
        wechatPayParam.setTimeStamp(param.get("timeStamp"));
        wechatPayParam.setPaySign(param.get("paySign"));
        wechatPayParam.setNonceStr(param.get("nonceStr"));
        wechatPayParam.setMwebUrl(response.getMwebUrl());
        wechatPayParam.setSignType("MD5");
        return wechatPayParam;
    }
}
