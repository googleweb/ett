package com.ett.visual.model.admin;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import com.smartken.toyz4j.model.IModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import java.util.Set;
import com.smartken.toyz4j.util.ObjectUtil;



public abstract class BaseDictTypeModel implements IModel{

	public enum F { 
 	Id,Text,Remark 
	 }

	public Object getPk(){ return Id;}

	public void setPk(Object pk) throws Exception { Id=pk.toString();}

	public void genPk() throws Exception {Id=ObjectUtil.GeneralPK(); }

	public ResultModel validate(){ return new ResultModel(); }

	public Enum[] enumFields(){ return BaseDictTypeModel.F.values(); }




protected String Id; 
protected String Text; 
protected String Remark; 



public String getId(){ return this.Id; }
public void setId(String id){ this.Id=id; }

public String getText(){ return this.Text; }
public void setText(String text){ this.Text=text; }

public String getRemark(){ return this.Remark; }
public void setRemark(String remark){ this.Remark=remark; }

public class Query {

protected Set<String> isinId,isnotinId,isinText,isnotinText,
				isinRemark,isnotinRemark;

protected String neqId,eqId,likeId,notlikeId,
				neqText,eqText,likeText,notlikeText,
				neqRemark,eqRemark,likeRemark,notlikeRemark;

protected Boolean isnullId,isnotnullId,isnullText,isnotnullText,
				isnullRemark,isnotnullRemark;

public Set<String> getIsinId(){ return this.isinId; }
public void setIsinId(Set<String> isinId){ this.isinId=isinId; }

public Set<String> getIsnotinId(){ return this.isnotinId; }
public void setIsnotinId(Set<String> isnotinId){ this.isnotinId=isnotinId; }

public Set<String> getIsinText(){ return this.isinText; }
public void setIsinText(Set<String> isinText){ this.isinText=isinText; }

public Set<String> getIsnotinText(){ return this.isnotinText; }
public void setIsnotinText(Set<String> isnotinText){ this.isnotinText=isnotinText; }

public Set<String> getIsinRemark(){ return this.isinRemark; }
public void setIsinRemark(Set<String> isinRemark){ this.isinRemark=isinRemark; }

public Set<String> getIsnotinRemark(){ return this.isnotinRemark; }
public void setIsnotinRemark(Set<String> isnotinRemark){ this.isnotinRemark=isnotinRemark; }

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

public String getNeqRemark(){ return this.neqRemark; }
public void setNeqRemark(String neqRemark){ this.neqRemark=neqRemark; }

public String getEqRemark(){ return this.eqRemark; }
public void setEqRemark(String eqRemark){ this.eqRemark=eqRemark; }

public String getLikeRemark(){ return this.likeRemark; }
public void setLikeRemark(String likeRemark){ this.likeRemark=likeRemark; }

public String getNotlikeRemark(){ return this.notlikeRemark; }
public void setNotlikeRemark(String notlikeRemark){ this.notlikeRemark=notlikeRemark; }

public Boolean getIsnullId(){ return this.isnullId; }
public void setIsnullId(Boolean isnullId){ this.isnullId=isnullId; }

public Boolean getIsnotnullId(){ return this.isnotnullId; }
public void setIsnotnullId(Boolean isnotnullId){ this.isnotnullId=isnotnullId; }

public Boolean getIsnullText(){ return this.isnullText; }
public void setIsnullText(Boolean isnullText){ this.isnullText=isnullText; }

public Boolean getIsnotnullText(){ return this.isnotnullText; }
public void setIsnotnullText(Boolean isnotnullText){ this.isnotnullText=isnotnullText; }

public Boolean getIsnullRemark(){ return this.isnullRemark; }
public void setIsnullRemark(Boolean isnullRemark){ this.isnullRemark=isnullRemark; }

public Boolean getIsnotnullRemark(){ return this.isnotnullRemark; }
public void setIsnotnullRemark(Boolean isnotnullRemark){ this.isnotnullRemark=isnotnullRemark; }





}  //end Query


} //end DictTypeModel