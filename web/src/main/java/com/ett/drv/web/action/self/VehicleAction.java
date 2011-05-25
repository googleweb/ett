package com.ett.drv.web.action.self;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import com.ett.self.BaseSelfAction;
import com.opensymphony.xwork2.ModelDriven;
import com.ett.drv.biz.ISelfBiz;
import com.ett.drv.model.self.BaseTransactModel;
import com.ett.drv.model.self.TransactVehicleModel;
import com.ett.drv.model.self.VehicleModel;
import com.ett.drv.web.action.BaseAction;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;


public class VehicleAction extends BaseSelfAction implements ModelDriven<BaseTransactModel>{

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
		_trModel=(BaseTransactModel) this.getHttpSession().getAttribute(ESessionKey.transact.name());
		if(_trModel==null){
			_trModel=new TransactVehicleModel();
		}
		this.setHttpSession(ESessionKey.transact.name(), _trModel);
	}
	
	
	
	public String to_index(){
		//this.getUser();
		//DrvUser user=this.iDrvQueryHelper.getUserWithLicense(this.getUser().getSfzmhm(), this.getDevice().getGlbm());
		//this.createNewId();
		return EJsp.index.name();
	}
	
	
	//选择业务类型后，去到选择办理方式页面
    public String do_select_transact(){
    	return EJsp.identity.name();
    }
	
	

    //根据机动车序列号从session的driverCar中获取一辆机动车信息，并根据业务类型跳转到相应的页面
	public String to_transact(){

		String transact=_trModel.getTransact();
		//VehicleModel vehmModel=null;
		String xh=this.getParamter(VehicleModel.F.Xh.name());
		ArrayList<VehicleModel> listCars= (ArrayList<VehicleModel>) this.getHttpSession().getAttribute(ESessionKey.driverCars.name());
		for(Iterator<VehicleModel> it=listCars.iterator();it.hasNext();){
			VehicleModel tmpVheModel=it.next();
			if(xh.trim().equalsIgnoreCase(tmpVheModel.getXh().trim())){
				
				TransactVehicleModel trvModel=(TransactVehicleModel)_trModel;
				trvModel.setPlateNo(tmpVheModel.getHphm());
				this.setHttpSession(ESessionKey.vehicle.name(), tmpVheModel);
				this.setHttpSession(ESessionKey.transact.name(), trvModel);
				break;
			}
		}
//		if(TransactVehicleModel.ETransact.exchange_vehicle_license.name().equalsIgnoreCase(transact)){
//			return EJsp.exchange_vehicle_license.name();
//		}else if(TransactVehicleModel.ETransact.exchange_plate.name().equalsIgnoreCase(transact)){
//			return EJsp.exchange_plate.name();
//		}else if(TransactVehicleModel.ETransact.exchange_qualified.name().equalsIgnoreCase(transact)){
//			return EJsp.exchange_qualified.name();
//		}
		return EJsp.transact.name();
	}
	
	
	public String do_transact(){
		
		return EJsp.contact.name();
	}
	


//	public void setTransact(String transact) {
//		//if(ObjectUtil.isInArray(transact, Transact.valu  es()
//		_trModel=(BaseTransactModel) this.getSessionAttribute(ESessionKey.transact);
//		_trModel.setTransact(transact);
//		this.getSession().setAttribute(ESessionKey.transact.name(), _trModel);
//	}
	//模型驱动，向session写入一个TransactVehicleModel对象，表示机动车业务
	public BaseTransactModel getModel() {
		// TODO Auto-generated method stub

		_trModel=(BaseTransactModel) this.getHttpSession().getAttribute(ESessionKey.transact.name());
		if(_trModel==null){
			_trModel=new TransactVehicleModel();
		    _trModel.setCreateDate(new Date());
		}
		this.setHttpSession(ESessionKey.transact.name(), _trModel);
		return _trModel;
	}




	




}
