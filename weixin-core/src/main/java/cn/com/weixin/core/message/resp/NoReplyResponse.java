package cn.com.weixin.core.message.resp;

import cn.com.weixin.core.message.WeixinResponse;

public class NoReplyResponse extends WeixinResponse {

	private static final NoReplyResponse instance = new NoReplyResponse();

	private NoReplyResponse() {
	}

	public static NoReplyResponse get() {
		return instance;
	}

}
