package cn.com.weixin.core.service;

import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.message.req.event.EventMessage;

public abstract class AbstractEventMessageService extends AbstractMessageService {
	@Override
	public WeixinResponse service(WeixinMessage req) {
		return this.doService((EventMessage)req);
	}
	
	protected abstract WeixinResponse doService(EventMessage reqMessage);
	
}
