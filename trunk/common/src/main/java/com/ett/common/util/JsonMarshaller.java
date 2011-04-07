package com.ett.common.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


/**
 * @author jianfeng008cn
 */

public class JsonMarshaller {
	//protected  Log log = LogFactory.getLog(JsonMarshaller.class);
	protected Logger log = Logger.getLogger(this.getClass());

	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static JsonUnMarshaller jsonUnMarshaller = new JsonUnMarshaller();

	private List<String> excludeProperties = new ArrayList<String>();

	public StringBuffer marshall(Object value) {
		if (null != value) {
			log.info("value.getClass():" + value.getClass());
		}
		StringBuffer tmp = new StringBuffer();
		if (value == null) {
			log.info("JsMarshaller:null");
			tmp.append("''");
		} else if (value instanceof Object[]) {
			log.info("JsMarshaller:Object[]");
			Object[] os = (Object[]) value;
			tmp.append("[");
			for (int i = 0; i < os.length; i++) {
				Object obj = os[i];
				tmp.append(this.marshall(obj)).append(',');
			}
			if (tmp.charAt(tmp.length() - 1) == ',') {
				tmp.deleteCharAt(tmp.length() - 1);
			}
			tmp.append("]");
		} else if ((value instanceof Long) || (value instanceof Integer)
				|| (value instanceof Double) || (value instanceof Float)
				|| (value instanceof Byte) || (value instanceof Boolean)) {
			log.info("JsMarshaller:primitive");
			tmp.append(value.toString());
		} else if ((value instanceof String) || (value instanceof StringBuffer)) {
			log.info("JsMarshaller:String||StringBuffer");
			String v=StringUtils.replace(value.toString(), "\\", "\\\\");
			v = StringUtils.replace(v, "\"", "\\\"");
			//String v = StringUtils.replace(value.toString(), "\"", "\\\"");
			//v = StringUtils.replace(v, "\\", "\\\\");			
			tmp.append('\"').append(v).append('\"');

		} else if (value instanceof Collection) {// 包括list和set
			log.info("JsMarshaller:Collection");
			Collection col = (Collection) value;
			Iterator iter = col.iterator();
			tmp.append("[");
			while (iter.hasNext()) {
				Object obj = iter.next();
				tmp.append(this.marshall(obj)).append(',');
			}
			if (tmp.charAt(tmp.length() - 1) == ',') {
				tmp.deleteCharAt(tmp.length() - 1);
			}
			tmp.append("]");
		} else if (value instanceof Map) {
			log.info("JsMarshaller:Map");
			tmp.append('{');
			Map map = (Map) value;
			Iterator keys = map.keySet().iterator();
			while (keys.hasNext()) {
				Object key = keys.next();
				Object v = map.get(key);
				tmp.append(key.toString()).append(':').append(this.marshall(v))
						.append(',');
			}
			if (tmp.charAt(tmp.length() - 1) == ',') {
				tmp.deleteCharAt(tmp.length() - 1);
			}
			tmp.append('}');
			log.info("JsMarshaller:生成的结果为Map＄1�7" + tmp);
			log.info("**********************************");
		} else if (value instanceof Exception) {
			log.info("JsMarshaller:Exception");
			Exception e = (Exception) value;
			StringBuffer t = new StringBuffer();
			t.append(e.getClass().getName()).append(':').append(e.getMessage());
			tmp.append(this.marshall(t));
		} else if (value instanceof java.util.Date) {
			log.info("JsMarshaller:java.util.Date");
			tmp.append('\"').append(format.format(value)).append('\"');
		} else if (value instanceof Calendar) {
			log.info("JsMarshaller:Calendar");
			Calendar c = (Calendar) value;
			tmp.append('\"').append(format.format(c.getTime())).append('\"');
		}/*
		 * else if(value instanceof JSScript){
		 * log.info("JsMarshaller:JSScript"); tmp.append(value.toString()); }
		 */else {
			log.info("JsMarshaller: javabean筄1�7");
			// Collection collection = getPropertyNames(value);
			Map map2 = null;
			if(!value.toString().equals("null")){
				map2 = getPropertyMap(value);				
				tmp.append(this.marshall(map2));			
			}else{
				tmp.append("\" \"");
			}
			log.info("JsMarshaller:生成的结果为javabean等：" + tmp);
			log.info("**********************************");

		}

		return tmp;
	}

	private Map getPropertyMap(Object obj) {

		String className = obj.getClass().getName();
		// 是否被cglib增强过了，如果是，应该取得原始的class
		int p = className.indexOf("$$");
		if (className.indexOf("$$") > 0) {
			className = className.substring(0, p);
		}
		/*
		 * MapStrategy strategy = (MapStrategy) strategies.get(className);
		 * if(strategy!=null){ Collection c= strategy.getMapProperties();
		 * Iterator ite1 = c.iterator(); while(ite1.hasNext()){ String name
		 * =(String) ite1.next(); if(name.equals("class")){ continue; } Object
		 * value = PropertyUtils.getProperty(obj,name); map.put(name,value); }
		 * return map; } //mvc框架相关的东襄1�7 这里先弄掄1�7
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		PropertyDescriptor[] descriptors = PropertyUtils
				.getPropertyDescriptors(obj);
		for (int i = 0; i < descriptors.length; i++) {
			String name = descriptors[i].getName();
			if (name.equals("class")) {
				continue;
			}
			if (null == name) {
				continue;
			}
			if (!this.excludeProperties.isEmpty()
					&& excludeProperties.contains(name)) {
				continue;
			}
			if ("this".equals(name)) {
				continue;
			}
			Object value;
			try {
				value = PropertyUtils.getProperty(obj, name);
				map.put(name, value);
			} catch (IllegalAccessException e) {
				log.error("getPropertyMap:"+ e);
			} catch (InvocationTargetException e) {
				log.error("getPropertyMap:"+ e);
			} catch (NoSuchMethodException e) {
				log.error("getPropertyMap:"+ e);
			}
			
		}
		return map;
	}

	// /前面是marshaller方法，下面的是unmarshaller方法，一般都用第丄1�7丄1�7
	public Object unmarshall(String js) {

		Object obj = jsonUnMarshaller.parse(js);
		// Object obj = (new JsonUnMarshaller()).parse(js);
		return obj;
	}

	public void exclude(String propertyName) {
		this.excludeProperties.add(propertyName);
	}

	public static void main(String[] args) {
		JsonMarshaller marshaller = new JsonMarshaller();
		StringBuffer t = marshaller.marshall("aaaaa\"asdfasd");
		System.out.println(t.toString());
	}
}
