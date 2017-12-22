package cn.com.weixin.core.util;

import java.io.Writer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XmlUtil {
	private static final String CDATA_START = "<![CDATA[";
	private static final String CDATA_END = "]]>";

	private static final Map<String, XStream> xstreamObj = new ConcurrentHashMap<String, XStream>();
	private static final Object lock = new Object();


	/**
	 * 将对象转成xml字符串
	 * 
	 * @author tanghc
	 * @param obj 对象支持XStream注解
	 * @return
	 */
	public static String toXML(Object obj) {
		XStream xstream = getXStream(obj.getClass());

		return xstream.toXML(obj);
	}
	
	/**
	 * 获取xstream对象
	 * @author tanghc
	 * @param clazz 对指定Class解析注解
	 * @return
	 */
	public static XStream getXStream(Class<?> clazz) {
		String key = clazz.getName();
		XStream xstream = xstreamObj.get(key);
		if (xstream == null) {
			synchronized (lock) {
				xstream = xstreamObj.get(key);
				if (xstream == null) {
					xstream = createXStream(true);
					// 解析注解
					if (clazz != null) {
						xstream.processAnnotations(clazz);
					}
					xstreamObj.put(key, xstream);
				}
			}
		}
		return xstream;
	}

	/**
	 * 创建XStream
	 * @author tanghc
	 * @param isCDATA xml节点是否被{@literal <![CDATA[ ]]> }包裹,如:<br>
	 * <pre>
	 * {@literal
	 * <xml>
		  <ToUserName><![CDATA[sdfsdfdf]]></ToUserName>
		  <FromUserName><![CDATA[fromuser]]></FromUserName>
		  <CreateTime><![CDATA[1482198258210]]></CreateTime>
		  <MsgType><![CDATA[text]]></MsgType>
		  <FuncFlag><![CDATA[0]]></FuncFlag>
		  <Content><![CDATA[aa]]></Content>
		</xml>
	 * }
	 * 
	 * </pre>
	 * @return
	 */
	public static XStream createXStream(final boolean isCDATA) {
		XStream xstream = new XStream(new XppDriver() {
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out) {

					private boolean cdata = isCDATA;

					protected void writeText(QuickWriter writer, String text) {
						if (cdata) {
							writer.write(CDATA_START);
							writer.write(text);
							writer.write(CDATA_END);
						} else {
							writer.write(text);
						}
					}
				};
			}
		});

		return xstream;
	}

}
