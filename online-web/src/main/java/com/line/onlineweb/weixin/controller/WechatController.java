package com.line.onlineweb.weixin.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.req.MessageFactory;
import cn.com.weixin.core.support.WeixinServiceController;
import cn.com.weixin.core.util.MessageUtil;
import cn.com.weixin.core.util.SignUtil;
import com.line.onlineweb.weixin.service.MainMessageServiceDispatcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 微信公众平台
 */
@Controller
public class WechatController extends WeixinServiceController<MainMessageServiceDispatcher> {
    // 提供给微信公众平台的token
    @Value("${weixin.token}")
    private String TOKEN;

    /**
     * 处理微信服务器发来的验证请求
     *
     * @param
     * @return 验证成功返回随机字符串
     */
    @RequestMapping(value = "wechat.do", method = RequestMethod.GET
            // 这句一定要加,如果不加默认会返回Content-Type=text/html导致token认证失败
            , produces = "text/plain")
    public @ResponseBody String validate(HttpServletRequest request) {
        return SignUtil.validateSignature(request, TOKEN);
    }

    /**
     * 处理微信服务器发来的请求
     *
     * @return 返回响应消息
     */
    @RequestMapping(value = "nbdservice.do", method = RequestMethod.POST)
    public @ResponseBody
    Object service(HttpServletRequest request) {
        Map<String, String> xmlMap = MessageUtil.parseXml(request);

        WeixinMessage reqMessage = MessageFactory.build(xmlMap);

        return this.getMessageServiceDispatcher().dispatcher(reqMessage);
    }


}
