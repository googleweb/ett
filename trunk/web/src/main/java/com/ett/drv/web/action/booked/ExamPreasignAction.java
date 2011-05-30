package com.ett.drv.web.action.booked;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;




import com.ett.drv.biz.impl.BookedBiz;
import com.ett.drv.model.booked.BookedLimitModel;
import com.ett.drv.model.booked.BookedOrderInfoModel;
import com.ett.drv.model.booked.BookedWeekRecordModel;
import com.ett.drv.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class ExamPreasignAction extends BaseAction  {

	
	private BookedWeekRecordModel weekRecord;
	private BookedLimitModel limit;
	
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
		int Id=ObjectUtil.formatInt(this.getParameter("Id")) ;
		if(Id==0){
			
		}
		this.bookedBiz.loadCrudMapper(BookedLimitModel.class);
		Object obj=this.bookedBiz.getModelEqPk(Id);
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
			if(boModel.getIChecked()!=2){
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
			if(boModel.getIChecked()==2){
				listPass.add(boModel);
			}
		}
		JSONObject datagrid=EasyUiUtil.toJsonDataGrid(listPass);
		this.writePlainText(datagrid.toString());
	}
	
}
