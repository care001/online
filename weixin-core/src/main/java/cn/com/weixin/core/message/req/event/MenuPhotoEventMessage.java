package cn.com.weixin.core.message.req.event;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 弹出拍照或者相册发图的事件推送(pic_sysphoto|pic_photo_or_album|pic_weixin)
 * 
 * @className MenuPhotoEventMessage
 * @author jinyu(foxinmy@gmail.com)
 * @date 2014年9月30日
 * @since JDK 1.6
 * @see <a
 *      href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454&token=&lang=zh_CN">订阅号、服务号的系统发图的事件推送</a>
 * @see <a
 *      href="http://qydev.weixin.qq.com/wiki/index.php?title=%E6%8E%A5%E6%94%B6%E4%BA%8B%E4%BB%B6#.E5.BC.B9.E5.87.BA.E7.B3.BB.E7.BB.9F.E6.8B.8D.E7.85.A7.E5.8F.91.E5.9B.BE.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">企业号的系统发图的事件推送</a>
 */
public class MenuPhotoEventMessage extends MenuEventMessage {


	/**
	 * 发送的图片信息
	 */
	private PictureInfo SendPicsInfo;
	
	public PictureInfo getSendPicsInfo() {
		return SendPicsInfo;
	}

	public void setSendPicsInfo(PictureInfo sendPicsInfo) {
		SendPicsInfo = sendPicsInfo;
	}

	/**
	 * 图片信息
	 * 
	 * @className PictureInfo
	 * @author jinyu(foxinmy@gmail.com)
	 * @date 2015年3月29日
	 * @since JDK 1.6
	 * @see
	 */
	public static class PictureInfo implements Serializable {

		private static final long serialVersionUID = -3361375879168233258L;

		/**
		 * 发送的图片数量
		 */
		private int Count;
		/**
		 * 图片列表
		 */
		@XmlElementWrapper(name = "PicList")
		private List<PictureItem> items;
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			Count = count;
		}
		public List<PictureItem> getItems() {
			return items;
		}
		public void setItems(List<PictureItem> items) {
			this.items = items;
		}

	}

	/**
	 * 图片
	 * 
	 * @className PictureItem
	 * @author jinyu(foxinmy@gmail.com)
	 * @date 2015年3月29日
	 * @since JDK 1.6
	 * @see
	 */
	public static class PictureItem implements Serializable {

		private static final long serialVersionUID = -7636697449096645590L;

		/**
		 * 图片的MD5值，开发者若需要，可用于验证接收到图片
		 */
		private String PicMd5Sum;

		public String getPicMd5Sum() {
			return PicMd5Sum;
		}

		public void setPicMd5Sum(String picMd5Sum) {
			PicMd5Sum = picMd5Sum;
		}
		
	}

}
