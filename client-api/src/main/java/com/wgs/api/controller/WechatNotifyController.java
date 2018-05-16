package com.wgs.api.controller;

import com.dw.ccm.wechat.base.utils.XMLUtils;
import com.wgs.api.service.OrderService;
import com.wgs.dto.wechat.WechatNotifyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@RequestMapping(value = "/pay/wechat")
@Controller
public class WechatNotifyController {

    private static Logger logger = LoggerFactory.getLogger(WechatNotifyController.class);

    @Resource
    private OrderService orderService;

    /**
     * 微信支付后的回调处理
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/notify", method = RequestMethod.POST)
    public WechatNotifyResponse notify(HttpServletRequest request) {
        try {
            Map<String,String> params = XMLUtils.toMap(request.getInputStream());
            orderService.notify(params);
        } catch (Exception e) {
            logger.error("微信支付回调验证出错", e);
            return new WechatNotifyResponse("FAIL", "ok");
        }
        return new WechatNotifyResponse("SUCCESS", "ok");
    }

}
