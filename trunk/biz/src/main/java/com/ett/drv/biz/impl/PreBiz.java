package com.ett.drv.biz.impl;

import java.io.File;

import com.ett.drv.biz.IPreBiz;
import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.ett.drvinterface.entity.BaseDrvResponse;
import com.smartken.kia.core.model.impl.ResultModel;
import com.ett.drvinterface.entity.DrvtempMidRequest;
import com.ett.drvinterface.entity.drvphotoRequest;

public class PreBiz extends BaseDrvBiz implements IPreBiz{

	public ResultModel verify(StudentApplyInfoModel studentApplyInfoModel,byte[] photo) {
	    DrvtempMidRequest request=new DrvtempMidRequest();
	    drvphotoRequest photorequest=new drvphotoRequest();
	    request.setLsh(studentApplyInfoModel.getCLsh());
	    request.setSfzmhm(studentApplyInfoModel.getSfzmhm());
	    request.setSfzmmc(studentApplyInfoModel.getSfzmmc());
	    request.setHmcd(Integer.toString(studentApplyInfoModel.getIHmcd()));
	    request.setXm(studentApplyInfoModel.getCXm());
	    request.setXb((studentApplyInfoModel.getIXb()==1)?"男":"女");
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
	    request.setTl((studentApplyInfoModel.getITl()==1?"合格":"不合格"));
	    request.setBsl((studentApplyInfoModel.getIBsl()==1?"合格":"不合格"));
	    request.setSz(studentApplyInfoModel.getISz()==1?"合格":"不合格");
	    request.setZxz(studentApplyInfoModel.getIZxz()==1?"合格":"不合格");
	    request.setYxz(studentApplyInfoModel.getIYxz()==1?"合格":"不合格");
	    request.setQgjb(studentApplyInfoModel.getIQgjb()==1?"合格":"不合格");
	    request.setTjrq(studentApplyInfoModel.getCTjrq());
	    request.setTjyymc(studentApplyInfoModel.getCTjyymc());
	    request.setSjhm(studentApplyInfoModel.getCSjhm());
	    request.setDzyx(studentApplyInfoModel.getCDzyx());
		// TODO Auto-generated method stub
	    photorequest.setSfzmhm(studentApplyInfoModel.getSfzmhm());
	    photorequest.setZp(photo);
	    
		ResultModel reModel=new ResultModel();
		BaseDrvResponse response= this.drvInterface.preinput(request);
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

	



	

}
