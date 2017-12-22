package com.line.onlineweb.weixin.interactive;


import com.line.utils.BaseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * access token entity
 * @author tom
 * 2015.12.2
 */
@Component
@ConfigurationProperties(prefix="weixin")
public class AccessTokenConfig {
	private static Logger logger = Logger.getLogger(AccessTokenConfig.class);
	
	private SimpleDateFormat sdf=new SimpleDateFormat("MMddHHmmss");

	private  String token;

	private  String appId;

	private  String appSecret;

	private String accessToken;

	private  String requestTime;

	private  Integer sleepTime;

	private  String encodingAESKey;

	private  String partnerid;
	
	public AccessTokenConfig(){
	}

	public String getEncodingAESKey(){
		return encodingAESKey;
	}


	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public Integer getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(Integer sleepTime) {
		this.sleepTime = sleepTime;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getToken(){
		return token;
	}

	public String getAppId(){
		return appId;
	}

	public String getAppSecret(){
		return appSecret;
	}



	public String getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}

	/**
	 * check accesstoken whether or not past due
	 * @return
	 */
	public boolean checkAccessToken(){
		Integer now = Integer.parseInt(sdf.format(new Date()));
		Integer oldTime = Integer.parseInt(requestTime);
		if(now - oldTime >= sleepTime){
			return false;
		}
		return true;
	}

	
	/**
	 * update accesstoken
	 */
	public void updateAccessToken(){
		String url = "https://api.weixin.qq.com/cgi-bin/token";
		String param = "grant_type=client_credential&appid="+appId+"&secret="+appSecret;
		String result = BaseUtil.sendGet(url, param);
		
		String pattern = "(.*)(\"access_token\":\")(.*)(\",\"expires_in\":)(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(result);
		if (m.find()) {
	         accessToken = m.group(3);
	         requestTime = sdf.format(new Date());
	    } else {
	         logger.error("updateAccessToken is failure");
	    }
	}

	public void validAccessToken(){
		if(!this.checkAccessToken()){
			this.updateAccessToken();
		}
	}
	
}
