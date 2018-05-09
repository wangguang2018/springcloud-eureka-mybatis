package com.wgs.dto.wechat;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 客户端签名参数返回对象
 * <p>
 * Created by peakren on 9/28/16.
 */
public class OrderPaySignResponse {


    private Integer isBalanceEnough;

    private String orderSn;


    private WechatPayParam wechatPayParam;


    private AlipayPayParam alipayPayParam;


    @JsonProperty("is_balance_enough")
    public Integer getIsBalanceEnough() {
        return isBalanceEnough;
    }

    public void setIsBalanceEnough(Integer isBalanceEnough) {
        this.isBalanceEnough = isBalanceEnough;
    }


    @JsonProperty("order_sn")
    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }


    @JsonProperty("wechatpay")
    public WechatPayParam getWechatPayParam() {
        return wechatPayParam;
    }

    public void setWechatPayParam(WechatPayParam wechatPayParam) {
        this.wechatPayParam = wechatPayParam;
    }


    @JsonProperty("alipay")
    public AlipayPayParam getAlipayPayParam() {
        return alipayPayParam;
    }

    public void setAlipayPayParam(AlipayPayParam alipayPayParam) {
        this.alipayPayParam = alipayPayParam;
    }

    /**
     * 支付宝支付参数
     */
    public static class AlipayPayParam {


        private String appAuthToken;

        private String appId;

        private String bizContent;

        private String charset;

        private String dataFormat;

        private String method;

        private String notifyUrl;

        private String sign;

        private String signType;

        private String timestamp;

        private String version;


        @JsonProperty("app_auth_token")
        public String getAppAuthToken() {
            return appAuthToken;
        }

        public void setAppAuthToken(String appAuthToken) {
            this.appAuthToken = appAuthToken;
        }

        @JsonProperty("app_id")
        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }


        @JsonProperty("biz_content")
        public String getBizContent() {
            return bizContent;
        }

        public void setBizContent(String bizContent) {
            this.bizContent = bizContent;
        }


        @JsonProperty("charset")
        public String getCharset() {
            return charset;
        }

        public void setCharset(String charset) {
            this.charset = charset;
        }


        @JsonProperty("format")
        public String getDataFormat() {
            return dataFormat;
        }

        public void setDataFormat(String dataFormat) {
            this.dataFormat = dataFormat;
        }


        @JsonProperty("method")
        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }


        @JsonProperty("notify_url")
        public String getNotifyUrl() {
            return notifyUrl;
        }

        public void setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
        }


        @JsonProperty("sign")
        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }


        @JsonProperty("sign_type")
        public String getSignType() {
            return signType;
        }

        public void setSignType(String signType) {
            this.signType = signType;
        }


        @JsonProperty("timestamp")
        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }


        @JsonProperty("version")
        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }


    /**
     * 微信支付的签名参数
     * <p>
     * Created by peakren on 9/28/16.
     */
    public static class WechatPayParam {

        private String appId;

        private String nonceStr;

        private String signPackage;

        private String partnerId;

        private String paySign;

        private String prepayId;

        private String signType;

        private String timeStamp;
        private String mwebUrl;


        @JsonProperty("app_id")
        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }


        @JsonProperty("nonce_str")
        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }


        @JsonProperty("package")
        public String getSignPackage() {
            return signPackage;
        }

        public void setSignPackage(String signPackage) {
            this.signPackage = signPackage;
        }

        @JsonProperty("partner_id")
        public String getPartnerId() {
            return partnerId;
        }

        public void setPartnerId(String partnerId) {
            this.partnerId = partnerId;
        }


        @JsonProperty("pay_sign")
        public String getPaySign() {
            return paySign;
        }

        public void setPaySign(String paySign) {
            this.paySign = paySign;
        }


        @JsonProperty("prepay_id")
        public String getPrepayId() {
            return prepayId;
        }

        public void setPrepayId(String prepayId) {
            this.prepayId = prepayId;
        }


        @JsonProperty("sign_type")
        public String getSignType() {
            return signType;
        }

        public void setSignType(String signType) {
            this.signType = signType;
        }


        @JsonProperty("time_stamp")
        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }


        @JsonProperty("mweb_url")
        public String getMwebUrl() {
            return mwebUrl;
        }

        public void setMwebUrl(String mwebUrl) {
            this.mwebUrl = mwebUrl;
        }
    }
}
