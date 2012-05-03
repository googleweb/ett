package com.ett.visual.model.res;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import com.smartken.toyz4j.model.IModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import java.util.Set;
import com.smartken.toyz4j.util.ObjectUtil;



public abstract class BaseResModel implements IModel{

	public enum F { 
 	Id,Filetype,Title,Remark,Content,Status,CheckDate,CheckUserId,ScanDate,ScanUserId,PrivateKey 
	 }

	public Object getPk(){ return Id;}

	public void setPk(Object pk) throws Exception { Id=pk.toString();}

	public void genPk() throws Exception {Id=ObjectUtil.GeneralPK(); }

	public ResultModel validate(){ return new ResultModel(); }

	public Enum[] enumFields(){ return BaseResModel.F.values(); }




protected String Id; 
protected String Filetype; 
protected String Title; 
protected String Remark; 
protected byte[] Content; 
protected String Status; 
protected Date CheckDate; 
protected String CheckUserId; 
protected Date ScanDate; 
protected String ScanUserId; 
protected String PrivateKey; 



public String getId(){ return this.Id; }
public void setId(String id){ this.Id=id; }

public String getFiletype(){ return this.Filetype; }
public void setFiletype(String filetype){ this.Filetype=filetype; }

public String getTitle(){ return this.Title; }
public void setTitle(String title){ this.Title=title; }

public String getRemark(){ return this.Remark; }
public void setRemark(String remark){ this.Remark=remark; }

public byte[] getContent(){ return this.Content; }
public void setContent(byte[] content){ this.Content=content; }

public String getStatus(){ return this.Status; }
public void setStatus(String status){ this.Status=status; }

public Date getCheckDate(){ return this.CheckDate; }
public void setCheckDate(Date checkDate){ this.CheckDate=checkDate; }

public String getCheckUserId(){ return this.CheckUserId; }
public void setCheckUserId(String checkUserId){ this.CheckUserId=checkUserId; }

public Date getScanDate(){ return this.ScanDate; }
public void setScanDate(Date scanDate){ this.ScanDate=scanDate; }

public String getScanUserId(){ return this.ScanUserId; }
public void setScanUserId(String scanUserId){ this.ScanUserId=scanUserId; }

public String getPrivateKey(){ return this.PrivateKey; }
public void setPrivateKey(String privateKey){ this.PrivateKey=privateKey; }

public class Query {

protected Set<String> isinId,isnotinId,isinFiletype,isnotinFiletype,
				isinTitle,isnotinTitle,isinRemark,isnotinRemark,
				isinStatus,isnotinStatus,isinCheckUserId,isnotinCheckUserId,
				isinScanUserId,isnotinScanUserId,isinPrivateKey,isnotinPrivateKey;

protected Date neqCheckDate,eqCheckDate,minCheckDate,maxCheckDate,
				neqScanDate,eqScanDate,minScanDate,maxScanDate;

protected Set<Date> isinCheckDate,isnotinCheckDate,isinScanDate,isnotinScanDate;

protected String neqId,eqId,likeId,notlikeId,
				neqFiletype,eqFiletype,likeFiletype,notlikeFiletype,
				neqTitle,eqTitle,likeTitle,notlikeTitle,
				neqRemark,eqRemark,likeRemark,notlikeRemark,
				neqStatus,eqStatus,likeStatus,notlikeStatus,
				neqCheckUserId,eqCheckUserId,likeCheckUserId,notlikeCheckUserId,
				neqScanUserId,eqScanUserId,likeScanUserId,notlikeScanUserId,
				neqPrivateKey,eqPrivateKey,likePrivateKey,notlikePrivateKey;

protected Boolean isnullId,isnotnullId,isnullFiletype,isnotnullFiletype,
				isnullTitle,isnotnullTitle,isnullRemark,isnotnullRemark,
				isnullStatus,isnotnullStatus,isnullCheckDate,isnotnullCheckDate,
				isnullCheckUserId,isnotnullCheckUserId,isnullScanDate,isnotnullScanDate,
				isnullScanUserId,isnotnullScanUserId,isnullPrivateKey,isnotnullPrivateKey;

public Set<String> getIsinId(){ return this.isinId; }
public void setIsinId(Set<String> isinId){ this.isinId=isinId; }

public Set<String> getIsnotinId(){ return this.isnotinId; }
public void setIsnotinId(Set<String> isnotinId){ this.isnotinId=isnotinId; }

public Set<String> getIsinFiletype(){ return this.isinFiletype; }
public void setIsinFiletype(Set<String> isinFiletype){ this.isinFiletype=isinFiletype; }

public Set<String> getIsnotinFiletype(){ return this.isnotinFiletype; }
public void setIsnotinFiletype(Set<String> isnotinFiletype){ this.isnotinFiletype=isnotinFiletype; }

public Set<String> getIsinTitle(){ return this.isinTitle; }
public void setIsinTitle(Set<String> isinTitle){ this.isinTitle=isinTitle; }

public Set<String> getIsnotinTitle(){ return this.isnotinTitle; }
public void setIsnotinTitle(Set<String> isnotinTitle){ this.isnotinTitle=isnotinTitle; }

public Set<String> getIsinRemark(){ return this.isinRemark; }
public void setIsinRemark(Set<String> isinRemark){ this.isinRemark=isinRemark; }

public Set<String> getIsnotinRemark(){ return this.isnotinRemark; }
public void setIsnotinRemark(Set<String> isnotinRemark){ this.isnotinRemark=isnotinRemark; }

public Set<String> getIsinStatus(){ return this.isinStatus; }
public void setIsinStatus(Set<String> isinStatus){ this.isinStatus=isinStatus; }

public Set<String> getIsnotinStatus(){ return this.isnotinStatus; }
public void setIsnotinStatus(Set<String> isnotinStatus){ this.isnotinStatus=isnotinStatus; }

public Set<String> getIsinCheckUserId(){ return this.isinCheckUserId; }
public void setIsinCheckUserId(Set<String> isinCheckUserId){ this.isinCheckUserId=isinCheckUserId; }

public Set<String> getIsnotinCheckUserId(){ return this.isnotinCheckUserId; }
public void setIsnotinCheckUserId(Set<String> isnotinCheckUserId){ this.isnotinCheckUserId=isnotinCheckUserId; }

public Set<String> getIsinScanUserId(){ return this.isinScanUserId; }
public void setIsinScanUserId(Set<String> isinScanUserId){ this.isinScanUserId=isinScanUserId; }

public Set<String> getIsnotinScanUserId(){ return this.isnotinScanUserId; }
public void setIsnotinScanUserId(Set<String> isnotinScanUserId){ this.isnotinScanUserId=isnotinScanUserId; }

public Set<String> getIsinPrivateKey(){ return this.isinPrivateKey; }
public void setIsinPrivateKey(Set<String> isinPrivateKey){ this.isinPrivateKey=isinPrivateKey; }

public Set<String> getIsnotinPrivateKey(){ return this.isnotinPrivateKey; }
public void setIsnotinPrivateKey(Set<String> isnotinPrivateKey){ this.isnotinPrivateKey=isnotinPrivateKey; }

public Date getNeqCheckDate(){ return this.neqCheckDate; }
public void setNeqCheckDate(Date neqCheckDate){ this.neqCheckDate=neqCheckDate; }

public Date getEqCheckDate(){ return this.eqCheckDate; }
public void setEqCheckDate(Date eqCheckDate){ this.eqCheckDate=eqCheckDate; }

public Date getMinCheckDate(){ return this.minCheckDate; }
public void setMinCheckDate(Date minCheckDate){ this.minCheckDate=minCheckDate; }

public Date getMaxCheckDate(){ return this.maxCheckDate; }
public void setMaxCheckDate(Date maxCheckDate){ this.maxCheckDate=maxCheckDate; }

public Date getNeqScanDate(){ return this.neqScanDate; }
public void setNeqScanDate(Date neqScanDate){ this.neqScanDate=neqScanDate; }

public Date getEqScanDate(){ return this.eqScanDate; }
public void setEqScanDate(Date eqScanDate){ this.eqScanDate=eqScanDate; }

public Date getMinScanDate(){ return this.minScanDate; }
public void setMinScanDate(Date minScanDate){ this.minScanDate=minScanDate; }

public Date getMaxScanDate(){ return this.maxScanDate; }
public void setMaxScanDate(Date maxScanDate){ this.maxScanDate=maxScanDate; }

public Set<Date> getIsinCheckDate(){ return this.isinCheckDate; }
public void setIsinCheckDate(Set<Date> isinCheckDate){ this.isinCheckDate=isinCheckDate; }

public Set<Date> getIsnotinCheckDate(){ return this.isnotinCheckDate; }
public void setIsnotinCheckDate(Set<Date> isnotinCheckDate){ this.isnotinCheckDate=isnotinCheckDate; }

public Set<Date> getIsinScanDate(){ return this.isinScanDate; }
public void setIsinScanDate(Set<Date> isinScanDate){ this.isinScanDate=isinScanDate; }

public Set<Date> getIsnotinScanDate(){ return this.isnotinScanDate; }
public void setIsnotinScanDate(Set<Date> isnotinScanDate){ this.isnotinScanDate=isnotinScanDate; }

public String getNeqId(){ return this.neqId; }
public void setNeqId(String neqId){ this.neqId=neqId; }

public String getEqId(){ return this.eqId; }
public void setEqId(String eqId){ this.eqId=eqId; }

public String getLikeId(){ return this.likeId; }
public void setLikeId(String likeId){ this.likeId=likeId; }

public String getNotlikeId(){ return this.notlikeId; }
public void setNotlikeId(String notlikeId){ this.notlikeId=notlikeId; }

public String getNeqFiletype(){ return this.neqFiletype; }
public void setNeqFiletype(String neqFiletype){ this.neqFiletype=neqFiletype; }

public String getEqFiletype(){ return this.eqFiletype; }
public void setEqFiletype(String eqFiletype){ this.eqFiletype=eqFiletype; }

public String getLikeFiletype(){ return this.likeFiletype; }
public void setLikeFiletype(String likeFiletype){ this.likeFiletype=likeFiletype; }

public String getNotlikeFiletype(){ return this.notlikeFiletype; }
public void setNotlikeFiletype(String notlikeFiletype){ this.notlikeFiletype=notlikeFiletype; }

public String getNeqTitle(){ return this.neqTitle; }
public void setNeqTitle(String neqTitle){ this.neqTitle=neqTitle; }

public String getEqTitle(){ return this.eqTitle; }
public void setEqTitle(String eqTitle){ this.eqTitle=eqTitle; }

public String getLikeTitle(){ return this.likeTitle; }
public void setLikeTitle(String likeTitle){ this.likeTitle=likeTitle; }

public String getNotlikeTitle(){ return this.notlikeTitle; }
public void setNotlikeTitle(String notlikeTitle){ this.notlikeTitle=notlikeTitle; }

public String getNeqRemark(){ return this.neqRemark; }
public void setNeqRemark(String neqRemark){ this.neqRemark=neqRemark; }

public String getEqRemark(){ return this.eqRemark; }
public void setEqRemark(String eqRemark){ this.eqRemark=eqRemark; }

public String getLikeRemark(){ return this.likeRemark; }
public void setLikeRemark(String likeRemark){ this.likeRemark=likeRemark; }

public String getNotlikeRemark(){ return this.notlikeRemark; }
public void setNotlikeRemark(String notlikeRemark){ this.notlikeRemark=notlikeRemark; }

public String getNeqStatus(){ return this.neqStatus; }
public void setNeqStatus(String neqStatus){ this.neqStatus=neqStatus; }

public String getEqStatus(){ return this.eqStatus; }
public void setEqStatus(String eqStatus){ this.eqStatus=eqStatus; }

public String getLikeStatus(){ return this.likeStatus; }
public void setLikeStatus(String likeStatus){ this.likeStatus=likeStatus; }

public String getNotlikeStatus(){ return this.notlikeStatus; }
public void setNotlikeStatus(String notlikeStatus){ this.notlikeStatus=notlikeStatus; }

public String getNeqCheckUserId(){ return this.neqCheckUserId; }
public void setNeqCheckUserId(String neqCheckUserId){ this.neqCheckUserId=neqCheckUserId; }

public String getEqCheckUserId(){ return this.eqCheckUserId; }
public void setEqCheckUserId(String eqCheckUserId){ this.eqCheckUserId=eqCheckUserId; }

public String getLikeCheckUserId(){ return this.likeCheckUserId; }
public void setLikeCheckUserId(String likeCheckUserId){ this.likeCheckUserId=likeCheckUserId; }

public String getNotlikeCheckUserId(){ return this.notlikeCheckUserId; }
public void setNotlikeCheckUserId(String notlikeCheckUserId){ this.notlikeCheckUserId=notlikeCheckUserId; }

public String getNeqScanUserId(){ return this.neqScanUserId; }
public void setNeqScanUserId(String neqScanUserId){ this.neqScanUserId=neqScanUserId; }

public String getEqScanUserId(){ return this.eqScanUserId; }
public void setEqScanUserId(String eqScanUserId){ this.eqScanUserId=eqScanUserId; }

public String getLikeScanUserId(){ return this.likeScanUserId; }
public void setLikeScanUserId(String likeScanUserId){ this.likeScanUserId=likeScanUserId; }

public String getNotlikeScanUserId(){ return this.notlikeScanUserId; }
public void setNotlikeScanUserId(String notlikeScanUserId){ this.notlikeScanUserId=notlikeScanUserId; }

public String getNeqPrivateKey(){ return this.neqPrivateKey; }
public void setNeqPrivateKey(String neqPrivateKey){ this.neqPrivateKey=neqPrivateKey; }

public String getEqPrivateKey(){ return this.eqPrivateKey; }
public void setEqPrivateKey(String eqPrivateKey){ this.eqPrivateKey=eqPrivateKey; }

public String getLikePrivateKey(){ return this.likePrivateKey; }
public void setLikePrivateKey(String likePrivateKey){ this.likePrivateKey=likePrivateKey; }

public String getNotlikePrivateKey(){ return this.notlikePrivateKey; }
public void setNotlikePrivateKey(String notlikePrivateKey){ this.notlikePrivateKey=notlikePrivateKey; }

public Boolean getIsnullId(){ return this.isnullId; }
public void setIsnullId(Boolean isnullId){ this.isnullId=isnullId; }

public Boolean getIsnotnullId(){ return this.isnotnullId; }
public void setIsnotnullId(Boolean isnotnullId){ this.isnotnullId=isnotnullId; }

public Boolean getIsnullFiletype(){ return this.isnullFiletype; }
public void setIsnullFiletype(Boolean isnullFiletype){ this.isnullFiletype=isnullFiletype; }

public Boolean getIsnotnullFiletype(){ return this.isnotnullFiletype; }
public void setIsnotnullFiletype(Boolean isnotnullFiletype){ this.isnotnullFiletype=isnotnullFiletype; }

public Boolean getIsnullTitle(){ return this.isnullTitle; }
public void setIsnullTitle(Boolean isnullTitle){ this.isnullTitle=isnullTitle; }

public Boolean getIsnotnullTitle(){ return this.isnotnullTitle; }
public void setIsnotnullTitle(Boolean isnotnullTitle){ this.isnotnullTitle=isnotnullTitle; }

public Boolean getIsnullRemark(){ return this.isnullRemark; }
public void setIsnullRemark(Boolean isnullRemark){ this.isnullRemark=isnullRemark; }

public Boolean getIsnotnullRemark(){ return this.isnotnullRemark; }
public void setIsnotnullRemark(Boolean isnotnullRemark){ this.isnotnullRemark=isnotnullRemark; }

public Boolean getIsnullStatus(){ return this.isnullStatus; }
public void setIsnullStatus(Boolean isnullStatus){ this.isnullStatus=isnullStatus; }

public Boolean getIsnotnullStatus(){ return this.isnotnullStatus; }
public void setIsnotnullStatus(Boolean isnotnullStatus){ this.isnotnullStatus=isnotnullStatus; }

public Boolean getIsnullCheckDate(){ return this.isnullCheckDate; }
public void setIsnullCheckDate(Boolean isnullCheckDate){ this.isnullCheckDate=isnullCheckDate; }

public Boolean getIsnotnullCheckDate(){ return this.isnotnullCheckDate; }
public void setIsnotnullCheckDate(Boolean isnotnullCheckDate){ this.isnotnullCheckDate=isnotnullCheckDate; }

public Boolean getIsnullCheckUserId(){ return this.isnullCheckUserId; }
public void setIsnullCheckUserId(Boolean isnullCheckUserId){ this.isnullCheckUserId=isnullCheckUserId; }

public Boolean getIsnotnullCheckUserId(){ return this.isnotnullCheckUserId; }
public void setIsnotnullCheckUserId(Boolean isnotnullCheckUserId){ this.isnotnullCheckUserId=isnotnullCheckUserId; }

public Boolean getIsnullScanDate(){ return this.isnullScanDate; }
public void setIsnullScanDate(Boolean isnullScanDate){ this.isnullScanDate=isnullScanDate; }

public Boolean getIsnotnullScanDate(){ return this.isnotnullScanDate; }
public void setIsnotnullScanDate(Boolean isnotnullScanDate){ this.isnotnullScanDate=isnotnullScanDate; }

public Boolean getIsnullScanUserId(){ return this.isnullScanUserId; }
public void setIsnullScanUserId(Boolean isnullScanUserId){ this.isnullScanUserId=isnullScanUserId; }

public Boolean getIsnotnullScanUserId(){ return this.isnotnullScanUserId; }
public void setIsnotnullScanUserId(Boolean isnotnullScanUserId){ this.isnotnullScanUserId=isnotnullScanUserId; }

public Boolean getIsnullPrivateKey(){ return this.isnullPrivateKey; }
public void setIsnullPrivateKey(Boolean isnullPrivateKey){ this.isnullPrivateKey=isnullPrivateKey; }

public Boolean getIsnotnullPrivateKey(){ return this.isnotnullPrivateKey; }
public void setIsnotnullPrivateKey(Boolean isnotnullPrivateKey){ this.isnotnullPrivateKey=isnotnullPrivateKey; }





}  //end Query


} //end ResModel