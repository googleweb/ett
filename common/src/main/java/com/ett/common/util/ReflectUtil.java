/**
 * @(#)ReflectUtil.java create by x_chenbiwu at 2008-3-27 Copyright 2008
 *                      fivemen,Inc. All rights reserved. fivemen
 *                      proprietary/confidential.Use is subject to license terms
 */

package com.ett.common.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;


/**
 * <p>
 * Description:
 * </p>
 * <p>
 * 鏈被鎻愪緵涓�浜涗緵鍙嶅皠璋冪敤鐨勯潤鎬佹柟娉�
 * </p>
 *
 * @author x_chenbiwu
 * @version 1.0
 */
public final class ReflectUtil
{
	
	protected static  final Log log = LogFactory.getLog(ReflectUtil.class);
	
	/**
	 * 閫氳繃鍙嶅皠,鑾峰緱瀹氫箟Class鏃跺０鏄庣殑鐖剁被鐨勮寖鍨嬪弬鏁扮殑绫诲瀷. 濡俻ublic BookManager extends GenricManager<Book>
	 *
	 * @param clazz The class to introspect
	 * @return the first generic declaration, or <code>Object.class</code> if cannot be determined
	 */
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 閫氳繃鍙嶅皠,鑾峰緱瀹氫箟Class鏃跺０鏄庣殑鐖剁被鐨勮寖鍨嬪弬鏁扮殑绫诲瀷. 濡俻ublic BookManager extends GenricManager<Book>
	 *
	 * @param clazz clazz The class to introspect
	 * @param index the Index of the generic ddeclaration,start from 0.
	 * @return the index generic declaration, or <code>Object.class</code> if cannot be determined
	 */
	public static Class getSuperClassGenricType(Class clazz, int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			log.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			log.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
					+ params.length);
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			log.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
			return Object.class;
		}
		return (Class) params[index];
	}
	
	
	/**
	 * @param owner
	 *            瀹炰緥鐨勫璞�
	 * @param fieldName
	 *            瀛楁鍚嶇О
	 * @return 瀛楁鐨勫叿浣撳�煎璞�
	 */
	public static Object getProperty ( Object owner, String fieldName )

	{
		if(owner==null)
		{
			return "";
		}
		Class ownerClass = owner.getClass();
		Object property=null;
		try
		{
			Field field = ownerClass.getField(fieldName);
			
			property = field.get(owner);
		}
		catch (Exception ex)

		{
			log.error(ex);
			//throw ex;
		}
		
		return property;
	}
	
	
	
	/**
	 * @param className 绫诲悕
	 * @param fieldName 瀛楁鍚�
	 * @return 灞炴�у��
	 */
	public static Object getStaticProperty ( String className, String fieldName )

	{
		Object property=null;
		try
		{
			Class ownerClass = Class.forName(className);
			Field field = ownerClass.getField(fieldName);
			property = field.get(ownerClass);
		}
		catch (Exception ex)
		{
			log.error(ex);
		}
		return property;
	}
	
	
	/**
	 * @param owner 瀵硅薄
	 * @param methodName 鏂规硶鍚嶇О
	 * @param args 鍙傛暟鍒楄〃
	 * @return 杩斿洖缁撴灉
	 */
	public static Object invokeMethod ( Object owner, String methodName, Object[] args )

	{
		
		Class ownerClass = owner.getClass();
		
		Class[] argsClass = new Class[args.length];
		
		for (int i = 0, j = args.length; i > j; i++)
		{
			argsClass[i] = args[i].getClass();
		}
		
		try
		{
			Method method = ownerClass.getMethod(methodName, argsClass);
			
			return method.invoke(owner, args);
		}
		catch (Exception ex)
		{
			log.error(ex);
			return null;
		}
		
	}
	
	
	/**
	 * @param className 绫诲悕
	 * @param methodName 闈欐�佹柟娉曞悕绉�
	 * @param args 鍙傛暟鍒楄〃
	 * @return 杩斿洖瀵硅薄
	 */
	public static Object invokeStaticMethod ( String className, String methodName,
			Object[] args )
	{
		try
		{
			Class ownerClass = Class.forName(className);
			
			Class[] argsClass = new Class[args.length];
			
			for (int i = 0, j = args.length; i > j; i++)
			{
				argsClass[i] = args[i].getClass();
			}
			
			Method method = ownerClass.getMethod(methodName, argsClass);
			
			return method.invoke(null, args);
		}
		catch (Exception ex)
		{
			log.error(ex);
			return null;
			
		}
	}
	
	
	/**
	 * @param className 绫诲悕
	 * @param args 鏋勯�犲嚱鏁扮殑鍙傛暟鍒楄〃
	 * @return 瀹炰緥瀵硅薄
	 */
	public static Object newInstance ( String className, Object[] args )

	{
		try
		{
			Class newoneClass = Class.forName(className);
			
			Class[] argsClass = new Class[args.length];
			
			for (int i = 0, j = args.length; i > j; i++)
			{
				argsClass[i] = args[i].getClass();
			}
			
			Constructor cons = newoneClass.getConstructor(argsClass);
			
			return cons.newInstance(args);
		}
		catch (Exception ex)
		{
			log.error(ex);
			return null;
		}
		
	}
	
	/**
	 * 寰幆鍚戜笂杞瀷,鑾峰彇瀵硅薄鐨凞eclaredField.
	 *
	 * @throws NoSuchFieldException 濡傛灉娌℃湁璇ield鏃舵姏鍑�.
	 */
	/**
	 * @param object
	 * @param propertyName
	 * @return
	 * @throws NoSuchFieldException
	 */
	public static Field getDeclaredField(Object object, String propertyName) throws NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);
		return getDeclaredField(object.getClass(), propertyName);
	}

	/**
	 * 寰幆鍚戜笂杞瀷,鑾峰彇瀵硅薄鐨凞eclaredField.
	 *
	 * @throws NoSuchFieldException 濡傛灉娌℃湁璇ield鏃舵姏鍑�.
	 */
	/**
	 * @param clazz
	 * @param propertyName
	 * @return
	 * @throws NoSuchFieldException
	 */
	public static Field getDeclaredField(Class clazz, String propertyName) throws NoSuchFieldException {
		Assert.notNull(clazz);
		Assert.hasText(propertyName);
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(propertyName);
			} catch (NoSuchFieldException e) {
				// Field涓嶅湪褰撳墠绫诲畾涔�,缁х画鍚戜笂杞瀷
			}
		}
		throw new NoSuchFieldException("No such field: " + clazz.getName() + '.' + propertyName);
	}

	/**
	 * 鏆村姏鑾峰彇瀵硅薄鍙橀噺鍊�,蹇界暐private,protected淇グ绗︾殑闄愬埗.
	 *
	 * @throws NoSuchFieldException 濡傛灉娌℃湁璇ield鏃舵姏鍑�.
	 */
	/**
	 * @param object
	 * @param propertyName
	 * @return
	 * @throws NoSuchFieldException
	 */
	public static Object forceGetProperty(Object object, String propertyName) throws NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);

		Field field = getDeclaredField(object, propertyName);

		boolean accessible = field.isAccessible();
		field.setAccessible(true);

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			log.info("error wont' happen");
		}
		field.setAccessible(accessible);
		return result;
	}

	/**
	 * 鏆村姏璁剧疆瀵硅薄鍙橀噺鍊�,蹇界暐private,protected淇グ绗︾殑闄愬埗.
	 *
	 * @throws NoSuchFieldException 濡傛灉娌℃湁璇ield鏃舵姏鍑�.
	 */
	/**
	 * @param object
	 * @param propertyName
	 * @param newValue
	 * @throws NoSuchFieldException
	 */
	public static void forceSetProperty(Object object, String propertyName, Object newValue)
			throws NoSuchFieldException {
		Assert.notNull(object);
		Assert.hasText(propertyName);

		Field field = getDeclaredField(object, propertyName);
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		try {
			field.set(object, newValue);
		} catch (IllegalAccessException e) {
			log.info("Error won't happen");
		}
		field.setAccessible(accessible);
	}

	/**
	 * 鏆村姏璋冪敤瀵硅薄鍑芥暟,蹇界暐private,protected淇グ绗︾殑闄愬埗.
	 *
	 * @throws NoSuchMethodException 濡傛灉娌℃湁璇ethod鏃舵姏鍑�.
	 */
	/**
	 * @param object
	 * @param methodName
	 * @param params
	 * @return
	 * @throws NoSuchMethodException
	 */
	public static Object invokePrivateMethod(Object object, String methodName, Object... params)
			throws NoSuchMethodException {
		Assert.notNull(object);
		Assert.hasText(methodName);
		Class[] types = new Class[params.length];
		for (int i = 0; i < params.length; i++) {
			types[i] = params[i].getClass();
		}

		Class clazz = object.getClass();
		Method method = null;
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				method = superClass.getDeclaredMethod(methodName, types);
				break;
			} catch (NoSuchMethodException e) {
				// 鏂规硶涓嶅湪褰撳墠绫诲畾涔�,缁х画鍚戜笂杞瀷
			}
		}

		if (method == null)
			throw new NoSuchMethodException("No Such Method:" + clazz.getSimpleName() + methodName);

		boolean accessible = method.isAccessible();
		method.setAccessible(true);
		Object result = null;
		try {
			result = method.invoke(object, params);
		} catch (Exception e) {
			ReflectionUtils.handleReflectionException(e);
		}
		method.setAccessible(accessible);
		return result;
	}

	/**
	 * 鎸塅iled鐨勭被鍨嬪彇寰桭ield鍒楄〃.
	 */
	/**
	 * @param object
	 * @param type
	 * @return
	 */
	public static List<Field> getFieldsByType(Object object, Class type) {
		List<Field> list = new ArrayList<Field>();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.getType().isAssignableFrom(type)) {
				list.add(field);
			}
		}
		return list;
	}

	/**
	 * 鎸塅iledName鑾峰緱Field鐨勭被鍨�.
	 */
	/**
	 * @param type
	 * @param name
	 * @return
	 * @throws NoSuchFieldException
	 */
	public static Class getPropertyType(Class type, String name) throws NoSuchFieldException {
		return getDeclaredField(type, name).getType();
	}

	/**
	 * 鑾峰緱field鐨刧etter鍑芥暟鍚嶇О.
	 */
	/**
	 * @param type
	 * @param fieldName
	 * @return
	 */
	public static String getGetterName(Class type, String fieldName) {
		Assert.notNull(type, "Type required");
		Assert.hasText(fieldName, "FieldName required");

		if (type.getName().equals("boolean")) {
			return "is" + StringUtils.capitalize(fieldName);
		} else {
			return "get" + StringUtils.capitalize(fieldName);
		}
	}

	/**
	 * 鑾峰緱field鐨刧etter鍑芥暟,濡傛灉鎵句笉鍒拌鏂规硶,杩斿洖null.
	 */
	/**
	 * @param type
	 * @param fieldName
	 * @return
	 */
	public static Method getGetterMethod(Class type, String fieldName) {
		try {
			return type.getMethod(getGetterName(type, fieldName));
		} catch (NoSuchMethodException e) {
			log.error(e);
		}
		return null;
	}
}
