package com.ett.visual.model.admin;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import com.smartken.toyz4j.model.IModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import java.util.Set;
import com.smartken.toyz4j.util.ObjectUtil;



public abstract class BaseRoleModel implements IModel{

	public enum F { 
 	Id,Name,Descp,TokenArray 
	 }

	public Object getPk(){ return Id;}

	public void setPk(Object pk) throws Exception { Id=pk.toString();}

	public void genPk() throws Exception {Id=ObjectUtil.GeneralPK(); }

	public ResultModel validate(){ return new ResultModel(); }

	public Enum[] enumFields(){ return BaseRoleModel.F.values(); }




protected String Id; 
protected String Name; 
protected String Descp; 
protected String TokenArray; 



public String getId(){ return this.Id; }
public void setId(String id){ this.Id=id; }

public String getName(){ return this.Name; }
public void setName(String name){ this.Name=name; }

public String getDescp(){ return this.Descp; }
public void setDescp(String descp){ this.Descp=descp; }

public String getTokenArray(){ return this.TokenArray; }
public void setTokenArray(String tokenArray){ this.TokenArray=tokenArray; }

public class Query {

protected Set<String> isinId,isnotinId,isinName,isnotinName,
				isinDescp,isnotinDescp,isinTokenArray,isnotinTokenArray;

protected String neqId,eqId,likeId,notlikeId,
				neqName,eqName,likeName,notlikeName,
				neqDescp,eqDescp,likeDescp,notlikeDescp,
				neqTokenArray,eqTokenArray,likeTokenArray,notlikeTokenArray;

protected Boolean isnullId,isnotnullId,isnullName,isnotnullName,
				isnullDescp,isnotnullDescp,isnullTokenArray,isnotnullTokenArray;

public Set<String> getIsinId(){ return this.isinId; }
public void setIsinId(Set<String> isinId){ this.isinId=isinId; }

public Set<String> getIsnotinId(){ return this.isnotinId; }
public void setIsnotinId(Set<String> isnotinId){ this.isnotinId=isnotinId; }

public Set<String> getIsinName(){ return this.isinName; }
public void setIsinName(Set<String> isinName){ this.isinName=isinName; }

public Set<String> getIsnotinName(){ return this.isnotinName; }
public void setIsnotinName(Set<String> isnotinName){ this.isnotinName=isnotinName; }

public Set<String> getIsinDescp(){ return this.isinDescp; }
public void setIsinDescp(Set<String> isinDescp){ this.isinDescp=isinDescp; }

public Set<String> getIsnotinDescp(){ return this.isnotinDescp; }
public void setIsnotinDescp(Set<String> isnotinDescp){ this.isnotinDescp=isnotinDescp; }

public Set<String> getIsinTokenArray(){ return this.isinTokenArray; }
public void setIsinTokenArray(Set<String> isinTokenArray){ this.isinTokenArray=isinTokenArray; }

public Set<String> getIsnotinTokenArray(){ return this.isnotinTokenArray; }
public void setIsnotinTokenArray(Set<String> isnotinTokenArray){ this.isnotinTokenArray=isnotinTokenArray; }

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

public String getNeqDescp(){ return this.neqDescp; }
public void setNeqDescp(String neqDescp){ this.neqDescp=neqDescp; }

public String getEqDescp(){ return this.eqDescp; }
public void setEqDescp(String eqDescp){ this.eqDescp=eqDescp; }

public String getLikeDescp(){ return this.likeDescp; }
public void setLikeDescp(String likeDescp){ this.likeDescp=likeDescp; }

public String getNotlikeDescp(){ return this.notlikeDescp; }
public void setNotlikeDescp(String notlikeDescp){ this.notlikeDescp=notlikeDescp; }

public String getNeqTokenArray(){ return this.neqTokenArray; }
public void setNeqTokenArray(String neqTokenArray){ this.neqTokenArray=neqTokenArray; }

public String getEqTokenArray(){ return this.eqTokenArray; }
public void setEqTokenArray(String eqTokenArray){ this.eqTokenArray=eqTokenArray; }

public String getLikeTokenArray(){ return this.likeTokenArray; }
public void setLikeTokenArray(String likeTokenArray){ this.likeTokenArray=likeTokenArray; }

public String getNotlikeTokenArray(){ return this.notlikeTokenArray; }
public void setNotlikeTokenArray(String notlikeTokenArray){ this.notlikeTokenArray=notlikeTokenArray; }

public Boolean getIsnullId(){ return this.isnullId; }
public void setIsnullId(Boolean isnullId){ this.isnullId=isnullId; }

public Boolean getIsnotnullId(){ return this.isnotnullId; }
public void setIsnotnullId(Boolean isnotnullId){ this.isnotnullId=isnotnullId; }

public Boolean getIsnullName(){ return this.isnullName; }
public void setIsnullName(Boolean isnullName){ this.isnullName=isnullName; }

public Boolean getIsnotnullName(){ return this.isnotnullName; }
public void setIsnotnullName(Boolean isnotnullName){ this.isnotnullName=isnotnullName; }

public Boolean getIsnullDescp(){ return this.isnullDescp; }
public void setIsnullDescp(Boolean isnullDescp){ this.isnullDescp=isnullDescp; }

public Boolean getIsnotnullDescp(){ return this.isnotnullDescp; }
public void setIsnotnullDescp(Boolean isnotnullDescp){ this.isnotnullDescp=isnotnullDescp; }

public Boolean getIsnullTokenArray(){ return this.isnullTokenArray; }
public void setIsnullTokenArray(Boolean isnullTokenArray){ this.isnullTokenArray=isnullTokenArray; }

public Boolean getIsnotnullTokenArray(){ return this.isnotnullTokenArray; }
public void setIsnotnullTokenArray(Boolean isnotnullTokenArray){ this.isnotnullTokenArray=isnotnullTokenArray; }





}  //end Query


} //end RoleModel