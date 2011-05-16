/**
 * 
 */
package com.austin.base.commons.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wutka.jox.JOXBeanInputStream;
import com.wutka.jox.JOXBeanOutputStream;

/**
 * @author austin
 * 
 */
public class BeanXMLMapping {

	private static final Log log = LogFactory.getLog(BeanXMLMapping.class);

	/**
	 * * Retrieves a bean object for the * received XML and matching bean class
	 */
	public static Object fromXML(String xml, Class className) {
		ByteArrayInputStream xmlData = new ByteArrayInputStream(xml.getBytes());
		JOXBeanInputStream joxIn = new JOXBeanInputStream(xmlData);
		try {
			return (Object) joxIn.readObject(className);
		} catch (IOException exc) {
			log.info("从xml转换成bean失败" + exc.toString());
			return null;
		} finally {
			try {
				xmlData.close();
				joxIn.close();
			} catch (Exception e) {
				log.info("从xml转换成bean失败" + e.toString());
			}
		}
	}

	/**
	 * * Returns an XML document．nbspString for the received bean
	 */
	public static String toXML(Object bean) {
		ByteArrayOutputStream xmlData = new ByteArrayOutputStream();
		JOXBeanOutputStream joxOut = new JOXBeanOutputStream(xmlData);
		try {
			joxOut.writeObject(beanName(bean), bean);
			return xmlData.toString();
		} catch (IOException exc) {
			log.info("从bean转换成xml失败" + exc.toString());
			return null;
		} finally {
			try {
				xmlData.close();
				joxOut.close();
			} catch (Exception e) {
				log.info("从bean转换成xml失败" + e.toString());
			}
		}
	}

	/**
	 * * Find out the bean class name
	 */
	private static String beanName(Object bean) {
		String fullClassName = bean.getClass().getName();
		String classNameTemp = fullClassName.substring(fullClassName
				.lastIndexOf(".") + 1, fullClassName.length());
		return classNameTemp.substring(0, 1) + classNameTemp.substring(1);
	}
}