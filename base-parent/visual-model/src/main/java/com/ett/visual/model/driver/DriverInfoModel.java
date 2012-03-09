package com.ett.visual.model.driver;

import com.ett.visual.model.BaseVisualModel;

public class DriverInfoModel extends BaseVisualModel {

	
	public static enum F { 
		  Id,Name,IdcardNo,FileNo,Phone,SchoolCode  
		 } 

	public  class SimpleQueryModel extends com.ett.visual.model.driver.DriverInfoModel { 
		  
	 } 
	
		private String Id;         //ID  VARCHAR2 50
		private String Name;         //NAME  VARCHAR2 50
		private String IdcardNo;         //IDCARD_NO  VARCHAR2 50
		private String FileNo;         //FILE_NO  VARCHAR2 50
		private String Phone;         //PHONE  VARCHAR2 50
		private String SchoolCode;         //SCHOOL_CODE  VARCHAR2 20
	
	
		
		
		
	@Override
	public Object getPk() {
		// TODO Auto-generated method stub
		return this.Id;
	}

	@Override
	public void setPk(Object pk) {
		// TODO Auto-generated method stub
        this.Id=pk.toString();
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getIdcardNo() {
		return IdcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		IdcardNo = idcardNo;
	}

	public String getFileNo() {
		return FileNo;
	}

	public void setFileNo(String fileNo) {
		FileNo = fileNo;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getSchoolCode() {
		return SchoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		SchoolCode = schoolCode;
	}
	
	
	

}
