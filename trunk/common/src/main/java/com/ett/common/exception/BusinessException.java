package com.ett.common.exception;


/**
 * 基本的业务异常信息类 uncheckedException是客户端代码无法处理的异帄1�7
 * 异常可以当作程序分支来实现，只是增加了栈的使甄1�7
 * @author x_chenbiwu
 * 
 * 扄1�7有的异常都外抛给Action处理 ，基类Action负责对异常进行提礄1�7 跳转
 * 
 * 普�1�7�异常都转化成uncheckedException，checked异常仅仅是一些提礄1�7
 * 
 * 错误信息放在资源束缓存中〄1�7
 *
 */
public class BusinessException extends java.lang.RuntimeException
{
	private String hint;
	
	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	/**
	 * @param message 异常信息
	 */
	public BusinessException(String msg)
	{
		//this.setHint(msg);
		
		super(msg);
		this.hint=msg;
		
	}
	
	/**
	 * @param ex 异常对象
	 */
	public BusinessException(Throwable ex)
	{
		super(ex);
		this.hint=this.getMessage();
	}
	
	/**
	 * @param message 异常信息
	 * @param cause 异常籄1�7
	 */
	public BusinessException(String msg, Throwable cause) 
	{
	        super(msg, cause);
	        this.hint=msg;
	}
	
	 /**
	 * 无参构�1�7�函敄1�7
	 */
	public BusinessException() 
	 {
			super();
			this.hint=this.getMessage();
	}

}
