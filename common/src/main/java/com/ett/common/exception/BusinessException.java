package com.ett.common.exception;


/**
 * 鍩烘湰鐨勪笟鍔″紓甯镐俊鎭被 uncheckedException鏄鎴风浠ｇ爜鏃犳硶澶勭悊鐨勫紓甯�
 * 寮傚父鍙互褰撲綔绋嬪簭鍒嗘敮鏉ュ疄鐜帮紝鍙槸澧炲姞浜嗘爤鐨勪娇鐢�
 * @author x_chenbiwu
 * 
 * 鎵�鏈夌殑寮傚父閮藉鎶涚粰Action澶勭悊 锛屽熀绫籄ction璐熻矗瀵瑰紓甯歌繘琛屾彁绀� 璺宠浆
 * 
 * 鏅�氬紓甯搁兘杞寲鎴恥ncheckedException锛宑hecked寮傚父浠呬粎鏄竴浜涙彁绀�
 * 
 * 閿欒淇℃伅鏀惧湪璧勬簮鏉熺紦瀛樹腑銆�
 *
 */
public class BusinessException extends java.lang.RuntimeException
{
	
	/**
	 * @param message 寮傚父淇℃伅
	 */
	public BusinessException(String message)
	{
		super(message);
	}
	
	/**
	 * @param ex 寮傚父瀵硅薄
	 */
	public BusinessException(Throwable ex)
	{
		super(ex);
	}
	
	/**
	 * @param message 寮傚父淇℃伅
	 * @param cause 寮傚父绫�
	 */
	public BusinessException(String message, Throwable cause) 
	{
	        super(message, cause);
	}
	
	 /**
	 * 鏃犲弬鏋勯�犲嚱鏁�
	 */
	public BusinessException() 
	 {
			super();
	}

}
