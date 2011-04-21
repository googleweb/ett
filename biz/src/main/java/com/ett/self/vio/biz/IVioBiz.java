package com.ett.self.vio.biz;

import java.util.List;

import com.ett.self.model.VehicleObject;

public interface IVioBiz {
	
	
	/**
	 * @param sfzmhm 身份证明号码
	 * @return 获取该身份证明号码下有多少的车列表
	 */
	public List getVehList(String sfzmhm);
	
	/**
	 * @param xh 机动车序号
	 * @return 获取一个车辆信息
	 */
	public VehicleObject getVehicle(String xh);
	
	/**
	 * @param hphm 机动车号牌号码
	 * @return 获取车辆的具体违法信息列表
	 */
	public List getVioDetail(String hphm);
	
	
	/**
	 * @param hphm 机动车号牌号码
	 * @return 获取车辆的具体违法信息列表
	 * 包含（处理未缴款和未处理的非现场处罚）
	 */
	public List getVioUnProcessDetail(String hphm);
	
	/**
	 * @param jdsbh 处理所有jdsbh的违法记录(包含缴费)
	 */
	public void saveProcessVioDetail(String[] jdsbh);
	
	

}
