package com.ett.drv.biz.impl;

import com.ett.drv.biz.IPreBiz;
import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.ett.drvinterface.entity.BaseDrvResponse;
import com.smartken.kia.core.model.impl.ResultModel;

public class PreBiz extends BaseDrvBiz implements IPreBiz{

	public ResultModel verify(StudentApplyInfoModel studentApplyInfoModel) {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		BaseDrvResponse response= this.drvInterface.preinput(null);
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
