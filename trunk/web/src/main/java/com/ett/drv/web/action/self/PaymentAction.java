package com.ett.drv.web.action.self;

import java.util.Date;
import java.util.Random;


import com.ett.self.BaseSelfAction;
import com.opensymphony.xwork2.ModelDriven;
import com.ett.drv.biz.ISelfBiz;
import com.ett.drv.model.self.BaseTransactModel;
import com.ett.drv.model.self.DrivingLicenseModel;
import com.ett.drv.model.self.DrvFlowModel;
import com.ett.drv.model.self.TransactDriverModel;
import com.ett.drv.model.self.TransactVehicleModel;
import com.ett.drv.model.self.VehFlowModel;
import com.ett.drv.model.self.VehicleModel;
import com.ett.drv.web.action.BaseAction;
import com.smartken.kia.core.enums.ResultEnum;

public class PaymentAction extends BaseSelfAction implements ModelDriven<BaseTransactModel>{

	BaseTransactModel _trModel;
	
	private ISelfBiz selfBiz;
	
	
	
	public void setSelfBiz(ISelfBiz selfBiz) {
		this.selfBiz = selfBiz;
	}


	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//记录支付方式为现金支付，直接跳转到现金支付页面
    public String to_payment_cash(){
    	_trModel.setPayment(BaseTransactModel.Payments.CASH);
    	this.setHttpSession(ESessionKey.transact.name(), _trModel);
    	return ResultEnum.jsp.name();
    }
	
    //记录支付方式为银行pos支付，直接跳转到银行pos支付页面
    public String to_payment_pos(){
    	_trModel.setPayment(BaseTransactModel.Payments.POS);
    	this.setHttpSession(ESessionKey.transact.name(), _trModel);
    	return ResultEnum.jsp.name();
    }
    
    //现金支付后，跳转到选择获取方式页面
    public String do_payment_cash(){
    	return EJsp.print_receipt.name();
    }
	
    //银行pos支付后，跳转到选择获取方式页面
    public String do_payment_pos(){
    	return EJsp.print_receipt.name();
    }
    
    //（暂时未用到）
    public String do_payment_success(){
    	return EJsp.print_receipt.name();
    }
    
    
    /**
     * 选择接收方式，更新接收方式到数据库 
     * 跳转到打印凭条的页面，显示凭条的具体信息
    **/
    public String do_select_recevie() throws Exception{
 	  /**
    	String flowNo="";
    	
        if(_trModel instanceof TransactDriverModel){
            DrivingLicenseModel drvlModel=(DrivingLicenseModel)this.getSessionAttribute(ESessionKey.drivinglicense);
            DrvFlowModel flowModel=new DrvFlowModel();
            flowModel.setYwyy(_trModel.getReason());
            flowModel.from(drvlModel);
            flowNo=selfBiz.saveTransactAndFlow((TransactDriverModel)_trModel, flowModel);
        }else if(_trModel instanceof TransactVehicleModel){
        	VehicleModel vheModel=(VehicleModel) this.getSessionAttribute(ESessionKey.vehicle);
        	VehFlowModel flowModel=new VehFlowModel();
        	flowModel.setYwyy(_trModel.getReason());
        	//flowModel.setSqrq(_trModel.getCreateDate());
        	flowModel.from(vheModel);
        	flowNo=selfBiz.saveTransactAndFlow((TransactVehicleModel) _trModel, flowModel);
        }
        this.getRequest().setAttribute("flowNo", flowNo);
       **/
    	int re=0;
    	if(_trModel instanceof TransactDriverModel){
    		TransactDriverModel trdrvModel=(TransactDriverModel)_trModel;
    		this.selfBiz.loadCrudMapper(TransactDriverModel.class);
    		
    		re+=this.selfBiz.modifyModel(trdrvModel).getRe();
    	}else if(_trModel instanceof TransactVehicleModel){
    		TransactVehicleModel trvehModel=(TransactVehicleModel)_trModel;
    		this.selfBiz.loadCrudMapper(TransactVehicleModel.class);
    		re+=this.selfBiz.modifyModel(trvehModel).getRe();
    	}
    	if(re==0){
    		return EJsp.error.name();
    	}
    	return EJsp.payment.name();
    }

	public BaseTransactModel getModel() {
		// TODO Auto-generated method stub
		_trModel=(BaseTransactModel) this.getHttpSession().getAttribute(ESessionKey.transact.name());
		this.setHttpSession(ESessionKey.transact.name(), _trModel);
		return _trModel;
	}
}
