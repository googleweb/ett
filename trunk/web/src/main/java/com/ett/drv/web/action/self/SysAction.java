package com.ett.drv.web.action.self;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ett.drv.biz.ISelfBiz;
import com.ett.drv.model.self.DeviceModel;
import com.ett.drv.model.self.TerminalModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;

public class SysAction extends BaseDrvAction {

	private ISelfBiz selfBiz;
	
	
	
	public void setSelfBiz(ISelfBiz selfBiz) {
		this.selfBiz = selfBiz;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	
	public String to_device() throws Exception{
		return ResultEnum.jsp.name();
	}

	public String to_terminal() throws Exception{
		return ResultEnum.jsp.name();
	}
	
	public void list_device() throws Exception{
	    selfBiz.loadCrudMapper(DeviceModel.class);
	    List list=selfBiz.getModel();
	    JSONArray jarr=ObjectUtil.toJsonArray(list);
	    JSONObject dg=EasyUiUtil.toJsonDataGrid(jarr);
	    this.writePlainText(dg.toString());
	}
	
	public void list_terminal() throws Exception{
	    selfBiz.loadCrudMapper(TerminalModel.class);
	    List list=selfBiz.getModel();
	    JSONArray jarr=ObjectUtil.toJsonArray(list);
	    JSONObject dg=EasyUiUtil.toJsonDataGrid(jarr);
	    this.writePlainText(dg.toString());
	}
	
	
}
