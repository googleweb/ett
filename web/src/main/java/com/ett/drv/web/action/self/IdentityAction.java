package com.ett.drv.web.action.self;

import java.io.IOException;
import java.util.ArrayList;

import com.ett.model.DrvUser;
import com.ett.self.BaseSelfAction;
import com.ett.self.fee.model.FeeObject;
import com.opensymphony.xwork2.ModelDriven;
import com.ett.drv.biz.ISelfBiz;
import com.ett.drv.model.self.BaseTransactModel;
import com.ett.drv.model.self.DrivingLicenseModel;
import com.ett.drv.model.self.DrvFlowModel;
import com.ett.drv.model.self.TransactDriverModel;
import com.ett.drv.model.self.TransactResourceModel;
import com.ett.drv.model.self.TransactVehicleModel;
import com.ett.drv.model.self.VehFlowModel;
import com.ett.drv.model.self.VehicleModel;
import com.ett.drv.web.action.BaseAction;

import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.util.FileUtil;
import com.smartken.kia.core.util.ObjectUtil;

public class IdentityAction extends BaseSelfAction implements ModelDriven<BaseTransactModel>{

	
	private BaseTransactModel _trModel;
	
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

	//选择申请方式后，跳转到车主身份证页面
    public String do_select_applicat(){
    	return EJsp.identity_driver.name();
    }
    
    //刷完车主身份证后，如果是代理人办理，则跳转到代理人身份证页面；否则直接跳到图片采集页面
	public String do_identityDriver(){
//		 this.getHttpSession().setAttribute(ESessionKey.transact.name(), _trModel);
//		String applicat=_trModel.getApplicat();
//		if(BaseTransactModel.EApplicat.agent.name().equalsIgnoreCase(applicat)){
//			return EJsp.identity_agent.name();
//		}else {
//			return EJsp.collect_image.name();
//		}
		
		String transact=_trModel.getTransact();
		DrvUser drvUser=this.getUser();
		_trModel.setDriverIdNo(drvUser.getSfzmhm());
		_trModel.setDriverIdName(drvUser.getXm());
		
		DrvUser agentUser=this.getAgentUser();
		if(agentUser!=null){
		  _trModel.setAgentIdNo(agentUser.getSfzmhm());
		  _trModel.setAgentIdName(agentUser.getXm());
		  _trModel.setApplicat(BaseTransactModel.Applicat.AGENT);
		}else{
		  _trModel.setApplicat(BaseTransactModel.Applicat.DRIVER);
		}
		 this.getHttpSession().setAttribute(ESessionKey.transact.name(),_trModel);
		String sfzmhm=_trModel.getDriverIdNo();
	    DrivingLicenseModel drlModel=null;
		try {		
			this.selfBiz.loadCrudMapper(DrivingLicenseModel.class);
		   // sfzmhm=this.getUser().getSfzmhm();
		    DrivingLicenseModel query=new DrivingLicenseModel();
		    query.setSfzmhm(sfzmhm);

			ArrayList listDrvL = selfBiz.getModel(query);
			if(listDrvL.size()>0){
			  drlModel=(DrivingLicenseModel) listDrvL.get(0);	   
			}else {
				return EJsp.error.name();
			}
			this.setHttpSession(ESessionKey.drivinglicense.name(), drlModel); 
		} catch (Exception e) {
			return EJsp.error.name();
		}

		if( _trModel instanceof TransactVehicleModel)
		{
			   this.selfBiz.loadCrudMapper(VehicleModel.class);
			   VehicleModel query=new VehicleModel();
			   query.setSfzmhm(sfzmhm);
				ArrayList driverCars=selfBiz.getModel(query);
				this.setHttpSession(ESessionKey.driverCars.name(),driverCars );
				if(driverCars==null|| driverCars.size()==0){
					return EJsp.error.name();
				}

//				if(BaseTransactModel.EApplicat.agent.name().equalsIgnoreCase(_trModel.getApplicat())){
//						return EJsp.identity_agent.name();
//				}
				return EJsp.list_cars.name();
		}else if(_trModel instanceof TransactDriverModel){
			   TransactDriverModel trdModel=(TransactDriverModel)_trModel;
			   trdModel.setLicenseNo(drlModel.getDabh());
			   this.setHttpSession(ESessionKey.transact.name(), trdModel);
//			   if(BaseTransactModel.EApplicat.agent.name().equalsIgnoreCase(_trModel.getApplicat())){
//					return EJsp.identity_agent.name();
//				}
				   return EJsp.transactDrv.name();
		}

        return EJsp.error.name();
		
	}
	
