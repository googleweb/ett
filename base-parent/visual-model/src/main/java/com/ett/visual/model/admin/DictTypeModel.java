package com.ett.visual.model.admin;

import com.smartken.toyz4j.model.impl.BaseModel;

public class DictTypeModel extends BaseModel{
	
	public static enum F { 
		  Id,Text,Remark  
		 } 
	
	public  class SimpleQueryModel extends com.ett.visual.model.admin.DictTypeModel { 
		  
	 } 

		private String Id;         //ID  VARCHAR2 50
		private String Text;         //TEXT  VARCHAR2 500
		private String Remark;         //REMARK  VARCHAR2 500
		
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
		public String getRemark() {
			return Remark;
		}
		public void setRemark(String remark) {
			Remark = remark;
		}


		@Override
		public Object getPk() {
			// TODO Auto-generated method stub
			return this.Id;
		}
		@Override
		public Enum[] enumFields() {
			// TODO Auto-generated method stub
			return DictModel.F.values();
		}
		@Override
		public void setPk(Object pk) {
			// TODO Auto-generated method stub
			this.Id=pk.toString();
		}
		
		

}
