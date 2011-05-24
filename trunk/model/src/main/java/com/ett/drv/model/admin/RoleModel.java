package com.ett.drv.model.admin;

import com.smartken.kia.core.model.impl.BaseModel;

public class RoleModel extends BaseModel {

	 public static enum F { 
		  Id,CName,CDescription,CRolestring  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private String CName;         //C_NAME  VARCHAR2 30
		private String CDescription;         //C_DESCRIPTION  VARCHAR2 200
		private String CRolestring;         //C_ROLESTRING  VARCHAR2 200
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getCName() {
			return CName;
		}
		public void setCName(String cName) {
			CName = cName;
		}
		public String getCDescription() {
			return CDescription;
		}
		public void setCDescription(String cDescription) {
			CDescription = cDescription;
		}
		public String getCRolestring() {
			return CRolestring;
		}
		public void setCRolestring(String cRolestring) {
			CRolestring = cRolestring;
		}
		
		

}
