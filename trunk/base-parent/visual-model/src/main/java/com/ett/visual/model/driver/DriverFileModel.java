package com.ett.visual.model.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.ett.visual.model.BaseVisualModel;
import com.smartken.toyz4j.model.impl.BaseModel;

public class DriverFileModel extends BaseVisualModel {

	
	 public static enum F { 
		  Id,Title,Remark,DriverPk,CreateDate,LastModifyDate,OperPk,Rec,Type,Status,CompleteInd,
		CleanInd,IndexInd,LastCheckDate  
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

	
	
	

}
