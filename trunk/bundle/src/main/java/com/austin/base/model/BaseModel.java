/**
 * 
 */
package com.austin.base.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.googlecode.jsonplugin.annotations.JSON;

/**
 * @author austin
 * 基本的模型类型
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="table_base_model")
public abstract class BaseModel implements Serializable  {
	private Long id;

	private boolean isDeleted = false;

	private String creator = "unkown";

	private Date createTime = new Date();

	private String createIp;

	private String modifier;

	private Date modifyTime;

	private String modifyIp;	

	private String keyword;// 关键字 供查询使用
	
	private String description;//说明性文字

	@Id
	@Column(name="id")
	@TableGenerator(
		name="tab-store",
		
		allocationSize=1,initialValue=1
		)
    @GeneratedValue(strategy = GenerationType.TABLE,generator="tab-store")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="i_isdeleted",nullable=true,columnDefinition="")
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(nullable=true,length=30,updatable=false,insertable=true,name="c_creator")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
//,columnDefinition=" date default sysdate"
	@Column(nullable=true, updatable=false,insertable=true,name="t_createtime")
	@Temporal(TemporalType.TIMESTAMP)
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(nullable=true,updatable=false,insertable=true,name="c_createip")
	public String getCreateIp() {
		return createIp;
	}

	public void setCreateIp(String createIp) {
		this.createIp = createIp;
	}

	@Column(nullable=true,updatable=true,insertable=false,name="c_modifier")
	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	@Column(nullable=true,updatable=true,insertable=false,name="t_modifytime")
	@Temporal(TemporalType.TIMESTAMP)
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Column(nullable=true,updatable=true,insertable=false,name="c_modifyip")
	public String getModifyIp() {
		return modifyIp;
	}

	public void setModifyIp(String modifyIp) {
		this.modifyIp = modifyIp;
	}

	@Column(nullable=true,name="c_keywords")
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(nullable=true,name="c_description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
