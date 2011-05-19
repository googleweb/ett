package com.ett.drv.web.action.admin;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.opensymphony.xwork2.ModelDriven;
import com.ett.drv.biz.IAdminBiz;
import com.ett.drv.model.admin.MenuModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;
import com.smartken.kia.core.enums.DataFormatEnum;
import com.smartken.kia.core.enums.QueryEnum;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.pager.PageBounds;
import com.ett.drv.web.action.BaseAction;

public class MenuAction extends BaseAction 
 implements ModelDriven<MenuModel>{

	private String menuid;
	private String menuids;
	private MenuModel menu;
	
   
	
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}


	public void setMenuids(String menuids) {
		this.menuids = menuids;
	}





	
	

	public MenuModel getModel() {
		// TODO Auto-generated method stub
		//String lStrId=ObjectHelper.formatString(_req.getParameter("id"));
        return menu;
	}


	public void setMenu(MenuModel menu) {
		this.menu = menu;
	}


	public void fn_modify() {
		// TODO Auto-generated method stub
		System.out.println("save:"+menu.toJson());
		int re=0;
		try {
			re = this.adminBiz.modifyModel(menu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeHTML(re+"xxxx");
		//return NONE;
	}


	public void fn_remove() {
		// TODO Auto-generated method stub
		HttpServletRequest req=this.getRequest();
		ArrayList lListIds=new ArrayList();
		try{
	    if(menuids!=null&&req.getMethod().equalsIgnoreCase(METHOD_GET))
		{
             lListIds=StringUtil.splitToList(menuids,",");
             int re=this.adminBiz.removeModelInPk(lListIds);
             writeHTML("xxxx"+re+"ssss");
             //return NONE;
		}else if(req.getMethod().equalsIgnoreCase(METHOD_POST))
		{
	    	lListIds.add(menu.getId());
	    	this.adminBiz.removeModelInPk(lListIds);
	    	//return INPUT;
		} 
		}catch(Exception e)
		{
		  e.printStackTrace();	
		}finally{return ;}
	}

	public void fn_search() {
		// TODO Auto-generated method stub
		//JSONArray lArrJson=iadminBiz.getMenuDataGrid();
		//System.out.println(iadminBiz.getMenuDataGrid().toString());
		//this.writeHTML(EasyUIHelper.toJsonDataGrid(iadminBiz.getMenuDataGrid()).toString());
		return ;
	}




	
	
	public void list_Tree() throws Exception{
		ArrayList lListToken=StringUtil.toList("root");
		adminBiz.loadCrudMapper(MenuModel.class);
		ArrayList<MenuModel> lListMenu=adminBiz.getModelNotInPk(lListToken);
		JSONArray lJsonMenu=this.loadTreeNode(lListMenu,"root");
		this.writeHTML(lJsonMenu.toString());

	}
	
	
	public void list_ComboTree() throws Exception{
		ArrayList lListIds=StringUtil.toList((String) menu.getId());
		adminBiz.loadCrudMapper(MenuModel.class);
	    ArrayList<MenuModel> lListMenu =adminBiz.getModelNotInPk(lListIds);
	    JSONArray lJsonMenu=this.loadTreeNode(lListMenu,null);
	    this.writePlainText(lJsonMenu.toString());
	}



	
	public void list_DataGrid() throws Exception {
		// TODO Auto-generated method stub
		PageBounds pb=this.getPager();
		adminBiz.loadCrudMapper(MenuModel.class);
		PageArrayList listMenu=adminBiz.getModelNotInPk(StringUtil.toList("root"),pb);
		//System.out.println("list:"+lArrJson.toString());
		JSONArray jarrMenu=ObjectUtil.toJsonArray(listMenu);
		 JSONObject lJsonDg=EasyUiUtil.toJsonDataGrid(jarrMenu,listMenu.getCount());
		if(ObjectUtil.isEquals(this.getDataFormat(), DataFormatEnum.json.toString()))
		{
		  this.writeHTML(lJsonDg.toString());

		}else if(ObjectUtil.isEquals(this.getDataFormat(), DataFormatEnum.json.toString()))
		{
		
		}else {
			 
			this.writeHTML(lJsonDg.toString());
		}

	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest req=this.getRequest();
		adminBiz.loadCrudMapper(MenuModel.class);
		if(req.getMethod().equalsIgnoreCase(METHOD_POST))
			return;
		String lStrId=ObjectUtil.formatString(this.menuid);
		if(lStrId.length()>0)
		{
			MenuModel m=(MenuModel) adminBiz.getModelEqPk(this.menuid);
		    this.menu=ObjectUtil.isEmpty(m)?new MenuModel():m;
		
		}else
		{
			this.clear();
		}
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.menu=new MenuModel();
		this.menuid="";
		this.menuids="";
	}
	
	
	
	
	private JSONArray loadTreeNode(ArrayList<MenuModel> pArrTreeNode,String pParentId) 
	{
		JSONArray lArrJson=new JSONArray();
		try
		{
		for (MenuModel mtn : pArrTreeNode) {
			if(ObjectUtil.isEquals(pParentId, mtn.getParentId()))
			{
				JSONObject json=new JSONObject();
				JSONObject jsonAttrs=new JSONObject();
				jsonAttrs.put("url", mtn.getUrl());
				json.put(EasyUiUtil.JSON_TREE_ID, mtn.getId());
				json.put(EasyUiUtil.JSON_TREE_TEXT, mtn.getName());
				json.put(EasyUiUtil.JSON_TREE_CHILDREN, loadTreeNode(pArrTreeNode, (String) mtn.getId()));
				json.put(EasyUiUtil.JSON_TREE_ICONCLS, mtn.getIcon());
	            json.put(EasyUiUtil.JSON_TREE_ATTRIBUTES, jsonAttrs);
				//json.put(EASYUI_TREE_IMAGE, mtn.getName());
				lArrJson.put(json);
			}
		}
		}catch(JSONException je)
		{}
		return lArrJson;
	}
	




	
	public String to_edit() throws Exception {
		// TODO Auto-generated method stub
		return ResultEnum.jsp.name();
	}
	
	public String to_add() throws Exception {
		// TODO Auto-generated method stub
		return ResultEnum.jsp.name();
	}


	public String fn_add() throws Exception {
		// TODO Auto-generated method stub
		int re=adminBiz.addModel(menu);
		return ResultEnum.jsp.name();
	}

}
