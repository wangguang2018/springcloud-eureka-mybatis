package com.wgs.eurekaprovider.service.wechat;

import com.dw.ccm.wechat.base.pay.CommonUtils;
import com.dw.ccm.wechat.base.pay.WeChatPayHelper;
import com.dw.ccm.wechat.base.pay.response.OrderResponse;
import com.dw.ccm.wechat.base.utils.XMLUtils;
import com.google.common.collect.Maps;
import com.wgs.dto.wechat.AccessTokenResponse;
import com.wgs.dto.wechat.OrderPaySignResponse;
import com.wgs.entity.Member;
import com.wgs.entity.Order;
import com.wgs.entity.enums.OrderStatusEnum;
import com.wgs.eurekaprovider.service.member.MemberService;
import com.wgs.eurekaprovider.service.order.OrderService;
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
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

import static com.wgs.entity.exception.ExceptionCodeTemplate.SERVER_ERROR;

@Service
public class WechatService extends BaseServiceImpl {
    private Logger logger = Logger.getLogger(WechatService.class);

    //小程序登录 获取信息url
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    /**
     * 微信全局token缓存变量
     */
    public final static String REDIS_ACCESS_TOKEN = "SZPM_ACCESS_TOKEN";

    @Resource
    private MemberService memberService;

    @Resource
    private OrderService orderService;


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
     *
     * @param code
     * @return
     */
    public String getXcxOpenId(String code) {
        String url = String.format(ACCESS_TOKEN_URL, xcxAppId, xcxSecret, code);
        String result = HttpUtils.get(url);
        AccessTokenResponse response = JsonMapper.nonEmptyMapper().fromJson(result, AccessTokenResponse.class);
        if (StringUtils.isBlank(response.getOpenid())) {
            logger.error("小程序openid获取失败：" + result);
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
            weChatPayHelper.setMchId(mchId);
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
            } else if ("MWEB".equalsIgnoreCase(tradeType)) {
                weChatPayHelper.setParameter("scene_info", "{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \"http://h5.toy.ydd100.cn\",\"wap_name\": \"娃娃机\"}}");
            }
            logger.info("统一订单请求参数" + ToStringBuilder.reflectionToString(weChatPayHelper));
            // 调用统一下单接口
            OrderResponse response = weChatPayHelper.unifiedOrder();

            // 记录统一下单接口返回
            logger.info(ToStringBuilder.reflectionToString(response));

            if (response.isSuccess()) {
                wechatPayParam = this.createGzhBizPackage(response);
                logger.info("返回的结果为：" + ToStringBuilder.reflectionToString(wechatPayParam));
            } else {
                logger.error("返回的结果为："+ToStringBuilder.reflectionToString(response));
                throw new RuntimeException("统一支付订单创建失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        param.put("appId", xcxAppId);
        param.put("nonceStr", CommonUtils.CreateNonceStr(30));
        param.put("package", "prepay_id=" + response.getPrepayId());
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

    public void notify(Map<String,String> params ) throws IOException {
        logger.info("微信回调参数:" + JsonMapper.nonNullMapper().toJson(params));
        // 读取输入流
        if (params.get("return_code").equals("SUCCESS")) {
            if (params.get("result_code").equals("SUCCESS")) {
                String orderSn = params.get("out_trade_no");
                Order order = orderService.findByOrderSn(orderSn,null);
                if (order.getStatus().intValue() >= OrderStatusEnum.PENDING_RECEIVED.value.intValue()) {
                    //已支付 不需要在判断
                    return;
                }
                if (!checkWxXml(params)) {
                    return;
                }
                String outTradeSn = params.get("transaction_id");
                orderService.paySuccess(order.getId(),outTradeSn);
            }
        }
    }


    private boolean checkWxXml( Map<String,String> params) throws IOException {
        String signFromAPIResponse = params.get("sign").toString();
        if (signFromAPIResponse == "" || signFromAPIResponse == null) {
            logger.info("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
            return false;
        }
        //清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
        params.put("sign", "");
        String signForAPIResponse = getSign(params);
        logger.info("签名验证后的sign:"+signForAPIResponse+"  微信回调传入的sign:"+signFromAPIResponse);
        if (!signForAPIResponse.equalsIgnoreCase(signFromAPIResponse)) {
            logger.info("API返回的数据签名数据不一样，有可能被第三方篡改!!!");
            return false;
        }
        return true;
    }

    private String getSign(Map<String, String> map) {
        SortedMap<String, String> signParams = new TreeMap<>();
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            signParams.put(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        signParams.remove("sign");
        String sign =  CommonUtils.getSign(signParams, key);
        return sign;
    }
}
