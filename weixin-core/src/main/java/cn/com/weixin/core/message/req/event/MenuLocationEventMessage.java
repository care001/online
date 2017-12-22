package cn.com.weixin.core.message.req.event;

import java.io.Serializable;

/**
 * 弹出地理位置选择器的事件推送
 * 
 * @className MenuLocationEventMessage
 * @author jinyu(foxinmy@gmail.com)
 * @date 2014年9月30日
 * @since JDK 1.6
 * @see <a
 *      href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454&token=&lang=zh_CN">订阅号、服务号的弹出地理位置选择事件推送</a>
 * @see <a
 *      href="http://qydev.weixin.qq.com/wiki/index.php?title=%E6%8E%A5%E6%94%B6%E4%BA%8B%E4%BB%B6#.E5.BC.B9.E5.87.BA.E5.9C.B0.E7.90.86.E4.BD.8D.E7.BD.AE.E9.80.89.E6.8B.A9.E5.99.A8.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">企业号的弹出地理位置选择事件推送</a>
 */
public class MenuLocationEventMessage extends MenuEventMessage {

	/**
	 * 发送的位置消息
	 */
	private LocationInfo SendLocationInfo;
	
	public LocationInfo getSendLocationInfo() {
		return SendLocationInfo;
	}

	public void setSendLocationInfo(LocationInfo sendLocationInfo) {
		SendLocationInfo = sendLocationInfo;
	}

	/**
	 * 地理位置信息
	 * 
	 * @className LocationInfo
	 * @author jinyu(foxinmy@gmail.com)
	 * @date 2015年3月29日
	 * @since JDK 1.6
	 * @see
	 */
	public static class LocationInfo implements Serializable {

		private static final long serialVersionUID = 4904181780216819965L;

		/**
		 * 地理位置维度
		 */
		private double Location_X;
		/**
		 * 地理位置经度
		 */
		private double Location_Y;
		/**
		 * 地图缩放大小
		 */
		private double Scale;
		/**
		 * 地理位置信息
		 */
		private String Label;
		/**
		 * 朋友圈POI的名字，可能为空
		 */
		private String Poiname;
		public double getLocation_X() {
			return Location_X;
		}
		public void setLocation_X(double location_X) {
			Location_X = location_X;
		}
		public double getLocation_Y() {
			return Location_Y;
		}
		public void setLocation_Y(double location_Y) {
			Location_Y = location_Y;
		}
		public double getScale() {
			return Scale;
		}
		public void setScale(double scale) {
			Scale = scale;
		}
		public String getLabel() {
			return Label;
		}
		public void setLabel(String label) {
			Label = label;
		}
		public String getPoiname() {
			return Poiname;
		}
		public void setPoiname(String poiname) {
			Poiname = poiname;
		}
		
	}
}
