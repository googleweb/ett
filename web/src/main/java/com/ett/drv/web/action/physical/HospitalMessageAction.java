package com.ett.drv.web.action.physical;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.ett.common.util.DateUtil;
import com.ett.drv.model.admin.BusAllInfoModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class HospitalMessageAction extends BaseDrvAction implements ModelDriven<BusAllInfoModel>{

	private static final long serialVersionUID = 1L;
	private BusAllInfoModel busAllInfoModel;
	
	public String to_process(){
	
		return  "jsp";
	}
	public String to_import() {
		/*if(isPost()){
			*//**
			 * 根据证件号等查询
			 *//*
			this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
			List list=this.hospitalBiz.getModel(busAllInfoModel);
			if(list!=null){
					this.getRequest().setAttribute("busAllInfoModel", list.get(0));
			}else{
				ResultModel resultModel=new ResultModel();
				resultModel.setMsg("没有符合条件的信息");
			}
		}*/
		//this.writePlainText(resultModell.)
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
		
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		busAllInfoModel.setIState(1);
		this.hospitalBiz.modifyOrAddModel(busAllInfoModel);
	}
	/**
	 * 根据证件号等查询
	 */
	@SuppressWarnings("unchecked")
	public void do_search(){
		
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		BusAllInfoModel busAllInfoModel=new BusAllInfoModel();
		String qCIdcard=this.getParameter("CIdcard1");
		String qCDabh=this.getParameter("CDabh1");
		if(StringUtil.isBlank(qCIdcard)){
			qCIdcard=null;
		}
		if(StringUtil.isBlank(qCDabh)){
			qCDabh=null;
		}
		String qCIdcardtype=this.getParameter("CIdcardtype1");
		if(StringUtil.isBlank(qCIdcardtype)){
			qCIdcardtype=null;
		}
		busAllInfoModel.setCIdcardtype(qCIdcardtype);
		busAllInfoModel.setCIdcard(qCIdcard);
		busAllInfoModel.setCDabh(qCDabh);
		List<IFormatterModel> list=this.hospitalBiz.getModel(busAllInfoModel);
		if(list.size()==0){
			//resultModel.setMsg("不存在这样的用户");
			//this.writePlainText(resultModel.toJson().toString());
		}else{
			this.writePlainText(list.get(0).toJson().toString());
		}
	}
		
	/**
	 *查询出业务查询 
	 */
	@SuppressWarnings("unchecked")
	public void datagrid_busAllLog(){
		BusAllInfoModel busAllInfoModel=new BusAllInfoModel();
		String qCIdcard=this.getParameter("qCIdcard");
        if(StringUtil.isBlank(qCIdcard)){
        	qCIdcard=null;
        }
        String qCOperator=this.getParameter("qCOperator");
        if(StringUtil.isBlank(qCOperator)){
        	qCOperator=null;
        }
        String qCDabh=this.getParameter("qCDabh");
        if(StringUtil.isBlank(qCDabh)){
        	qCDabh=null;
        }
        String qCXm=this.getParameter("qCXm");
        if(StringUtil.isBlank(qCXm)){
        	qCXm=null;
        }
        String qCCarType=this.getParameter("qCCarType");
        if(StringUtil.isBlank(qCCarType)){
        	qCCarType=null;
        }
        String qbeginDate=this.getParameter("qbeginDate");
        if(StringUtil.isBlank(qbeginDate)){
        	qbeginDate=null;
        	Calendar cal=Calendar.getInstance();
    		cal.setTimeInMillis(0);
			busAllInfoModel.setBeginDate(cal.getTime());
        }else{
        	busAllInfoModel.setBeginDate(DateTimeUtil.parse(qbeginDate));
        }
        String qendDate=this.getParameter("qendDate");
        if(StringUtil.isBlank(qendDate)){
        	qendDate=null;
        	 busAllInfoModel.setEndDate(DateTimeUtil.parse("2050-01-01"));
        }else{
        	busAllInfoModel.setEndDate(DateTimeUtil.parse(qendDate));
        }
        busAllInfoModel.setCIdcard(qCIdcard);
        busAllInfoModel.setCOperator(qCOperator);
        busAllInfoModel.setCDabh(qCDabh);
        busAllInfoModel.setCXm(qCXm);
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		PageArrayList list=this.hospitalBiz.getModel(busAllInfoModel,this.getPager());
		JSONObject json=EasyUiUtil.toJsonDataGrid(list,list.getCount());
		this.writePlainText(json.toString());
	}
	/**
	 *根据医院，或成员查询 
	 */
	@SuppressWarnings("unchecked")
	public void datagrid_hospital(){
		String qbeginDate=this.getParameter("qbeginDate");
        String qendDate=this.getParameter("qendDate");
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        if(StringUtil.isBlank(qbeginDate)){
        	qbeginDate="2000-1-1";
        }
        if(StringUtil.isBlank(qendDate)){
        	qendDate=sf.format(new Date());
        }
		int type=ObjectUtil.formatInt(this.getParameter("type"));
		List list = null;
		try {
			list = this.hospitalBiz.getViewGroupByHospital(type, DateUtil.parseDate(qbeginDate), DateUtil.parseDate(qendDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject json=EasyUiUtil.toJsonDataGrid(list);
		this.writePlainText(json.toString());
	}
	/*
	 * 退办受理，把I_State变成0
	 * */
	public void do_cancel(){
		//String CIdcard=this.getParameter("CIdcard");
		//System.out.println(CIdcard);
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		this.busAllInfoModel.setIState(0);
		this.hospitalBiz.addOrModifyModel(busAllInfoModel);
		ResultModel resultModel=new ResultModel();
		resultModel.setTitle("受理回执信息");
		resultModel.setMsg("成功退办业务");
		this.writePlainText(resultModel.toJson().toString());
	}
	/**
	 * 得到当前用户对应的部门名字
	 * */
	@SuppressWarnings("unchecked")
	public void get_departmentName(){
		UserModel userModel=(UserModel)this.getSessionAttribute("authUser");
		try {
			List list=this.adminBiz.listDepartmentName(userModel.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 打印出受理的信息成EXCEL表格
	 * */
	public void do_print(){
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		BusAllInfoModel busAllInfoModelprint=(BusAllInfoModel)this.hospitalBiz.getModel(busAllInfoModel).get(0);
		this.writePlainText(busAllInfoModelprint.toJson().toString());
		
	}
	public void clear() {
	}
}
