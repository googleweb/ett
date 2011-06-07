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

public class SelfTransactVehAction extends BaseAction implements ModelDriven<TransactVehicleModel>{

	private TransactVehicleModel _trvehModel;
	private TransactResourceModel _trvResourceModel;
	
	private ISelfBiz selfBiz;
	
	public void setSelfBiz(ISelfBiz selfBiz) {
		this.selfBiz = selfBiz;
	}
	
	public String to_index(){
		return ResultEnum.jsp.name();
	}
	
	public void datagrid_all(){
		this.selfBiz.loadCrudMapper(TransactVehicleModel.class);
		List listTranDrv=this.selfBiz.getModel();
		JSONArray jarrTranDrv=ObjectUtil.toJsonArray(listTranDrv);
		JSONObject jobjTranDrv=EasyUiUtil.toJsonDataGrid(jarrTranDrv);
        this.writePlainText(jobjTranDrv.toString());
       
	}

	public TransactVehicleModel getModel() {
		// TODO Auto-generated method stub
	    if(this.isGet()){
	    	String flowNo=this.getParameter(BaseTransactModel.F.FlowNo);
	    	if(StringUtil.isBlank(flowNo))return null;
	    	this.selfBiz.loadCrudMapper(TransactVehicleModel.class);
	        //TransactVehicleModel query=new TransactVehicleModel();
	        //query.setFlowNo(flowNo);
	        _trvehModel=(TransactVehicleModel) this.selfBiz.getModelEqPk(flowNo);

	    }	
		return _trvehModel;
	}
	
	public String to_verify(){
    	DrivingLicenseModel query=new DrivingLicenseModel();
    	this.selfBiz.loadCrudMapper(DrivingLicenseModel.class);
    	query.setSfzmhm(_trvehModel.getDriverIdNo());
    	List listDrvLince=selfBiz.getModel(query);
    	DrivingLicenseModel drvLinModel=new DrivingLicenseModel();
    	if(listDrvLince.size()==1){
    		drvLinModel=(DrivingLicenseModel) listDrvLince.get(0);
    	}
    	this.setRequestAttribute("drivingLicense", drvLinModel.toJson().toString());
		return ResultEnum.jsp.name();
	}
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void stream_resImg(){
		String resName=this.getParameter("resName");
		String flowNo=_trvehModel.getFlowNo();
		byte[] bs=this.selfBiz.getSelfResource(flowNo, resName);
		this.writeStream(bs);
	}
	
	public void stream_DriverIdFrontImg(){
		try{
	    this.selfBiz.loadCrudMapper(TransactResourceModel.class);
	    _trvResourceModel=(TransactResourceModel)this.selfBiz.getModelEqPk(_trvehModel.getFlowNo());
		byte[] bytes=_trvResourceModel.getDriverIdFrontImg();
		this.writeStream(bytes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stream_DriverIdBackImg(){
		try{
		this.selfBiz.loadCrudMapper(TransactResourceModel.class);
		_trvResourceModel=(TransactResourceModel)this.selfBiz.getModelEqPk(_trvehModel.getFlowNo());
		byte[] bytes=_trvResourceModel.getDriverIdBackImg();
		this.writeStream(bytes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stream_AgentIdFrontImg(){
		try{
		this.selfBiz.loadCrudMapper(TransactResourceModel.class);
		_trvResourceModel=(TransactResourceModel)this.selfBiz.getModelEqPk(_trvehModel.getFlowNo());
		byte[] bytes=_trvResourceModel.getAgentIdFrontImg();
		this.writeStream(bytes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stream_AgentIdBackImg(){
		try{
			this.selfBiz.loadCrudMapper(TransactResourceModel.class);
			_trvResourceModel=(TransactResourceModel)this.selfBiz.getModelEqPk(_trvehModel.getFlowNo());
		byte[] bytes=_trvResourceModel.getAgentIdBackImg();
		this.writeStream(bytes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stream_captureImg(){
		try{
			this.selfBiz.loadCrudMapper(TransactResourceModel.class);
			_trvResourceModel=(TransactResourceModel)this.selfBiz.getModelEqPk(_trvehModel.getFlowNo());
		byte[] bytes=_trvResourceModel.getCaptureImg();
		this.writeStream(bytes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void do_verify(){
		this._trvehModel.setVerifyerFk("admin");
		this._trvehModel.setVerifyDate(new Date());
		this._trvehModel.setVerifyInd("Y");
        //System.out.println(this._trvehModel.toJson());
        int re=0;
        this.selfBiz.loadCrudMapper(TransactVehicleModel.class);
        re+=this.selfBiz.modifyModel(_trvehModel);
        ResultModel resultModel=new ResultModel();
        String msg="";
        if(re==1){
           resultModel.setTitle("操作成功");

           if("Y".equalsIgnoreCase(_trvehModel.getPassInd())){
        	   resultModel.setAction(ResultModel.ACTION_CONFIRM);
        	   msg=MessageFormat.format("记录{0}:审核通过\n 是否马上打印表格?",_trvehModel.getFlowNo());
           }else{
        	   resultModel.setAction(ResultModel.ACTION_ALERT);
        	   msg=MessageFormat.format("记录{0}:审核不通过\n 备注原因:{1}",_trvehModel.getFlowNo(),_trvehModel.getRemark());
           }
        }else {
        	resultModel.setTitle("操作失败");
        	msg="记录没有被更新，请检查数据库";
        }
        resultModel.setMsg(msg);
        this.writePlainText(resultModel.toJson().toString());
	}
	
	
}
