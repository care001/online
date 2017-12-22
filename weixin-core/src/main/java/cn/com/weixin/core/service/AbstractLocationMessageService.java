package cn.com.weixin.core.service;

import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.message.req.LocationMessage;

public abstract class AbstractLocationMessageService extends AbstractMessageService {
	@Override
	public WeixinResponse service(WeixinMessage req) {
		return this.doService((LocationMessage)req);
	}
	
	protected abstract WeixinResponse doService(LocationMessage reqMessage);
	
}
