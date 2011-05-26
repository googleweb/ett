package com.ett.drv.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


import com.smartken.kia.core.model.IBaseCrudBiz;
import com.ett.drv.model.admin.DepartmentModel;
import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.model.booked.BookedLimitModel;
import com.ett.drv.model.booked.BookedWeekRecordModel;

public interface IAdminBiz extends IBaseCrudBiz {

	public static String TYPE_NAME_KSCC="考试场次";
	public static String TYPE_NAME_KSDD="考试地点";
	public static String DEP_TYPE_SCHOOL="驾校";
	
	public ArrayList<DictModel> listKscc(String code) throws Exception;
	
	public ArrayList<DictModel> listKsdd(String code) throws Exception;
	
	public ArrayList<DepartmentModel> listSchool(String code) throws Exception;

	public BookedLimitModel fillObject(BookedLimitModel pLimit) throws Exception;
	
	public UserModel login(String loginName,String pwd);
	
	public List<DictModel> listIdcardType() throws Exception;
}
