/**
 * @(#)ObjectDontExistException.java.java 
 *
 * create by chen at 2008-6-28
 *
 * Copyright 2008 fivemen,Inc. All rights reserved.
 *
 * fivemen proprietary/confidential.Use is subject to license terms
 */
package com.ett.common.exception;


/**
 * @author chen
 * 鐢ㄦ埛娌℃湁鏉冮檺寮傚父
 */
public class NoRightException extends BusinessException {
	/**
	 * @param message 寮傚父淇℃伅
	 */
	public NoRightException(String message)
	{
		super(message);
	}
	
	/**
	 * @param ex 寮傚父瀵硅薄
	 */
	public NoRightException(Throwable ex)
	{
		super(ex);
	}
	
	/**
	 * @param message 寮傚父淇℃伅
	 * @param cause 寮傚父绫�
	 */
	public NoRightException(String message, Throwable cause) 
	{
	        super(message, cause);
	}
	
	 /**
	 * 鏃犲弬鏋勯�犲嚱鏁�
	 */
	public NoRightException() 
	 {
			super();
	}

}
