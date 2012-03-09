package com.ett.visual.model.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import sun.tools.tree.ThisExpression;

import com.ett.visual.model.BaseVisualModel;
import com.smartken.toyz4j.model.impl.BaseModel;

public class DriverFileModel extends BaseVisualModel {

	
	public static enum F { 
		  Id,Title,Remark,DriverPk,CreateDate,LastModifyDate,OperPk,Rec,Type,Status,CompleteInd,
		CleanInd,IndexInd,LastCheckDate,SecretLevel  
		 } 

		private String Id;         //ID  VARCHAR2 50
		private String Title;         //TITLE  VARCHAR2 50
		private String Remark;         //REMARK  VARCHAR2 500
		private String DriverPk;         //DRIVER_PK  VARCHAR2 50
		private Date CreateDate;         //CREATE_DATE  DATE 0
		private Date LastModifyDate;         //LAST_MODIFY_DATE  DATE 0
		private String OperPk;         //OPER_PK  VARCHAR2 50
		private byte[] Rec;         //REC  BLOB -1
		private String Type;         //TYPE  VARCHAR2 50
		private String Status;         //STATUS  VARCHAR2 10
		private String CompleteInd;         //COMPLETE_IND  CHAR 1
		private String CleanInd;         //CLEAN_IND  CHAR 1
		private String IndexInd;         //INDEX_IND  CHAR 1
		private Date LastCheckDate;         //LAST_CHECK_DATE  DATE 0
		private Integer SecretLevel;         //SECRET_LEVEL  NUMBER 38
		 

		 public  class SimpleQueryModel extends com.ett.visual.model.driver.DriverFileModel { 
		  private Date minCreateDate ; 
		 private Date maxCreateDate ; 
		 private Date minLastModifyDate ; 
		 private Date maxLastModifyDate ; 
		 private Date minLastCheckDate ; 
		 private Date maxLastCheckDate ; 
		 private Integer minSecretLevel ; 
		 private Integer maxSecretLevel ;
		public Date getMinCreateDate() {
			return minCreateDate;
		}
		public void setMinCreateDate(Date minCreateDate) {
			this.minCreateDate = minCreateDate;
		}
		public Date getMaxCreateDate() {
			return maxCreateDate;
		}
		public void setMaxCreateDate(Date maxCreateDate) {
			this.maxCreateDate = maxCreateDate;
		}
		public Date getMinLastModifyDate() {
			return minLastModifyDate;
		}
		public void setMinLastModifyDate(Date minLastModifyDate) {
			this.minLastModifyDate = minLastModifyDate;
		}
		public Date getMaxLastModifyDate() {
			return maxLastModifyDate;
		}
		public void setMaxLastModifyDate(Date maxLastModifyDate) {
			this.maxLastModifyDate = maxLastModifyDate;
		}
		public Date getMinLastCheckDate() {
			return minLastCheckDate;
		}
		public void setMinLastCheckDate(Date minLastCheckDate) {
			this.minLastCheckDate = minLastCheckDate;
		}
		public Date getMaxLastCheckDate() {
			return maxLastCheckDate;
		}
		public void setMaxLastCheckDate(Date maxLastCheckDate) {
			this.maxLastCheckDate = maxLastCheckDate;
		}
		public Integer getMinSecretLevel() {
			return minSecretLevel;
		}
		public void setMinSecretLevel(Integer minSecretLevel) {
			this.minSecretLevel = minSecretLevel;
		}
		public Integer getMaxSecretLevel() {
			return maxSecretLevel;
		}
		public void setMaxSecretLevel(Integer maxSecretLevel) {
			this.maxSecretLevel = maxSecretLevel;
		} 
		 
		 
		 }


		public String getId() {
			return Id;
		}


		public void setId(String id) {
			Id = id;
		}


		public String getTitle() {
			return Title;
		}


		public void setTitle(String title) {
			Title = title;
		}


		public String getRemark() {
			return Remark;
		}


		public void setRemark(String remark) {
			Remark = remark;
		}


		public String getDriverPk() {
			return DriverPk;
		}


		public void setDriverPk(String driverPk) {
			DriverPk = driverPk;
		}


		public Date getCreateDate() {
			return CreateDate;
		}


		public void setCreateDate(Date createDate) {
			CreateDate = createDate;
		}


		public Date getLastModifyDate() {
			return LastModifyDate;
		}


		public void setLastModifyDate(Date lastModifyDate) {
			LastModifyDate = lastModifyDate;
		}


		public String getOperPk() {
			return OperPk;
		}


		public void setOperPk(String operPk) {
			OperPk = operPk;
		}


		public byte[] getRec() {
			return Rec;
		}


		public void setRec(byte[] rec) {
			Rec = rec;
		}


		public String getType() {
			return Type;
		}


		public void setType(String type) {
			Type = type;
		}


		public String getStatus() {
			return Status;
		}


		public void setStatus(String status) {
			Status = status;
		}


		public String getCompleteInd() {
			return CompleteInd;
		}


		public void setCompleteInd(String completeInd) {
			CompleteInd = completeInd;
		}


		public String getCleanInd() {
			return CleanInd;
		}


		public void setCleanInd(String cleanInd) {
			CleanInd = cleanInd;
		}


		public String getIndexInd() {
			return IndexInd;
		}


		public void setIndexInd(String indexInd) {
			IndexInd = indexInd;
		}


		public Date getLastCheckDate() {
			return LastCheckDate;
		}


		public void setLastCheckDate(Date lastCheckDate) {
			LastCheckDate = lastCheckDate;
		}


		public Integer getSecretLevel() {
			return SecretLevel;
		}


		public void setSecretLevel(Integer secretLevel) {
			SecretLevel = secretLevel;
		}


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
		 
		 
		 
	
	

}
