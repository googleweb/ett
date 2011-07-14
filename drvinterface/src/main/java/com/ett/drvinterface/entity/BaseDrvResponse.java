/**
 * 
 */
package com.ett.drvinterface.entity;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @author austin
 * 公有的返回元素
 */
public class BaseDrvResponse {
	
	final public static int CODE_SUCCESS=1;
	
	private int code;
	private int retcode;
	private String retdesc;
	
	public int getCode() {
		return code;
	}



	public String getMessage() {
		return message;
	}



	public String getRetdesc() {
		return retdesc;
	}



	public int getRetcode() {
		return retcode;
	}



	private String message;
	
	protected Document doc;
	protected SAXReader saxReader;
	
	protected Node node;
	
	public void fromXml(String xml) throws DocumentException
	{
		this.buildDocument(xml);
		//this.code=this.selectNode("");
		
		try
		{
	    this.message=this.selectNode("//message");
		this.code=Integer.parseInt(this.selectNode("//code"));
		this.retcode=Integer.parseInt(this.selectNode("//retcode"));
		}catch(Exception ex)
		{
			
		}
		
	}
	
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

}
