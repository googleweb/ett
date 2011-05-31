package com.ett.drv.biz;

import java.util.ArrayList;
import java.util.List;

import com.ett.drv.model.admin.DepartmentModel;
import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.admin.RoleModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.model.booked.BookedLimitModel;
import com.smartken.kia.core.model.IBaseCrudBiz;

public interface IAdminBiz extends IBaseCrudBiz {

	public static String TYPE_NAME_KSCC="考试场次";
	public static String TYPE_NAME_KSDD="考试地点";
	public static String TYPE_NAME_KSKM="考试科目";
	public static String DEP_TYPE_SCHOOL="驾校";
	
	public List<DictModel> listKscc(String code) throws Exception;
	
	public List<DictModel> listKsdd(String code) throws Exception;
	
	public List<DepartmentModel> listSchool(String code) throws Exception;
	
	public ArrayList<RoleModel> listRoleModel() throws Exception;

	public BookedLimitModel fillObject(BookedLimitModel pLimit) throws Exception;
	
	public UserModel login(String loginName,String pwd);
	
	public List<DictModel> listIdcardType() throws Exception;
	
	public List<DictModel> listCarType() throws Exception;
	
	public List<DictModel> listKskm(String code) throws Exception;
}
