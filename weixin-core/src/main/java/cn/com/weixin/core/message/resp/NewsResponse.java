package cn.com.weixin.core.message.resp;

import java.util.List;

import cn.com.weixin.core.message.Article;
import cn.com.weixin.core.message.WeixinResponse;
import cn.com.weixin.core.type.MessageType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 新闻消息回复
 * @author tanghc
 */
@XStreamAlias("xml")
public class NewsResponse extends WeixinResponse {
	// 图文消息个数，限制为10条以内
	private int ArticleCount;
	// 多条图文消息信息，默认第一个item为大图
	private List<Article> Articles;

	public NewsResponse() {
		this.setMsgType(MessageType.news.name());
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

}
