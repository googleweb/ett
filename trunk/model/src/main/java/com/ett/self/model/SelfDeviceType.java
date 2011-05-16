/**
 * 
 */
package com.ett.self.model;

/**
 * @author austin
 * 自助设备的类型，目前的产品类型
 */
public class SelfDeviceType {
	
	/**
	 * 告知业务办理到哪里下一步应该去哪里
	 */
	public static final String SearchMachine="业务查询机";
	/**
	 * 科目一预约考试，需要考虑排队的事项
	 */
	public static final String Km1PreasignMachine="科目一预约机";
	/**
	 * 违法缴费机，只能通过银行刷卡
	 */
	public static final String VioFeeMachine="违法缴费机";
	/**
	 * 所有业务功能的综合
	 */
	public static final String MutipleMachine="综合一体机";
	
	/**
	 * 打印申请回执的大表
	 */
	public static final String PrintMachine="申请回执打印机";

}
