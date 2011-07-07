package com.ett.drv.web.action.statis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.ett.drv.view.StatisDriverView;
import com.ett.drv.web.action.BaseDrvAction;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.StringUtil;

public class DriverAction extends BaseDrvAction {
	private StatisDriverView  statisDriverview;

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

    //异地数量统计
	public String to_ydsl(){
		return ResultEnum.jsp.name();
	}

	
	//联系地址雷同30个以上
	public String to_addressRepeat(){
		return ResultEnum.jsp.name();
	}
	
	//异地驾驶人考试情况超过100
	public String to_ydksqk(){
		return ResultEnum.jsp.name();
	}
	
	//暂住证号码雷同超过3
	public String to_zzzRepeat(){
		return ResultEnum.jsp.name();
	}
	
	public void search_address(){
		String stringbegindate=this.getParameter("begindate");
		String stringenddate=this.getParameter("enddate");
		if(StringUtil.isNotBlank(stringbegindate)&&StringUtil.isNotBlank(stringenddate)){
			Date begindate=new Date();
			Date enddate=new Date();
			try {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				begindate=sdf.parse(stringbegindate);
				enddate=sdf.parse(stringenddate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List list=this.statisBiz.selectViewAddreesRepeatGt30("a", begindate, enddate);
			JSONObject jsonDg=EasyUiUtil.toJsonDataGrid(list);
			this.writePlainText(jsonDg.toString());
		}
	}
}
