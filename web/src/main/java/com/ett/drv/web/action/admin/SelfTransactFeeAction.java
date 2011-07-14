package com.ett.drv.web.action.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ModelDriven;
import com.ett.drv.model.self.FeeLogModel;
import com.ett.drv.model.self.FeeReconModel;
import com.ett.drv.model.self.Km1PreasignRecordModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.smartken.kia.core.enums.EResult;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class SelfTransactFeeAction extends BaseDrvAction implements ModelDriven<FeeLogModel> {

	private FeeLogModel _feeLogModel;
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	
	public String to_feeLog(){
		return EResult.jsp.name();
	}
	
	public String to_feeRecon(){
		
		FeeLogModel query=new FeeLogModel();
		String strCreateTime=this.getParameter("cTime");
		Date createDate=new Date();
		if(StringUtil.isNotBlank(strCreateTime))
		{
			createDate= DateTimeUtil.parse(strCreateTime.trim());

		}
		_feeLogModel.setTCreatetime(createDate);
		query.setTCreatetime(createDate);
		this.selfBiz.loadCrudMapper(FeeLogModel.class);
		List listPreasignRecord=this.selfBiz.getModel(query);
		//JSONArray jarrPreasignRecord=ObjectUtil.toJsonArray(listPreasignRecord);
		JSONObject jsonDg=EasyUiUtil.toJsonDataGrid(listPreasignRecord);
		//System.err.println(jsonDg.toString());
		FeeReconModel feeReconModel=new FeeReconModel(createDate, listPreasignRecord);
		this.setRequestAttribute("datagridFeeLog",jsonDg.toString());
		this.setRequestAttribute("feeRecon",feeReconModel);
		this.setRequestAttribute("cTime", DateTimeUtil.format(createDate, "yyyy-MM-dd"));
		return EResult.jsp.name();
	}
	
	public String do_feeRecon(){
		
		String strCreateTime=this.getParameter("cTime");
		Date createDate=new Date();
		if(StringUtil.isNotBlank(strCreateTime))
		{
			createDate= DateTimeUtil.parse(strCreateTime.trim());

		}
		selfBiz.doSynFeelog(createDate);
		return to_feeRecon();
	}

	
	public void datagrid_feeLog(){
		this.selfBiz.loadCrudMapper(FeeLogModel.class);
		List listPreasignRecord=this.selfBiz.getModel(this.getPager());
		JSONArray jarrPreasignRecord=ObjectUtil.toJsonArray(listPreasignRecord);
		JSONObject jsonDg=EasyUiUtil.toJsonDataGrid(jarrPreasignRecord,this.selfBiz.count());
		this.writePlainText(jsonDg.toString());
	}
	
	
	public void search_feeLog(){
		FeeLogModel query=new FeeLogModel();
		String xm=this.getParameter("xm");
		if(StringUtil.isNotBlank(xm)){
			query.setXm(xm);
		}
		String sfzmhm=this.getParameter(FeeLogModel.F.Sfzmhm);
		if(StringUtil.isNotBlank(sfzmhm)){
			query.setSfzmhm(sfzmhm.length()==0?null:sfzmhm);
		}
		String feewaytype=this.getParameter(FeeLogModel.F.Feewaytype);
		if(StringUtil.isNotBlank(feewaytype)){
			query.setFeewaytype(feewaytype.length()==0?null:feewaytype);
		}
		
//		String kscccode=this.getParameter(Km1PreasignRecordModel.F.kscccode);
//		if(StringUtil.isNotBlank(kscccode)){
//			query.setKsddcode(kscccode.length()==0?null:kscccode);
//		}
		
		String strCreateTime=this.getParameter(FeeLogModel.F.TCreatetime);
		if(StringUtil.isNotBlank(strCreateTime))
		{
			Date createTime= DateTimeUtil.parse(strCreateTime.trim());
			query.setTCreatetime(createTime);
		}
        this.selfBiz.loadCrudMapper(FeeLogModel.class);
		List listPreasignRecord=this.selfBiz.getModel(query);
		//JSONArray jarrPreasignRecord=ObjectUtil.toJsonArray(listPreasignRecord);
		JSONObject jsonDg=EasyUiUtil.toJsonDataGrid(listPreasignRecord);
		this.writePlainText(jsonDg.toString());
	}


	public FeeLogModel getModel() {
		// TODO Auto-generated method stub
		if(_feeLogModel==null){
			_feeLogModel=new FeeLogModel();
		}
		
		return _feeLogModel;
	}



	
	
	
}
