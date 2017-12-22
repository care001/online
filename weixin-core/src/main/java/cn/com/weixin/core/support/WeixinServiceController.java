package cn.com.weixin.core.support;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.weixin.core.service.AbstractMessageServiceDispatcher;

public abstract class WeixinServiceController<MessageServiceDispatcher extends AbstractMessageServiceDispatcher> {

	private MessageServiceDispatcher messageServiceDispatcher;

	@Autowired
	public void setMessageServiceDispatcher(MessageServiceDispatcher messageServiceDispatcher) {
		this.messageServiceDispatcher = messageServiceDispatcher;
	}

	public MessageServiceDispatcher getMessageServiceDispatcher() {
		return messageServiceDispatcher;
	}

}
