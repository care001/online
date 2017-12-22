package cn.com.weixin.core.service;

import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.message.req.VoiceMessage;

public abstract class AbstractVoiceMessageService extends AbstractMessageService {
	@Override
	public WeixinResponse service(WeixinMessage req) {
		return this.doService((VoiceMessage)req);
	}
	
	protected abstract WeixinResponse doService(VoiceMessage reqMessage);
	
}
