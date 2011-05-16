package com.austin.base.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface IBaseAction {
	
	/**
	 * 查询的Result
	 */
	public static final String ListPage="list";	
	/**
	 * 编辑成功后的Result
	 */
	public static final String EditPage="edit";	
	/**
	 * 添加成功后的Result
	 */
	public static final String AddPage="add";	
	
	/**
	 * 导出Excel
	 */
	public static final String ExcelPage="excel";	
	
	/**
	 * 导出Pdf
	 */
	public static final String PdfPage="pdf";	
	
	/**
	 * 导出Cvs
	 */
	public static final String CvsPage="cvs";	
	
	/**
	 * 导出Xml
	 */
	public static final String XmlPage="xml";	
	
	/**
	 * 打印的Result
	 */
	public static final String PrintPage="print";	
	
	/**
	 * 返回结果的result字符串，供struts2和webwork使用，struts1未知
	 */
	public static final String AjaxResult="ajaxResult";	
	
	/**
	 * 提示信息的页面,带上returnurl的参数供返回
	 */
	public static final String HintPage="hint";	
	
	/**
	 * 出错时候的警告页面
	 */
	public static final String ErrorPage="error";	
	
	/**
	 * @return 获取当前的Request
	 */
	public HttpServletRequest getCurrentRequest();
	
	/**
	 * @return 获取当前的Response
	 */
	public HttpServletResponse getCurrentResponse();
	
	/**
	 * @param text输出类型为text/html
	 */
	public void renderHtml(String text);
	
	/**
	 * @param text输出类型为text/xml
	 */
	public void renderXML(String text);
	
	/**
	 * @param text输出类型为text/plain
	 */
	public void renderText(String text);
	
	/**
	 * @param text 输出内容
	 * @param contentType 输出的类型
	 */
	public void render(String text,String contentType);
	
	
	/**
	 * @param rightId 权限的ID
	 * @return 是否拥有该权限
	 */
	public boolean checkUserRight(String rightId); 
	
	
	/**
	 * @param relativePath 相对路径
	 * @return 绝对路径
	 */
	public String getRealPath(String relativePath);
	
	
	/**
	 * @return 获取Session
	 */
	public HttpSession getHttpSession();
	
	/**
	 * @param key key 
	 * @param value 对象
	 */
	public void setHttpSession(String key,Object value);
	
	/**
	 * 清理所有的HttpSession
	 */
	public void clearHttpSession();
	
	/**
	 * @param key 移开HttpSession 
	 */
	public void removeHttpSession(String key);
	
	/**
	 * @param key 从htmlpost数据取数据或参数取
	 * @return 优先从html Post的元素取数据，如果没有，从url参数取
	 */
	public String getHtmlAttributeOrParamter(String key);
	
	/**
	 * @param key 关键字
	 * @return 获取Html内容的属性
	 */
	public Object getHtmlAttribute(String key);
	
	/**
	 * @param key 关键字
	 * @return 从html的url参数中获取关键字的值
	 */
	public  String getParamter(String key);
	
	/**
	 * @param key 关键字
	 * @param value 放入html内容表单中的值
	 */
	public void setHtmlAttribute(String key,Object value);
	
	/**
	 * @param failerrors 设置错误提示信息并跳转到错误提示页面
	 */
	public String goFailPage(String failerrors);
	
	
	/**
	 * @param successHint 设置正确的提示信息并跳转到提示页
	 */
	public String goSuccessPage(String successHint);
	
	
	/**
	 * @return 获取客户端的IP地址
	 */
	public String getRemoteAddr();

}
