package com.ett.drv.web.action.admin;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ett.self.BaseSelfAction;
import com.opensymphony.xwork2.ModelDriven;
import com.ett.drv.biz.ISelfBiz;
import com.ett.drv.model.self.BaseTransactModel;
import com.ett.drv.model.self.DrivingLicenseModel;
import com.ett.drv.model.self.TransactDriverModel;
import com.ett.drv.model.self.TransactResourceModel;
import com.ett.drv.model.self.TransactVehicleModel;
import com.ett.drv.web.action.BaseAction;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class SelfTransactDrvAction extends BaseAction implements ModelDriven<TransactDriverModel> {

	private ISelfBiz selfBiz;
	private TransactDriverModel _trDrvModel;
	private TransactResourceModel _trvResourceModel;
	
	public void setSelfBiz(ISelfBiz selfBiz) {
		this.selfBiz = selfBiz;
	}


	
	public void datagrid_all(){
		this.selfBiz.loadCrudMapper(TransactDriverModel.class);
		List listTranDrv=this.selfBiz.getModel();
		JSONArray jarrTranDrv=ObjectUtil.toJsonArray(listTranDrv);
		JSONObject jobjTranDrv=EasyUiUtil.toJsonDataGrid(jarrTranDrv);
        this.writePlainText(jobjTranDrv.toString());
       
	}

	public TransactDriverModel getModel() {
		// TODO Auto-generated method stub
	    if(this.isGet()){
	    	String flowNo=this.getParameter(BaseTransactModel.F.FlowNo);
	    	if(StringUtil.isBlank(flowNo))return null;
	    	this.selfBiz.loadCrudMapper(TransactDriverModel.class);
	        //TransactVehicleModel query=new TransactVehicleModel();
	        //query.setFlowNo(flowNo);
	        _trDrvModel=(TransactDriverModel) this.selfBiz.getModelEqPk(flowNo);
	    }	
		return _trDrvModel;
	}



	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}



	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
    public String to_verify() throws Exception{
    	DrivingLicenseModel query=new DrivingLicenseModel();
    	this.selfBiz.loadCrudMapper(DrivingLicenseModel.class);
    	query.setSfzmhm(_trDrvModel.getDriverIdNo());
    	List listDrvLince=selfBiz.getModel(query);
    	DrivingLicenseModel drvLinModel=new DrivingLicenseModel();
    	if(listDrvLince.size()==1){
    		drvLinModel=(DrivingLicenseModel) listDrvLince.get(0);
    	}
    	this.setRequestAttribute("drivingLicense", drvLinModel.toJson().toString());
    	return ResultEnum.jsp.name();
    }
    
    
    
	public void stream_driverIdFrontImg(){
		try{
	    this.selfBiz.loadCrudMapper(TransactResourceModel.class);
	    _trvResourceModel=(TransactResourceModel)this.selfBiz.getModelEqPk(_trDrvModel.getFlowNo());
		byte[] bytes=_trvResourceModel.getDriverIdFrontImg();
		this.writeStream(bytes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stream_driverIdBackImg(){
		try{
		this.selfBiz.loadCrudMapper(TransactResourceModel.class);
		_trvResourceModel=(TransactResourceModel)this.selfBiz.getModelEqPk(_trDrvModel.getFlowNo());
		byte[] bytes=_trvResourceModel.getDriverIdBackImg();
		this.writeStream(bytes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stream_agentIdFrontImg(){
		try{
		this.selfBiz.loadCrudMapper(TransactResourceModel.class);
		_trvResourceModel=(TransactResourceModel)this.selfBiz.getModelEqPk(_trDrvModel.getFlowNo());
		byte[] bytes=_trvResourceModel.getAgentIdFrontImg();
		this.writeStream(bytes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stream_agentIdBackImg(){
		try{
			this.selfBiz.loadCrudMapper(TransactResourceModel.class);
			_trvResourceModel=(TransactResourceModel)this.selfBiz.getModelEqPk(_trDrvModel.getFlowNo());
		byte[] bytes=_trvResourceModel.getAgentIdBackImg();
		this.writeStream(bytes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stream_captureImg(){
		try{
			this.selfBiz.loadCrudMapper(TransactResourceModel.class);
			_trvResourceModel=(TransactResourceModel)this.selfBiz.getModelEqPk(_trDrvModel.getFlowNo());
		byte[] bytes=_trvResourceModel.getCaptureImg();
		this.writeStream(bytes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void do_verify(){
		this._trDrvModel.setVerifyerFk("admin");
		this._trDrvModel.setVerifyDate(new Date());
		this._trDrvModel.setVerifyInd("Y");
        //System.out.println(this._trDrvModel.toJson());
        int re=0;
        this.selfBiz.loadCrudMapper(TransactDriverModel.class);
        re+=this.selfBiz.modifyModel(_trDrvModel);
        ResultModel resultModel=new ResultModel();
        String msg="";
        if(re==1){
           resultModel.setTitle("操作成功");

           if("Y".equalsIgnoreCase(_trDrvModel.getPassInd())){
        	   resultModel.setAction(ResultModel.ACTION_CONFIRM);
        	   msg=MessageFormat.format("记录{0}:审核通过\n 是否马上打印表格?",_trDrvModel.getFlowNo());
           }else{
        	   resultModel.setAction(ResultModel.ACTION_ALERT);
        	   msg=MessageFormat.format("记录{0}:审核不通过\n 备注原因:{1}",_trDrvModel.getFlowNo(),_trDrvModel.getRemark());
           }
        }else {
        	resultModel.setTitle("操作失败");
        	msg="记录没有被更新，请检查数据库";
        }
        resultModel.setMsg(msg);
        this.writePlainText(resultModel.toJson().toString());
	}
    
    
   
	
}
