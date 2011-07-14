package com.ett.drv.biz;

import java.util.ArrayList;
import java.util.List;

import com.ett.drv.model.admin.DepartmentModel;
import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.admin.DictTypeModel;
import com.ett.drv.model.admin.RoleModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.model.booked.BookedLimitModel;
import com.smartken.kia.core.model.IBaseCrudBiz;

public interface IAdminBiz extends IBaseCrudBiz {

	public static String TYPE_NAME_KSCC="考试场次";
	public static String TYPE_NAME_KSDD="考试地点";
	public static String TYPE_NAME_KSKM="考试科目";
	public static String DEP_TYPE_SCHOOL="驾校";
	public static String DICT_VALID="字典状态";
	public static String SMZ_TYPE="证件类型";
	public static String DICT_GJ="国籍";
	public static String DICT_XB="性别";
	public static String DICT_LXZS="联系住所";
	public static String CAR_TYPE="申请车型";
	public static String DRIVER_FROM="驾驶人来源";
	public static String IF_OK="是否合格";
	public static String DICT_HOSPITAL="体检医院";
	public static String DICT_CHECK="审核结果";
	
	public List<DictModel> listKscc(String code) throws Exception;
	
	public List<DictModel> listKsdd(String code) throws Exception;
	
	public List<DepartmentModel> listSchool(String code) throws Exception;
	
	public ArrayList<RoleModel> listRoleModel() throws Exception;

	public BookedLimitModel fillObject(BookedLimitModel pLimit) throws Exception;
	
	public UserModel login(String loginName,String pwd);
	
	public List<DictModel> listIdcardType() throws Exception;
	
	public List<DictModel> listCarType() throws Exception;
	
	public List<DictModel> listKskm(String code) throws Exception;
	
	public List<DictTypeModel> listDictType() throws Exception;
	
	public List<DictModel> listDictValid() throws Exception;
	
	public List<DictModel> listDetail() throws Exception;
	
	public List<DictModel> listgj() throws Exception;
	
	public List<DictModel> listxb() throws Exception;
	
	public List<DictModel> listdjzs() throws Exception;
	
	public List<DictModel> listcartype() throws Exception;
	
	public List<DictModel> listdriverfrom() throws Exception;
	
	public List<DictModel> listifok() throws Exception;
	
	public List<DictModel> listhospital() throws Exception;
	
	public List<DictModel> listcheck()throws Exception;
	
	public List<DepartmentModel> listdepartment()throws Exception;

	public List<UserModel> listDepartmentName(Integer id) throws Exception;
}
