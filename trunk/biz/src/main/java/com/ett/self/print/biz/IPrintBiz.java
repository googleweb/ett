/**
 * 
 */
package com.ett.self.print.biz;

import java.util.List;

import com.ett.self.ISelfBiz;
import com.ett.self.model.PrintObject;

/**
 * @author austin
 * 供自助终端查询业务流水使用
 */
public interface IPrintBiz extends ISelfBiz {
	
	/**
	 * @param idcard 身份证明号码
	 * @return 用户三个月内办理的驾驶证业务流水记录
	 */
	public List getPersonFlow(String idcard);
	/**
	 * @param lsh 流水号
	 * @return 根据流水号获取打印的回执对象
	 */
	public PrintObject getPersonPrintObject(String lsh);

	
	/**
	 * @param idcard 身份证明号码
	 * @return 用户三个月内办理的机动车业务流水记录
	 */
	public List getCarFlow(String idcard);
	/**
	 * @param lsh 流水号
	 * @return 根据流水号获取打印的回执对象
	 */
	public PrintObject getCarPrintObject(String lsh);

	
	/**
	 * @param idcard 身份证明号码
	 * @return 用户三个月内违法业务流水记录
	 */
	public List getVioFlow(String idcard);
	
	/**
	 * @param lsh 流水号
	 * @return 根据流水号获取打印的回执对象
	 */
	public PrintObject getVioPrintObject(String lsh);

	
	/**
	 * @param idcard 身份证明号码
	 * @return 用户三个月内办理的驾驶证体检业务流水记录
	 */
	public List getHospitalFlow(String idcard);
	
	
	/**
	 * @param lsh 流水号
	 * @return 根据流水号获取打印的回执对象
	 */
	public PrintObject getHospitalPrintObject(String lsh);

}
