package cn.com.weixin.core.message.req;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.req.event.EventMessage;
import cn.com.weixin.core.type.MessageType;
import cn.com.weixin.core.util.MessageUtil;
import cn.com.weixin.core.util.ReflectionUtils;

/**
 * 微信消息工厂,根据微信发来的请求构建不同的消息
 */
public class MessageFactory {
	
	private static final String MSG_TYPE_NAME = "MsgType";
	private static Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
	
	static {
		classMap.put(MessageType.text.name(), TextMessage.class);
		classMap.put(MessageType.image.name(), ImageMessage.class);
		classMap.put(MessageType.link.name(), LinkMessage.class);
		classMap.put(MessageType.location.name(), LocationMessage.class);
		classMap.put(MessageType.voice.name(), VoiceMessage.class);
		classMap.put(MessageType.event.name(), EventMessage.class);
	}
	
	public static <T extends WeixinMessage> T build(Class<T> clazz,
                                                    Map<String, String> xmlMap) {
		return ReflectionUtils.convertMap2Obj(clazz, xmlMap);
	}
	
	/**
	 * 将微信发来的请求解析成消息对象
	 * @author tanghc
	 * @param request
	 * @return
	 */
	public static WeixinMessage build(HttpServletRequest request) {
		Map<String, String> xmlMap = MessageUtil.parseXml(request);
		return build(xmlMap);
	}
	
	/**
	 * 将微信发来的请求解析成消息对象
	 * @param xmlMap
	 * @return 返回消息对象
	 */
	public static WeixinMessage build(Map<String, String> xmlMap) {
		String msgType = xmlMap.get(MSG_TYPE_NAME);
		Class<?> clazz = classMap.get(msgType);
		return (WeixinMessage) ReflectionUtils.convertMap2Obj(clazz, xmlMap);
	}
	
}