	//刷完代理人身份证后，直接跳到图片采集页面
	public String do_identityAgent(){
		
		DrvUser agentUser=this.getAgentUser();
		_trModel.setAgentIdNo(agentUser.getSfzmhm());
		_trModel.setAgentIdName(agentUser.getXm());
		
        this.setHttpSession(ESessionKey.transact.name(), _trModel);
		if( _trModel instanceof TransactVehicleModel)
		{
			return EJsp.list_cars.name();
		}else if( _trModel instanceof TransactDriverModel)
		{
			return EJsp.transactDrv.name();
		}
		return EJsp.error.name();
	}
	
	/**采集头像信息后，判断业务类型
	 * 1.机动车业务：根据车主身份证号码获取车主所有机动车的信息，并保存到session中，最后跳转到机车车列表页面
	 * 2.驾驶证业务：根据车主身份证号码获取车主驾驶证信息，并保存到session中；再根据换证原因（到期、遗失和损坏）跳转到相应的业务办理页面
    **/
	public String do_collect_image(){
		return EJsp.select_receive.name();
//		String transact=_trModel.getTransact();
//		if( _trModel instanceof TransactVehicleModel)
//		{
//			   this.selfBiz.loadCrudMapper(VehicleModel.class);
//			   VehicleModel query=new VehicleModel();
//			   String sfzmhm=_trModel.getDriverIdNo();
//			   query.setSfzmhm(sfzmhm);
//			   try {
//				ArrayList driverCars=selfBiz.getModel(query);
//				this.setHttpSession(ESessionKey.driverCars.name(),driverCars );
//				if(driverCars==null|| driverCars.size()==0){
//					return EJsp.error.name();
//				}else if(driverCars.size()==1){
//					VehicleModel tmpVheModel=(VehicleModel) driverCars.get(0);
//					TransactVehicleModel trvModel=(TransactVehicleModel)_trModel;
//					trvModel.setPlateNo(tmpVheModel.getHphm());
//					trvModel.setPlateClass(tmpVheModel.getHpzl());
//					this.setHttpSession(ESessionKey.vehicle.name(), tmpVheModel);
//					this.setHttpSession(ESessionKey.transact.name(), trvModel);
//					if(TransactVehicleModel.ETransact.exchange_vehicle_license.name().equalsIgnoreCase(transact)){
//						return EJsp.exchange_vehicle_license.name();
//					}else if(TransactVehicleModel.ETransact.exchange_plate.name().equalsIgnoreCase(transact)){
//						return EJsp.exchange_plate.name();
//					}else if(TransactVehicleModel.ETransact.exchange_qualified.name().equalsIgnoreCase(transact)){
//						return EJsp.exchange_qualified.name();
//					}
//				}else{
//					return EJsp.list_cars.name();
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			   return EJsp.list_cars.name();
//		}else if(_trModel instanceof TransactDriverModel){
//			   this.selfBiz.loadCrudMapper(DrivingLicenseModel.class);
//			   String sfzmhm=_trModel.getDriverIdNo();
//			   DrivingLicenseModel query=new DrivingLicenseModel();
//			   query.setSfzmhm(sfzmhm);
//			   DrivingLicenseModel drlModel=null;
//			try {
//				ArrayList listDrvL = selfBiz.getModel(query);
//				if(listDrvL.size()>0){
//				  drlModel=(DrivingLicenseModel) listDrvL.get(0);	   
//				}
//			} catch (Exception e) {e.printStackTrace();}
//			   TransactDriverModel trdModel=(TransactDriverModel)_trModel;
//			   trdModel.setLicenseNo(drlModel.getDabh());
//			   this.setHttpSession(ESessionKey.drivinglicense.name(), drlModel); 
//			   this.setHttpSession(ESessionKey.transact.name(), trdModel);
//			   if(transact.equalsIgnoreCase(TransactDriverModel.ETransact.exchange_driver_license.name())){
//			       return EJsp.exchange_driver_license.name();
//			    }else if(transact.equalsIgnoreCase(TransactDriverModel.ETransact.lost_driver_license.name())){
//			       return EJsp.lost_driver_license.name();
//			    }else if(transact.equalsIgnoreCase(TransactDriverModel.ETransact.destroy_driver_license.name())){
//			       return EJsp.destroy_driver_license.name();
//			    }else {return null;}
//		}
//       else {
//	    	return null;
//	    }
		
	}	
	
