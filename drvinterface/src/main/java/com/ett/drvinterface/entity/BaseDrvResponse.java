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
	
	private int code;
	private String message;
	
	protected Document doc;
	protected SAXReader saxReader;
	
	protected Node node;
	
	public void fromXml(String xml) throws DocumentException
	{
		this.buildDocument(xml);
		//this.code=this.selectNode("");
		this.message=this.selectNode("//message");
		try
		{
		this.code=Integer.parseInt(this.selectNode("//code"));
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
