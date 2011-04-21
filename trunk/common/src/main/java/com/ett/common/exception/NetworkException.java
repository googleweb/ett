/**
 * 
 */
package com.ett.common.exception;

/**
 * @author austin
 *
 */
public class NetworkException extends BusinessException {
	/**
	 * @param message 异常信息
	 */
	public NetworkException(String message)
	{
		super(message);
	}
	
	/**
	 * @param ex 异常对象
	 */
	public NetworkException(Throwable ex)
	{
		super(ex);
	}
	
	/**
	 * @param message 异常信息
	 * @param cause 异常籄1�7
	 */
	public NetworkException(String message, Throwable cause) 
	{
	
	        super(message, cause);
	}
	
	 /**
	 * 无参构�1�7�函敄1�7
	 */
	public NetworkException() 
	 {
			super();
	}

}
