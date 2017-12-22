package cn.com.weixin.core.service;

import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.message.req.ImageMessage;

public abstract class AbstractImageMessageService extends AbstractMessageService {
	@Override
	public WeixinResponse service(WeixinMessage req) {
		return this.doService((ImageMessage)req);
	}
	
	protected abstract WeixinResponse doService(ImageMessage reqMessage);
	
}
