package com.ett.drv.web.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.ett.self.BaseSelfAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.ett.drv.biz.IAdminBiz;
import com.ett.drv.biz.IBookedBiz;
import com.ett.drv.biz.ISelfBiz;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.web.filter.AuthFilter;
import com.smartken.kia.core.enums.DataFormatEnum;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.model.IBaseAction;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.util.ObjectUtil;



public abstract class BaseAction extends ActionSupport 
implements Preparable,IBaseAction
{

	private String dataFormat;
    private Integer page;
    private Integer rows;
    protected int count;

	
    protected ISelfBiz selfBiz;
    protected IAdminBiz adminBiz;
    protected IBookedBiz bookedBiz;
    

	public abstract void clear();
	
	public String to_index() throws Exception
	{
	    
		return ResultEnum.jsp.name();
	    
	}
	
	public UserModel getAuthUser(){
		UserModel userModel=(UserModel) this.getSessionAttribute(AuthFilter.AUTH_USER);
		return userModel;
	}
	
	protected void writeHTML(String lStrHTML)
	{
		HttpServletResponse res=this.getResponse();
		res.setContentType("text/html; charset=UTF-8");
		try {
			res.getWriter().write(lStrHTML);
			res.getWriter().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writePlainText(String lStrText)
	{
		try {
				HttpServletResponse res=this.getResponse();
				res.setContentType("text/plain; charset=UTF-8");
				PrintWriter pw=res.getWriter();
				pw.write(lStrText);
				pw.flush();
				pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeScript(String lStrScript)
	{
		HttpServletResponse res=this.getResponse();
		res.setContentType("text/html; charset=UTF-8");
		try {
			res.getWriter().println("<script type='text/javascript'>"+lStrScript+"</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	public void setPage(Integer page) {
		
		this.page = ObjectUtil.formatInt(page,PageBounds.NO_ROW_OFFSET);
	}
	public void setRows(Integer rows) {
		this.rows = ObjectUtil.formatInt(rows,PageBounds.NO_ROW_LIMIT);
	}
	
	

	public String getDataFormat() {
		// TODO Auto-generated method stub
		return this.dataFormat;
	}

	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	public Integer getRows() {
		// TODO Auto-generated method stub
		return this.rows;
	}

	public PageBounds getPager(){
		PageBounds pb=new PageBounds(this.page==null?PageBounds.NO_ROW_OFFSET:(this.page-1)*this.rows,
				                     this.rows==null?PageBounds.NO_ROW_LIMIT:this.rows);
		return pb;
	}

	public void setDataFormat(String format) {
		// TODO Auto-generated method stub
		this.dataFormat = ObjectUtil.formatString(dataFormat,DataFormatEnum.json.toString());
	}
	
	public HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse()
	{
		return ServletActionContext.getResponse();
	}
	
	public String getParameter(Enum en) {
		// TODO Auto-generated method stub
		return getParameter(en.name());
	}
	
	
	public String getParameter(String key) {
		// TODO Auto-generated method stub
		return ObjectUtil.formatString(this.getRequest().getParameter(key));
	}

	public Object getRequestAttribute(Enum en) {
		// TODO Auto-generated method stub
		return this.getRequestAttribute(en.name());
	}

	public Object getRequestAttribute(String key) {
		// TODO Auto-generated method stub
		return this.getRequest().getAttribute(key);
	}

	public HttpSession getSession() {
		// TODO Auto-generated method stub
		return this.getRequest().getSession();
	}

	public Object getSessionAttribute(Enum en) {
		// TODO Auto-generated method stub
		return this.getSessionAttribute(en.name());
	}

	public Object getSessionAttribute(String key) {
		// TODO Auto-generated method stub
		return this.getSession().getAttribute(key);
	}
	
	

	public void setSelfBiz(ISelfBiz selfBiz) {
		this.selfBiz = selfBiz;
	}

	public void setAdminBiz(IAdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}

	public void setBookedBiz(IBookedBiz bookedBiz) {
		this.bookedBiz = bookedBiz;
	}

	public boolean isGet() {
		// TODO Auto-generated method stub
		return IBaseAction.METHOD_GET.equalsIgnoreCase(this.getRequest().getMethod());
	}

	public boolean isPost() {
		// TODO Auto-generated method stub
		return IBaseAction.METHOD_POST.equalsIgnoreCase(this.getRequest().getMethod());
	}

	public void setRequestAttribute(Enum en, Object obj) {
		// TODO Auto-generated method stub
		this.setRequestAttribute(en.name(), obj);
	}

	public void setRequestAttribute(String key, Object obj) {
		// TODO Auto-generated method stub
		 this.getRequest().setAttribute(key, obj);
	}

	public void setSessionAttribute(Enum en, Object obj) {
		// TODO Auto-generated method stub
		this.setSessionAttribute(en.name(), obj);
	}

	public void setSessionAttribute(String key, Object obj) {
		// TODO Auto-generated method stub
		this.getSession().setAttribute(key, obj);
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void writeStream(byte[] bytes) {
		// TODO Auto-generated method stub
		try {
			OutputStream os= this.getResponse().getOutputStream();
			os.write(bytes);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
