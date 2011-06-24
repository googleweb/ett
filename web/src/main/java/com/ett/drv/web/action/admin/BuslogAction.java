package com.ett.drv.web.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.ett.drv.model.admin.BusLogModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.FileUtil;

public class BuslogAction extends BaseDrvAction {

    private	File[] files;
	private String[] filesFileName;
	private String[] filesContentType;

	
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}
	
	
	public void datagrid_buslog(){
		Date dateStartRegDate=this.getParameterDate("qStartRegDate",null);
		Date dateEndRegDate=this.getParameterDate("qEndRegDate",null);
		String operator=this.getParameter("qOperator");
		
		BusLogModel qModel=new BusLogModel();
		qModel.setqStartRegDate(dateStartRegDate);
		qModel.setqEndRegDate(dateEndRegDate);
		qModel.setCOperator(null);
		
		this.adminBiz.loadCrudMapper(BusLogModel.class);
		PageArrayList listLog=this.adminBiz.getModel(qModel,this.getPager());
		JSONObject datagrid=EasyUiUtil.toJsonDataGrid(listLog,listLog.getCount());
		this.writePlainText(datagrid.toString());
	}

	public String to_count(){
		return ResultEnum.jsp.name();
	}
	
	public void upload_file(){
	    try {
//	    	String tempPath = "C:\\upload\\tmp\\";
//	        ServletFileUpload sfu = new ServletFileUpload();
//	        sfu.setFileItemFactory(new DiskFileItemFactory());
//	        // 设置最大文件尺寸，这里是4MB
//	        //fu.setSizeMax(4194304);
//	        // 设置缓冲区大小，这里是4kb
//	        // 设置临时目录：
//	        // 得到所有的文件：
//	        HttpServletRequest req=this.getRequest();
//	        
//	        //RequestContext reqContext=new ServletRequestContext(this.getRequest());
//	        List fileItems = sfu.parseRequest(req);
//	        Iterator i = fileItems.iterator();
//	        // 依次处理每一个文件：
//	        while(i.hasNext()) {
//	            FileItem fi = (FileItem)i.next();
//	            // 获得文件名，这个文件名包括路径：
//	            String fileName = fi.getName();
//
//	        }
	        ServletContext servletContext = ServletActionContext.getServletContext();
	        String dataDir = ("c:/temp.f");
	        System.out.println(dataDir);
	        for (int i = 0; i < files.length; i++) {
	              File saveFile = new File(dataDir);
	              if(!saveFile.exists()){
	            	  saveFile.createNewFile();
	              }else {
	            	  saveFile.delete();
	              }
	    
	              files[i].renameTo(saveFile);
	            
	              
	        }
	        

	    }
	    catch(Exception e) {
	        // 可以跳转出错页面
	    	e.printStackTrace();
	    }
	}


	public File[] getFiles() {
		return files;
	}


	public void setFiles(File[] files) {
		this.files = files;
	}


	public String[] getFilesFileName() {
		return filesFileName;
	}


	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}


	public String[] getFilesContentType() {
		return filesContentType;
	}


	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}
	
	
	
}
