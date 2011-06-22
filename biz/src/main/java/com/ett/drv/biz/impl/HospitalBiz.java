package com.ett.drv.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ett.drv.biz.IHospitalBiz;

public class HospitalBiz extends BaseDrvBiz implements IHospitalBiz {

	public List getViewGroupByHospital(int type, Date startDate, Date endDate) {
		List list = new ArrayList();
		try {
			if(type==TYPE_HOSPITAL){
				list = this.busAllInfoMapper.selectGroupByHospital(startDate,endDate);
			}else if(type==TYPE_OPERATION){
				list = this.busAllInfoMapper.selectGroupByOperaction(startDate, endDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * public List getViewGroupByHospital(Date startDate, Date endDate){ return
	 * this.busAllInfoMapper.selectGroupByHospital(startDate,endDate); }
	 */
}
