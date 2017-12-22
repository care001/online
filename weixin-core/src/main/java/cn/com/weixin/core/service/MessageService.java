package cn.com.weixin.core.service;

import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.WeixinResponse;

public interface MessageService {
	WeixinResponse service(WeixinMessage reqMessage);
}