	/**修改联系方式后，往数据库写入流水信息和业务信息。先判断业务类型
    * 1.机动车业务：流水信息保存到VEH_FLOW，业务信息保存到SELF_TRANSACT_VEHICLE
    * 2.驾驶证业务：流水信息保存到DRV_FLOW，业务信息保存到SELF_TRANSACT_DRIVER
    * 
    * 成功保存后获取生成的流水号；
	**/
	public String do_contact(){
    	String flowNo="";
    	_trModel.setReceive(BaseTransactModel.Receive.PULL_OR_POST);
    	_trModel.setSeqno(this.getiIdGeneratorBiz().createNewId());
    	_trModel.setCostPost(Double.valueOf(0));
    	_trModel.setCostTransact(Double.valueOf(35));
//    	    	String flowNo="";
        
    	//_trModel.setCostPost(costPost)
    	//FeeObject feeObject=new FeeObject();
    	//this.getFeeObject().setMoney(30);
        //this.setFeeObject(feeObject);
        if(_trModel instanceof TransactDriverModel){
            DrivingLicenseModel drvlModel=(DrivingLicenseModel)this.getHttpSession().getAttribute(ESessionKey.drivinglicense.name());
            DrvFlowModel flowModel=new DrvFlowModel();
            flowModel.setYwyy(_trModel.getReason());
            flowModel.from(drvlModel);
            flowNo=selfBiz.saveTransactAndFlow((TransactDriverModel)_trModel, flowModel);
        }else if(_trModel instanceof TransactVehicleModel){
        	VehicleModel vheModel=(VehicleModel) this.getHttpSession().getAttribute(ESessionKey.vehicle.name());
        	VehFlowModel flowModel=new VehFlowModel();
        	flowModel.setYwyy(_trModel.getReason());
        	//flowModel.setSqrq(_trModel.getCreateDate());
        	flowModel.from(vheModel);
        	flowNo=selfBiz.saveTransactAndFlow((TransactVehicleModel) _trModel, flowModel);
        }
        _trModel.setFlowNo(flowNo);		
        this.setHttpSession(ESessionKey.transact.name(), _trModel);
        TransactResourceModel resModel=new TransactResourceModel();
        resModel.setFlowNo(flowNo);
        try {
			resModel.setDriverIdBackImg(FileUtil.toBytes("h://"+TransactResourceModel.F.driverIdBackImg.name()+".jpg"));
			resModel.setDriverIdFrontImg(FileUtil.toBytes("h://"+TransactResourceModel.F.driverIdFrontImg.name()+".jpg"));
			resModel.setAgentIdBackImg(FileUtil.toBytes("h://"+TransactResourceModel.F.agentIdBackImg.name()+".jpg"));
			resModel.setAgentIdFrontImg(FileUtil.toBytes("h://"+TransactResourceModel.F.agentIdFrontImg.name()+".jpg"));
			resModel.setCaptureImg(FileUtil.toBytes("h://"+TransactResourceModel.F.captureImg.name()+".jpg"));
			this.selfBiz.loadCrudMapper(TransactResourceModel.class);
			this.selfBiz.addModel(resModel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return EJsp.payment.name();
        //return EJsp.collect_image.name();
	}
	
	


	public BaseTransactModel getModel() {
		// TODO Auto-generated method stub
		_trModel=(BaseTransactModel) this.getHttpSession().getAttribute(ESessionKey.transact.name());
		this.setHttpSession(ESessionKey.transact.name(), _trModel);
		return _trModel;
	}
}
