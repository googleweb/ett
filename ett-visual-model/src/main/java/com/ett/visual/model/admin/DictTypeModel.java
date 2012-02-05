package com.ett.visual.model.admin;

import com.smartken.toyz4j.model.impl.BaseModel;

public class DictTypeModel extends BaseModel{


	 public static enum F { 
		  Id,CTypename,CDescription  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private String CTypename;         //C_TYPENAME  VARCHAR2 60
		private String CDescription;         //C_DESCRIPTION  VARCHAR2 100
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getCTypename() {
			return CTypename;
		}
		public void setCTypename(String cTypename) {
			CTypename = cTypename;
		}
		public String getCDescription() {
			return CDescription;
		}
		public void setCDescription(String cDescription) {
			CDescription = cDescription;
		}
		@Override
		public Object getPk() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void setPk(Object pk) {
			// TODO Auto-generated method stub
			
		}
		
		

}
