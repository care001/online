package cn.com.weixin.core.message.req.event;

import cn.com.weixin.core.message.WeixinMessage;

/**
 * 事件消息对象
 * @author tanghc
 */
public class EventMessage extends WeixinMessage {

	// 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
	private String Event;
	private String EventKey;
	private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	/**
	 * // 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
	 * @author tanghc
	 * @return
	 */
	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	@Override
	public String toString() {
		return "EventMessage [Event=" + Event + ", EventKey=" + EventKey + ", Ticket=" + Ticket + ", toString()="
				+ super.toString() + "]";
	}

}
