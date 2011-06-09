package com.ett.drv.web.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.ett.drv.model.self.DeviceModel;
import com.ett.drv.model.self.DeviceSnModel;
import com.ett.drv.model.self.HardwareModel;
import com.ett.drv.web.action.BaseAction;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.StringUtil;

public class SelfDeviceAction extends BaseAction {

	private HardwareModel hardware;
	private DeviceModel device;
	private DeviceSnModel deviceSn;
	
	
	



	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	
	public String to_device(){
		return ResultEnum.jsp.name();
	}
	
	public String to_deviceSn(){
		return ResultEnum.jsp.name();
	}
	
	public String to_hardware(){
		return ResultEnum.jsp.name();
	}
	
	public String edit_hardware(){
		//HardwareModel hardwareModel=new HardwareModel();
		if(this.isGet()){
			String id=this.getParameter("id");
			if(StringUtil.isNotBlank(id)){
				this.selfBiz.loadCrudMapper(HardwareModel.class);
				hardware=(HardwareModel) this.selfBiz.getModelEqPk(Integer.parseInt(id));
			}else {
				hardware=new HardwareModel();
			}
		}
		//this.setRequestAttribute("hardware", hardwareModel);
		return "edit";
	}
	
	public String edit_device(){
		//HardwareModel hardwareModel=new HardwareModel();
		if(this.isGet()){
			String id=this.getParameter("id");
			if(StringUtil.isNotBlank(id)){
				this.selfBiz.loadCrudMapper(DeviceModel.class);
				device=(DeviceModel) this.selfBiz.getModelEqPk(Integer.parseInt(id));
			}else {
				device=new DeviceModel();
			}
		}
		//this.setRequestAttribute("hardware", hardwareModel);
		return "edit";
	}
	
	public String edit_deviceSn(){
		//HardwareModel hardwareModel=new HardwareModel();
		if(this.isGet()){
			String id=this.getParameter("id");
			if(StringUtil.isNotBlank(id)){
				this.selfBiz.loadCrudMapper(DeviceSnModel.class);
				deviceSn=(DeviceSnModel) this.selfBiz.getModelEqPk(Integer.parseInt(id));
			}else {
				deviceSn=new DeviceSnModel();
			}
		}
		//this.setRequestAttribute("hardware", hardwareModel);
		return "edit";
	}
	
	public String to_editDevice(){
		//HardwareModel hardwareModel=new HardwareModel();
		if(this.isGet()){
			String id=this.getParameter("id");
			if(id!=null){
				this.selfBiz.loadCrudMapper(DeviceModel.class);
				device=(DeviceModel) this.selfBiz.getModelEqPk(Integer.parseInt(id));
			}
		}
		//this.setRequestAttribute("hardware", hardwareModel);
		return ResultEnum.jsp.name();
	}
	
	public String to_editDeviceSn(){
		//HardwareModel hardwareModel=new HardwareModel();
		if(this.isGet()){
			String id=this.getParameter("id");
			if(id!=null){
				this.selfBiz.loadCrudMapper(DeviceSnModel.class);
				deviceSn=(DeviceSnModel) this.selfBiz.getModelEqPk(Integer.parseInt(id));
			}
		}
		//this.setRequestAttribute("hardware", hardwareModel);
		return ResultEnum.jsp.name();
	}
	
	public void do_editHardware(){
		int re=0;
		if(this.isPost()){
			this.selfBiz.loadCrudMapper(HardwareModel.class);
			re+=this.selfBiz.modifyOrAddModel(hardware).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			if(hardware.getId()==null){
				pattern="硬件设备:{0}保存成功,再添加一个硬件？";
				resultModel.setAction(ResultModel.ACTION_CONFIRM);
				//hardware=new HardwareModel();
			}else {
				pattern="硬件设备:{0}保存成功";
			}
			resultModel.setMsg(pattern, hardware.getCCatalog());
			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	
	public void do_editDevice(){
		int re=0;
		if(this.isPost()){
			this.selfBiz.loadCrudMapper(DeviceModel.class);
			re+=this.selfBiz.modifyOrAddModel(device).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			if(device.getId()==null){
				pattern="自助设备:{0}保存成功,再添加一个硬件？";
				resultModel.setAction(ResultModel.ACTION_CONFIRM);
				//device=new DeviceModel();
			}else {
				pattern="自助设备:{0}保存成功";
			}
			resultModel.setMsg(pattern, device.getCCatalog());
			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	
	
	public void do_editDeviceSn(){
		int re=0;
		if(this.isPost()){
			this.selfBiz.loadCrudMapper(DeviceSnModel.class);
			re+=this.selfBiz.modifyOrAddModel(deviceSn).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			if(deviceSn.getId()==null){
				pattern="自助设备接口:{0}保存成功,再添加一个接口？";
				resultModel.setAction(ResultModel.ACTION_CONFIRM);
				//deviceSn=new DeviceSnModel();
			}else {
				pattern="自助设备接口:{0}保存成功";
			}
			resultModel.setMsg(pattern, deviceSn.getCSn());
			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	
	
	public void do_removeDevice(){
		ArrayList lListIds=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
	    if(ids!=null)
		{
             lListIds=StringUtil.splitToList(ids,",");
             this.selfBiz.loadCrudMapper(DeviceModel.class);
             re+=this.selfBiz.removeModelInPk(lListIds).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			//resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg("成功删除{0}个硬件设备",re);
	
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有硬件设备被删除");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	
	
	public void do_removeHardware(){
		ArrayList lListIds=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
	    if(ids!=null)
		{
             lListIds=StringUtil.splitToList(ids,",");
             this.selfBiz.loadCrudMapper(HardwareModel.class);
             re+=this.selfBiz.removeModelInPk(lListIds).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			//resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg("成功删除{0}个硬件设备",re);
	
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有硬件设备被删除");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	
	public void do_removeDeviceSn(){
		ArrayList lListIds=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
	    if(ids!=null)
		{
             lListIds=StringUtil.splitToList(ids,",");
             this.selfBiz.loadCrudMapper(DeviceSnModel.class);
             re+=this.selfBiz.removeModelInPk(lListIds).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			//resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg("成功删除{0}个硬件设备",re);
	
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有硬件设备被删除");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	
	
	
	public void datagrid_device(){
		this.selfBiz.loadCrudMapper(DeviceModel.class);
		List list=this.selfBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.selfBiz.count());
		this.writePlainText(jsonDG.toString());
	}
	
	public void datagrid_deviceSn(){
		this.selfBiz.loadCrudMapper(DeviceSnModel.class);
		List list=this.selfBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.selfBiz.count());
		this.writePlainText(jsonDG.toString());
	}
	
	public void datagrid_hardware(){
		this.selfBiz.loadCrudMapper(HardwareModel.class);
		List list=this.selfBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.selfBiz.count());
		this.writePlainText(jsonDG.toString());
	}
	
	
	
	
	
	public HardwareModel getHardware() {
		return hardware;
	}


	public void setHardware(HardwareModel hardware) {
		this.hardware = hardware;
	}


	public DeviceModel getDevice() {
		return device;
	}


	public void setDevice(DeviceModel device) {
		this.device = device;
	}


	public DeviceSnModel getDeviceSn() {
		return deviceSn;
	}


	public void setDeviceSn(DeviceSnModel deviceSn) {
		this.deviceSn = deviceSn;
	}
	
	
}
