package com.ett.drv.biz.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;


import com.ett.drv.biz.IPreBiz;
import com.ett.drv.model.dict.AreaModel;
import com.ett.drv.model.exam.ExamTKcnModel;
import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.ett.drvinterface.entity.BaseDrvResponse;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.FileUtil;
import com.ett.drvinterface.entity.DrvphotoRequest;
import com.ett.drvinterface.entity.DrvtempMidRequest;


public class PreBiz extends BaseDrvBiz implements IPreBiz{

	public ResultModel verify(StudentApplyInfoModel studentApplyInfoModel, byte[] bt) {
	    DrvtempMidRequest request=new DrvtempMidRequest();
	    DrvphotoRequest photorequest=new DrvphotoRequest();
	    request.setLsh(studentApplyInfoModel.getCLsh());
	    request.setSfzmhm(studentApplyInfoModel.getSfzmhm());
	    request.setSfzmmc(studentApplyInfoModel.getSfzmmc());
	    request.setHmcd(Integer.toString(studentApplyInfoModel.getIHmcd()));
	    request.setXm(studentApplyInfoModel.getCXm());
	    request.setXb(studentApplyInfoModel.getIXb().toString());
	    request.setCsrq(studentApplyInfoModel.getCCsrq());
	    request.setGj(studentApplyInfoModel.getCGj());
	    request.setDjzsxzqh(studentApplyInfoModel.getCDjzsxzqh());
	    request.setLxzsxxdz(studentApplyInfoModel.getCLxzsxxdz());
	    request.setLxzsyzbm(studentApplyInfoModel.getCLxzsyzbm());
	    request.setLy(studentApplyInfoModel.getCLy());
	    request.setXzqh(studentApplyInfoModel.getCXzqh());
	    request.setLxdh(studentApplyInfoModel.getCLxdh());
	    request.setZzzm(studentApplyInfoModel.getCZzzm());
	    request.setZkzmbh(studentApplyInfoModel.getCZkzmbh());
	    request.setDabh(studentApplyInfoModel.getCDabh());
	    request.setZkcx(studentApplyInfoModel.getCZkcx());
	    request.setJxmc(studentApplyInfoModel.getCJxmc());
	    request.setSg(studentApplyInfoModel.getCSg());
	    request.setZsl(studentApplyInfoModel.getIZsl());
	    request.setYsl(studentApplyInfoModel.getIYsl());
	    request.setTl(studentApplyInfoModel.getITl().toString());
	    request.setBsl(studentApplyInfoModel.getIBsl().toString());
	    request.setSz(studentApplyInfoModel.getISz().toString());
	    request.setZxz(studentApplyInfoModel.getIZxz().toString());
	    request.setYxz(studentApplyInfoModel.getIYxz().toString());
	    request.setQgjb(studentApplyInfoModel.getIQgjb().toString());
	    request.setTjrq(studentApplyInfoModel.getCTjrq());
	    request.setTjyymc(studentApplyInfoModel.getCTjyymc());
	    request.setSjhm(studentApplyInfoModel.getCSjhm());
	    request.setDzyx(studentApplyInfoModel.getCDzyx());
		// TODO Auto-generated method stub
	    photorequest.setSfzmhm(studentApplyInfoModel.getSfzmhm());
	    photorequest.setZp(studentApplyInfoModel.getBlobPhoto());

	    
		ResultModel reModel=new ResultModel();
		BaseDrvResponse response= this.drvInterface.preinput(request);
		@SuppressWarnings("unused")
		BaseDrvResponse photoresponse=this.drvInterface.photopreinput(photorequest);
		int code=response.getCode();
		if(code==BaseDrvResponse.CODE_SUCCESS){
			reModel.setTitle("请求成功");
			reModel.setMsg("");
		}else{
			reModel.setTitle("请求失败");
			reModel.setTitle(response.getRetdesc());
		}	
		return reModel;
	}
	
	public List<AreaModel> getArea(String a){
		List<AreaModel> list=null;
		try {
			list = this.drvCodeMapper.selectArea(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<ExamTKcnModel> getTopic(String cartype){
		List<ExamTKcnModel> list=null;
		try {
			list = this.examTKcnMapper.selectTopic(cartype);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	 

	



	

}
