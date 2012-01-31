<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.io.PrintWriter"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
    
<%!
   String getScriptTag(String pStrSrcPath)
   {
     return "<script type='text/javascript' language='javascript' src='"+pStrSrcPath+"'></script>\n";
     
   }
   
   String getCssLinkTag(String pStrHrefPath)
   {
    return "<link rel='stylesheet' type='text/css'  href='"+pStrHrefPath+"' /> \n";
   }
   
   boolean isExist(String[] pArrPlugs,String pStrPlug)
   {
      if(pArrPlugs.length<1||pStrPlug==null)return false;
      for(int i=0;i<pArrPlugs.length;i++)
      {
        if(pArrPlugs[i].equalsIgnoreCase(pStrPlug))
         return true;
      }
      return false;  
    }
 %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/plugin";

     String lStrPlugins=request.getParameter("plugin")==null?"":request.getParameter("plugin").toString();
     String mode="dev";
     String[] lArrPlugins=URLDecoder.decode(lStrPlugins).split(",");
     PrintWriter _PW= response.getWriter();
     StringBuffer lSbrScript=new StringBuffer("");
     String lStrPlugFloder="";
    
     if(mode.equals("dev")){
      lStrPlugFloder=basePath+"/jquery";
      lSbrScript.append(getScriptTag(lStrPlugFloder+"/jquery-1.6.2.min.js"));
      
      lStrPlugFloder=basePath+"/jquery-pageload";
      lSbrScript.append(getScriptTag(lStrPlugFloder+"/jquery.pageload.js"));
         
      lStrPlugFloder=basePath+"/jquery-easyui-1.2.5"; 
      lSbrScript.append(getScriptTag(lStrPlugFloder+"/jquery.easyui.min.js"));
      
      lSbrScript.append(getScriptTag(basePath+"/jquery-easyui-datagridview/datagrid-defaultview.js"))
         .append(getScriptTag(basePath+"/jquery-easyui-datagridview/datagrid-groupview.js"))
    	 .append(getScriptTag(basePath+"/jquery-easyui-datagridview/datagrid-detailview.js"))
      ;
     }else{
    	 lSbrScript.append(getScriptTag(basePath+"/package.js"));
     }
     
     lStrPlugFloder=basePath+"/jquery-easyui-1.2.4"; 
     lSbrScript
	 .append(getCssLinkTag(lStrPlugFloder+"/themes/default/easyui.css"))
	 .append(getCssLinkTag(lStrPlugFloder+"/themes/icon.css"))
	 ;
     
     
        _PW.write(lSbrScript.toString());

%>


