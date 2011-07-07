package com.ett.drv.biz;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ett.drv.view.StatisCoachCarView;
import com.ett.drv.view.StatisDriverView;
import com.ett.drv.view.StatisKmView;
import com.ett.drv.view.StatisSchoolView;

public interface IStatisBiz {

	//教练车查询
	public List<StatisCoachCarView> getViewCoachCar(String fzjg ,String idCard,String hphm);
	
	
	//联系地址雷同30个以上
	public List<StatisDriverView> selectViewAddreesRepeatGt30(String fzjg,Date startDate,Date endDate);
	
	//异地数量统计
	public List<StatisDriverView> selectViewYdsl(String fzjg,String glbm,Date startDate,Date endDate);
	
	
	//异地驾驶人考试情况超过100的
	public List<StatisDriverView> selectViewYdKsqkGt100(String fzjg,Date startDate,Date endDate);
	
	
	//暂住证号码雷同超过3个
	public List<StatisDriverView> selectViewZzzRepeatGt3(String fzjg,Date startDate,Date endDate);
	
	
	//考试员科目三一天考试次数超过50
	public List<StatisKmView> selectViewKm3KscsGt50(String fzjg,Date startDate,Date endDate);
	
	//驾校状况统计(未能使用)
	public List<StatisSchoolView> selectViewSchool(String glbm,Date startDate,Date endDate);


}
