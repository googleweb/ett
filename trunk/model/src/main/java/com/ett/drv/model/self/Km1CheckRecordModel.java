package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class Km1CheckRecordModel extends BaseModel {

   public static enum F{
		id,createip,createtime,creator,isdeleted,description,keywords,modifier,modifyip,modifytime,ksdd,
		ksddname,lsh,sfzmhm,xm
   }	
	

	private Integer id;         //ID  NUMBER 19
	private String createip;         //C_CREATEIP  VARCHAR2 1,020
	private Date createtime;         //T_CREATETIME  DATE 0
	private String creator;         //C_CREATOR  VARCHAR2 120
	private Integer isdeleted;         //I_ISDELETED  NUMBER 1
	private String description;         //C_DESCRIPTION  VARCHAR2 1,020
	private String keywords;         //C_KEYWORDS  VARCHAR2 1,020
	private String modifier;         //C_MODIFIER  VARCHAR2 1,020
	private String modifyip;         //C_MODIFYIP  VARCHAR2 1,020
	private Date modifytime;         //T_MODIFYTIME  DATE 0
	private String ksdd;         //KSDD  VARCHAR2 1,020
	private String ksddname;         //C_KSDDNAME  VARCHAR2 1,020
	private String lsh;         //LSH  VARCHAR2 1,020
	private String sfzmhm;         //SFZMHM  VARCHAR2 1,020
	private String xm;         //XM  VARCHAR2 1,020
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreateip() {
		return createip;
	}
	public void setCreateip(String createip) {
		this.createip = createip;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getModifyip() {
		return modifyip;
	}
	public void setModifyip(String modifyip) {
		this.modifyip = modifyip;
	}
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	public String getKsdd() {
		return ksdd;
	}
	public void setKsdd(String ksdd) {
		this.ksdd = ksdd;
	}
	public String getKsddname() {
		return ksddname;
	}
	public void setKsddname(String ksddname) {
		this.ksddname = ksddname;
	}
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	public String getSfzmhm() {
		return sfzmhm;
	}
	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}

	
	
}
