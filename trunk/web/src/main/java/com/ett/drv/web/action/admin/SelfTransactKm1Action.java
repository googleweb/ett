package com.ett.drv.web.action.admin;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;




import com.ett.drv.model.self.Km1CheckRecordModel;
import com.ett.drv.model.self.Km1PreasignRecordModel;
import com.ett.drv.web.action.BaseAction;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class SelfTransactKm1Action extends BaseAction {

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	public String to_checkRecord(){
		return ResultEnum.jsp.name();
	}
	
	
	public String to_preasignRecord(){
		return ResultEnum.jsp.name();
	}
	
	
	public void datagrid_preasignRecord(){
		this.selfBiz.loadCrudMapper(Km1PreasignRecordModel.class);
		ArrayList listPreasignRecord=this.selfBiz.getModel(this.getPager());
		JSONArray jarrPreasignRecord=ObjectUtil.toJsonArray(listPreasignRecord);
		JSONObject jsonDg=EasyUiUtil.toJsonDataGrid(jarrPreasignRecord,this.selfBiz.count());
		this.writePlainText(jsonDg.toString());
	}
	
	
	public void datagrid_checkRecord(){
		this.selfBiz.loadCrudMapper(Km1CheckRecordModel.class);
		ArrayList listPreasignRecord=this.selfBiz.getModel(this.getPager());
		JSONArray jarrPreasignRecord=ObjectUtil.toJsonArray(listPreasignRecord);
		JSONObject jsonDg=EasyUiUtil.toJsonDataGrid(jarrPreasignRecord,this.selfBiz.count());
		this.writePlainText(jsonDg.toString());
	}
	
	public void search_checkRecord(){
		Km1CheckRecordModel query=new Km1CheckRecordModel();
		String xm=this.getParameter("xm");
		if(StringUtil.isNotBlank(xm)){
			query.setXm(xm);
		}
		String sfzmhm=this.getParameter(Km1CheckRecordModel.F.sfzmhm);
		if(StringUtil.isNotBlank(sfzmhm)){
			query.setSfzmhm(sfzmhm.length()==0?null:sfzmhm);
		}
		String ksdd=this.getParameter(Km1CheckRecordModel.F.ksdd);
		if(StringUtil.isNotBlank(ksdd)){
			query.setKsdd(ksdd.length()==0?null:ksdd);
		}
		String strCreateTime=this.getParameter(Km1CheckRecordModel.F.createtime);
		if(StringUtil.isNotBlank(strCreateTime))
		{
			Date createTime= DateTimeUtil.parse(strCreateTime.trim());
			query.setCreatetime(createTime);
		}

		ArrayList listPreasignRecord=this.selfBiz.getModel(query);
		//JSONArray jarrPreasignRecord=ObjectUtil.toJsonArray(listPreasignRecord);
		JSONObject jsonDg=EasyUiUtil.toJsonDataGrid(listPreasignRecord);
		this.writePlainText(jsonDg.toString());
	}
	
	public void search_preasignRecord(){
		Km1PreasignRecordModel query=new Km1PreasignRecordModel();
		String xm=this.getParameter("xm");
		if(StringUtil.isNotBlank(xm)){
			query.setXm(xm);
		}
		String sfzmhm=this.getParameter(Km1PreasignRecordModel.F.sfzmhm);
		if(StringUtil.isNotBlank(sfzmhm)){
			query.setSfzmhm(sfzmhm.length()==0?null:sfzmhm);
		}
		String ksddcode=this.getParameter(Km1PreasignRecordModel.F.ksddcode);
		if(StringUtil.isNotBlank(ksddcode)){
			query.setKsddcode(ksddcode.length()==0?null:ksddcode);
		}
		
		String kscccode=this.getParameter(Km1PreasignRecordModel.F.kscccode);
		if(StringUtil.isNotBlank(kscccode)){
			query.setKsddcode(kscccode.length()==0?null:kscccode);
		}
		
		String strCreateTime=this.getParameter(Km1PreasignRecordModel.F.createtime);
		if(StringUtil.isNotBlank(strCreateTime))
		{
			Date createTime= DateTimeUtil.parse(strCreateTime.trim());
			query.setCreatetime(createTime);
		}

		ArrayList listPreasignRecord=this.selfBiz.getModel(query);
		//JSONArray jarrPreasignRecord=ObjectUtil.toJsonArray(listPreasignRecord);
		JSONObject jsonDg=EasyUiUtil.toJsonDataGrid(listPreasignRecord);
		this.writePlainText(jsonDg.toString());
	}
	
}
