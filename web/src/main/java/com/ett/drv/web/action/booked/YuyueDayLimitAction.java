package com.ett.drv.web.action.booked;

import java.util.ArrayList;
import java.util.List;



import org.json.JSONArray;
import org.json.JSONObject;


import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.admin.DictTypeModel;
import com.ett.drv.model.booked.BookedDayLimitModel;

import com.ett.drv.web.action.BaseAction;


import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;


public class YuyueDayLimitAction extends BaseAction implements ModelDriven<BookedDayLimitModel>{
	private BookedDayLimitModel BookedDayLimitModel;

	public BookedDayLimitModel getBookedDayLimitModel() {
		return BookedDayLimitModel;
	}
	public void setBookedDayLimitModel(BookedDayLimitModel bookedDayLimitModel) {
		BookedDayLimitModel = bookedDayLimitModel;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public BookedDayLimitModel getModel() {
		// TODO Auto-generated method stub
		if(isGet()){
			int id=ObjectUtil.formatInt(this.getParameter("id"));
			if(id==0)
			{
				BookedDayLimitModel=new BookedDayLimitModel();
			}else{
				this.bookedBiz.loadCrudMapper(BookedDayLimitModel.class);
				BookedDayLimitModel=(BookedDayLimitModel) this.bookedBiz.getModelEqPk(id);
			}
		}
		return BookedDayLimitModel;
	}
	
	public void datagrid_yuyuedaylimit(){
		this.bookedBiz.loadCrudMapper(BookedDayLimitModel.class);
		List list=this.bookedBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.bookedBiz.count());
		this.writePlainText(jsonDG.toString());		
	}
	
	public String to_editYuyueDayLimit(){
	    return "jsp";
	}
	
	public void combobox_Km(){
		List listKm=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			listKm=this.adminBiz.listKskm(null);
			jarr=ObjectUtil.toJsonArray(listKm);
		}catch (Exception e) {e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	
	public void do_delete(){
    	
    	ArrayList lListIds=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
	    if(ids!=null)
		{
             lListIds=StringUtil.splitToList(ids,",");
             this.bookedBiz.loadCrudMapper(BookedDayLimitModel.class);
             re+=this.bookedBiz.removeModelInPk(lListIds).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			//resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg("成功删除{0}个",re);
	
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有删除");
		}
		this.writePlainText(resultModel.toJson().toString());   	
    }
	
	public void  do_editDict(){
		int re=0;
		
		if(this.isPost()){
			
			this.bookedBiz.loadCrudMapper(BookedDayLimitModel.class);
			re+=this.bookedBiz.modifyOrAddModel(BookedDayLimitModel).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			if(BookedDayLimitModel.getId()==null){
				pattern="用户管理:{0}保存成功,再添加一个用户？";
				resultModel.setAction(ResultModel.ACTION_CONFIRM);
				//hardware=new HardwareModel();
			}else {
				pattern="用户管理:{0}保存成功";
			}
			resultModel.setMsg(pattern,re);;
			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	public void  do_add(){
		int re=0;
		if(this.isPost()){
			this.bookedBiz.loadCrudMapper(BookedDayLimitModel.class);
			re+=this.bookedBiz.modifyOrAddModel(BookedDayLimitModel).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			pattern="预约间隔限制管理:{0}保存成功,再添加一个？";
			resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg(pattern,re);;
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	public void  do_modify(){
		int re=0;
		if(this.isPost()){
			this.bookedBiz.loadCrudMapper(BookedDayLimitModel.class);
			re+=this.bookedBiz.modifyOrAddModel(BookedDayLimitModel).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";			
			resultModel.setAction(ResultModel.ACTION_CONFIRM);
			pattern="预约间隔限制管理:{0}保存成功";	
			resultModel.setMsg(pattern,re);;			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
		
	}
	public void  do_deleteDayLimit(){
		List lListIds=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
	    if(ids!=null)
		{
             lListIds=StringUtil.splitToList(ids,",");
             this.bookedBiz.loadCrudMapper(BookedDayLimitModel.class);
             re+=this.bookedBiz.removeModelInPk(lListIds).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			//resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg("成功删除{0}个预约间隔限制类型",re);
	
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有预约间隔类型被删除");
		}
		this.writePlainText(resultModel.toJson().toString());   
	}
	
	
}
	
