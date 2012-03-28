package com.ett.visual.action;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ett.visual.biz.IAdminBiz;
import com.ett.visual.biz.IDriverBiz;
import com.ett.visual.biz.IVehicleBiz;
import com.ett.visual.model.admin.DictTypeModel;
import com.ett.visual.model.admin.RoleModel;
import com.ett.visual.model.driver.DriverFileModel;


import com.smartken.toyz4j.model.IBaseModel;
import com.smartken.toyz4j.model.IToyzBiz;
import com.smartken.toyz4j.model.IToyzCrudBean;
import com.smartken.toyz4j.model.impl.BaseAction;

import com.smartken.toyz4j.model.impl.BaseModel;
import com.smartken.toyz4j.model.impl.ResultModel;
import com.smartken.toyz4j.pager.PageArrayList;
import com.smartken.toyz4j.pager.PageList;
import com.smartken.toyz4j.util.EasyUiUtil;
import com.smartken.toyz4j.util.ObjectUtil;
import com.smartken.toyz4j.util.StringUtil;

public abstract class BaseVisualAction<M extends IBaseModel> extends BaseAction<M> {
      
	
	protected IAdminBiz adminBiz;
	protected IDriverBiz driverBiz;
	protected IVehicleBiz vehicleBiz;

	public void setAdminBiz(IAdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}
	
	
	
	public void setDriverBiz(IDriverBiz driverBiz) {
		this.driverBiz = driverBiz;
	}



	public void setVehicleBiz(IVehicleBiz vehicleBiz) {
		this.vehicleBiz = vehicleBiz;
	}



	public  static String importPageResourceContext(){
	
		HttpServletRequest request=ServletActionContext.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		     boolean isDebug=true;
		     String jsTagPattern="<script type=\"text/javascript\"  src=\""+basePath+"{0}\"></script> \n";
		     String jsContextPattern="<script type=\"text/javascript\" >{0}</script> \n";
		     String cssTagPatttern="<link rel=\"stylesheet\" type=\"text/css\" href=\""+basePath+"{0}\"> \n";
		     StringBuffer sbr=new StringBuffer("");
		     String pathPrefix="";

			 pathPrefix="/js3rd";
			 sbr.append(MessageFormat.format(cssTagPatttern, pathPrefix+"/jquery-easyui-1.2.5/themes/gray/easyui.css"));
			 sbr.append(MessageFormat.format(cssTagPatttern, pathPrefix+"/jquery-easyui-1.2.5/themes/icon.css"));
			 sbr.append(MessageFormat.format(cssTagPatttern, pathPrefix+"/jquery-jqzoom_ev-2.3/css/jquery.jqzoom.css"));
			 pathPrefix="/css";
			 sbr.append(MessageFormat.format(cssTagPatttern, pathPrefix+"/main.css"));
			 sbr.append(MessageFormat.format(cssTagPatttern, pathPrefix+"/toyz-icon.css"));
		     if(isDebug){

		    	 
		    	 pathPrefix="/js3rd";
		    	 sbr
		    	 .append(MessageFormat.format(jsTagPattern,pathPrefix+"/dateJs/date.js"))
		    	 .append(MessageFormat.format(jsTagPattern,pathPrefix+"/jquery/jquery-1.7.1.min.js"))
		    	 .append(MessageFormat.format(jsTagPattern,pathPrefix+"/jquery-pageload/jquery.pageload.js"))
		    	 .append(MessageFormat.format(jsTagPattern,pathPrefix+ "/jquery-easyui-1.2.5/jquery.easyui.min.js"))
		    	 .append(MessageFormat.format(jsTagPattern,pathPrefix+ "/jquery-easyui-1.2.5/locale/easyui-lang-zh_CN.js"))
		    	 .append(MessageFormat.format(jsTagPattern, pathPrefix+"/jquery-easyui-datagridview/datagrid-detailview.js"))
		    	 .append(MessageFormat.format(jsTagPattern,pathPrefix+ "/jquery-easyui-datagridview/datagrid-groupview.js"))
		    	 .append(MessageFormat.format(jsTagPattern,pathPrefix+ "/jquery-jqzoom_ev-2.3/js/jquery.jqzoom-core-pack.js"))
		    	.append(MessageFormat.format(jsTagPattern,pathPrefix+ "/jquery.hotkeys-0.7.9/jquery.hotkeys.min.js"))
		    	//.append(MessageFormat.format(jsTagPattern,pathPrefix+ "/jquery.shortkey/jquery.shortkeys.js"))
		    	 ;
		    	 
		    	 pathPrefix="/js";
		    	 sbr
		    	 .append(MessageFormat.format(jsContextPattern,getToyz4jsCfg().toScirpt()))
		    	 .append(MessageFormat.format(jsTagPattern,pathPrefix+"/Toyz4js.core.js"))
		    	 //.append(MessageFormat.format(jsTagPattern, pathPrefix+"/Toyz4js.cfg.js"))
		    	 .append(MessageFormat.format(jsTagPattern, pathPrefix+"/Toyz4js.prototype.Array.js"))
		    	 .append(MessageFormat.format(jsTagPattern, pathPrefix+"/Toyz4js.prototype.String.js"))
		    	 .append(MessageFormat.format(jsTagPattern, pathPrefix+"/Toyz4js.extends.jquery.js"))
		    	 .append(MessageFormat.format(jsTagPattern, pathPrefix+"/Toyz4js.extends.easyui.js"))
		    	 .append(MessageFormat.format(jsTagPattern, pathPrefix+"/Toyz4js.plugin.CrudDatagrid.js"))
		    	 ;
		     }else{
		    	 
		    	 pathPrefix="/js3rd";
		    	 sbr
		    	 .append(MessageFormat.format(jsTagPattern,pathPrefix+"/js3rd.package.js"));
		    	 
		    	 pathPrefix="/js";
		    	 sbr
		    	 .append(MessageFormat.format(jsContextPattern,getToyz4jsCfg().toScirpt()))
		    	 .append(MessageFormat.format(jsTagPattern,pathPrefix+"/Toyz4js.package.min.js"));
		    	 
		     }
		     return sbr.toString();
	}



	public IToyzCrudBean<M> getToyzCurdBean() throws NullPointerException {
		// TODO Auto-generated method stub
		return adminBiz.newToyzCrudBean(this.getModelClass());
	}



	


   

	
   
    
    
	
}
