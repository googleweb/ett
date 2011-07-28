package com.ett.drv.biz;

import java.util.List;

import com.ett.drv.model.dict.AreaModel;
import com.ett.drv.model.exam.ExamTKcnModel;
import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.impl.ResultModel;

public interface IPreBiz extends IBaseCrudBiz {
	
	
	public ResultModel verify(StudentApplyInfoModel studentApplyInfoModel,byte[] blobPhoto) ;

	public List<AreaModel> getArea(String area);
	
	public List<ExamTKcnModel> getTopic(String cartype);

}
