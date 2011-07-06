package com.ett.drv.web.action.statis;

import com.ett.drv.web.action.BaseDrvAction;
import com.smartken.kia.core.enums.ResultEnum;

public class DriverAction extends BaseDrvAction {

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

    //异地数量统计
	public String to_ydsl(){
		return ResultEnum.jsp.name();
	}

	
	//联系地址雷同30个以上
	public String to_addressRepeat(){
		return ResultEnum.jsp.name();
	}
	
	//异地驾驶人考试情况超过100
	public String to_ydksqk(){
		return ResultEnum.jsp.name();
	}
	
	//暂住证号码雷同超过3
	public String to_zzzRepeat(){
		return ResultEnum.jsp.name();
	}
}
