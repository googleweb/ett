package com.ett.drv.web.action.statis;

import java.util.List;

import org.json.JSONObject;

import com.ett.drv.web.action.BaseDrvAction;
import com.smartken.kia.core.util.EasyUiUtil;



@SuppressWarnings("serial")
public class CoachCarAction extends BaseDrvAction {

	/*
	 * 接受页面传递的二个参数
	 * 向页面输出json数据
	 * */
	public void datagrid_CoachCar(){
		String fzjg="111";
		String idCard=this.getParameter("cardnum");
		String hphm=this.getParameter("carnum");
		if(fzjg!=""&&idCard!=""&&hphm!=""){
			@SuppressWarnings("unused")
			List list=this.statisBiz.getViewCoachCar(fzjg, idCard, hphm);
			JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.adminBiz.count());
			this.writePlainText(jsonDG.toString());
		}
	}
	@Override
	public void clear() {
	}



}
