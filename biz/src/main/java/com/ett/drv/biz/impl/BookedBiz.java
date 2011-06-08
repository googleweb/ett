package com.ett.drv.biz.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.model.impl.BaseCurdBiz;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.ObjectUtil;

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


	public ResultModel tranSaveWeekPb(BookedWeekRecordModel weekPb) {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		int re=0;
		try {
			weekPb.updateFpContext(weekPb.getLimits());
			re+=this.weekRecordMapper.updateOne(weekPb);
			int weekNum=weekPb.getIWeekNum();
			List<BookedLimitModel> listDelectLimit=new ArrayList<BookedLimitModel>();
			BookedLimitModel q=new BookedLimitModel();
			q.setIWeekNum(weekNum);
			listDelectLimit=this.limitMapper.select(q);
		    List<Integer> ids=new ArrayList<Integer>();
            for(BookedLimitModel blm: listDelectLimit){
            	ids.add(blm.getId());
            }
			
			re+=this.limitMapper.deleteInPk(ids);
			Map<String,BookedLimitModel> limits=weekPb.getLimits();
			for(Iterator<String> it=limits.keySet().iterator();it.hasNext();){
			   BookedLimitModel limit=limits.get(it.next());
			   re+=this.limitMapper.insertOne(limit);
			}
			reModel.setAction(ResultModel.ACTION_ALERT);
	    if(re==0){
	    	reModel.setTitle("操作失败");
	    	reModel.setMsg("周排班保存失败");
	    }else{
	    	reModel.setTitle("操作成功");
	    	reModel.setMsg("周排班保存成功");
	    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reModel;
	}
	
	


}
