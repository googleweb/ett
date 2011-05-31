package com.ett.drv.biz.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.model.impl.BaseCurdBiz;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.DateTimeUtil;

import com.ett.drv.biz.IBookedBiz;
import com.ett.drv.mapper.booked.ILimitMapper;
import com.ett.drv.mapper.booked.IOrderInfoMapper;
import com.ett.drv.mapper.booked.IWeekRecordMapper;
import com.ett.drv.model.booked.BookedLimitModel;
import com.ett.drv.model.booked.BookedOrderInfoModel;
import com.ett.drv.model.booked.BookedWeekRecordModel;

public class BookedBiz extends BaseDrvBiz implements IBookedBiz {



	
	public BookedWeekRecordModel getWeekRecord(int weekNum) {
		// TODO Auto-generated method stub
		
		//int lIntWeek=DateTimeUtil.getWeekOfYear(pDate);
		BookedWeekRecordModel lWeekReurn=new BookedWeekRecordModel();
		lWeekReurn.setIWeekNum(weekNum);
		try {
		List<BookedWeekRecordModel> lListWeek= weekRecordMapper.select(lWeekReurn);
		if(lListWeek.size()>0){
			lWeekReurn=lListWeek.get(0);
		}else{
			Calendar cal=Calendar.getInstance();
			lWeekReurn.setYear(cal.get(Calendar.YEAR));
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lWeekReurn;
	}
	
	
	public Map<String,BookedLimitModel> getLimits(int weekNum) throws Exception{
		Map<String, BookedLimitModel> lMapReturn=new HashMap<String, BookedLimitModel>();
		BookedLimitModel lLimit=new BookedLimitModel();
		lLimit.setIWeekNum(weekNum);
        List<BookedLimitModel> lListLimit=limitMapper.select(lLimit);
		for (BookedLimitModel bookedLimitModel : lListLimit) {
			   lMapReturn.put((String) bookedLimitModel.generalPK(), bookedLimitModel);	
		}
	   return lMapReturn;
	}


	public ResultModel tranExamPreasgin(BookedOrderInfoModel orderInfoModel) {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		int re=0;
		try {
			re+= this.orderInfoMapper.insertOne(orderInfoModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reModel;
	}

}
