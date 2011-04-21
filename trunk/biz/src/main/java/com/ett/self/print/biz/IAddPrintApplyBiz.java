/**
 * 
 */
package com.ett.self.print.biz;

import com.ett.model.DrvUser;
import com.ett.self.model.SelfDeviceObject;
import com.ett.self.print.model.AddPrintApplyObject;

/**
 * @author austin
 * 补打业务申请类
 */
public interface IAddPrintApplyBiz {
	
	/**
	 * 体检回执补打申请
	 * @param user 哪个人
	 * @param device 哪台自助终端
	 * @param lsh 补打申请的流水号
	 */
	public AddPrintApplyObject addHospitalPrint(DrvUser user,SelfDeviceObject device,String lsh,int lineupid);
	
	/**
	 * 处罚决定书补打申请
	 * @param user 哪个人
	 * @param device 哪台自助终端
	 * @param lsh 补打申请的流水号
	 */
	public AddPrintApplyObject addVioPrint(DrvUser user,SelfDeviceObject device,String jdsbh,int lineupid);

}
