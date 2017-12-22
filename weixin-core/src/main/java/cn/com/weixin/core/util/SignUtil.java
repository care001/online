package cn.com.weixin.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信token验证
 * @author tanghc
 *
 */
public class SignUtil {

	// 微信服务器请求过来的字段名
	private static final String SIGNATURE_NAME = "signature";
	private static final String TIMESTAMP_NAME = "timestamp";
	private static final String NONCE_NAME = "nonce";
	private static final String ECHOSTR_NAME = "echostr";

	/**
	 * 微信服务验证
	 * 
	 * @param request
	 * @param token
	 * @return
	 */
	public static String validateSignature(HttpServletRequest request, String token) {
		// 微信加密签名
		String signature = request.getParameter(SIGNATURE_NAME);
		String timestamp = request.getParameter(TIMESTAMP_NAME);
		String nonce = request.getParameter(NONCE_NAME);
		String echostr = request.getParameter(ECHOSTR_NAME);

		boolean isTrueSign = checkSignature(signature, timestamp, nonce, token);

		return isTrueSign ? echostr : "";
	}

	/**
	 * 验证签名
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce, String token) {
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		String content = sort(token, timestamp, nonce);
		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		String mySignature = encrypt(content);

		// 3. 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
		return compareSignature(mySignature, signature);
	}

	/**
	 * 比较加密传
	 * 
	 * @param mySignature
	 * @param paramSignature
	 * @return
	 */
	private static boolean compareSignature(String mySignature, String paramSignature) {
		if (mySignature == null || "".equals(mySignature)) {
			return false;
		}
		if (paramSignature == null || "".equals(paramSignature)) {
			return false;
		}
		return mySignature.equals(paramSignature.toUpperCase());
	}

	/**
	 * 将token、timestamp、nonce三个参数进行字典序排序
	 * 
	 * @param token
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static String sort(String token, String timestamp, String nonce) {
		String[] arr = new String[] { token, timestamp, nonce };
		// 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arr);

		StringBuilder content = new StringBuilder();
		for (String param : arr) {
			content.append(param);
		}

		return content.toString();
	}

	/**
	 * 将三个参数字符串拼接成一个字符串进行sha1加密
	 * 
	 * @param content
	 * @return
	 */
	public static String encrypt(String content) {
		MessageDigest md = null;
		String retVal = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			retVal = byteToStr(digest);
			return retVal;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}
}
