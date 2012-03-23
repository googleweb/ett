package com.ett.visual.model.admin;

import com.smartken.toyz4j.model.impl.BaseModel;

public class DictModel extends BaseModel {



	 public static enum F { 
		  Id,Text,Value,TypeFk,Remark,State  
		 } 

		private String Id;         //ID  VARCHAR2 50
		private String Text;         //TEXT  VARCHAR2 500
		private String Value;         //VALUE  VARCHAR2 500
		private String TypeFk;         //TYPE_FK  VARCHAR2 50
		private String Remark;         //REMARK  VARCHAR2 500
		private String State;         //STATE  VARCHAR2 10
		
		public  class SimpleQueryModel extends com.ett.visual.model.admin.DictModel { 
			  
		 } 
		
		public String getId() {
			return Id;
		}
		public void setId(String id) {
			Id = id;
		}
		public String getText() {
			return Text;
		}
		public void setText(String text) {
			Text = text;
		}
		public String getValue() {
			return Value;
		}
		public void setValue(String value) {
			Value = value;
		}
		public String getTypeFk() {
			return TypeFk;
		}
		public void setTypeFk(String typeFk) {
			TypeFk = typeFk;
		}
		public String getRemark() {
			return Remark;
		}
		public void setRemark(String remark) {
			Remark = remark;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
		
		public Object getPk() {
			// TODO Auto-generated method stub
			return this.Id;
		}
		@Override
		public Enum[] enumFields() {
			// TODO Auto-generated method stub
			return DictModel.F.values();
		}
		
		public void setPk(Object pk) {
			// TODO Auto-generated method stub
			this.Id=pk.toString();
		}
		
		
		
		




	
	
}
