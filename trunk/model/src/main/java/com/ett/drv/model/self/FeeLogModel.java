package com.ett.drv.model.self;

import java.util.Date;

import com.smartken.kia.core.model.impl.BaseModel;

public class FeeLogModel extends BaseModel {

	public static enum F{
		id,createip,createtime,creator,isdeleted,description,keywords,modifier,modifyip,modifytime,bustype,
		detail,feetype,money,sfzmhm,visacard,xm,feelsh,postfee,feewaytype,relationid
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
	private String bustype;         //BUSTYPE  VARCHAR2 120
	private String detail;         //DETAIL  VARCHAR2 800
	private String feetype;         //FEETYPE  VARCHAR2 120
	private Integer money;         //MONEY  NUMBER 10
	private String sfzmhm;         //SFZMHM  VARCHAR2 72
	private String visacard;         //VISACARD  VARCHAR2 120
	private String xm;         //XM  VARCHAR2 120
	private String feelsh;         //FEELSH  VARCHAR2 1,056
	private Integer postfee;         //POSTFEE  NUMBER 10
	private String feewaytype;         //FEEWAYTYPE  VARCHAR2 120
	private String relationid;         //RELATIONID  VARCHAR2 1,020
	private Integer syn;         //I_SYN  NUMBER 1
	
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
	public String getBustype() {
		return bustype;
	}
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getFeetype() {
		return feetype;
	}
	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getSfzmhm() {
		return sfzmhm;
	}
	public void setSfzmhm(String sfzmhm) {
		this.sfzmhm = sfzmhm;
	}
	public String getVisacard() {
		return visacard;
	}
	public void setVisacard(String visacard) {
		this.visacard = visacard;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getFeelsh() {
		return feelsh;
	}
	public void setFeelsh(String feelsh) {
		this.feelsh = feelsh;
	}
	public Integer getPostfee() {
		return postfee;
	}
	public void setPostfee(Integer postfee) {
		this.postfee = postfee;
	}
	public String getFeewaytype() {
		return feewaytype;
	}
	public void setFeewaytype(String feewaytype) {
		this.feewaytype = feewaytype;
	}
	public String getRelationid() {
		return relationid;
	}
	public void setRelationid(String relationid) {
		this.relationid = relationid;
	}
	public Integer getSyn() {
		return syn;
	}
	public void setSyn(Integer syn) {
		this.syn = syn;
	}
	
	
	
	
}
