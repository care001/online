package com.line.onlineweb.weixin.service;

import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.message.req.event.EventMessage;
import cn.com.weixin.core.message.resp.RespMessageFactory;
import cn.com.weixin.core.service.AbstractEventMessageService;
import org.springframework.stereotype.Service;

/**
 * 事件消息处理
 */
@Service
public class EventMessageService extends AbstractEventMessageService{

	@Override
	protected WeixinResponse doService(EventMessage reqMessage) {
		if(reqMessage.getEventKey().equals("NBD_YJFK")){
			return RespMessageFactory.buildTextResponse("您好，意见反馈请直接微信回复",reqMessage);
		}
		return null;
	}

	

}
