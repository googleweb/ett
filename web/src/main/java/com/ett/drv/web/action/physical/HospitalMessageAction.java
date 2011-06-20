package com.ett.drv.web.action.physical;

import java.util.List;

import org.json.JSONObject;

import com.ett.drv.model.admin.BusAllInfoModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.util.EasyUiUtil;

public class HospitalMessageAction extends BaseDrvAction implements ModelDriven<BusAllInfoModel>{

	private static final long serialVersionUID = 1L;
	private BusAllInfoModel busAllInfoModel;
	
	public String to_process(){
		return  "jsp";
	}
	public String to_import() {
		return "jsp";
	}
	public String to_checkRecord() {
		return "jsp";
	}
	public String to_logMessage() {
		return "jsp";
	}
	public String to_statistics() {
		return "jsp";
	}
	public String to_hospitalwork(){
		return  "jsp";
	}
	public BusAllInfoModel getModel() {
		busAllInfoModel=new BusAllInfoModel();
		return busAllInfoModel;
	}
	/**
	 * 增加体检受理
	 */
	public void do_add(){
	//	this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
	//	this.hospitalBiz.modifyOrAddModel(busAllInfoModel);
	}
	/**
	 * 根据证件号查询
	 */
	@SuppressWarnings("unchecked")
	public void do_search(){
	//	this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
	//	List list=this.hospitalBiz.getModel(busAllInfoModel);
	//	this.getRequest().setAttribute("busAllInfoModel", list.get(0));
		
	}
	/**
	 *查询出业务查询 
	 */
	@SuppressWarnings("unchecked")
	public void do_bizsearch(){
	//	this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
	//	List list=this.hospitalBiz.getModel(busAllInfoModel);
	//	JSONObject json=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
	//	this.writePlainText(json.toString());
	}
	public void clear() {
	}
}
