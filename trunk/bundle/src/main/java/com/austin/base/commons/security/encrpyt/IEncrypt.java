package com.austin.base.commons.security.encrpyt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author chen 加密，解密接口
 */
public interface IEncrypt {

	static final Log log = LogFactory.getLog(IEncrypt.class);

	/**
	 * @param str
	 *            需要加密的字符串
	 * @return 加密后的字符串
	 * @throws Exception
	 *             抛出的异常
	 */
	public String encrypt(String str) throws Exception;

	/**
	 * @param str
	 *            需要解密的字符串
	 * @return 解密后的字符串
	 * @throws Exception
	 *             抛出的异常
	 */
	public String decrypt(String str) throws Exception;

}