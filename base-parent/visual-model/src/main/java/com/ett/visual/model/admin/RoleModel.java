package com.ett.visual.model.admin;


import com.smartken.toyz4j.model.impl.BaseModel;

public class RoleModel extends BaseModel {

	 public static enum F { 
		  Id,Name,Descp,TokenArray  
		 } 

	 public  class SimpleQueryModel extends com.ett.visual.model.admin.RoleModel { 
		  
	 } 
	 
		private String Id;         //ID  VARCHAR2 50
		
		private String Name;         //NAME  VARCHAR2 50
		private String Descp;         //DESCP  VARCHAR2 200
		private String TokenArray;         //TOKEN_ARRAY  VARCHAR2 3,000
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
		public String getDescp() {
			return Descp;
		}
		public void setDescp(String descp) {
			Descp = descp;
		}
		public String getTokenArray() {
			return TokenArray;
		}
		public void setTokenArray(String tokenArray) {
			TokenArray = tokenArray;
		}
		
		

		public Object getPk() {
			// TODO Auto-generated method stub
			return this.Id;
		}
		
	
		
		public void setPk(Object pk) {
			// TODO Auto-generated method stub
			this.Id=pk.toString();
		}
		
		
		
		
		

}
