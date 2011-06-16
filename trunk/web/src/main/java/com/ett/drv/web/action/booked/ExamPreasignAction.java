package com.ett.drv.web.action.booked;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.record.formula.functions.Fpos;
import org.json.JSONArray;
import org.json.JSONObject;




import com.ett.drv.biz.impl.BookedBiz;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.model.booked.BookedDayLimitModel;
import com.ett.drv.model.booked.BookedLimitModel;
import com.ett.drv.model.booked.BookedOrderInfoModel;
import com.ett.drv.model.booked.BookedWeekRecordModel;
import com.ett.drv.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class ExamPreasignAction extends BaseAction implements ModelDriven<BookedOrderInfoModel>  {

	
	private BookedWeekRecordModel weekRecord;
	private BookedLimitModel limit;
	private BookedOrderInfoModel orderInfo;

	private int Id;
	
	
	public BookedWeekRecordModel getWeekRecord() {
		return weekRecord;
	}

    public BookedLimitModel getLimit(){
    	return limit;
    }
	


	public void setId(int id) {
		Id = id;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}




	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		super.prepare();
		if(isPost()){
			if(orderInfo==null){
				orderInfo=new BookedOrderInfoModel();
			}
		}
	}

	@Override
	public String to_index() throws Exception {
		// TODO Auto-generated method stub
		String searchDate=this.getParameter("inputDate");
		Date d=new Date();
		if(StringUtil.isNotBlank(searchDate)){
			d=DateTimeUtil.parse(searchDate);
		}
		this.bookedBiz.loadCrudMapper(BookedWeekRecordModel.class);
		int weekNum=DateTimeUtil.getWeekOfYear(d);
		BookedWeekRecordModel q=new BookedWeekRecordModel();
		q.setIWeekNum(weekNum);
		List listWeekRecord=bookedBiz.getModel(q);
		if(listWeekRecord.size()>0){
			weekRecord=(BookedWeekRecordModel) listWeekRecord.get(0);
		}else{
			weekRecord=new BookedWeekRecordModel();
			weekRecord.setIWeekNum(weekNum);
			weekRecord.setYear(Calendar.getInstance().get(Calendar.YEAR));
		}
		return super.to_index();
	}

	
	public String to_preasign() throws Exception{
		int limitId=ObjectUtil.formatInt(this.getParameter("limitId")) ;
		this.bookedBiz.loadCrudMapper(BookedLimitModel.class);
		Object obj=this.bookedBiz.getModelEqPk(limitId);
		if(obj!=null){
			limit=(BookedLimitModel)obj;
		}else{
			return to_index();
		}
		return ResultEnum.jsp.name();
	}
	
	private List<BookedOrderInfoModel> getOrderInfo(int id){
		List<BookedOrderInfoModel> listOrderInfo=new ArrayList<BookedOrderInfoModel>();
		if(id==0){return listOrderInfo;}
		this.bookedBiz.loadCrudMapper(BookedOrderInfoModel.class);
		BookedOrderInfoModel q=new BookedOrderInfoModel();
		q.setIPaibanid(id);
		listOrderInfo=this.bookedBiz.getModel(q);
		return listOrderInfo;
	}
	
	public void datagrid_passOrderInfo(){
		List<BookedOrderInfoModel> listOrderInfo=getOrderInfo(Id);
		List listPass=new ArrayList();
		for(BookedOrderInfoModel boModel : listOrderInfo){
			if(ObjectUtil.isNotEquals(2, boModel.getIChecked())){
				listPass.add(boModel);
			}
		}
		JSONObject datagrid=EasyUiUtil.toJsonDataGrid(listPass);
		this.writePlainText(datagrid.toString());
	}
	
	public void datagrid_failOrderInfo(){
		List<BookedOrderInfoModel> listOrderInfo=getOrderInfo(Id);
		List listPass=new ArrayList();
		for(BookedOrderInfoModel boModel : listOrderInfo){
			if(ObjectUtil.isEquals(2, boModel.getIChecked())){
				listPass.add(boModel);
			}
		}
		JSONObject datagrid=EasyUiUtil.toJsonDataGrid(listPass);
		this.writePlainText(datagrid.toString());
	}
	
	
	public  void combobox_kscc() throws Exception
	{

		List lListKscc=adminBiz.listKscc(null);
		JSONArray lJsonKscc= ObjectUtil.toJsonArray(lListKscc);
		this.writePlainText(lJsonKscc.toString());
	}
	
	public void combobox_ksdd() throws Exception
	{

		List lListKsdd=adminBiz.listKsdd(null);
		JSONArray lJsonKsdd= ObjectUtil.toJsonArray(lListKsdd);
		this.writePlainText(lJsonKsdd.toString());
	}
	
	public void combobox_kskm() throws Exception
	{

		List lListKsdd=adminBiz.listKskm(null);
		JSONArray lJsonKsdd= ObjectUtil.toJsonArray(lListKsdd);
		this.writePlainText(lJsonKsdd.toString());
	}
	
	public void do_cancelPreasign(){
		String ids=ObjectUtil.formatString(this.getParameter("ids")) ;
		List listId=StringUtil.splitToList(ids,",");
		ResultModel reModel=new ResultModel();
		int re=0;
		this.bookedBiz.loadCrudMapper(BookedOrderInfoModel.class);
		re+=this.bookedBiz.removeModelInPk(listId).getRe();
		reModel.setAction(ResultModel.ACTION_ALERT);
		if(re>0){
			reModel.setTitle("操作成功");
			reModel.setMsg("成功撤消{0}条记录",re);
		}else{
			reModel.setTitle("操作失败");
			reModel.setMsg("没有预约记录被撤消",re);
		}
		this.writePlainText(reModel.toJson().toString());
	}
	
	public void do_preasign(){
		ResultModel reModel=this.bookedBiz.tranExamPreasgin(orderInfo);
		this.writePlainText(reModel.toJson().toString());
	}

	public BookedOrderInfoModel getModel() {
		// TODO Auto-generated method stub
		if(orderInfo==null){
			orderInfo=new BookedOrderInfoModel();
		}
		return orderInfo;
	}
	
	public String to_verify(){
		return ResultEnum.jsp.name();
	}
	
	public void datagrid_orderInfo(){
		String strIdCard= this.getParameter("idCard");
		String strChecked=this.getParameter("checked");
		UserModel userModel=this.getAuthUser();
		String strKm=userModel.getCKm();
		Integer intKm=ObjectUtil.formatInt(strKm,-1);
		Integer intChecked=null;
		if(StringUtil.isBlank(strIdCard)){
			strIdCard=null;
		}
		if(ObjectUtil.formatInt(strKm,-1)!=-1){
			intKm=ObjectUtil.formatInt(strKm);
		}
		if(ObjectUtil.formatInt(strChecked,-1)!=-1){
			intChecked=ObjectUtil.formatInt(strChecked);
		}
		
		BookedOrderInfoModel q=new BookedOrderInfoModel();
		q.setCIdcard(strIdCard);
		q.setIKm(intKm);
		q.setIChecked(intChecked);
		
		this.bookedBiz.loadCrudMapper(BookedOrderInfoModel.class);
		List listOrderInfo=this.bookedBiz.getModel(q,this.getPager());
		JSONObject datagrid=EasyUiUtil.toJsonDataGrid(listOrderInfo,this.bookedBiz.count());
		this.writePlainText(datagrid.toString());
	}
	
	
	public String to_extraAssign(){
		return ResultEnum.jsp.name();
	}
	

	public void datagrid_extraAssignLimits(){
		String ksrq=this.getParameter("ksrq");
		this.bookedBiz.loadCrudMapper(BookedLimitModel.class);
		List list=new ArrayList();
		if(StringUtil.isBlank(ksrq)){
			list=this.bookedBiz.getModel(this.getPager());
		}else{
			BookedLimitModel q=new BookedLimitModel();
			q.setDateKsrq(ksrq);
			list=this.bookedBiz.getModel(q,this.getPager());
		}

		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.bookedBiz.count());
		this.writePlainText(jsonDG.toString());	
	}
	
	public void do_extraAssign(){
		
		int tpNum=ObjectUtil.formatInt(this.getParameter("tpNum"));
		int id=ObjectUtil.formatInt(this.getParameter("id"));
		this.bookedBiz.loadCrudMapper(BookedLimitModel.class);
		BookedLimitModel bLimitModel=(BookedLimitModel) this.bookedBiz.getModelEqPk(id);
		bLimitModel.setITptotal(tpNum);
		ResultModel reModel=this.bookedBiz.modifyModel(bLimitModel);
		this.writePlainText(reModel.toJson().toString());
	}
	
	
	public void do_verifyOrderInfo(){
	   String ids=this.getParameter("ids");
	   List<String> listPk=StringUtil.splitToList(ids,",");
	   ResultModel reModel=this.bookedBiz.tranVerifyOrderInfo(listPk);
	   this.writePlainText(reModel.toJson().toString());
	}
	
}
