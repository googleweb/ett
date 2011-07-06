package com.ett.drv.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ett.drv.biz.IStatisBiz;
import com.ett.drv.view.StatisCoachCarView;
import com.ett.drv.view.StatisDriverView;
import com.ett.drv.view.StatisKmView;
import com.ett.drv.view.StatisSchoolView;

public class StatisBiz extends BaseDrvBiz implements IStatisBiz {

	public List<StatisCoachCarView> getViewCoachCar(String fzjg, String idCard,
			String hphm) {
		// TODO Auto-generated method stub
		List<StatisCoachCarView> list=new ArrayList<StatisCoachCarView>();
		try {
			list=this.statisCoachCarMapper.selectViewCoachCar(fzjg, idCard, hphm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public List<StatisDriverView> selectViewAddreesRepeatGt30(String fzjg,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		List<StatisDriverView> list=new ArrayList<StatisDriverView>();
		try {
			list=this.statisDriverMapper.selectViewAddreesRepeatGt(fzjg, startDate, endDate, 30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public List<StatisKmView> selectViewKm3KscsGt50(String fzjg,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		List<StatisKmView> list=new ArrayList<StatisKmView>();
		try {
			list=this.statisKmMapper.selectViewKm3KscsGt(fzjg, startDate, endDate, 50);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public List<StatisSchoolView> selectViewSchool(String glbm) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public List<StatisDriverView> selectViewYdKsqkGt100(String fzjg,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		List<StatisDriverView> list=new ArrayList<StatisDriverView>();
		try {
			list=this.statisDriverMapper.selectViewYdKsqkGt(fzjg, startDate, endDate, 100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public List<StatisDriverView> selectViewYdsl(String fzjg, String glbm,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		List<StatisDriverView> list=new ArrayList<StatisDriverView>();
		try {
			list=this.statisDriverMapper.selectViewYdsl(fzjg, glbm, startDate, endDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public List<StatisDriverView> selectViewZzzRepeatGt3(String fzjg,
			Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		List<StatisDriverView> list=new ArrayList<StatisDriverView>();
		try {
			list=this.statisDriverMapper.selectViewZzzRepeatGt(fzjg, startDate, endDate, 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		return list;
	}

}
