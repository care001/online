package cn.com.weixin.core.message.req;

import cn.com.weixin.core.message.WeixinMessage;

public class ImageMessage extends WeixinMessage {
	// 图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	@Override
	public String toString() {
		return "ImageMessage [PicUrl=" + PicUrl + ", toString()=" + super.toString() + "]";
	}

}
