package com.ett.visual.biz;

import com.ett.visual.mapper.admin.IDictMapper;
import com.ett.visual.mapper.admin.IDictTypeMapper;
import com.ett.visual.mapper.admin.IMenuMapper;
import com.ett.visual.mapper.admin.IRoleMapper;
import com.ett.visual.mapper.admin.IUserMapper;
import com.ett.visual.mapper.driver.IDriverFileMapper;
import com.ett.visual.mapper.driver.IDriverInfoMapper;
import com.ett.visual.model.admin.DictModel;
import com.ett.visual.model.admin.DictTypeModel;
import com.ett.visual.model.admin.MenuModel;
import com.ett.visual.model.admin.RoleModel;
import com.ett.visual.model.admin.UserModel;
import com.ett.visual.model.driver.DriverFileModel;
import com.ett.visual.model.driver.DriverInfoModel;
import com.smartken.toyz4j.model.IMapper;
import com.smartken.toyz4j.model.impl.BaseCurdBiz;

public class BaseVisualBiz extends BaseCurdBiz{

	protected IMenuMapper<MenuModel> menuMapper;
	protected IUserMapper<UserModel> userMapper;
	protected IRoleMapper<RoleModel> roleMapper;
	protected IDriverFileMapper<DriverFileModel> driverFileMapper;
	protected IDriverInfoMapper<DriverInfoModel> driverInfoMapper;
	protected IDictMapper<DictModel> dictMapper;
	protected IDictTypeMapper<DictTypeModel> dictTypeMapper;
	 
	public void setDictMapper(IDictMapper<DictModel> dictMapper){
		this.addCrudMapper(DictModel.class, dictMapper);
		this.dictMapper=dictMapper;
	}
	
	public void setDictTypeMapper(IDictTypeMapper<DictTypeModel> dictTypeMapper){
		this.addCrudMapper(DictTypeModel.class, dictTypeMapper);
		this.dictTypeMapper=dictTypeMapper;
	}

	public void setMenuMapper(IMenuMapper<MenuModel> menuMapper) {
		this.addCrudMapper(MenuModel.class, menuMapper);
		this.menuMapper = menuMapper;
	}
	public void setUserMapper(IUserMapper<UserModel> userMapper){
		this.addCrudMapper(UserModel.class, userMapper);
		this.userMapper=userMapper;
	}
	public void setRoleMapper(IRoleMapper<RoleModel> roleMapper) {
		this.roleMapper = roleMapper;
	    this.addCrudMapper(RoleModel.class, roleMapper);
	}
	public void setDriverFileMapper(
			IDriverFileMapper<DriverFileModel> driverFileMapper) {
		this.driverFileMapper = driverFileMapper;
		this.addCrudMapper(DriverFileModel.class, driverFileMapper);
	}
	public void setDriverInfoMapper(
			IDriverInfoMapper<DriverInfoModel> driverInfoMapper) {
		this.driverInfoMapper = driverInfoMapper;
		this.addCrudMapper(DriverInfoModel.class, driverInfoMapper);
	}


	
	
	
}
