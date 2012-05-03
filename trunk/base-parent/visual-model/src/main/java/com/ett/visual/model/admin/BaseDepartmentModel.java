package com.ett.visual.model.admin;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import com.smartken.toyz4j.model.IModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import java.util.Set;
import com.smartken.toyz4j.util.ObjectUtil;



public abstract class BaseDepartmentModel implements IModel{

	public enum F { 
 	Id,CTypename,CDescription 
	 }

	public Object getPk(){ return Id;}

	public void setPk(Object pk) throws Exception { Id=Integer.parseInt(pk.toString());}

	public void genPk() throws Exception { }

	public ResultModel validate(){ return new ResultModel(); }

	public Enum[] enumFields(){ return BaseDepartmentModel.F.values(); }




protected Integer Id; 
protected String CTypename; 
protected String CDescription; 



public Integer getId(){ return this.Id; }
public void setId(Integer id){ this.Id=id; }

public String getCTypename(){ return this.CTypename; }
public void setCTypename(String cTypename){ this.CTypename=cTypename; }

public String getCDescription(){ return this.CDescription; }
public void setCDescription(String cDescription){ this.CDescription=cDescription; }

public class Query {

protected String neqCTypename,eqCTypename,likeCTypename,notlikeCTypename,
				neqCDescription,eqCDescription,likeCDescription,notlikeCDescription;

protected List<String> isinCTypename,isnotinCTypename,isinCDescription,isnotinCDescription;

protected Integer neqId,eqId,minId,maxId;

protected List<Integer> isinId,isnotinId;

protected Boolean isnullId,isnotnullId,isnullCTypename,isnotnullCTypename,
				isnullCDescription,isnotnullCDescription;

public String getNeqCTypename(){ return this.neqCTypename; }
public void setNeqCTypename(String neqCTypename){ this.neqCTypename=neqCTypename; }

public String getEqCTypename(){ return this.eqCTypename; }
public void setEqCTypename(String eqCTypename){ this.eqCTypename=eqCTypename; }

public String getLikeCTypename(){ return this.likeCTypename; }
public void setLikeCTypename(String likeCTypename){ this.likeCTypename=likeCTypename; }

public String getNotlikeCTypename(){ return this.notlikeCTypename; }
public void setNotlikeCTypename(String notlikeCTypename){ this.notlikeCTypename=notlikeCTypename; }

public String getNeqCDescription(){ return this.neqCDescription; }
public void setNeqCDescription(String neqCDescription){ this.neqCDescription=neqCDescription; }

public String getEqCDescription(){ return this.eqCDescription; }
public void setEqCDescription(String eqCDescription){ this.eqCDescription=eqCDescription; }

public String getLikeCDescription(){ return this.likeCDescription; }
public void setLikeCDescription(String likeCDescription){ this.likeCDescription=likeCDescription; }

public String getNotlikeCDescription(){ return this.notlikeCDescription; }
public void setNotlikeCDescription(String notlikeCDescription){ this.notlikeCDescription=notlikeCDescription; }

public List<String> getIsinCTypename(){ return this.isinCTypename; }
public void setIsinCTypename(List<String> isinCTypename){ this.isinCTypename=isinCTypename; }

public List<String> getIsnotinCTypename(){ return this.isnotinCTypename; }
public void setIsnotinCTypename(List<String> isnotinCTypename){ this.isnotinCTypename=isnotinCTypename; }

public List<String> getIsinCDescription(){ return this.isinCDescription; }
public void setIsinCDescription(List<String> isinCDescription){ this.isinCDescription=isinCDescription; }

public List<String> getIsnotinCDescription(){ return this.isnotinCDescription; }
public void setIsnotinCDescription(List<String> isnotinCDescription){ this.isnotinCDescription=isnotinCDescription; }

public Integer getNeqId(){ return this.neqId; }
public void setNeqId(Integer neqId){ this.neqId=neqId; }

public Integer getEqId(){ return this.eqId; }
public void setEqId(Integer eqId){ this.eqId=eqId; }

public Integer getMinId(){ return this.minId; }
public void setMinId(Integer minId){ this.minId=minId; }

public Integer getMaxId(){ return this.maxId; }
public void setMaxId(Integer maxId){ this.maxId=maxId; }

public List<Integer> getIsinId(){ return this.isinId; }
public void setIsinId(List<Integer> isinId){ this.isinId=isinId; }

public List<Integer> getIsnotinId(){ return this.isnotinId; }
public void setIsnotinId(List<Integer> isnotinId){ this.isnotinId=isnotinId; }

public Boolean getIsnullId(){ return this.isnullId; }
public void setIsnullId(Boolean isnullId){ this.isnullId=isnullId; }

public Boolean getIsnotnullId(){ return this.isnotnullId; }
public void setIsnotnullId(Boolean isnotnullId){ this.isnotnullId=isnotnullId; }

public Boolean getIsnullCTypename(){ return this.isnullCTypename; }
public void setIsnullCTypename(Boolean isnullCTypename){ this.isnullCTypename=isnullCTypename; }

public Boolean getIsnotnullCTypename(){ return this.isnotnullCTypename; }
public void setIsnotnullCTypename(Boolean isnotnullCTypename){ this.isnotnullCTypename=isnotnullCTypename; }

public Boolean getIsnullCDescription(){ return this.isnullCDescription; }
public void setIsnullCDescription(Boolean isnullCDescription){ this.isnullCDescription=isnullCDescription; }

public Boolean getIsnotnullCDescription(){ return this.isnotnullCDescription; }
public void setIsnotnullCDescription(Boolean isnotnullCDescription){ this.isnotnullCDescription=isnotnullCDescription; }





}  //end Query


} //end DepartmentModel