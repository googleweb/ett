package com.ett.drv.biz;

import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.impl.ResultModel;

public interface IPreBiz extends IBaseCrudBiz {
	
	
	public ResultModel verify(StudentApplyInfoModel studentApplyInfoModel,byte[] blobPhoto) ;

	

}
