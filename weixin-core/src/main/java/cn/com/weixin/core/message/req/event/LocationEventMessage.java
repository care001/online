package cn.com.weixin.core.message.req.event;

/**
 * 上报地理位置事件
 * 
 * @className LocationEventMessage
 * @author jinyu(foxinmy@gmail.com)
 * @date 2014年4月6日
 * @since JDK 1.6
 * @see <a href=
 *      "https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454&token=&lang=zh_CN">
 *      订阅号、服务号的上报地理位置事件</a>
 * @see <a href=
 *      "http://qydev.weixin.qq.com/wiki/index.php?title=%E6%8E%A5%E6%94%B6%E4%BA%8B%E4%BB%B6#.E4.B8.8A.E6.8A.A5.E5.9C.B0.E7.90.86.E4.BD.8D.E7.BD.AE.E4.BA.8B.E4.BB.B6">
 *      企业号的上报地理位置事件</a>
 */
public class LocationEventMessage extends EventMessage {

	/**
	 * 地理位置纬度
	 */
	private double Latitude;
	/**
	 * 地理位置经度
	 */
	private double Longitude;
	/**
	 * 地理位置精度
	 */
	private double Precision;

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public double getPrecision() {
		return Precision;
	}

	public void setPrecision(double precision) {
		Precision = precision;
	}

}
