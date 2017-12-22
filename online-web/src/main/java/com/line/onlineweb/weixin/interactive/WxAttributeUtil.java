package com.line.onlineweb.weixin.interactive;



/**
 * @author qianjia
 * */

public class WxAttributeUtil {
	public static AccessTokenConfig accessTokenConfig;

	static{
		accessTokenConfig = new AccessTokenConfig();
	}

	public static AccessTokenConfig getAccessToken(){
		if(!accessTokenConfig.checkAccessToken()){
			accessTokenConfig.updateAccessToken();
		}
		return accessTokenConfig;
		
	}

}
