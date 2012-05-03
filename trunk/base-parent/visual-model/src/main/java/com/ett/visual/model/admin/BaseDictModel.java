package com.ett.visual.model.admin;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import com.smartken.toyz4j.model.IModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import java.util.Set;
import com.smartken.toyz4j.util.ObjectUtil;



public abstract class BaseDictModel implements IModel{

	public enum F { 
 	Id,Text,Value,TypeFk,Remark,State 
	 }

	public Object getPk(){ return Id;}

	public void setPk(Object pk) throws Exception { Id=pk.toString();}

	public void genPk() throws Exception {Id=ObjectUtil.GeneralPK(); }

	public ResultModel validate(){ return new ResultModel(); }

	public Enum[] enumFields(){ return BaseDictModel.F.values(); }




protected String Id; 
protected String Text; 
protected String Value; 
protected String TypeFk; 
protected String Remark; 
protected String State; 



public String getId(){ return this.Id; }
public void setId(String id){ this.Id=id; }

public String getText(){ return this.Text; }
public void setText(String text){ this.Text=text; }

public String getValue(){ return this.Value; }
public void setValue(String value){ this.Value=value; }

public String getTypeFk(){ return this.TypeFk; }
public void setTypeFk(String typeFk){ this.TypeFk=typeFk; }

public String getRemark(){ return this.Remark; }
public void setRemark(String remark){ this.Remark=remark; }

public String getState(){ return this.State; }
public void setState(String state){ this.State=state; }

public class Query {

protected Set<String> isinId,isnotinId,isinText,isnotinText,
				isinValue,isnotinValue,isinTypeFk,isnotinTypeFk,
				isinRemark,isnotinRemark,isinState,isnotinState;

protected String neqId,eqId,likeId,notlikeId,
				neqText,eqText,likeText,notlikeText,
				neqValue,eqValue,likeValue,notlikeValue,
				neqTypeFk,eqTypeFk,likeTypeFk,notlikeTypeFk,
				neqRemark,eqRemark,likeRemark,notlikeRemark,
				neqState,eqState,likeState,notlikeState;

protected Boolean isnullId,isnotnullId,isnullText,isnotnullText,
				isnullValue,isnotnullValue,isnullTypeFk,isnotnullTypeFk,
				isnullRemark,isnotnullRemark,isnullState,isnotnullState;

public Set<String> getIsinId(){ return this.isinId; }
public void setIsinId(Set<String> isinId){ this.isinId=isinId; }

public Set<String> getIsnotinId(){ return this.isnotinId; }
public void setIsnotinId(Set<String> isnotinId){ this.isnotinId=isnotinId; }

public Set<String> getIsinText(){ return this.isinText; }
public void setIsinText(Set<String> isinText){ this.isinText=isinText; }

public Set<String> getIsnotinText(){ return this.isnotinText; }
public void setIsnotinText(Set<String> isnotinText){ this.isnotinText=isnotinText; }

public Set<String> getIsinValue(){ return this.isinValue; }
public void setIsinValue(Set<String> isinValue){ this.isinValue=isinValue; }

public Set<String> getIsnotinValue(){ return this.isnotinValue; }
public void setIsnotinValue(Set<String> isnotinValue){ this.isnotinValue=isnotinValue; }

public Set<String> getIsinTypeFk(){ return this.isinTypeFk; }
public void setIsinTypeFk(Set<String> isinTypeFk){ this.isinTypeFk=isinTypeFk; }

public Set<String> getIsnotinTypeFk(){ return this.isnotinTypeFk; }
public void setIsnotinTypeFk(Set<String> isnotinTypeFk){ this.isnotinTypeFk=isnotinTypeFk; }

public Set<String> getIsinRemark(){ return this.isinRemark; }
public void setIsinRemark(Set<String> isinRemark){ this.isinRemark=isinRemark; }

public Set<String> getIsnotinRemark(){ return this.isnotinRemark; }
public void setIsnotinRemark(Set<String> isnotinRemark){ this.isnotinRemark=isnotinRemark; }

public Set<String> getIsinState(){ return this.isinState; }
public void setIsinState(Set<String> isinState){ this.isinState=isinState; }

public Set<String> getIsnotinState(){ return this.isnotinState; }
public void setIsnotinState(Set<String> isnotinState){ this.isnotinState=isnotinState; }

public String getNeqId(){ return this.neqId; }
public void setNeqId(String neqId){ this.neqId=neqId; }

public String getEqId(){ return this.eqId; }
public void setEqId(String eqId){ this.eqId=eqId; }

public String getLikeId(){ return this.likeId; }
public void setLikeId(String likeId){ this.likeId=likeId; }

public String getNotlikeId(){ return this.notlikeId; }
public void setNotlikeId(String notlikeId){ this.notlikeId=notlikeId; }

public String getNeqText(){ return this.neqText; }
public void setNeqText(String neqText){ this.neqText=neqText; }

public String getEqText(){ return this.eqText; }
public void setEqText(String eqText){ this.eqText=eqText; }

public String getLikeText(){ return this.likeText; }
public void setLikeText(String likeText){ this.likeText=likeText; }

public String getNotlikeText(){ return this.notlikeText; }
public void setNotlikeText(String notlikeText){ this.notlikeText=notlikeText; }

public String getNeqValue(){ return this.neqValue; }
public void setNeqValue(String neqValue){ this.neqValue=neqValue; }

public String getEqValue(){ return this.eqValue; }
public void setEqValue(String eqValue){ this.eqValue=eqValue; }

public String getLikeValue(){ return this.likeValue; }
public void setLikeValue(String likeValue){ this.likeValue=likeValue; }

public String getNotlikeValue(){ return this.notlikeValue; }
public void setNotlikeValue(String notlikeValue){ this.notlikeValue=notlikeValue; }

public String getNeqTypeFk(){ return this.neqTypeFk; }
public void setNeqTypeFk(String neqTypeFk){ this.neqTypeFk=neqTypeFk; }

public String getEqTypeFk(){ return this.eqTypeFk; }
public void setEqTypeFk(String eqTypeFk){ this.eqTypeFk=eqTypeFk; }

public String getLikeTypeFk(){ return this.likeTypeFk; }
public void setLikeTypeFk(String likeTypeFk){ this.likeTypeFk=likeTypeFk; }

public String getNotlikeTypeFk(){ return this.notlikeTypeFk; }
public void setNotlikeTypeFk(String notlikeTypeFk){ this.notlikeTypeFk=notlikeTypeFk; }

public String getNeqRemark(){ return this.neqRemark; }
public void setNeqRemark(String neqRemark){ this.neqRemark=neqRemark; }

public String getEqRemark(){ return this.eqRemark; }
public void setEqRemark(String eqRemark){ this.eqRemark=eqRemark; }

public String getLikeRemark(){ return this.likeRemark; }
public void setLikeRemark(String likeRemark){ this.likeRemark=likeRemark; }

public String getNotlikeRemark(){ return this.notlikeRemark; }
public void setNotlikeRemark(String notlikeRemark){ this.notlikeRemark=notlikeRemark; }

public String getNeqState(){ return this.neqState; }
public void setNeqState(String neqState){ this.neqState=neqState; }

public String getEqState(){ return this.eqState; }
public void setEqState(String eqState){ this.eqState=eqState; }

public String getLikeState(){ return this.likeState; }
public void setLikeState(String likeState){ this.likeState=likeState; }

public String getNotlikeState(){ return this.notlikeState; }
public void setNotlikeState(String notlikeState){ this.notlikeState=notlikeState; }

public Boolean getIsnullId(){ return this.isnullId; }
public void setIsnullId(Boolean isnullId){ this.isnullId=isnullId; }

public Boolean getIsnotnullId(){ return this.isnotnullId; }
public void setIsnotnullId(Boolean isnotnullId){ this.isnotnullId=isnotnullId; }

public Boolean getIsnullText(){ return this.isnullText; }
public void setIsnullText(Boolean isnullText){ this.isnullText=isnullText; }

public Boolean getIsnotnullText(){ return this.isnotnullText; }
public void setIsnotnullText(Boolean isnotnullText){ this.isnotnullText=isnotnullText; }

public Boolean getIsnullValue(){ return this.isnullValue; }
public void setIsnullValue(Boolean isnullValue){ this.isnullValue=isnullValue; }

public Boolean getIsnotnullValue(){ return this.isnotnullValue; }
public void setIsnotnullValue(Boolean isnotnullValue){ this.isnotnullValue=isnotnullValue; }

public Boolean getIsnullTypeFk(){ return this.isnullTypeFk; }
public void setIsnullTypeFk(Boolean isnullTypeFk){ this.isnullTypeFk=isnullTypeFk; }

public Boolean getIsnotnullTypeFk(){ return this.isnotnullTypeFk; }
public void setIsnotnullTypeFk(Boolean isnotnullTypeFk){ this.isnotnullTypeFk=isnotnullTypeFk; }

public Boolean getIsnullRemark(){ return this.isnullRemark; }
public void setIsnullRemark(Boolean isnullRemark){ this.isnullRemark=isnullRemark; }

public Boolean getIsnotnullRemark(){ return this.isnotnullRemark; }
public void setIsnotnullRemark(Boolean isnotnullRemark){ this.isnotnullRemark=isnotnullRemark; }

public Boolean getIsnullState(){ return this.isnullState; }
public void setIsnullState(Boolean isnullState){ this.isnullState=isnullState; }

public Boolean getIsnotnullState(){ return this.isnotnullState; }
public void setIsnotnullState(Boolean isnotnullState){ this.isnotnullState=isnotnullState; }





}  //end Query


} //end DictModel