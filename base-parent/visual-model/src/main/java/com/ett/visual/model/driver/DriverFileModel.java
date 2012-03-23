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

		private Date CreateDate,LastModifyDate,LastCheckDate;

		private Integer SecretLevel;

		private byte[] Rec;

		private String Id,Title,Remark,DriverPk,
						OperPk,Type,Status,CompleteInd,
						CleanInd,IndexInd;

		 

		 public  class SimpleQueryModel extends com.ett.visual.model.driver.DriverFileModel { 
		 private List<Date> isinCreateDate,isnotinCreateDate,isinLastModifyDate,isnotinLastModifyDate,
						isinLastCheckDate,isnotinLastCheckDate;

		private Date neqCreateDate,eqCreateDate,minCreateDate,maxCreateDate,
						neqLastModifyDate,eqLastModifyDate,minLastModifyDate,maxLastModifyDate,
						neqLastCheckDate,eqLastCheckDate,minLastCheckDate,maxLastCheckDate;

		private String neqId,eqId,likeId,notlikeId,
						neqTitle,eqTitle,likeTitle,notlikeTitle,
						neqRemark,eqRemark,likeRemark,notlikeRemark,
						neqDriverPk,eqDriverPk,likeDriverPk,notlikeDriverPk,
						neqOperPk,eqOperPk,likeOperPk,notlikeOperPk,
						neqType,eqType,likeType,notlikeType,
						neqStatus,eqStatus,likeStatus,notlikeStatus,
						neqCompleteInd,eqCompleteInd,likeCompleteInd,notlikeCompleteInd,
						neqCleanInd,eqCleanInd,likeCleanInd,notlikeCleanInd,
						neqIndexInd,eqIndexInd,likeIndexInd,notlikeIndexInd;

		private List<String> isinId,isnotinId,isinTitle,isnotinTitle,
						isinRemark,isnotinRemark,isinDriverPk,isnotinDriverPk,
						isinOperPk,isnotinOperPk,isinType,isnotinType,
						isinStatus,isnotinStatus,isinCompleteInd,isnotinCompleteInd,
						isinCleanInd,isnotinCleanInd,isinIndexInd,isnotinIndexInd;

		private Integer neqSecretLevel,eqSecretLevel,minSecretLevel,maxSecretLevel;

		private List<Integer> isinSecretLevel,isnotinSecretLevel;

		private Boolean isnullId,isnotnullId,isnullTitle,isnotnullTitle,
						isnullRemark,isnotnullRemark,isnullDriverPk,isnotnullDriverPk,
						isnullCreateDate,isnotnullCreateDate,isnullLastModifyDate,isnotnullLastModifyDate,
						isnullOperPk,isnotnullOperPk,isnullType,isnotnullType,
						isnullStatus,isnotnullStatus,isnullCompleteInd,isnotnullCompleteInd,
						isnullCleanInd,isnotnullCleanInd,isnullIndexInd,isnotnullIndexInd,
						isnullLastCheckDate,isnotnullLastCheckDate,isnullSecretLevel,isnotnullSecretLevel;

		public List<Date> getIsinCreateDate() {
			return isinCreateDate;
		}

		public void setIsinCreateDate(List<Date> isinCreateDate) {
			this.isinCreateDate = isinCreateDate;
		}

		public List<Date> getIsnotinCreateDate() {
			return isnotinCreateDate;
		}

		public void setIsnotinCreateDate(List<Date> isnotinCreateDate) {
			this.isnotinCreateDate = isnotinCreateDate;
		}

		public List<Date> getIsinLastModifyDate() {
			return isinLastModifyDate;
		}

		public void setIsinLastModifyDate(List<Date> isinLastModifyDate) {
			this.isinLastModifyDate = isinLastModifyDate;
		}

		public List<Date> getIsnotinLastModifyDate() {
			return isnotinLastModifyDate;
		}

		public void setIsnotinLastModifyDate(List<Date> isnotinLastModifyDate) {
			this.isnotinLastModifyDate = isnotinLastModifyDate;
		}

		public List<Date> getIsinLastCheckDate() {
			return isinLastCheckDate;
		}

		public void setIsinLastCheckDate(List<Date> isinLastCheckDate) {
			this.isinLastCheckDate = isinLastCheckDate;
		}

		public List<Date> getIsnotinLastCheckDate() {
			return isnotinLastCheckDate;
		}

		public void setIsnotinLastCheckDate(List<Date> isnotinLastCheckDate) {
			this.isnotinLastCheckDate = isnotinLastCheckDate;
		}

		public Date getNeqCreateDate() {
			return neqCreateDate;
		}

		public void setNeqCreateDate(Date neqCreateDate) {
			this.neqCreateDate = neqCreateDate;
		}

		public Date getEqCreateDate() {
			return eqCreateDate;
		}

		public void setEqCreateDate(Date eqCreateDate) {
			this.eqCreateDate = eqCreateDate;
		}

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

		public Date getNeqLastModifyDate() {
			return neqLastModifyDate;
		}

		public void setNeqLastModifyDate(Date neqLastModifyDate) {
			this.neqLastModifyDate = neqLastModifyDate;
		}

		public Date getEqLastModifyDate() {
			return eqLastModifyDate;
		}

		public void setEqLastModifyDate(Date eqLastModifyDate) {
			this.eqLastModifyDate = eqLastModifyDate;
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

		public Date getNeqLastCheckDate() {
			return neqLastCheckDate;
		}

		public void setNeqLastCheckDate(Date neqLastCheckDate) {
			this.neqLastCheckDate = neqLastCheckDate;
		}

		public Date getEqLastCheckDate() {
			return eqLastCheckDate;
		}

		public void setEqLastCheckDate(Date eqLastCheckDate) {
			this.eqLastCheckDate = eqLastCheckDate;
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

		public String getNeqId() {
			return neqId;
		}

		public void setNeqId(String neqId) {
			this.neqId = neqId;
		}

		public String getEqId() {
			return eqId;
		}

		public void setEqId(String eqId) {
			this.eqId = eqId;
		}

		public String getLikeId() {
			return likeId;
		}

		public void setLikeId(String likeId) {
			this.likeId = likeId;
		}

		public String getNotlikeId() {
			return notlikeId;
		}

		public void setNotlikeId(String notlikeId) {
			this.notlikeId = notlikeId;
		}

		public String getNeqTitle() {
			return neqTitle;
		}

		public void setNeqTitle(String neqTitle) {
			this.neqTitle = neqTitle;
		}

		public String getEqTitle() {
			return eqTitle;
		}

		public void setEqTitle(String eqTitle) {
			this.eqTitle = eqTitle;
		}

		public String getLikeTitle() {
			return likeTitle;
		}

		public void setLikeTitle(String likeTitle) {
			this.likeTitle = likeTitle;
		}

		public String getNotlikeTitle() {
			return notlikeTitle;
		}

		public void setNotlikeTitle(String notlikeTitle) {
			this.notlikeTitle = notlikeTitle;
		}

		public String getNeqRemark() {
			return neqRemark;
		}

		public void setNeqRemark(String neqRemark) {
			this.neqRemark = neqRemark;
		}

		public String getEqRemark() {
			return eqRemark;
		}

		public void setEqRemark(String eqRemark) {
			this.eqRemark = eqRemark;
		}

		public String getLikeRemark() {
			return likeRemark;
		}

		public void setLikeRemark(String likeRemark) {
			this.likeRemark = likeRemark;
		}

		public String getNotlikeRemark() {
			return notlikeRemark;
		}

		public void setNotlikeRemark(String notlikeRemark) {
			this.notlikeRemark = notlikeRemark;
		}

		public String getNeqDriverPk() {
			return neqDriverPk;
		}

		public void setNeqDriverPk(String neqDriverPk) {
			this.neqDriverPk = neqDriverPk;
		}

		public String getEqDriverPk() {
			return eqDriverPk;
		}

		public void setEqDriverPk(String eqDriverPk) {
			this.eqDriverPk = eqDriverPk;
		}

		public String getLikeDriverPk() {
			return likeDriverPk;
		}

		public void setLikeDriverPk(String likeDriverPk) {
			this.likeDriverPk = likeDriverPk;
		}

		public String getNotlikeDriverPk() {
			return notlikeDriverPk;
		}

		public void setNotlikeDriverPk(String notlikeDriverPk) {
			this.notlikeDriverPk = notlikeDriverPk;
		}

		public String getNeqOperPk() {
			return neqOperPk;
		}

		public void setNeqOperPk(String neqOperPk) {
			this.neqOperPk = neqOperPk;
		}

		public String getEqOperPk() {
			return eqOperPk;
		}

		public void setEqOperPk(String eqOperPk) {
			this.eqOperPk = eqOperPk;
		}

		public String getLikeOperPk() {
			return likeOperPk;
		}

		public void setLikeOperPk(String likeOperPk) {
			this.likeOperPk = likeOperPk;
		}

		public String getNotlikeOperPk() {
			return notlikeOperPk;
		}

		public void setNotlikeOperPk(String notlikeOperPk) {
			this.notlikeOperPk = notlikeOperPk;
		}

		public String getNeqType() {
			return neqType;
		}

		public void setNeqType(String neqType) {
			this.neqType = neqType;
		}

		public String getEqType() {
			return eqType;
		}

		public void setEqType(String eqType) {
			this.eqType = eqType;
		}

		public String getLikeType() {
			return likeType;
		}

		public void setLikeType(String likeType) {
			this.likeType = likeType;
		}

		public String getNotlikeType() {
			return notlikeType;
		}

		public void setNotlikeType(String notlikeType) {
			this.notlikeType = notlikeType;
		}

		public String getNeqStatus() {
			return neqStatus;
		}

		public void setNeqStatus(String neqStatus) {
			this.neqStatus = neqStatus;
		}

		public String getEqStatus() {
			return eqStatus;
		}

		public void setEqStatus(String eqStatus) {
			this.eqStatus = eqStatus;
		}

		public String getLikeStatus() {
			return likeStatus;
		}

		public void setLikeStatus(String likeStatus) {
			this.likeStatus = likeStatus;
		}

		public String getNotlikeStatus() {
			return notlikeStatus;
		}

		public void setNotlikeStatus(String notlikeStatus) {
			this.notlikeStatus = notlikeStatus;
		}

		public String getNeqCompleteInd() {
			return neqCompleteInd;
		}

		public void setNeqCompleteInd(String neqCompleteInd) {
			this.neqCompleteInd = neqCompleteInd;
		}

		public String getEqCompleteInd() {
			return eqCompleteInd;
		}

		public void setEqCompleteInd(String eqCompleteInd) {
			this.eqCompleteInd = eqCompleteInd;
		}

		public String getLikeCompleteInd() {
			return likeCompleteInd;
		}

		public void setLikeCompleteInd(String likeCompleteInd) {
			this.likeCompleteInd = likeCompleteInd;
		}

		public String getNotlikeCompleteInd() {
			return notlikeCompleteInd;
		}

		public void setNotlikeCompleteInd(String notlikeCompleteInd) {
			this.notlikeCompleteInd = notlikeCompleteInd;
		}

		public String getNeqCleanInd() {
			return neqCleanInd;
		}

		public void setNeqCleanInd(String neqCleanInd) {
			this.neqCleanInd = neqCleanInd;
		}

		public String getEqCleanInd() {
			return eqCleanInd;
		}

		public void setEqCleanInd(String eqCleanInd) {
			this.eqCleanInd = eqCleanInd;
		}

		public String getLikeCleanInd() {
			return likeCleanInd;
		}

		public void setLikeCleanInd(String likeCleanInd) {
			this.likeCleanInd = likeCleanInd;
		}

		public String getNotlikeCleanInd() {
			return notlikeCleanInd;
		}

		public void setNotlikeCleanInd(String notlikeCleanInd) {
			this.notlikeCleanInd = notlikeCleanInd;
		}

		public String getNeqIndexInd() {
			return neqIndexInd;
		}

		public void setNeqIndexInd(String neqIndexInd) {
			this.neqIndexInd = neqIndexInd;
		}

		public String getEqIndexInd() {
			return eqIndexInd;
		}

		public void setEqIndexInd(String eqIndexInd) {
			this.eqIndexInd = eqIndexInd;
		}

		public String getLikeIndexInd() {
			return likeIndexInd;
		}

		public void setLikeIndexInd(String likeIndexInd) {
			this.likeIndexInd = likeIndexInd;
		}

		public String getNotlikeIndexInd() {
			return notlikeIndexInd;
		}

		public void setNotlikeIndexInd(String notlikeIndexInd) {
			this.notlikeIndexInd = notlikeIndexInd;
		}

		public List<String> getIsinId() {
			return isinId;
		}

		public void setIsinId(List<String> isinId) {
			this.isinId = isinId;
		}

		public List<String> getIsnotinId() {
			return isnotinId;
		}

		public void setIsnotinId(List<String> isnotinId) {
			this.isnotinId = isnotinId;
		}

		public List<String> getIsinTitle() {
			return isinTitle;
		}

		public void setIsinTitle(List<String> isinTitle) {
			this.isinTitle = isinTitle;
		}

		public List<String> getIsnotinTitle() {
			return isnotinTitle;
		}

		public void setIsnotinTitle(List<String> isnotinTitle) {
			this.isnotinTitle = isnotinTitle;
		}

		public List<String> getIsinRemark() {
			return isinRemark;
		}

		public void setIsinRemark(List<String> isinRemark) {
			this.isinRemark = isinRemark;
		}

		public List<String> getIsnotinRemark() {
			return isnotinRemark;
		}

		public void setIsnotinRemark(List<String> isnotinRemark) {
			this.isnotinRemark = isnotinRemark;
		}

		public List<String> getIsinDriverPk() {
			return isinDriverPk;
		}

		public void setIsinDriverPk(List<String> isinDriverPk) {
			this.isinDriverPk = isinDriverPk;
		}

		public List<String> getIsnotinDriverPk() {
			return isnotinDriverPk;
		}

		public void setIsnotinDriverPk(List<String> isnotinDriverPk) {
			this.isnotinDriverPk = isnotinDriverPk;
		}

		public List<String> getIsinOperPk() {
			return isinOperPk;
		}

		public void setIsinOperPk(List<String> isinOperPk) {
			this.isinOperPk = isinOperPk;
		}

		public List<String> getIsnotinOperPk() {
			return isnotinOperPk;
		}

		public void setIsnotinOperPk(List<String> isnotinOperPk) {
			this.isnotinOperPk = isnotinOperPk;
		}

		public List<String> getIsinType() {
			return isinType;
		}

		public void setIsinType(List<String> isinType) {
			this.isinType = isinType;
		}

		public List<String> getIsnotinType() {
			return isnotinType;
		}

		public void setIsnotinType(List<String> isnotinType) {
			this.isnotinType = isnotinType;
		}

		public List<String> getIsinStatus() {
			return isinStatus;
		}

		public void setIsinStatus(List<String> isinStatus) {
			this.isinStatus = isinStatus;
		}

		public List<String> getIsnotinStatus() {
			return isnotinStatus;
		}

		public void setIsnotinStatus(List<String> isnotinStatus) {
			this.isnotinStatus = isnotinStatus;
		}

		public List<String> getIsinCompleteInd() {
			return isinCompleteInd;
		}

		public void setIsinCompleteInd(List<String> isinCompleteInd) {
			this.isinCompleteInd = isinCompleteInd;
		}

		public List<String> getIsnotinCompleteInd() {
			return isnotinCompleteInd;
		}

		public void setIsnotinCompleteInd(List<String> isnotinCompleteInd) {
			this.isnotinCompleteInd = isnotinCompleteInd;
		}

		public List<String> getIsinCleanInd() {
			return isinCleanInd;
		}

		public void setIsinCleanInd(List<String> isinCleanInd) {
			this.isinCleanInd = isinCleanInd;
		}

		public List<String> getIsnotinCleanInd() {
			return isnotinCleanInd;
		}

		public void setIsnotinCleanInd(List<String> isnotinCleanInd) {
			this.isnotinCleanInd = isnotinCleanInd;
		}

		public List<String> getIsinIndexInd() {
			return isinIndexInd;
		}

		public void setIsinIndexInd(List<String> isinIndexInd) {
			this.isinIndexInd = isinIndexInd;
		}

		public List<String> getIsnotinIndexInd() {
			return isnotinIndexInd;
		}

		public void setIsnotinIndexInd(List<String> isnotinIndexInd) {
			this.isnotinIndexInd = isnotinIndexInd;
		}

		public Integer getNeqSecretLevel() {
			return neqSecretLevel;
		}

		public void setNeqSecretLevel(Integer neqSecretLevel) {
			this.neqSecretLevel = neqSecretLevel;
		}

		public Integer getEqSecretLevel() {
			return eqSecretLevel;
		}

		public void setEqSecretLevel(Integer eqSecretLevel) {
			this.eqSecretLevel = eqSecretLevel;
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

		public List<Integer> getIsinSecretLevel() {
			return isinSecretLevel;
		}

		public void setIsinSecretLevel(List<Integer> isinSecretLevel) {
			this.isinSecretLevel = isinSecretLevel;
		}

		public List<Integer> getIsnotinSecretLevel() {
			return isnotinSecretLevel;
		}

		public void setIsnotinSecretLevel(List<Integer> isnotinSecretLevel) {
			this.isnotinSecretLevel = isnotinSecretLevel;
		}

		public Boolean getIsnullId() {
			return isnullId;
		}

		public void setIsnullId(Boolean isnullId) {
			this.isnullId = isnullId;
		}

		public Boolean getIsnotnullId() {
			return isnotnullId;
		}

		public void setIsnotnullId(Boolean isnotnullId) {
			this.isnotnullId = isnotnullId;
		}

		public Boolean getIsnullTitle() {
			return isnullTitle;
		}

		public void setIsnullTitle(Boolean isnullTitle) {
			this.isnullTitle = isnullTitle;
		}

		public Boolean getIsnotnullTitle() {
			return isnotnullTitle;
		}

		public void setIsnotnullTitle(Boolean isnotnullTitle) {
			this.isnotnullTitle = isnotnullTitle;
		}

		public Boolean getIsnullRemark() {
			return isnullRemark;
		}

		public void setIsnullRemark(Boolean isnullRemark) {
			this.isnullRemark = isnullRemark;
		}

		public Boolean getIsnotnullRemark() {
			return isnotnullRemark;
		}

		public void setIsnotnullRemark(Boolean isnotnullRemark) {
			this.isnotnullRemark = isnotnullRemark;
		}

		public Boolean getIsnullDriverPk() {
			return isnullDriverPk;
		}

		public void setIsnullDriverPk(Boolean isnullDriverPk) {
			this.isnullDriverPk = isnullDriverPk;
		}

		public Boolean getIsnotnullDriverPk() {
			return isnotnullDriverPk;
		}

		public void setIsnotnullDriverPk(Boolean isnotnullDriverPk) {
			this.isnotnullDriverPk = isnotnullDriverPk;
		}

		public Boolean getIsnullCreateDate() {
			return isnullCreateDate;
		}

		public void setIsnullCreateDate(Boolean isnullCreateDate) {
			this.isnullCreateDate = isnullCreateDate;
		}

		public Boolean getIsnotnullCreateDate() {
			return isnotnullCreateDate;
		}

		public void setIsnotnullCreateDate(Boolean isnotnullCreateDate) {
			this.isnotnullCreateDate = isnotnullCreateDate;
		}

		public Boolean getIsnullLastModifyDate() {
			return isnullLastModifyDate;
		}

		public void setIsnullLastModifyDate(Boolean isnullLastModifyDate) {
			this.isnullLastModifyDate = isnullLastModifyDate;
		}

		public Boolean getIsnotnullLastModifyDate() {
			return isnotnullLastModifyDate;
		}

		public void setIsnotnullLastModifyDate(Boolean isnotnullLastModifyDate) {
			this.isnotnullLastModifyDate = isnotnullLastModifyDate;
		}

		public Boolean getIsnullOperPk() {
			return isnullOperPk;
		}

		public void setIsnullOperPk(Boolean isnullOperPk) {
			this.isnullOperPk = isnullOperPk;
		}

		public Boolean getIsnotnullOperPk() {
			return isnotnullOperPk;
		}

		public void setIsnotnullOperPk(Boolean isnotnullOperPk) {
			this.isnotnullOperPk = isnotnullOperPk;
		}

		public Boolean getIsnullType() {
			return isnullType;
		}

		public void setIsnullType(Boolean isnullType) {
			this.isnullType = isnullType;
		}

		public Boolean getIsnotnullType() {
			return isnotnullType;
		}

		public void setIsnotnullType(Boolean isnotnullType) {
			this.isnotnullType = isnotnullType;
		}

		public Boolean getIsnullStatus() {
			return isnullStatus;
		}

		public void setIsnullStatus(Boolean isnullStatus) {
			this.isnullStatus = isnullStatus;
		}

		public Boolean getIsnotnullStatus() {
			return isnotnullStatus;
		}

		public void setIsnotnullStatus(Boolean isnotnullStatus) {
			this.isnotnullStatus = isnotnullStatus;
		}

		public Boolean getIsnullCompleteInd() {
			return isnullCompleteInd;
		}

		public void setIsnullCompleteInd(Boolean isnullCompleteInd) {
			this.isnullCompleteInd = isnullCompleteInd;
		}

		public Boolean getIsnotnullCompleteInd() {
			return isnotnullCompleteInd;
		}

		public void setIsnotnullCompleteInd(Boolean isnotnullCompleteInd) {
			this.isnotnullCompleteInd = isnotnullCompleteInd;
		}

		public Boolean getIsnullCleanInd() {
			return isnullCleanInd;
		}

		public void setIsnullCleanInd(Boolean isnullCleanInd) {
			this.isnullCleanInd = isnullCleanInd;
		}

		public Boolean getIsnotnullCleanInd() {
			return isnotnullCleanInd;
		}

		public void setIsnotnullCleanInd(Boolean isnotnullCleanInd) {
			this.isnotnullCleanInd = isnotnullCleanInd;
		}

		public Boolean getIsnullIndexInd() {
			return isnullIndexInd;
		}

		public void setIsnullIndexInd(Boolean isnullIndexInd) {
			this.isnullIndexInd = isnullIndexInd;
		}

		public Boolean getIsnotnullIndexInd() {
			return isnotnullIndexInd;
		}

		public void setIsnotnullIndexInd(Boolean isnotnullIndexInd) {
			this.isnotnullIndexInd = isnotnullIndexInd;
		}

		public Boolean getIsnullLastCheckDate() {
			return isnullLastCheckDate;
		}

		public void setIsnullLastCheckDate(Boolean isnullLastCheckDate) {
			this.isnullLastCheckDate = isnullLastCheckDate;
		}

		public Boolean getIsnotnullLastCheckDate() {
			return isnotnullLastCheckDate;
		}

		public void setIsnotnullLastCheckDate(Boolean isnotnullLastCheckDate) {
			this.isnotnullLastCheckDate = isnotnullLastCheckDate;
		}

		public Boolean getIsnullSecretLevel() {
			return isnullSecretLevel;
		}

		public void setIsnullSecretLevel(Boolean isnullSecretLevel) {
			this.isnullSecretLevel = isnullSecretLevel;
		}

		public Boolean getIsnotnullSecretLevel() {
			return isnotnullSecretLevel;
		}

		public void setIsnotnullSecretLevel(Boolean isnotnullSecretLevel) {
			this.isnotnullSecretLevel = isnotnullSecretLevel;
		}

		 
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



		public byte[] getRec() {
			return Rec;
		}



		public void setRec(byte[] rec) {
			Rec = rec;
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



		public String getOperPk() {
			return OperPk;
		}



		public void setOperPk(String operPk) {
			OperPk = operPk;
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



		public Object getPk() {
			// TODO Auto-generated method stub
			return this.Id;
		}



		public void setPk(Object pk) {
			// TODO Auto-generated method stub
			this.Id=pk.toString();
		} 
		 
		 
}
