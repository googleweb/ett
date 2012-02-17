package com.ett.visual.model.admin;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartken.toyz4j.model.impl.BaseModel;


public class UserModel extends BaseModel {	
	 /**
	 * 
	 */
	public static enum F { 
		  Id,LoginName,LoginPwd,RoleFk,DepFk,WorkId,BeginIp,EndIp,State,PrivateToken,PublicToken,
		PersonName,SignName  
		 } 

		private String Id;         //ID  VARCHAR2 50
		private String LoginName;         //LOGIN_NAME  VARCHAR2 50
		private String LoginPwd;         //LOGIN_PWD  VARCHAR2 100
		private String RoleFk;         //ROLE_FK  VARCHAR2 50
		private String DepFk;         //DEP_FK  VARCHAR2 50
		private String WorkId;         //WORK_ID  VARCHAR2 50
		private String BeginIp;         //BEGIN_IP  VARCHAR2 50
		private String EndIp;         //END_IP  VARCHAR2 50
		private String State;         //STATE  VARCHAR2 8
		private String PrivateToken;         //PRIVATE_TOKEN  VARCHAR2 2,000
		private String PublicToken;         //PUBLIC_TOKEN  VARCHAR2 2,000
		private String PersonName;         //PERSON_NAME  VARCHAR2 50
		private String SignName;         //SIGN_NAME  VARCHAR2 100
		
		
		
		public String getId() {
			return Id;
		}
		public void setId(String id) {
			Id = id;
		}
		public String getLoginName() {
			return LoginName;
		}
		public void setLoginName(String loginName) {
			LoginName = loginName;
		}
		public String getLoginPwd() {
			return LoginPwd;
		}
		public void setLoginPwd(String loginPwd) {
			LoginPwd = loginPwd;
		}
		public String getRoleFk() {
			return RoleFk;
		}
		public void setRoleFk(String roleFk) {
			RoleFk = roleFk;
		}
		public String getDepFk() {
			return DepFk;
		}
		public void setDepFk(String depFk) {
			DepFk = depFk;
		}
		public String getWorkId() {
			return WorkId;
		}
		public void setWorkId(String workId) {
			WorkId = workId;
		}
		public String getBeginIp() {
			return BeginIp;
		}
		public void setBeginIp(String beginIp) {
			BeginIp = beginIp;
		}
		public String getEndIp() {
			return EndIp;
		}
		public void setEndIp(String endIp) {
			EndIp = endIp;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
		public String getPrivateToken() {
			return PrivateToken;
		}
		public void setPrivateToken(String privateToken) {
			PrivateToken = privateToken;
		}
		public String getPublicToken() {
			return PublicToken;
		}
		public void setPublicToken(String publicToken) {
			PublicToken = publicToken;
		}
		public String getPersonName() {
			return PersonName;
		}
		public void setPersonName(String personName) {
			PersonName = personName;
		}
		public String getSignName() {
			return SignName;
		}
		public void setSignName(String signName) {
			SignName = signName;
		}
		public Object getPk() {
			// TODO Auto-generated method stub
			return this.Id;
		}
		@Override
		public Enum[] enumFields() {
			// TODO Auto-generated method stub
			return RoleModel.F.values();
		}
		@Override
		public void setPk(Object pk) {
			// TODO Auto-generated method stub
			this.Id=pk.toString();
		}
}
