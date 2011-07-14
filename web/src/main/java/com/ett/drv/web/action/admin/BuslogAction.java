package com.ett.drv.web.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ett.drv.model.admin.BusLogModel;
import com.ett.drv.model.admin.RoleModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.smartken.kia.core.enums.EResult;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.FileUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class BuslogAction extends BaseDrvAction {


	
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}
	
	
	public void datagrid_buslog(){
		Date dateStartRegDate=this.getParameterDate("qStartRegDate",null);
		Date dateEndRegDate=this.getParameterDate("qEndRegDate",null);
		String qOperator=this.getParameter("qOperator");
		if(StringUtil.isBlank(qOperator)){
			qOperator=null;
		}else{
			qOperator="%"+qOperator.trim()+"%";
		}
		BusLogModel qModel=new BusLogModel();
		qModel.setqStartRegDate(dateStartRegDate);
		qModel.setqEndRegDate(dateEndRegDate);
		qModel.setCOperator(qOperator);
		
		this.adminBiz.loadCrudMapper(BusLogModel.class);
		PageArrayList listLog=this.adminBiz.getModel(qModel,this.getPager());
		JSONObject datagrid=EasyUiUtil.toJsonDataGrid(listLog,listLog.getCount());
		this.writePlainText(datagrid.toString());
	}

	public String to_count(){
		return EResult.jsp.name();
	}
	
     
	public void datagrid_buslogCount(){
		Date dateStartRegDate=this.getParameterDate("qStartRegDate",null);
		Date dateEndRegDate=this.getParameterDate("qEndRegDate",null);
		String qOperator=this.getParameter("qOperator");
		if(StringUtil.isBlank(qOperator)){
			qOperator=null;
		}else{
			qOperator="%"+qOperator.trim()+"%";
		}
		BusLogModel qModel=new BusLogModel();
		qModel.setqStartRegDate(dateStartRegDate);
		qModel.setqEndRegDate(dateEndRegDate);
		qModel.setCOperator(qOperator);
		
		this.adminBiz.loadCrudMapper(BusLogModel.class);
		List<BusLogModel> listLog=this.adminBiz.getModel(qModel);
		Map<String,Integer> mapLogCount=new HashMap<String, Integer>();
		for(BusLogModel tempLog : listLog){
			String key=tempLog.getCOperator()+"::"+tempLog.getCBustype();
			Integer tempCount=ObjectUtil.formatInt(mapLogCount.get(key));
			mapLogCount.put(key, ++tempCount);
		}
		JSONArray jarrLogsCount=new JSONArray();
		for(Iterator<String> it=mapLogCount.keySet().iterator();it.hasNext();){
			 String key=it.next();
			 String[] vals=key.split("::");
			 String operator=vals[0];
			 String bustype=vals[1];
			 JSONObject jsonLogsCount=new JSONObject();
			 try {
				jsonLogsCount.put(BusLogModel.F.COperator.name(), operator);
				jsonLogsCount.put(BusLogModel.F.CBustype.name(), bustype);
				jsonLogsCount.put("count", mapLogCount.get(key));
				jarrLogsCount.put(jsonLogsCount);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		
		this.writePlainText(jarrLogsCount.toString());
	}
	
	
	public void combobox_roles(){
		this.adminBiz.loadCrudMapper(RoleModel.class);
		List<String> listFields=new ArrayList<String>();
		//listFields.add(UserModel.F.Id.name());
		listFields.add(RoleModel.F.CName.name());
		List listUser=this.adminBiz.getModel();
		JSONArray jarrUsers=ObjectUtil.toJsonArray(listUser);
		this.writePlainText(jarrUsers.toString());
	}

}
