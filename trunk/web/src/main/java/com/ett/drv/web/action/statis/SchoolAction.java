package com.ett.drv.web.action.statis;

import java.util.List;

import org.json.JSONObject;

import com.ett.drv.web.action.BaseDrvAction;
import com.smartken.kia.core.util.EasyUiUtil;

public class SchoolAction extends BaseDrvAction {

	
	/*
	 * 接受页面传递的二个参数
	 * 向页面输出json数据
	 * */
	public void datagrid_School(){
		String fzjg="111";
		String begindate=this.getParameter("begindate");
		String enddate=this.getParameter("enddate");
		if(begindate!=""&&enddate!=""&&fzjg!=""){
			//List list=this.statisBiz.
			//JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
			//this.writePlainText(jsonDG.toString());
		}
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
