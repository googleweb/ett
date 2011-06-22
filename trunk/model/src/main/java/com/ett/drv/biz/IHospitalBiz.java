package com.ett.drv.biz;

import java.util.Date;
import java.util.List;

import com.smartken.kia.core.model.IBaseCrudBiz;


public interface IHospitalBiz extends IBaseCrudBiz{
	public static final int TYPE_HOSPITAL=1;
	public static final int TYPE_OPERATION=2;
	public List getViewGroupByHospital(int type,Date qbeginDate, Date qendDate);
}
