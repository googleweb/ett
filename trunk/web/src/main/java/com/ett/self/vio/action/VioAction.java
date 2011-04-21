/**
 * 
 */
package com.ett.self.vio.action;

import java.util.List;

import com.ett.common.exception.ObjectDontExistException;
import com.ett.self.BaseSelfAction;
import com.ett.self.model.VehicleObject;
import com.ett.self.vio.biz.IVioBiz;

/**
 * @author austin
 * 违法缴费的Action
 */
public class VioAction extends BaseSelfAction {
	
	private IVioBiz iVioBiz;
	

	
	public IVioBiz getiVioBiz() {
		return iVioBiz;
	}

	public void setiVioBiz(IVioBiz iVioBiz) {
		this.iVioBiz = iVioBiz;
	}

	private List lists;

	public List getLists() {
		return lists;
	}

	public void setLists(List lists) {
		this.lists = lists;
	}
	
	private VehicleObject vehicle;
	
	private String jdsbh;

	public VehicleObject getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleObject vehicle) {
		this.vehicle = vehicle;
	}

	public String getJdsbh() {
		return jdsbh;
	}

	public void setJdsbh(String jdsbh) {
		this.jdsbh = jdsbh;
	}
	
	public String vehicleVioList()
	{
		String xh=this.getHtmlAttributeOrParamter("xh");
		this.vehicle=iVioBiz.getVehicle(xh);
		this.lists=iVioBiz.getVioUnProcessDetail(vehicle.getHphm());
		return "vehicleviolist";
	}

	public String vehicleSelectList()
	{
		
		List list=iVioBiz.getVehList(this.getUser().getSfzmhm());
		if(list!=null)
		{
			logger.debug("获取到车辆的数量为:"+list.size());
			if(list.size()==1)
			{
				this.vehicle=(VehicleObject)list.get(0);
				this.lists=iVioBiz.getVioUnProcessDetail(vehicle.getHphm());
				return "vehicleviolist";
			}
			else
			{
		     this.lists=list;
			  return "vehicleselectlist";
			}
		}
		else
		{
			throw new ObjectDontExistException("对不起，您没有在本地登记的车辆！");
		}
	}
	
	public String feeTypeSelect()
	{
		return "feetypeselect";
	}

}
