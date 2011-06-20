package com.ett.drv.web.action.self;

import java.util.Date;

import com.ett.self.BaseSelfAction;
import com.opensymphony.xwork2.ModelDriven;
import com.ett.drv.model.self.BaseTransactModel;
import com.ett.drv.model.self.TransactDriverModel;
import com.ett.drv.model.self.TransactVehicleModel;


import com.smartken.kia.core.util.ObjectUtil;

public class DriverAction extends BaseSelfAction implements ModelDriven<BaseTransactModel>{

	BaseTransactModel _trModel;
	
	

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	//选择业务类型后，去到选择办理方式页面
	public String do_select_transact(){
	    	return EJsp.identity.name();
	}
	
	//选择办理方式后，去到车主身份证页面
    public String do_select_applicat(){
    	return EJsp.identity_driver.name();
    }
   
    
	public String do_identity(){

		String applicat=_trModel.getApplicat();
		if(BaseTransactModel.Applicats.AGENT.equalsIgnoreCase(applicat)){
			return EJsp.identity_agent.name();
		}else {
			return EJsp.collect_image.name();
		}
	}
	
	//办理业务后，跳到修改联系方式页面
	public String do_transact(){
		return EJsp.contact.name();
	}
	
	
//	public void setTransact(String transact) {
//		_trModel=(BaseTransactModel) this.getSessionAttribute(ESessionKey.transact);
//		_trModel.setTransact(transact);
//		this.getSession().setAttribute(ESessionKey.transact.name(), _trModel);
//	}

	
	//模型驱动，向session写入一个TransactDriverModel对象，表示驾驶证业务
	public BaseTransactModel getModel() {
		// TODO Auto-generated method stub
		_trModel=(BaseTransactModel) this.getHttpSession().getAttribute(ESessionKey.transact.name());
		if(_trModel==null){
			_trModel=new TransactDriverModel();
		    int seqno=this.createNewId();
		    _trModel.setSeqno(seqno);
		    _trModel.setCreateDate(new Date());
		}
		this.setHttpSession(ESessionKey.transact.name(), _trModel);
		return _trModel;
	}




	
}
