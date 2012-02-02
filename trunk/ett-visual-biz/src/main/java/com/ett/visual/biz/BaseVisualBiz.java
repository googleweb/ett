package com.ett.visual.biz;

import com.ett.visual.mapper.admin.IMenuMapper;
import com.ett.visual.model.admin.MenuModel;
import com.smartken.toyz4j.model.impl.BaseCurdBiz;

public class BaseVisualBiz extends BaseCurdBiz{

	private IMenuMapper<MenuModel> menuMapper;

	public void setMenuMapper(IMenuMapper<MenuModel> menuMapper) {
		this.addCrudMapper(MenuModel.class, menuMapper);
		this.menuMapper = menuMapper;
	}
	
	
}
