package cn.com.weixin.core.message.resp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.weixin.core.message.Article;
import cn.com.weixin.core.message.Image;
import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.type.MessageType;

/**
 * 消息回复工厂类
 * 
 * @author tanghc
 */
public class RespMessageFactory {

	private static Map<Class<?>, MessageType> msgTypeMap = new HashMap<Class<?>, MessageType>();
	static {
		msgTypeMap.put(TextResponse.class, MessageType.text);
		msgTypeMap.put(NewsResponse.class, MessageType.news);
		msgTypeMap.put(ImageResponse.class, MessageType.image);
		msgTypeMap.put(MusicResponse.class, MessageType.music);
	}
	
	/**
	 * 构建无回复响应.<br>
	 * 返回此对象,用户将不会收到服务器的回复
	 * @author tanghc
	 * @param req
	 * @return
	 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140543&token=&lang=zh_CN">被动回复用户消息</a>
	 */
	public static WeixinResponse buildNoReplyResponse() {
		return NoReplyResponse.get();
	}

	/**
	 * 构建文本消息
	 * 
	 * @param text
	 *            文本内容
	 * @param req
	 * @return
	 */
	public static TextResponse buildTextResponse(String text, WeixinMessage req) {
		TextResponse respMessage = buildTextResponse(req);
		respMessage.setContent(text);
		return respMessage;
	}

	/**
	 * 构建文本消息回复
	 * 
	 * @author tanghc
	 * @param mediaId
	 *            图片mediaId
	 * @param req
	 *            微信消息请求
	 * @return ImageResponse对象
	 */
	public static ImageResponse buildImageResponse(String mediaId, WeixinMessage req) {
		return buildImageResponse(new Image(mediaId), req);
	}

	/**
	 * 构建文本消息回复
	 * 
	 * @author tanghc
	 * @param image
	 *            图片对象
	 * @param req
	 *            微信消息请求
	 * @return ImageResponse对象
	 */
	public static ImageResponse buildImageResponse(Image image, WeixinMessage req) {
		ImageResponse resp = buildImageResponse(req);
		resp.setImage(image);
		return resp;
	}

	/**
	 * 构建新闻消息
	 * 
	 * @param req
	 * @return
	 */
	public static NewsResponse buildNewsResponse(List<Article> articles, int count, WeixinMessage req) {
		NewsResponse news = build(req, NewsResponse.class);
		news.setArticles(articles);
		news.setArticleCount(count);
		return news;
	}
	

	/**
	 * 构建文本消息
	 * 
	 * @param req
	 * @return
	 */
	private static TextResponse buildTextResponse(WeixinMessage req) {
		return build(req, TextResponse.class);
	}

	/**
	 * 构建文本消息回复
	 * 
	 * @author tanghc
	 * @param req
	 *            微信消息请求
	 * @return ImageResponse对象
	 */
	private static ImageResponse buildImageResponse(WeixinMessage req) {
		return build(req, ImageResponse.class);
	}

	private static <T extends WeixinResponse> T build(WeixinMessage req, Class<T> clazz) {
		try {
			T resp = clazz.newInstance();
			resp.setToUserName(req.getFromUserName());
			resp.setFromUserName(req.getToUserName());
			resp.setCreateTime(System.currentTimeMillis());
			resp.setMsgType(msgTypeMap.get(clazz).name());
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
