package com.ett.drv.model.self;

public class TransactVehicleModel extends BaseTransactModel {

	public static int CODE=2;
	
	public static enum F{
		PlateNo,PlateClass
	}
	
	private String PlateNo;         //PLATE_NO  VARCHAR2 30
	private String PlateClass;         //PLATE_CLASS  VARCHAR2 100
	
	
	public static enum ETransact {
		exchange_vehicle_license,exchange_plate,exchange_qualified		
	}
	
	public static class Transacts{
		  public static String EXCHANGE_VEHICLE_LICENSE="补换行驶证";
		  public static String EXCHANGE_PLATE="补换号牌";
		  public static String EXCHANGE_QUALIFIED="补换合格标志";
	  }
	  
	
	public static class Items{
		public static String REPLACE="补领";
		public static String RENEWAL="换领";
		public static String APPLY="申领";
	}
	

	
	
	public  String getTransactCN(){
		String strCn="";
		if(ETransact.exchange_plate.name().equalsIgnoreCase(this.getTransact())){
			strCn="补领号牌";
		}else if(ETransact.exchange_qualified.name().equalsIgnoreCase(this.getTransact())){
			strCn="补领合格证";
		}else if(ETransact.exchange_vehicle_license.name().equalsIgnoreCase(this.getTransact())){
			strCn="补行驶证";
		}
		return strCn;
	}


	public String getPlateNo() {
		return PlateNo;
	}


	public void setPlateNo(String plateNo) {
		this.PlateNo = plateNo;
	}


	public String getPlateClass() {
		return PlateClass;
	}


	public void setPlateClass(String plateClass) {
		this.PlateClass = plateClass;
	}

	

	@Override
	public void setTransact(String transact) {
		// TODO Auto-generated method stub
		if(ETransact.exchange_plate.name().equalsIgnoreCase(transact)){
			this.Transact=TransactVehicleModel.Transacts.EXCHANGE_PLATE;
		}else if(ETransact.exchange_qualified.name().equalsIgnoreCase(transact)){
			this.Transact=TransactVehicleModel.Transacts.EXCHANGE_QUALIFIED;
		}else if(ETransact.exchange_vehicle_license.name().equalsIgnoreCase(transact)){
			this.Transact=TransactVehicleModel.Transacts.EXCHANGE_VEHICLE_LICENSE;
		}else {
			this.Transact=transact;
		}
	}
	
	
	
	
	
}
