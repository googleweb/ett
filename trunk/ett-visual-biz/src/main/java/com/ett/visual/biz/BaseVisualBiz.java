package com.ett.visual.biz;

import com.ett.visual.mapper.admin.IMenuMapper;
import com.ett.visual.mapper.admin.IRoleMapper;
import com.ett.visual.model.admin.MenuModel;
import com.ett.visual.model.admin.RoleModel;
import com.smartken.toyz4j.model.IMapper;
import com.smartken.toyz4j.model.impl.BaseCurdBiz;

public class BaseVisualBiz extends BaseCurdBiz{

	private IMenuMapper<MenuModel> menuMapper;
	
	private IRoleMapper<RoleModel> roleMapper;

	public void setMenuMapper(IMenuMapper<MenuModel> menuMapper) {
		this.addCrudMapper(MenuModel.class, menuMapper);
		this.menuMapper = menuMapper;
	}

	public void setRoleMapper(IRoleMapper<RoleModel> roleMapper) {
		this.addCrudMapper(RoleModel.class, roleMapper);
		this.roleMapper = roleMapper;
	}


	
	
}
