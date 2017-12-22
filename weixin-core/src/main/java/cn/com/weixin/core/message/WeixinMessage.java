package cn.com.weixin.core.message;

import java.util.Date;

public class WeixinMessage {
	// 开发者微信号
	private String ToUserName;
	// 发送方帐号（一个OpenID）
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型（text/image/location/link）
	private String MsgType;
	// 消息id，64位整型
	private long MsgId;

	/**
	 * 开发者微信号(原始ID)
	 * @author tanghc
	 * @return
	 */
	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	/**
	 * 发送方帐号（一个OpenID）
	 * @author tanghc
	 * @return
	 */
	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
	
	/**
	 * 获取创建时间,微信服务器传过来的时间是10位,需要在后面加三个0
	 * @author tanghc
	 * @return 
	 */
	public Date fatchCreateTime() {
		return new Date(this.CreateTime * 1000L);
	}

	@Override
	public String toString() {
		return "WeixinMessage [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + ", MsgId=" + MsgId + "]";
	}

}
