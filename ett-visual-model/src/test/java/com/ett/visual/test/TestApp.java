package com.ett.visual.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ett.visual.model.admin.MenuModel;
import com.ett.visual.model.admin.RoleModel;
import com.smartken.toyz4j.util.EasyUiUtil;

public class TestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        System.out.println(EasyUiUtil.genDatagirdContext(RoleModel.class, "id").toScirpt());
	}

}
