package com.ett.drv.web.action.booked;

import java.util.Date;


import com.ett.drv.model.booked.BookedWeekRecordModel;
import com.ett.drv.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.StringUtil;

public class ExamPreasignAction extends BaseAction  {

	
	private BookedWeekRecordModel weekRecord;
	
	
	
	
	public BookedWeekRecordModel getWeekRecord() {
		return weekRecord;
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
		weekRecord=bookedBiz.getWeekRecord(weekNum);
		return super.to_index();
	}

	
	
	
}
