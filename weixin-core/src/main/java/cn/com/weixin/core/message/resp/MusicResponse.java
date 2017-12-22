package cn.com.weixin.core.message.resp;

import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.type.MessageType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import cn.com.weixin.core.message.Music;

/**
 * 音乐消息回复
 * @author tanghc
 */
@XStreamAlias("xml")
public class MusicResponse extends WeixinResponse {
	// 音乐
	private Music Music;

	public MusicResponse() {
		this.setMsgType(MessageType.music.name());
	}

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

}
