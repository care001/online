package cn.com.weixin.core.message.req;

import cn.com.weixin.core.message.Music;
import cn.com.weixin.core.message.WeixinMessage;

public class MusicMessage extends WeixinMessage {
    // 音乐  
    private cn.com.weixin.core.message.Music Music;
  
    public Music getMusic() {  
        return Music;  
    }  
  
    public void setMusic(Music music) {  
        Music = music;  
    }  
}  