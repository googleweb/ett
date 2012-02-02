package com.ett.visual.model.admin;

import com.smartken.toyz4j.model.impl.BaseModel;

public class DictModel extends BaseModel {



	 public static enum F { 
		  Id,CTypename,CDictText,CDictValue,CDes1,CDes2,CDes3,CState  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private String CTypename;         //C_TYPENAME  VARCHAR2 60
		private String CDictText;         //C_DICT_TEXT  VARCHAR2 30
		private String CDictValue;         //C_DICT_VALUE  VARCHAR2 30
		private String CDes1;         //C_DES1  VARCHAR2 30
		private String CDes2;         //C_DES2  VARCHAR2 30
		private String CDes3;         //C_DES3  VARCHAR2 30
		private String CState;         //C_STATE  VARCHAR2 10
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
		public String getCDictText() {
			return CDictText;
		}
		public void setCDictText(String cDictText) {
			CDictText = cDictText;
		}
		public String getCDictValue() {
			return CDictValue;
		}
		public void setCDictValue(String cDictValue) {
			CDictValue = cDictValue;
		}
		public String getCDes1() {
			return CDes1;
		}
		public void setCDes1(String cDes1) {
			CDes1 = cDes1;
		}
		public String getCDes2() {
			return CDes2;
		}
		public void setCDes2(String cDes2) {
			CDes2 = cDes2;
		}
		public String getCDes3() {
			return CDes3;
		}
		public void setCDes3(String cDes3) {
			CDes3 = cDes3;
		}
		public String getCState() {
			return CState;
		}
		public void setCState(String cState) {
			CState = cState;
		}
		
		
		




	
	
}
