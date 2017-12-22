package cn.com.weixin.core.message.resp;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import cn.com.weixin.core.message.Image;
import cn.com.weixin.core.message.WeixinResponse;

/**
 * 图片消息回复对象
 * @author tanghc
 */
@XStreamAlias("xml")
public class ImageResponse extends WeixinResponse {
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

	@Override
	public String toString() {
		return "ImageResponse [Image=" + Image.toString() + ", toString()=" + super.toString() + "]";
	}
	
}
