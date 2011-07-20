package com.ett.drv.biz;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.ett.drv.model.admin.BusAllInfoModel;
import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.impl.ResultModel;


public interface IHospitalBiz extends IBaseCrudBiz{
	public static final int TYPE_HOSPITAL=1;
	public static final int TYPE_OPERATION=2;
	public List getViewGroupByHospital(int type,Date qbeginDate, Date qendDate);
	public ResultModel addHealthMessage(BusAllInfoModel busAllInfoModel);
	public ResultModel addPhotoMessage(BusAllInfoModel busAllInfoModel,File file);
	public byte[] getphotoByCIdcard(String sfzmmc,String sfzmhm);
}
