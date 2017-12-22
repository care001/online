package cn.com.weixin.core.message;

/**
 * 图片消息内容
 * 
 * @author tanghc
 */
public class Image {
	private String MediaId;

	public Image(String mediaId) {
		super();
		MediaId = mediaId;
	}

	public Image() {
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	@Override
	public String toString() {
		return "Image [MediaId=" + MediaId + "]";
	}

}
