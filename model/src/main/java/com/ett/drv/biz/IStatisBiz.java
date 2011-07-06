package com.ett.drv.biz;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ett.drv.view.StatisCoachCarView;
import com.ett.drv.view.StatisDriverView;
import com.ett.drv.view.StatisKmView;
import com.ett.drv.view.StatisSchoolView;

public interface IStatisBiz {

	
	public List<StatisCoachCarView> getViewCoachCar(String fzjg ,String idCard,String hphm);
	
	public List<StatisDriverView> selectViewAddreesRepeatGt30(String fzjg,Date startDate,Date endDate);
	
	public List<StatisDriverView> selectViewYdsl(String fzjg,String glbm,Date startDate,Date endDate);
	
	public List<StatisDriverView> selectViewYdKsqkGt100(String fzjg,Date startDate,Date endDate);
	
	public List<StatisDriverView> selectViewZzzRepeatGt3(String fzjg,Date startDate,Date endDate);
	
	public List<StatisKmView> selectViewKm3KscsGt50(String fzjg,Date startDate,Date endDate);
	
	public List<StatisSchoolView> selectViewSchool(String glbm);


}
