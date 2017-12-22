package cn.com.weixin.core.message.req.event;

/**
 * 自定义菜单事件(view|click)
 * 
 * @className MenuEventMessage
 * @author jinyu(foxinmy@gmail.com)
 * @date 2014年4月6日
 * @since JDK 1.6
 * @see <a href=
 *      "https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454&token=&lang=zh_CN">
 *      订阅号、服务号的菜单事件</a>
 * @see <a href=
 *      "http://qydev.weixin.qq.com/wiki/index.php?title=%E6%8E%A5%E6%94%B6%E4%BA%8B%E4%BB%B6#.E4.B8.8A.E6.8A.A5.E8.8F.9C.E5.8D.95.E4.BA.8B.E4.BB.B6">
 *      企业号的菜单事件</a>
 */
public class MenuEventMessage extends EventMessage {

	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	private String EventKey;
	/**
	 * 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了。
	 */
	private String MenuID;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getMenuID() {
		return MenuID;
	}

	public void setMenuID(String menuID) {
		MenuID = menuID;
	}

}
