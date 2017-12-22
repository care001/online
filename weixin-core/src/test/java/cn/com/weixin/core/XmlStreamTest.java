package cn.com.weixin.core;

import java.util.ArrayList;
import java.util.List;

import cn.com.weixin.core.message.Article;
import cn.com.weixin.core.message.resp.ImageResponse;
import org.junit.Test;

import cn.com.weixin.core.message.Image;
import cn.com.weixin.core.message.WeixinMessage;
import cn.com.weixin.core.message.resp.NewsResponse;
import cn.com.weixin.core.message.resp.RespMessageFactory;
import cn.com.weixin.core.message.resp.TextResponse;
import cn.com.weixin.core.type.MessageType;
import cn.com.weixin.core.util.MessageUtil;
import junit.framework.TestCase;

public class XmlStreamTest extends TestCase {
	
	@Test
	public void testXml() {
		TextResponse response = new TextResponse();
		response.setContent("aa");
		response.setCreateTime(System.currentTimeMillis());
		response.setFromUserName("fromuser");
		response.setMsgType("text");
		response.setToUserName("sdfsdfdf");
		
		System.out.println(MessageUtil.toXML(response));
	}

	@Test
	public void testXmlPrint() {
		
		List<Article> articles = new ArrayList<Article>();
		
		Article article1 = new Article();
		article1.setTitle("新闻标题1");
		article1.setUrl("https://www.baidu.com/");
		article1.setPicUrl("http://img1.sc115.com/uploads/sc/jpg/HD/22/15600.jpg");
		article1.setDescription("新闻描述1");
		
		Article article2 = new Article();
		article2.setTitle("新闻标题1");
		article1.setUrl("https://www.baidu.com/");
		article1.setPicUrl("http://img1.sc115.com/uploads/sc/jpg/HD/22/15600.jpg");
		article2.setDescription("新闻描述1");
		
		
		articles.add(article1);
		articles.add(article2);
		
		NewsResponse newsRsp = RespMessageFactory.buildNewsResponse(articles,articles.size(),new WeixinMessage());
		
		String xml = MessageUtil.toXML(newsRsp);
		
		System.out.println(xml);
		
	}
	
	/*
	 * 回复图片消息
	 * <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[image]]></MsgType>
		<Image>
		<MediaId><![CDATA[media_id]]></MediaId>
		</Image>
		</xml>
	 */
	@Test
	public void testXmlPrint2() {
		Image image = new Image();
		image.setMediaId("media_id");
		
		ImageResponse resp = new ImageResponse();
		resp.setCreateTime(System.currentTimeMillis());
		resp.setFromUserName("fromUser");
		resp.setFuncFlag(0);
		resp.setImage(image);
		resp.setMsgType(MessageType.image.name());
		resp.setToUserName("toUsername");
		
		String xml = MessageUtil.toXML(resp);
		
		System.out.println(xml);
	}

}
