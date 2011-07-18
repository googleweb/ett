package com.ett.drv.biz.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ett.drv.biz.IHospitalBiz;
import com.ett.drv.model.admin.BusAllInfoModel;
import com.ett.drvinterface.IDrvInterface;
import com.ett.drvinterface.entity.BaseDrvResponse;
import com.ett.drvinterface.entity.HealthBeanRequest;
import com.ett.drvinterface.entity.drvphotoRequest;
import com.smartken.kia.core.model.impl.ResultModel;

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
	
	/**
	 * 通过接口向平台添加体检信息
	 *@param BusInfModel
	 *@return 常用的ResultModel，用于提示信息
	 */
	public ResultModel addHealthMessage(BusAllInfoModel busAllInfoModel){
		ResultModel resultModel=new ResultModel();
		HealthBeanRequest healthBeanRequest=new HealthBeanRequest();
		healthBeanRequest.setSfzmmc(busAllInfoModel.getCIdcard());
		healthBeanRequest.setSg(busAllInfoModel.getCHeight());
		healthBeanRequest.setZsl(busAllInfoModel.getCZsl());
		healthBeanRequest.setYsl(busAllInfoModel.getCYxz());
		healthBeanRequest.setBsl(busAllInfoModel.getCBsl());
		healthBeanRequest.setTl(busAllInfoModel.getCTl());
		healthBeanRequest.setSz(busAllInfoModel.getCSz());
		healthBeanRequest.setZxz(busAllInfoModel.getCZxz());
		healthBeanRequest.setYxz(busAllInfoModel.getCYxz());
		healthBeanRequest.setQgjb(busAllInfoModel.getCQgjb());
		healthBeanRequest.setTjrq(busAllInfoModel.getCheckdate());
		healthBeanRequest.setTjyymc(busAllInfoModel.getCHospital());
		BaseDrvResponse response=this.drvInterface.healthBean(healthBeanRequest);
		int code=response.getCode();
		if(code==BaseDrvResponse.CODE_SUCCESS){
			resultModel.setTitle("执行成功");
			resultModel.setMsg("");
		}else{
			resultModel.setTitle("执行失败");
			resultModel.setTitle(response.getRetdesc());
		}	
		return resultModel;
	}
	/**
	 *@param 身份证号码
	 *@param 图片文件
	 *@return 常用的ResultModel，用于提示信息
	 */
	public ResultModel addPhotoMessage(BusAllInfoModel busAllInfoModel,File file){
		ResultModel resultModel=new ResultModel();
		drvphotoRequest request=new drvphotoRequest();
		request.setSfzmhm(busAllInfoModel.getCIdcard());
		request.setZp(file);
		BaseDrvResponse response=this.drvInterface.drvphoto(request);
		int code=response.getCode();
		if(code==BaseDrvResponse.CODE_SUCCESS){
			resultModel.setTitle("执行成功");
			resultModel.setMsg("");
		}else{
			resultModel.setTitle("执行失败");
			resultModel.setTitle(response.getRetdesc());
		}	
		return resultModel;
	}
}