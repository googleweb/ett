package com.ett.visual.model.drv;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import com.smartken.toyz4j.model.IModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import java.util.Set;
import com.smartken.toyz4j.util.ObjectUtil;



public abstract class BaseDriverInfoModel implements IModel{

	public enum F { 
 	Id,Name,Idcard,Dabh,Phone,SchoolName,SchoolCode,Syn,SynResult 
	 }

	public Object getPk(){ return Id;}

	public void setPk(Object pk) throws Exception { Id=pk.toString();}

	public void genPk() throws Exception {Id=ObjectUtil.GeneralPK(); }

	public ResultModel validate(){ return new ResultModel(); }

	public Enum[] enumFields(){ return BaseDriverInfoModel.F.values(); }




protected String Id; 
protected String Name; 
protected String Idcard; 
protected String Dabh; 
protected String Phone; 
protected String SchoolName; 
protected String SchoolCode; 
protected Integer Syn; 
protected String SynResult; 



public String getId(){ return this.Id; }
public void setId(String id){ this.Id=id; }

public String getName(){ return this.Name; }
public void setName(String name){ this.Name=name; }

public String getIdcard(){ return this.Idcard; }
public void setIdcard(String idcard){ this.Idcard=idcard; }

public String getDabh(){ return this.Dabh; }
public void setDabh(String dabh){ this.Dabh=dabh; }

public String getPhone(){ return this.Phone; }
public void setPhone(String phone){ this.Phone=phone; }

public String getSchoolName(){ return this.SchoolName; }
public void setSchoolName(String schoolName){ this.SchoolName=schoolName; }

public String getSchoolCode(){ return this.SchoolCode; }
public void setSchoolCode(String schoolCode){ this.SchoolCode=schoolCode; }

public Integer getSyn(){ return this.Syn; }
public void setSyn(Integer syn){ this.Syn=syn; }

public String getSynResult(){ return this.SynResult; }
public void setSynResult(String synResult){ this.SynResult=synResult; }

public class Query {

protected Set<String> isinId,isnotinId,isinName,isnotinName,
				isinIdcard,isnotinIdcard,isinDabh,isnotinDabh,
				isinPhone,isnotinPhone,isinSchoolName,isnotinSchoolName,
				isinSchoolCode,isnotinSchoolCode,isinSynResult,isnotinSynResult;

protected Set<Integer> isinSyn,isnotinSyn;

protected String neqId,eqId,likeId,notlikeId,
				neqName,eqName,likeName,notlikeName,
				neqIdcard,eqIdcard,likeIdcard,notlikeIdcard,
				neqDabh,eqDabh,likeDabh,notlikeDabh,
				neqPhone,eqPhone,likePhone,notlikePhone,
				neqSchoolName,eqSchoolName,likeSchoolName,notlikeSchoolName,
				neqSchoolCode,eqSchoolCode,likeSchoolCode,notlikeSchoolCode,
				neqSynResult,eqSynResult,likeSynResult,notlikeSynResult;

protected Integer neqSyn,eqSyn,minSyn,maxSyn;

protected Boolean isnullId,isnotnullId,isnullName,isnotnullName,
				isnullIdcard,isnotnullIdcard,isnullDabh,isnotnullDabh,
				isnullPhone,isnotnullPhone,isnullSchoolName,isnotnullSchoolName,
				isnullSchoolCode,isnotnullSchoolCode,isnullSyn,isnotnullSyn,
				isnullSynResult,isnotnullSynResult;

public Set<String> getIsinId(){ return this.isinId; }
public void setIsinId(Set<String> isinId){ this.isinId=isinId; }

public Set<String> getIsnotinId(){ return this.isnotinId; }
public void setIsnotinId(Set<String> isnotinId){ this.isnotinId=isnotinId; }

public Set<String> getIsinName(){ return this.isinName; }
public void setIsinName(Set<String> isinName){ this.isinName=isinName; }

public Set<String> getIsnotinName(){ return this.isnotinName; }
public void setIsnotinName(Set<String> isnotinName){ this.isnotinName=isnotinName; }

public Set<String> getIsinIdcard(){ return this.isinIdcard; }
public void setIsinIdcard(Set<String> isinIdcard){ this.isinIdcard=isinIdcard; }

public Set<String> getIsnotinIdcard(){ return this.isnotinIdcard; }
public void setIsnotinIdcard(Set<String> isnotinIdcard){ this.isnotinIdcard=isnotinIdcard; }

public Set<String> getIsinDabh(){ return this.isinDabh; }
public void setIsinDabh(Set<String> isinDabh){ this.isinDabh=isinDabh; }

public Set<String> getIsnotinDabh(){ return this.isnotinDabh; }
public void setIsnotinDabh(Set<String> isnotinDabh){ this.isnotinDabh=isnotinDabh; }

public Set<String> getIsinPhone(){ return this.isinPhone; }
public void setIsinPhone(Set<String> isinPhone){ this.isinPhone=isinPhone; }

public Set<String> getIsnotinPhone(){ return this.isnotinPhone; }
public void setIsnotinPhone(Set<String> isnotinPhone){ this.isnotinPhone=isnotinPhone; }

public Set<String> getIsinSchoolName(){ return this.isinSchoolName; }
public void setIsinSchoolName(Set<String> isinSchoolName){ this.isinSchoolName=isinSchoolName; }

public Set<String> getIsnotinSchoolName(){ return this.isnotinSchoolName; }
public void setIsnotinSchoolName(Set<String> isnotinSchoolName){ this.isnotinSchoolName=isnotinSchoolName; }

public Set<String> getIsinSchoolCode(){ return this.isinSchoolCode; }
public void setIsinSchoolCode(Set<String> isinSchoolCode){ this.isinSchoolCode=isinSchoolCode; }

public Set<String> getIsnotinSchoolCode(){ return this.isnotinSchoolCode; }
public void setIsnotinSchoolCode(Set<String> isnotinSchoolCode){ this.isnotinSchoolCode=isnotinSchoolCode; }

public Set<String> getIsinSynResult(){ return this.isinSynResult; }
public void setIsinSynResult(Set<String> isinSynResult){ this.isinSynResult=isinSynResult; }

public Set<String> getIsnotinSynResult(){ return this.isnotinSynResult; }
public void setIsnotinSynResult(Set<String> isnotinSynResult){ this.isnotinSynResult=isnotinSynResult; }

public Set<Integer> getIsinSyn(){ return this.isinSyn; }
public void setIsinSyn(Set<Integer> isinSyn){ this.isinSyn=isinSyn; }

public Set<Integer> getIsnotinSyn(){ return this.isnotinSyn; }
public void setIsnotinSyn(Set<Integer> isnotinSyn){ this.isnotinSyn=isnotinSyn; }

public String getNeqId(){ return this.neqId; }
public void setNeqId(String neqId){ this.neqId=neqId; }

public String getEqId(){ return this.eqId; }
public void setEqId(String eqId){ this.eqId=eqId; }

public String getLikeId(){ return this.likeId; }
public void setLikeId(String likeId){ this.likeId=likeId; }

public String getNotlikeId(){ return this.notlikeId; }
public void setNotlikeId(String notlikeId){ this.notlikeId=notlikeId; }

public String getNeqName(){ return this.neqName; }
public void setNeqName(String neqName){ this.neqName=neqName; }

public String getEqName(){ return this.eqName; }
public void setEqName(String eqName){ this.eqName=eqName; }

public String getLikeName(){ return this.likeName; }
public void setLikeName(String likeName){ this.likeName=likeName; }

public String getNotlikeName(){ return this.notlikeName; }
public void setNotlikeName(String notlikeName){ this.notlikeName=notlikeName; }

public String getNeqIdcard(){ return this.neqIdcard; }
public void setNeqIdcard(String neqIdcard){ this.neqIdcard=neqIdcard; }

public String getEqIdcard(){ return this.eqIdcard; }
public void setEqIdcard(String eqIdcard){ this.eqIdcard=eqIdcard; }

public String getLikeIdcard(){ return this.likeIdcard; }
public void setLikeIdcard(String likeIdcard){ this.likeIdcard=likeIdcard; }

public String getNotlikeIdcard(){ return this.notlikeIdcard; }
public void setNotlikeIdcard(String notlikeIdcard){ this.notlikeIdcard=notlikeIdcard; }

public String getNeqDabh(){ return this.neqDabh; }
public void setNeqDabh(String neqDabh){ this.neqDabh=neqDabh; }

public String getEqDabh(){ return this.eqDabh; }
public void setEqDabh(String eqDabh){ this.eqDabh=eqDabh; }

public String getLikeDabh(){ return this.likeDabh; }
public void setLikeDabh(String likeDabh){ this.likeDabh=likeDabh; }

public String getNotlikeDabh(){ return this.notlikeDabh; }
public void setNotlikeDabh(String notlikeDabh){ this.notlikeDabh=notlikeDabh; }

public String getNeqPhone(){ return this.neqPhone; }
public void setNeqPhone(String neqPhone){ this.neqPhone=neqPhone; }

public String getEqPhone(){ return this.eqPhone; }
public void setEqPhone(String eqPhone){ this.eqPhone=eqPhone; }

public String getLikePhone(){ return this.likePhone; }
public void setLikePhone(String likePhone){ this.likePhone=likePhone; }

public String getNotlikePhone(){ return this.notlikePhone; }
public void setNotlikePhone(String notlikePhone){ this.notlikePhone=notlikePhone; }

public String getNeqSchoolName(){ return this.neqSchoolName; }
public void setNeqSchoolName(String neqSchoolName){ this.neqSchoolName=neqSchoolName; }

public String getEqSchoolName(){ return this.eqSchoolName; }
public void setEqSchoolName(String eqSchoolName){ this.eqSchoolName=eqSchoolName; }

public String getLikeSchoolName(){ return this.likeSchoolName; }
public void setLikeSchoolName(String likeSchoolName){ this.likeSchoolName=likeSchoolName; }

public String getNotlikeSchoolName(){ return this.notlikeSchoolName; }
public void setNotlikeSchoolName(String notlikeSchoolName){ this.notlikeSchoolName=notlikeSchoolName; }

public String getNeqSchoolCode(){ return this.neqSchoolCode; }
public void setNeqSchoolCode(String neqSchoolCode){ this.neqSchoolCode=neqSchoolCode; }

public String getEqSchoolCode(){ return this.eqSchoolCode; }
public void setEqSchoolCode(String eqSchoolCode){ this.eqSchoolCode=eqSchoolCode; }

public String getLikeSchoolCode(){ return this.likeSchoolCode; }
public void setLikeSchoolCode(String likeSchoolCode){ this.likeSchoolCode=likeSchoolCode; }

public String getNotlikeSchoolCode(){ return this.notlikeSchoolCode; }
public void setNotlikeSchoolCode(String notlikeSchoolCode){ this.notlikeSchoolCode=notlikeSchoolCode; }

public String getNeqSynResult(){ return this.neqSynResult; }
public void setNeqSynResult(String neqSynResult){ this.neqSynResult=neqSynResult; }

public String getEqSynResult(){ return this.eqSynResult; }
public void setEqSynResult(String eqSynResult){ this.eqSynResult=eqSynResult; }

public String getLikeSynResult(){ return this.likeSynResult; }
public void setLikeSynResult(String likeSynResult){ this.likeSynResult=likeSynResult; }

public String getNotlikeSynResult(){ return this.notlikeSynResult; }
public void setNotlikeSynResult(String notlikeSynResult){ this.notlikeSynResult=notlikeSynResult; }

public Integer getNeqSyn(){ return this.neqSyn; }
public void setNeqSyn(Integer neqSyn){ this.neqSyn=neqSyn; }

public Integer getEqSyn(){ return this.eqSyn; }
public void setEqSyn(Integer eqSyn){ this.eqSyn=eqSyn; }

public Integer getMinSyn(){ return this.minSyn; }
public void setMinSyn(Integer minSyn){ this.minSyn=minSyn; }

public Integer getMaxSyn(){ return this.maxSyn; }
public void setMaxSyn(Integer maxSyn){ this.maxSyn=maxSyn; }

public Boolean getIsnullId(){ return this.isnullId; }
public void setIsnullId(Boolean isnullId){ this.isnullId=isnullId; }

public Boolean getIsnotnullId(){ return this.isnotnullId; }
public void setIsnotnullId(Boolean isnotnullId){ this.isnotnullId=isnotnullId; }

public Boolean getIsnullName(){ return this.isnullName; }
public void setIsnullName(Boolean isnullName){ this.isnullName=isnullName; }

public Boolean getIsnotnullName(){ return this.isnotnullName; }
public void setIsnotnullName(Boolean isnotnullName){ this.isnotnullName=isnotnullName; }

public Boolean getIsnullIdcard(){ return this.isnullIdcard; }
public void setIsnullIdcard(Boolean isnullIdcard){ this.isnullIdcard=isnullIdcard; }

public Boolean getIsnotnullIdcard(){ return this.isnotnullIdcard; }
public void setIsnotnullIdcard(Boolean isnotnullIdcard){ this.isnotnullIdcard=isnotnullIdcard; }

public Boolean getIsnullDabh(){ return this.isnullDabh; }
public void setIsnullDabh(Boolean isnullDabh){ this.isnullDabh=isnullDabh; }

public Boolean getIsnotnullDabh(){ return this.isnotnullDabh; }
public void setIsnotnullDabh(Boolean isnotnullDabh){ this.isnotnullDabh=isnotnullDabh; }

public Boolean getIsnullPhone(){ return this.isnullPhone; }
public void setIsnullPhone(Boolean isnullPhone){ this.isnullPhone=isnullPhone; }

public Boolean getIsnotnullPhone(){ return this.isnotnullPhone; }
public void setIsnotnullPhone(Boolean isnotnullPhone){ this.isnotnullPhone=isnotnullPhone; }

public Boolean getIsnullSchoolName(){ return this.isnullSchoolName; }
public void setIsnullSchoolName(Boolean isnullSchoolName){ this.isnullSchoolName=isnullSchoolName; }

public Boolean getIsnotnullSchoolName(){ return this.isnotnullSchoolName; }
public void setIsnotnullSchoolName(Boolean isnotnullSchoolName){ this.isnotnullSchoolName=isnotnullSchoolName; }

public Boolean getIsnullSchoolCode(){ return this.isnullSchoolCode; }
public void setIsnullSchoolCode(Boolean isnullSchoolCode){ this.isnullSchoolCode=isnullSchoolCode; }

public Boolean getIsnotnullSchoolCode(){ return this.isnotnullSchoolCode; }
public void setIsnotnullSchoolCode(Boolean isnotnullSchoolCode){ this.isnotnullSchoolCode=isnotnullSchoolCode; }

public Boolean getIsnullSyn(){ return this.isnullSyn; }
public void setIsnullSyn(Boolean isnullSyn){ this.isnullSyn=isnullSyn; }

public Boolean getIsnotnullSyn(){ return this.isnotnullSyn; }
public void setIsnotnullSyn(Boolean isnotnullSyn){ this.isnotnullSyn=isnotnullSyn; }

public Boolean getIsnullSynResult(){ return this.isnullSynResult; }
public void setIsnullSynResult(Boolean isnullSynResult){ this.isnullSynResult=isnullSynResult; }

public Boolean getIsnotnullSynResult(){ return this.isnotnullSynResult; }
public void setIsnotnullSynResult(Boolean isnotnullSynResult){ this.isnotnullSynResult=isnotnullSynResult; }





}  //end Query


} //end DriverInfoModel