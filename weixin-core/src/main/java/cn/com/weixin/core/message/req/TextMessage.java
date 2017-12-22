package cn.com.weixin.core.message.req;

import cn.com.weixin.core.message.WeixinMessage;

public class TextMessage extends WeixinMessage {
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "TextMessage [Content=" + Content + ", toString()=" + super.toString() + "]";
	}
	
}
