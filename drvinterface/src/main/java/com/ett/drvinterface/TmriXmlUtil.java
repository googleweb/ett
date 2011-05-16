package com.ett.drvinterface;

import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;


/**
 * @author austin
 * 接口xml转换的类
 */
public class TmriXmlUtil {
	
	public static String encodeUTF8(String xmlDoc)
	{
		String result="";
		try
		{
			result=URLEncoder.encode(xmlDoc,"utf-8");
			
		}
		catch(Exception ex)
		{
			result=ex.toString();
		}
		return result;
	}
	
	public static String decodeUTF8(String str)
	{
		String result="";
		try
		{
			result=URLDecoder.decode(str,"utf-8");
		}
		catch(Exception ex)
		{
			result=ex.toString();
		}
		return result;
	}
	
	
	public static String getXMLFileHead()
	{
	  return "<?xml version=\"1.0\" encoding=\"GBK\"?>\n<root>\n";
	}
	public static String getXMLFileFoot()
	{
		return "</root>";
	}
	
	/**
	 * @param bean
	 * @param itemName
	 * @param itemId
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static String bean2XMLUTF8(Object bean,String itemName,String itemId) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		StringBuffer sb=new StringBuffer();
		Map p=BeanUtils.describe(bean);
		Set s=p.keySet();
		Iterator i=s.iterator();
		sb.append("<");
		sb.append(itemName);
		if(itemId==null||"".equals(itemId))
		{
			sb.append(">");
		}
		else
		{
			sb.append(" id=\"");
			sb.append(itemId);
			sb.append("\">");
		}
		while(i.hasNext())
		{
			Object key=i.next();
			if(key.equals("class")){}
			else
			{
				Object value=p.get(key);
				sb.append("\n  <");
				sb.append(key);
				sb.append(">");
				if(value==null||"".equals(value.toString()))
				{
					sb.append("");
				}
				else
				{
					value=encodeUTF8(value.toString());
					sb.append(value);
				}
				sb.append("</");
				sb.append(key);
				sb.append(">");
			}
		}
		sb.append("\n</");
		sb.append(itemName);
		sb.append(">\n");
		return sb.toString();
	}

}
