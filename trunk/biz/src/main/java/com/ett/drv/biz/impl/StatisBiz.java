package com.ett.drv.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ett.common.util.MathUtil;
import com.ett.drv.biz.IStatisBiz;
import com.ett.drv.view.StatisCoachCarView;
import com.ett.drv.view.StatisDriverView;
import com.ett.drv.view.StatisKmView;
import com.ett.drv.view.StatisSchoolView;
import com.smartken.kia.core.util.ObjectUtil;

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

	public List<StatisSchoolView> selectViewSchool(String glbm,Date startDate,Date endDate) {
		// TODO Auto-generated method stub
		List<StatisSchoolView> listSchool=new ArrayList<StatisSchoolView>();
		Map<String, StatisSchoolView> mapSchool=new HashMap<String, StatisSchoolView>();
		try {
			listSchool=this.statisSchoolMapper.selectViewFirstQuery(glbm, startDate, endDate);
			if(listSchool.size()==0){
				return listSchool;
			}
			for(StatisSchoolView tempSchool:listSchool){
				mapSchool.put(tempSchool.getJxmc(), tempSchool);
			}
			List<StatisSchoolView> listTempSchool=new ArrayList<StatisSchoolView>();
			
			//secondQuery
			listTempSchool=this.statisSchoolMapper.selectViewSecondQuery(glbm, startDate, endDate);
			for(StatisSchoolView tempSchool:listTempSchool){
				StatisSchoolView tSchool=mapSchool.get(tempSchool.getJxmc());
				if(tSchool!=null){
					int km1hg=tSchool.getKm1hg()+tempSchool.getKm1hg();
					int zkhg=tSchool.getZkhg()+tempSchool.getZkhg();
					int km3hg=tSchool.getKm3hg()+tempSchool.getKm3hg();
					tSchool.setKm1hg(km1hg);
					tSchool.setZkhg(zkhg);
					tSchool.setKm3hg(km3hg);
					mapSchool.put(tSchool.getJxmc(), tSchool);
				}
			}
			
			//OnStudyQuery
			listTempSchool=this.statisSchoolMapper.selectViewOnStudyQuery(glbm, startDate, endDate);
			for(StatisSchoolView tempSchool:listTempSchool){
				StatisSchoolView tSchool=mapSchool.get(tempSchool.getJxmc());
				if(tSchool!=null){
					int onStudy=tSchool.getOnStudy();
					tSchool.setOnStudy(onStudy);
					mapSchool.put(tSchool.getJxmc(), tSchool);
				}
			}
			
			//Km1DkQuery
			listTempSchool=this.statisSchoolMapper.selectViewKm1DkQuery(glbm, startDate, endDate);
			for(StatisSchoolView tempSchool:listTempSchool){
				StatisSchoolView tSchool=mapSchool.get(tempSchool.getJxmc());
				if(tSchool!=null){
					int km1c1dk=tSchool.getKm1c1dk();
					int km1nc1dk=tSchool.getKm1nc1dk();
					tSchool.setKm1c1dk(km1c1dk);
					tSchool.setKm1nc1dk(km1nc1dk);
					mapSchool.put(tSchool.getJxmc(), tSchool);
				}
			}
			
			//ZkDkQuery
			listTempSchool=this.statisSchoolMapper.selectViewZkDkQuery(glbm, startDate, endDate);
			for(StatisSchoolView tempSchool:listTempSchool){
				StatisSchoolView tSchool=mapSchool.get(tempSchool.getJxmc());
				if(tSchool!=null){
					int zkc1dk=tSchool.getZkc1dk();
					int zknc1dk=tSchool.getZknc1dk();
					tSchool.setZkc1dk(zkc1dk);
					tSchool.setZknc1dk(zknc1dk);
					mapSchool.put(tSchool.getJxmc(), tSchool);
				}
			}
			
			//CdDkQuery
			listTempSchool=this.statisSchoolMapper.selectViewCdDkQuery(glbm, startDate, endDate);
			for(StatisSchoolView tempSchool:listTempSchool){
				StatisSchoolView tSchool=mapSchool.get(tempSchool.getJxmc());
				if(tSchool!=null){
					int cdc1dk=tSchool.getCdc1dk();
					int cdnc1dk=tSchool.getCdnc1dk();
					tSchool.setCdc1dk(cdc1dk);
					tSchool.setCdnc1dk(cdnc1dk);
					mapSchool.put(tSchool.getJxmc(), tSchool);
				}
			}
			
			//Km3DkQuery
			listTempSchool=this.statisSchoolMapper.selectViewKm3DkQuery(glbm, startDate, endDate);
			for(StatisSchoolView tempSchool:listTempSchool){
				StatisSchoolView tSchool=mapSchool.get(tempSchool.getJxmc());
				if(tSchool!=null){
					int km3c1dk=tSchool.getKm3c1dk();
					int km3nc1dk=tSchool.getKm3nc1dk();
					tSchool.setKm3c1dk(km3c1dk);
					tSchool.setKm3nc1dk(km3nc1dk);
					mapSchool.put(tSchool.getJxmc(), tSchool);
				}
			}
			
			//计算合格率
			for(Iterator<String> it=mapSchool.keySet().iterator();it.hasNext();){
				String key=it.next();
				StatisSchoolView tSchool=mapSchool.get(key);
				if(tSchool!=null){
					int km1hg=ObjectUtil.formatInt(tSchool.getKm1hg(),0) ;
					int km1bhg=ObjectUtil.formatInt(tSchool.getKm1bhg(),0);
					int zkhg=ObjectUtil.formatInt(tSchool.getZkhg(),0);
					int zkbhg=ObjectUtil.formatInt(tSchool.getZkbhg(),0);
					int cdhg=ObjectUtil.formatInt(tSchool.getCdhg(),0);
					int cdbhg=ObjectUtil.formatInt(tSchool.getCdbhg(),0);
					int km3hg=ObjectUtil.formatInt(tSchool.getKm3hg(),0);
					int km3bhg=ObjectUtil.formatInt(tSchool.getKm3bhg(),0);
					String km1hgl=MathUtil.percent(km1hg, km1bhg);
					String zkhgl=MathUtil.percent(zkhg, zkbhg);
					String cdhgl=MathUtil.percent(cdhg, cdbhg);
					String km3hgl=MathUtil.percent(km3hg, km3bhg);
					String zhgl=MathUtil.percent(km1hg+zkhg+cdhg+km3hg, km1bhg+zkbhg+cdbhg+km3bhg);
					
					tSchool.setKm1hgl(km1hgl);
					tSchool.setZkhgl(zkhgl);
					tSchool.setCdhgl(cdhgl);
					tSchool.setKm3hgl(km3hgl);
					tSchool.setZhgl(zhgl);
                    
					mapSchool.put(tSchool.getJxmc(), tSchool);
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<StatisSchoolView>) mapSchool.values();
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
