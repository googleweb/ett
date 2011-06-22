package com.ett.drv.web.action.physical;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.record.CalcCountRecord;
import org.json.JSONObject;

import com.ett.common.util.DateUtil;
import com.ett.drv.model.admin.BusAllInfoModel;
import com.ett.drv.model.admin.BusLogModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.StringUtil;

public class HospitalMessageAction extends BaseDrvAction implements ModelDriven<BusAllInfoModel>{

	private static final long serialVersionUID = 1L;
	private BusAllInfoModel busAllInfoModel;
	
	public String to_process(){
	
		return  "jsp";
	}
	@SuppressWarnings("unchecked")
	public String to_import() {
		if(isPost()){
			/**
			 * 根据证件号等查询
			 */
			this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
			List list=this.hospitalBiz.getModel(busAllInfoModel);
			this.getRequest().setAttribute("busAllInfoModel", list.get(0));
		}
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
		this.hospitalBiz.modifyOrAddModel(busAllInfoModel);
	}
	/**
	 * 根据证件号等查询
	 */
	public void do_search(){

		
	}
	/**
	 *查询出业务查询 
	 */
	@SuppressWarnings("unchecked")
	public void datagrid_busAllLog(){
        if(StringUtil.isBlank(busAllInfoModel.getCIdcard())){
        	busAllInfoModel.setCIdcard(null);
        }
        if(StringUtil.isBlank(busAllInfoModel.getCDabh())){
        	busAllInfoModel.setCDabh(null);
        }
        if(StringUtil.isBlank(busAllInfoModel.getCXm())){
        	busAllInfoModel.setCXm(null);
        }
        if(StringUtil.isBlank(busAllInfoModel.getCCarType())){
        	busAllInfoModel.setCCarType(null);
        }
        if(busAllInfoModel.getBeginDate()==null){
        		Calendar cal=Calendar.getInstance();
        		cal.setTimeInMillis(0);
				busAllInfoModel.setBeginDate(cal.getTime());

        }
        if(busAllInfoModel.getEndDate()==null){
    	   busAllInfoModel.setEndDate(new Date());
        }
        if(StringUtil.isBlank(busAllInfoModel.getCOperator())){
        	busAllInfoModel.setCOperator(null);
        }
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		PageArrayList list=this.hospitalBiz.getModel(busAllInfoModel,this.getPager());
		JSONObject json=EasyUiUtil.toJsonDataGrid(list,list.getCount());
		this.writePlainText(json.toString());
	}
	/**
	 *根据日志表查询信息 
	 */
	/*@SuppressWarnings("unchecked")
	public void do_searchLog(){
		this.hospitalBiz.loadCrudMapper(BusLogModel.class);
		List list=this.hospitalBiz.getModel();
		JSONObject json=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
		this.writePlainText(json.toString());
	}*/
	/**
	 *根据医院，或成员查询 
	 */
	public void datagrid_hospital(){
		String statistics_type=this.getParameter("statistics_type");
		if(statistics_type.equals("按医院名称")){
			//this.hospitalBiz.
		}
	}
	public void clear() {
	}
}
