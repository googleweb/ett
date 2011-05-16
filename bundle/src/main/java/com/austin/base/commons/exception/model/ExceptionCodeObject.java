/**
 * 
 */
package com.austin.base.commons.exception.model;

/**
 * @author austin
 *  跟数据库表对应
 */
public class ExceptionCodeObject {
	
	private String code;
	
	private String message;

	/**
	 * @return 异常信息代码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code 异常信息代码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return 异常信息内容
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message 异常信息内容
	 */
	public void setMessage(String message) {
		this.message = message;
	}


}
