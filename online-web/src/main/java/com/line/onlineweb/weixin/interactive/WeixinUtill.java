package com.line.onlineweb.weixin.interactive;

import com.line.utils.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class WeixinUtill {
	/**
	 * 获取openId
	 * @author qianjia
	 * 
	 * */
	@Autowired
	private AccessTokenConfig accessToken;

	private static AccessTokenConfig accessTokenConfig;

	@PostConstruct
	private void init(){
		accessTokenConfig = accessToken;
	}

	public static String getOpenId(String code){
		if(!"authdeny".equals(code)){
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
			String param = "appid=" + accessTokenConfig.getAppId() + "&secret=" + accessTokenConfig.getAppSecret()
					+ "&code=" + code + "&grant_type=authorization_code";
			return  BaseUtil.sendGet(url, param);
		}
		return  "";
	}
	/**
	 * 获取微信基本信息
	 * @author qianjia
	 * 
	 * */
	public static String getWeixinInfo(String openId){
		accessTokenConfig.validAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/user/info";
		String param = "access_token=" + accessTokenConfig.getAccessToken() + "&openid=" + openId
				+ "&&lang=zh_CN";
		return  BaseUtil.sendGet(url, param);
	}

	public static String findAppId(){
		return accessTokenConfig.getAppId();
	}

}
