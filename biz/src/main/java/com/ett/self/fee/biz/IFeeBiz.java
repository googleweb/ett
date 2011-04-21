package com.ett.self.fee.biz;

import java.util.List;

import com.ett.model.DrvUser;
import com.ett.self.fee.model.FeeObject;
import com.ett.self.model.SelfDeviceObject;

/**
 * @author austin
 * 缴费业务接口 目前假设一次全部缴费完毕，不存入用户账户
 */
public interface IFeeBiz {
	
	/**
	 * @param lsh 驾驶证缴费流水号以;隔开
	 */
	public void saveFeePerson(DrvUser user,SelfDeviceObject device,FeeObject fee);
	
	/**
	 * @param lsh 违法缴费决定书编号以;隔开
	 */
	public void saveFeeVio(DrvUser user,SelfDeviceObject device,FeeObject fee);
	
	/**
	 * @param lsh 机动车缴费以;隔开
	 */
	public void saveFeeVehicle(DrvUser user,SelfDeviceObject device,FeeObject fee);
	
	/**
	 * @param sfzmhm 身份证明号码
	 * @return 机动车业务未缴费列表
	 */
	public List getVehicleFlowList(DrvUser user);
	
	/**
	 * @param sfzmhm 身份证明号码
	 * @return 违法记录未缴费列表
	 */
	public List getVioFlowList(DrvUser user);
	
	/**
	 * @param sfzmhm 身份证明号码
	 * @return 驾驶人业务未缴费列表
	 */
	public List getPersonFlowList(DrvUser user);

}
