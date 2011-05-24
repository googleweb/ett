package com.ett.drv.biz.impl;


import java.util.ArrayList;
import com.ett.drv.biz.IAdminBiz;
import com.smartken.kia.core.model.impl.BaseCurdBiz;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.util.StringUtil;
import com.ett.drv.mapper.admin.IDepartmentMapper;
import com.ett.drv.mapper.admin.IDictMapper;
import com.ett.drv.mapper.admin.IMenuMapper;
import com.ett.drv.mapper.admin.IUserMapper;
import com.ett.drv.model.admin.DepartmentModel;
import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.admin.MenuModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.model.booked.BookedLimitModel;



public class AdminBiz extends BaseDrvBiz implements IAdminBiz {

	/**
	private IDictMapper<DictModel> dictMapper;
	private IDepartmentMapper<DepartmentModel> departmentMapper;
	private IMenuMapper<MenuModel> menuMapper;
	private IUserMapper<UserModel> userMapper;
 
  



	public void setDictMapper(IDictMapper<DictModel> dictMapper) {
		this.dictMapper = dictMapper;
		this.addCrudMapper(DictModel.class, dictMapper);
	}



	public void setDepartmentMapper(
			IDepartmentMapper<DepartmentModel> departmentMapper) {
		this.departmentMapper = departmentMapper;
		this.addCrudMapper(DepartmentModel.class, departmentMapper);
	}

	public void setMenuMapper(IMenuMapper<MenuModel> menuMapper) {
		this.menuMapper = menuMapper;
		this.addCrudMapper(MenuModel.class, menuMapper);
	}



	public void setUserMapper(IUserMapper<UserModel> userMapper) {
		this.userMapper = userMapper;
		this.addCrudMapper(UserModel.class, userMapper);
	}

**/

	public ArrayList<DictModel> listKscc(String code) throws Exception {
		// TODO Auto-generated method stub
		DictModel lDict=new DictModel();
		lDict.setCTypename(TYPE_NAME_KSCC);
		//lDict.setC(code);
		ArrayList<DictModel> lListKscc=dictMapper.select(lDict);
		return lListKscc;
	}


	public ArrayList<DictModel> listKsdd(String code) throws Exception {
		// TODO Auto-generated method stub
		DictModel lDict=new DictModel();
		lDict.setCTypename(TYPE_NAME_KSDD);
		//lDict.setCTypename(code);
		ArrayList<DictModel> lListKsdd=dictMapper.select(lDict);
		return lListKsdd;
	}


	public ArrayList<DepartmentModel> listSchool(String code) throws Exception {
		// TODO Auto-generated method stub
	    DepartmentModel lDep=new DepartmentModel();
        lDep.setCDeptype(DEP_TYPE_SCHOOL);
        lDep.setCDepcode(code);
        ArrayList<DepartmentModel> lListSchool=departmentMapper.select(lDep);
        return lListSchool;
	}


	public BookedLimitModel fillObject(BookedLimitModel pLimit)
			throws Exception {
		// TODO Auto-generated method stub
		if(StringUtil.isNotBlank(pLimit.getCKsccCode()))
		{
		   DictModel dict=new DictModel();
		   dict.setCTypename(TYPE_NAME_KSCC);
		   dict.setCTypename(pLimit.getCKsccCode());
		   DictModel dictKscc=dictMapper.select(dict).get(0);
		   pLimit.setCKscc(dictKscc.getCDictText());
		}
		if(StringUtil.isNotBlank(pLimit.getCKsddCode()))
		{
		   DictModel dict=new DictModel();
		   dict.setCTypename(TYPE_NAME_KSDD);
		   dict.setCTypename(pLimit.getCKsddCode());
		   DictModel dictKsdd=dictMapper.select(dict).get(0);
		   pLimit.setCKsdd(dictKsdd.getCDictText());
		}
		if(StringUtil.isNotBlank(pLimit.getCSchoolCode()))
		{
		   DepartmentModel dep=new DepartmentModel();
		   dep.setCDeptype(DEP_TYPE_SCHOOL);
		   dep.setCDepcode(pLimit.getCSchoolCode());
		   DepartmentModel depSchool=departmentMapper.select(dep).get(0);
		   pLimit.setCSchoolName(depSchool.getCDepnickname());
		}
		return pLimit;
	}



	public UserModel login(String loginName, String pwd) {
		// TODO Auto-generated method stub
		UserModel userModel=null;
		UserModel query=new UserModel();
		query.setCLoginName(loginName);
		query.setCPwd(pwd);
		try {
			ArrayList<UserModel> listUser=this.userMapper.select(query);
			userModel=listUser.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return userModel;
		}
		return userModel;
	}
	
	







}




	
	

