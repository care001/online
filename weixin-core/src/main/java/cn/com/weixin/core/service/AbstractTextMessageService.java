package cn.com.weixin.core.service;

import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.message.req.TextMessage;

public abstract class AbstractTextMessageService extends AbstractMessageService {
	@Override
	public WeixinResponse service(WeixinMessage req) {
		return this.doService((TextMessage)req);
	}
	
	protected abstract WeixinResponse doService(TextMessage reqMessage);
	
}
