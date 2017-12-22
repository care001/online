package cn.com.weixin.core.message.req.event;

import java.io.Serializable;

/**
 * 扫码推事件(scancode_push|scancode_waitmsg)
 * 
 * @className MenuScanEventMessage
 * @author jinyu(foxinmy@gmail.com)
 * @date 2014年9月30日
 * @since JDK 1.6
 * @see <a href=
 *      "https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454&token=&lang=zh_CN">
 *      订阅号、服务号的扫码推事件</a>
 * @see <a href=
 *      "http://qydev.weixin.qq.com/wiki/index.php?title=%E6%8E%A5%E6%94%B6%E4%BA%8B%E4%BB%B6#.E6.89.AB.E7.A0.81.E6.8E.A8.E4.BA.8B.E4.BB.B6.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">
 *      企业号的的扫码推事件</a>
 */
public class MenuScanEventMessage extends MenuEventMessage {

	/**
	 * 扫描信息
	 */
	private ScanInfo ScanCodeInfo;

	public ScanInfo getScanCodeInfo() {
		return ScanCodeInfo;
	}

	public void setScanCodeInfo(ScanInfo scanCodeInfo) {
		ScanCodeInfo = scanCodeInfo;
	}

	/**
	 * 扫描信息
	 * 
	 * @className ScanInfo
	 * @author jinyu(foxinmy@gmail.com)
	 * @date 2015年3月29日
	 * @since JDK 1.6
	 * @see
	 */
	public static class ScanInfo implements Serializable {

		private static final long serialVersionUID = 2237570238164900421L;
		/**
		 * 扫描类型，一般是qrcode
		 */
		private String ScanType;
		/**
		 * 扫描结果，即二维码对应的字符串信息
		 */
		private String ScanResult;

		public String getScanType() {
			return ScanType;
		}

		public void setScanType(String scanType) {
			ScanType = scanType;
		}

		public String getScanResult() {
			return ScanResult;
		}

		public void setScanResult(String scanResult) {
			ScanResult = scanResult;
		}
	}

}
