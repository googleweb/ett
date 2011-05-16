/**
 * 
 */
package com.austin.base.commons.exception;

import com.austin.base.commons.exception.model.ExceptionCodeObject;

/**
 * @author austin
 * 业务异常内，包含代码和代码表，跟数据库错误代码表对应
 */
public class BusinessException extends java.lang.RuntimeException {
	private String code="Default_Unknown_Code";
	
	public static final String Default_Unknown_Code="Default_Unknown_Code";
	
	public static final String Default_NetworkException_Code="Default_NetworkException_Code";
	
	public static final String Default_NoRightException_Code="Default_NoRightException_Code";
	
	public static final String Default_NoLoginException_Code="Default_NoLoginException_Code";
	
	public static final String Default_ObjectDontException_Code="Default_ObjectDontException_Code";
	
	public ExceptionCodeObject getExceptionCodeObject()
	{
		return null;
	}

	/**
	 * @param message 异常信息
	 */
	public BusinessException(String code)
	{
		//super(msg);
		//super();
		this.code=code;

	}
	
	/**
	 * @param ex 异常对象
	 */
	public BusinessException(String code,Throwable ex)
	{
		super(ex);
		this.code=code;
	}
	
	 /**
	 * 无构造函数的异常对象,默认的错误代码为-1,未知错误代码
	 */
	public BusinessException() 
	{
			super();
			//this.code="";
	}
}
