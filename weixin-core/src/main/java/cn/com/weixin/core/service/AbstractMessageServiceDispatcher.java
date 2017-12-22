package cn.com.weixin.core.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.message.resp.NoReplyResponse;
import cn.com.weixin.core.message.resp.RespMessageFactory;
import cn.com.weixin.core.type.MessageType;
import cn.com.weixin.core.util.ResponseUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.weixin.core.message.req.MessageFactory;
import cn.com.weixin.core.util.MessageUtil;

/**
 * 消息转发
 * 
 * @author tanghc
 *
 */
public abstract class AbstractMessageServiceDispatcher {

	protected static Log logger = LogFactory.getLog(AbstractMessageServiceDispatcher.class);
	private Map<String, MessageService> serviceMap = new HashMap<String, MessageService>();

	private AbstractEventMessageService eventMessageService;
	private AbstractImageMessageService imageMessageService;
	private AbstractLinkMessageService linkMessageService;
	private AbstractLocationMessageService locationMessageService;
	private AbstractTextMessageService textMessageService;
	private AbstractVoiceMessageService voiceMessageService;
	
	private Object lock = new Object();
	
	private boolean inited = false;
	
	/**
	 * 处理消息
	 * @author tanghc
	 * @param request
	 * @param response
	 */
	public void processMessage(HttpServletRequest request,HttpServletResponse response) {
		WeixinMessage reqMessage = MessageFactory.build(request);
		
		WeixinResponse weixinResp = this.dispatcher(reqMessage);
		
		if(weixinResp instanceof NoReplyResponse) {
			ResponseUtils.renderText(response, "success");
		}else{
			String xml = MessageUtil.toXML(weixinResp);
			System.out.println(xml);
			ResponseUtils.renderXml(response, xml);
		}
	}

	/**
	 * 处理分发,不同类型的消息使用对应的service去处理
	 * 
	 * @param reqMessage
	 *            消息对象
	 * @return 返回响应消息
	 */
	public WeixinResponse dispatcher(WeixinMessage reqMessage) {
		logger.info("dispatcher收到微信消息:" + reqMessage.toString());
		
		init();
		this.fireMsg(reqMessage);
		
		WeixinResponse baseRespMessage = null;
		String msgType = reqMessage.getMsgType();
		MessageService messageService = serviceMap.get(msgType);

		if (messageService != null) {
			baseRespMessage = messageService.service(reqMessage);
		} else {
			baseRespMessage = buildTextResponse("请求处理异常，请稍候尝试！", reqMessage);
		}
		
		return baseRespMessage;
	}
	
	/**
	 * 处理用户消息
	 * @author tanghc
	 * @param reqMessage
	 */
	protected void fireMsg(WeixinMessage reqMessage) {
		
	}
	
	private void init() {
		if(!this.inited) {
			synchronized (lock) {
				if(!this.inited) {
					serviceMap.put(MessageType.event.name(), eventMessageService);
					serviceMap.put(MessageType.image.name(), imageMessageService);
					serviceMap.put(MessageType.link.name(), linkMessageService);
					serviceMap.put(MessageType.location.name(), locationMessageService);
					serviceMap.put(MessageType.text.name(), textMessageService);
					serviceMap.put(MessageType.voice.name(), voiceMessageService);
					
					this.inited = true;
				}
			}
		}
	}

	private WeixinResponse buildTextResponse(String error, WeixinMessage reqMessage) {
		return RespMessageFactory.buildTextResponse(error, reqMessage);
	}

	public AbstractEventMessageService getEventMessageService() {
		return eventMessageService;
	}

	public void setEventMessageService(AbstractEventMessageService eventMessageService) {
		this.eventMessageService = eventMessageService;
	}

	public AbstractImageMessageService getImageMessageService() {
		return imageMessageService;
	}

	public void setImageMessageService(AbstractImageMessageService imageMessageService) {
		this.imageMessageService = imageMessageService;
	}

	public AbstractLinkMessageService getLinkMessageService() {
		return linkMessageService;
	}

	public void setLinkMessageService(AbstractLinkMessageService linkMessageService) {
		this.linkMessageService = linkMessageService;
	}

	public AbstractLocationMessageService getLocationMessageService() {
		return locationMessageService;
	}

	public void setLocationMessageService(AbstractLocationMessageService locationMessageService) {
		this.locationMessageService = locationMessageService;
	}

	public AbstractTextMessageService getTextMessageService() {
		return textMessageService;
	}

	public void setTextMessageService(AbstractTextMessageService textMessageService) {
		this.textMessageService = textMessageService;
	}

	public AbstractVoiceMessageService getVoiceMessageService() {
		return voiceMessageService;
	}

	public void setVoiceMessageService(AbstractVoiceMessageService voiceMessageService) {
		this.voiceMessageService = voiceMessageService;
	}

}
