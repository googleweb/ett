/**
 * @(#)ReflectUtil.java create by x_chenbiwu at 2008-3-27 Copyright 2008
 *                      fivemen,Inc. All rights reserved. fivemen
 *                      proprietary/confidential.Use is subject to license terms
 */

package com.austin.base.commons.util;

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
 * 本类提供丄1�7些供反射调用的静态方泄1�7
 * </p>
 *
 * @author x_chenbiwu
 * @version 1.0
 */
public final class ReflectUtil
{
	
	protected static  final Log log = LogFactory.getLog(ReflectUtil.class);
	
	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型. 如public BookManager extends GenricManager<Book>
	 *
	 * @param clazz The class to introspect
	 * @return the first generic declaration, or <code>Object.class</code> if cannot be determined
	 */
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型. 如public BookManager extends GenricManager<Book>
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
	 *            实例的对豄1�7
	 * @param fieldName
	 *            字段名称
	 * @return 字段的具体�1�7�对豄1�7
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
	 * @param className 类名
	 * @param fieldName 字段各1�7
	 * @return 属�1�7��1�7�1�7
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
	 * @param owner 对象
	 * @param methodName 方法名称
	 * @param args 参数列表
	 * @return 返回结果
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
	 * @param className 类名
	 * @param methodName 静�1�7�方法名秄1�7
	 * @param args 参数列表
	 * @return 返回对象
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
	 * @param className 类名
	 * @param args 构�1�7�函数的参数列表
	 * @return 实例对象
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
	 * 循环向上转型,获取对象的DeclaredField.
	 *
	 * @throws NoSuchFieldException 如果没有该Field时抛凄1�7.
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
	 * 循环向上转型,获取对象的DeclaredField.
	 *
	 * @throws NoSuchFieldException 如果没有该Field时抛凄1�7.
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
				// Field不在当前类定乄1�7,继续向上转型
			}
		}
		throw new NoSuchFieldException("No such field: " + clazz.getName() + '.' + propertyName);
	}

	/**
	 * 暴力获取对象变量倄1�7,忽略private,protected修饰符的限制.
	 *
	 * @throws NoSuchFieldException 如果没有该Field时抛凄1�7.
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
	 * 暴力设置对象变量倄1�7,忽略private,protected修饰符的限制.
	 *
	 * @throws NoSuchFieldException 如果没有该Field时抛凄1�7.
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
	 * 暴力调用对象函数,忽略private,protected修饰符的限制.
	 *
	 * @throws NoSuchMethodException 如果没有该Method时抛凄1�7.
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
				// 方法不在当前类定乄1�7,继续向上转型
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
	 * 按Filed的类型取得Field列表.
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
	 * 按FiledName获得Field的类垄1�7.
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
	 * 获得field的getter函数名称.
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
	 * 获得field的getter函数,如果找不到该方法,返回null.
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
