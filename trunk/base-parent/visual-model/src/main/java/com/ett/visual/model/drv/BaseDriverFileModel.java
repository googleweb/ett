package com.ett.visual.model.drv;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import com.smartken.toyz4j.model.IModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import java.util.Set;
import com.smartken.toyz4j.util.ObjectUtil;



public abstract class BaseDriverFileModel implements IModel{

	public enum F { 
 	DrvId,ResId,Id 
	 }

	public Object getPk(){ return Id;}

	public void setPk(Object pk) throws Exception { Id=Integer.parseInt(pk.toString());}

	public void genPk() throws Exception { }

	public ResultModel validate(){ return new ResultModel(); }

	public Enum[] enumFields(){ return BaseDriverFileModel.F.values(); }




protected String DrvId; 
protected String ResId; 
protected Integer Id; 



public String getDrvId(){ return this.DrvId; }
public void setDrvId(String drvId){ this.DrvId=drvId; }

public String getResId(){ return this.ResId; }
public void setResId(String resId){ this.ResId=resId; }

public Integer getId(){ return this.Id; }
public void setId(Integer id){ this.Id=id; }

public class Query {

protected Set<String> isinDrvId,isnotinDrvId,isinResId,isnotinResId;

protected Set<Integer> isinId,isnotinId;

protected String neqDrvId,eqDrvId,likeDrvId,notlikeDrvId,
				neqResId,eqResId,likeResId,notlikeResId;

protected Integer neqId,eqId,minId,maxId;

protected Boolean isnullDrvId,isnotnullDrvId,isnullResId,isnotnullResId,
				isnullId,isnotnullId;

public Set<String> getIsinDrvId(){ return this.isinDrvId; }
public void setIsinDrvId(Set<String> isinDrvId){ this.isinDrvId=isinDrvId; }

public Set<String> getIsnotinDrvId(){ return this.isnotinDrvId; }
public void setIsnotinDrvId(Set<String> isnotinDrvId){ this.isnotinDrvId=isnotinDrvId; }

public Set<String> getIsinResId(){ return this.isinResId; }
public void setIsinResId(Set<String> isinResId){ this.isinResId=isinResId; }

public Set<String> getIsnotinResId(){ return this.isnotinResId; }
public void setIsnotinResId(Set<String> isnotinResId){ this.isnotinResId=isnotinResId; }

public Set<Integer> getIsinId(){ return this.isinId; }
public void setIsinId(Set<Integer> isinId){ this.isinId=isinId; }

public Set<Integer> getIsnotinId(){ return this.isnotinId; }
public void setIsnotinId(Set<Integer> isnotinId){ this.isnotinId=isnotinId; }

public String getNeqDrvId(){ return this.neqDrvId; }
public void setNeqDrvId(String neqDrvId){ this.neqDrvId=neqDrvId; }

public String getEqDrvId(){ return this.eqDrvId; }
public void setEqDrvId(String eqDrvId){ this.eqDrvId=eqDrvId; }

public String getLikeDrvId(){ return this.likeDrvId; }
public void setLikeDrvId(String likeDrvId){ this.likeDrvId=likeDrvId; }

public String getNotlikeDrvId(){ return this.notlikeDrvId; }
public void setNotlikeDrvId(String notlikeDrvId){ this.notlikeDrvId=notlikeDrvId; }

public String getNeqResId(){ return this.neqResId; }
public void setNeqResId(String neqResId){ this.neqResId=neqResId; }

public String getEqResId(){ return this.eqResId; }
public void setEqResId(String eqResId){ this.eqResId=eqResId; }

public String getLikeResId(){ return this.likeResId; }
public void setLikeResId(String likeResId){ this.likeResId=likeResId; }

public String getNotlikeResId(){ return this.notlikeResId; }
public void setNotlikeResId(String notlikeResId){ this.notlikeResId=notlikeResId; }

public Integer getNeqId(){ return this.neqId; }
public void setNeqId(Integer neqId){ this.neqId=neqId; }

public Integer getEqId(){ return this.eqId; }
public void setEqId(Integer eqId){ this.eqId=eqId; }

public Integer getMinId(){ return this.minId; }
public void setMinId(Integer minId){ this.minId=minId; }

public Integer getMaxId(){ return this.maxId; }
public void setMaxId(Integer maxId){ this.maxId=maxId; }

public Boolean getIsnullDrvId(){ return this.isnullDrvId; }
public void setIsnullDrvId(Boolean isnullDrvId){ this.isnullDrvId=isnullDrvId; }

public Boolean getIsnotnullDrvId(){ return this.isnotnullDrvId; }
public void setIsnotnullDrvId(Boolean isnotnullDrvId){ this.isnotnullDrvId=isnotnullDrvId; }

public Boolean getIsnullResId(){ return this.isnullResId; }
public void setIsnullResId(Boolean isnullResId){ this.isnullResId=isnullResId; }

public Boolean getIsnotnullResId(){ return this.isnotnullResId; }
public void setIsnotnullResId(Boolean isnotnullResId){ this.isnotnullResId=isnotnullResId; }

public Boolean getIsnullId(){ return this.isnullId; }
public void setIsnullId(Boolean isnullId){ this.isnullId=isnullId; }

public Boolean getIsnotnullId(){ return this.isnotnullId; }
public void setIsnotnullId(Boolean isnotnullId){ this.isnotnullId=isnotnullId; }





}  //end Query


} //end DriverFileModel