/**
 * 
 */
package com.ett.web.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ett.model.BaseEntity;
import com.ett.model.Person;
import com.ett.self.SelfDeviceUser;
import com.opensymphony.xwork2.ActionContext;
/**
 * @author chen
 * 对输入输出一些结果的限定 各个framework自己实现具体方法
 */
public  class HttpUtil {
	
	
	/**
	 * 登陆用户的Session中的key
	 */
	public static final String Login_User_Constant="login_user_constant";
	
	
	
	
	
	//struts2下获取spring的bean
	public  Object getBeanStruts2(String id)
	{
		ServletContext sc = ServletActionContext.getServletContext();
		WebApplicationContext  context=WebApplicationContextUtils.getWebApplicationContext(sc);
		return context.getBean(id);
	}
	
	protected static  Log log = LogFactory.getLog(HttpUtil.class);
	/**
	 * @param response 输出结果，文本，主要供ajax返回结果使用
	 */
	public static void setTextPlain(HttpServletResponse response)
	{
		response.setContentType("text/plain charset=utf-8");
	}
	
	/**
	 * @param response 执行调用ajax动作成功后输出一个success等于true的json对象
	 * @throws IOException 
	 */
	public static void ajaxSuccess(HttpServletResponse response) throws IOException
	{
		setTextPlain(response);
		response.getWriter().write("{success:true}");
	}
	
	/**
	 * @param response 执行调用ajax动作失败后输出一个success属性为false的json对象
	 * @throws IOException 
	 */
	public static void ajaxFail(HttpServletResponse response) throws IOException
	{
		setTextPlain(response);
		response.getWriter().write("{success:false}");
	}
	
	/**
	 * @param response 执行丄调用ajax动作失败后输出一个success等于�为false的json对象
	 * @param message 具体的执行结果信息
	 * @throws IOException 输出异常结果
	 */
	public static void ajaxFail(HttpServletResponse response,String message) throws IOException
	{
		setTextPlain(response);
		response.getWriter().write("{success:false,msg:"+message+"}");
	}
	
	public static String  getParaValue(Object key)
	{
		String[] values=getParaValues(key);
		return values!=null&&values.length>0?values[0]:"";		
	}
	
	public static String[] getParaValues(Object key)
	{
		Object value = ActionContext.getContext().getParameters().get(key);
		if (value instanceof String) {
			return new String[] { value.toString() };
		}
		if (value instanceof String[]) {
			return (String[]) value;
		}
		if (value instanceof Object[]) {
			Object[] value2 = (Object[]) value;
			List<String> result = new ArrayList<String>();
			for (Object each : value2) {
				result.add(each.toString());
			}
			return (String[]) result.toArray();
		}
		return null;
	}
	
	
	
	
	
	public  void renderExcel(HSSFWorkbook wb,String title,HttpServletResponse response) throws IOException
	{
		if(wb!=null)
		{
			//response.setHeader("Content-disposition","attachment; filename="+java.net.URLEncoder.encode(title)+".xls");
			response.setHeader("Content-disposition","attachment; filename="+(new String(title.getBytes("gb2312"), "ISO8859-1"))+".xls");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			OutputStream out = response.getOutputStream();
			wb.write(out);
	        out.flush();
	        out.close();
		}
	}

	/**
	 * 增加一个对象的实体的初始化
	 * @param entity
	 */
	public static void initAdd(HttpServletRequest req,Object entity)
	{
		try
		{
		BaseEntity tmp=(BaseEntity)entity;
			String createIp = getUserIp(req);
			Person user = getLoginPerson(req);
			tmp.setCreateIp(createIp);
			if(user!=null){
				tmp.setCreator(user.getFullName());
			}else{
				tmp.setCreator("notlogin");	
			}
		}
		catch(Exception ex)
		{
			log.info("对象不是基本的实体类型，所以出错");
			log.info(ex);
		}
		
	}
	
	/**
	 * struts2获取登陆用户的ip
	 * @return
	 */
	public static String getUserIp(HttpServletRequest request)
	{
		return request.getRemoteAddr();
	}
	
	
	
	
	
	/**
	 * @return 获取登陆用户
	 */
	public static Person getLoginPerson(HttpServletRequest res)
	{
		try
		{
		if(res==null)
		{
			return null;
		}
		HttpSession session=res.getSession();
		if(session==null)
		{
			return null;
		}
		Object obj=session.getAttribute(Login_User_Constant);
		if(obj!=null)
			return (Person)obj;
		else
			return null;
		}
		catch(Exception ex)
		{
			return null;
		}
	   //return null;
	}
	
	/**
	 * @param user 设置登陆用户
	 */
	public static void setLoginPerson(HttpServletRequest req,Person person)
	{
		req.getSession().setAttribute(Login_User_Constant, person);
	}
	
	public static HttpSession getHttpSession(HttpServletRequest req)
	{
		return req.getSession();
	}
	
	/**
	 * 修改实体的初始化
	 * @param entity
	 */
	public static void initEdit(HttpServletRequest req,Object entity)
	{
		try
		{
			BaseEntity tmp=(BaseEntity)entity;
			String createIp = getUserIp(req);
			Person person = getLoginPerson(req);
			
			tmp.setModifyIp(createIp);
			tmp.setModifyTime(new Date());
			if(person!=null){
				tmp.setModifier(person.getFullName());
			}else{
				tmp.setModifier("notlogin");	
			}
		}
		catch(Exception ex)
		{
			log.info("对象不是基本的实体类型，所以出错");
			log.info(ex);
		}
		
	}
	
	
	
}
