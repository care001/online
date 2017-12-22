package com.line.onlineweb.weixin.service;


import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.message.req.TextMessage;
import cn.com.weixin.core.message.resp.RespMessageFactory;
import cn.com.weixin.core.message.resp.TextResponse;
import cn.com.weixin.core.service.AbstractTextMessageService;
import org.springframework.stereotype.Service;

/**
 * 文本消息处理
 */
@Service
public class TextMessageService extends AbstractTextMessageService {
	
	@Override
	protected WeixinResponse doService(TextMessage reqMessage) {
		TextResponse textMessage = RespMessageFactory.buildTextResponse("这是纽堡迪的文本消息/::)\n您发的文本消息为:" + reqMessage.getContent(),reqMessage);
		
		return textMessage;
	}

}
