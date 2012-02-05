package com.ett.visual.model.admin;

import org.json.JSONException;
import org.json.JSONObject;

import com.smartken.toyz4j.model.impl.BaseModel;


public class UserModel extends BaseModel {	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static enum F { 
		  Id,CLoginName,CFullName,CPwd,IRoleid,IDepid,CIdcard,CWorkid,CBeginip,CEndip,CState  
		 } 
	 
	 public static enum V{
		 RoleName,DepName
	 }
		private Integer Id;         //ID  NUMBER 38
		private String CLoginName;         //C_LOGIN_NAME  VARCHAR2 30
		private String CFullName;         //C_FULL_NAME  VARCHAR2 30
		private String CPwd;         //C_PWD  VARCHAR2 200
		private Integer IRoleid;         //I_ROLEID  NUMBER 38
		private Integer IDepid;         //I_DEPID  NUMBER 38
		private String CIdcard;         //C_IDCARD  VARCHAR2 20
		private String CWorkid;         //C_WORKID  VARCHAR2 20
		private String CBeginip;         //C_BEGINIP  VARCHAR2 30
		private String CEndip;         //C_ENDIP  VARCHAR2 30
		private String CState;         //C_STATE  VARCHAR2 8
		private String CKm;         //C_KM  VARCHAR2 10
		
		private RoleModel roleModel=new RoleModel();
		
		private DepartmentModel departmentModel=new DepartmentModel();
		
		public  DepartmentModel getDepartmentModel(){
			return departmentModel;  
		}
		public void  setDepartmentModel(DepartmentModel departmentModel){
			this.departmentModel=departmentModel;
		}		
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getCLoginName() {
			return CLoginName;
		}
		public void setCLoginName(String cLoginName) {
			CLoginName = cLoginName;
		}
		public String getCFullName() {
			return CFullName;
		}
		public void setCFullName(String cFullName) {
			CFullName = cFullName;
		}
		public String getCPwd() {
			return CPwd;
		}
		public void setCPwd(String cPwd) {
			CPwd = cPwd;
		}
		public Integer getIRoleid() {
			return IRoleid;
		}
		public void setIRoleid(Integer iRoleid) {
			IRoleid = iRoleid;
		}
		public Integer getIDepid() {
			return IDepid;
		}
		public void setIDepid(Integer iDepid) {
			IDepid = iDepid;
		}
		public String getCIdcard() {
			return CIdcard;
		}
		public void setCIdcard(String cIdcard) {
			CIdcard = cIdcard;
		}
		public String getCWorkid() {
			return CWorkid;
		}
		public void setCWorkid(String cWorkid) {
			CWorkid = cWorkid;
		}
		public String getCBeginip() {
			return CBeginip;
		}
		public void setCBeginip(String cBeginip) {
			CBeginip = cBeginip;
		}
		public String getCEndip() {
			return CEndip;
		}
		public void setCEndip(String cEndip) {
			CEndip = cEndip;
		}
		public String getCState() {
			return CState;
		}
		public void setCState(String cState) {
			CState = cState;
		}
		public String getCKm() {
			return CKm;
		}
		public void setCKm(String cKm) {
			CKm = cKm;
		}
		public RoleModel getRoleModel() {
			return roleModel;
		}
		public void setRoleModel(RoleModel roleModel) {
			this.roleModel = roleModel;
		}	
		@Override
		public JSONObject toJson() {
			// TODO Auto-generated method stub
			JSONObject json= super.toJson();
			try {
				json.put(UserModel.V.RoleName.name(), roleModel.getCName());		
				json.put(UserModel.V.DepName.name(),departmentModel.getCDepnickname());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return json;
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
