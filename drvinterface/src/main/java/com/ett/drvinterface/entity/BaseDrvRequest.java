/**
 * 
 */
package com.ett.drvinterface.entity;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


/**
 * @author austin
 *  基本的请求公有元素
 */
public abstract class BaseDrvRequest {
	protected String dabh;
	protected String lsh;
	protected String sfzmmc;
	protected String sfzmhm;
	protected String xm;
	protected String glbm;
	protected String xh;
	protected String fzjg;
	
	protected String sn;
	
	protected String xtlb;
	protected String jkxlh;
	protected String jkid;
	
	
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getXtlb() {
		return xtlb;
	}
	public void setXtlb(String xtlb) {
		this.xtlb = xtlb;
	}
	public String getJkxlh() {
		return jkxlh;
	}
	public void setJkxlh(String jkxlh) {
		this.jkxlh = jkxlh;
	}
	public String getJkid() {
		return jkid;
	}
	public void setJkid(String jkid) {
		this.jkid = jkid;
	}
	public SAXReader getSaxReader() {
		return saxReader;
	}
	public void setSaxReader(SAXReader saxReader) {
		this.saxReader = saxReader;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public abstract String toXml();
	
	public String getDabh() {
		return dabh;
	}
	public void setDabh(String dabh) {
		this.dabh = dabh;
	}
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	public String getSfzmmc() {
		return sfzmmc;
	}
	public void setSfzmmc(String sfzmmc) {
		this.sfzmmc = sfzmmc;
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
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	
	protected Document doc;
	protected SAXReader saxReader;
	
	protected Node node;
	
	protected void buildDocument(String xml) throws DocumentException
	{
		//saxReader = new SAXReader();
		doc=DocumentHelper.parseText(xml);
		//doc = saxReader.read(new StringInputStream(xml));
	}
	
	protected String selectNode(String xpathExpression)
	{
		node=doc.selectSingleNode(xpathExpression);
		if(node==null)
		{
			return "";
		}
		return node.getText();
	}
	
	protected void appendTag(StringBuffer sb,String tag,String value)
	{
		if(value!=null){
		sb.append("<"+tag+">");
		
		sb.append(value);
		sb.append("</"+tag+">");}
		else
		{
			sb.append("<"+tag+">");
			sb.append("</"+tag+">");
		}
	}
	

}
