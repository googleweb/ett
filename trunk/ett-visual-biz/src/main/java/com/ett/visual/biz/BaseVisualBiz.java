package com.ett.visual.biz;

import com.ett.visual.mapper.admin.IMenuMapper;
import com.ett.visual.mapper.admin.IUserMapper;
import com.ett.visual.model.admin.MenuModel;
import com.ett.visual.model.admin.UserModel;
import com.smartken.toyz4j.model.IMapper;
import com.smartken.toyz4j.model.impl.BaseCurdBiz;

public class BaseVisualBiz extends BaseCurdBiz{

	private IMenuMapper<MenuModel> menuMapper;
	private IUserMapper<UserModel> userMapper;

	public void setMenuMapper(IMenuMapper<MenuModel> menuMapper) {
		this.addCrudMapper(MenuModel.class, menuMapper);
		this.menuMapper = menuMapper;
	}
	public void setUserMapper(IUserMapper<UserModel> userMapper){
		this.addCrudMapper(UserModel.class, userMapper);
		this.userMapper=userMapper;
	}


	
	
}
