package cn.com.weixin.core.message.resp;

import cn.com.weixin.core.message.WeixinResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import cn.com.weixin.core.type.MessageType;

/**
 * 文本消息回复
 * @author tanghc
 */
@XStreamAlias("xml")
public class TextResponse extends WeixinResponse {
	// 回复的消息内容
	private String Content;

	public TextResponse() {
		this.setMsgType(MessageType.text.name());
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
