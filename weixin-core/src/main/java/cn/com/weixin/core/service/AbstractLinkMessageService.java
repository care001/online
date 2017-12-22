package cn.com.weixin.core.service;

import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.message.req.LinkMessage;

public abstract class AbstractLinkMessageService extends AbstractMessageService {
	@Override
	public WeixinResponse service(WeixinMessage req) {
		return this.doService((LinkMessage)req);
	}
	
	protected abstract WeixinResponse doService(LinkMessage reqMessage);
	
}
