package com.ett.drv.web.action.admin;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.opensymphony.xwork2.ModelDriven;
import com.ett.drv.biz.IAdminBiz;
import com.ett.drv.model.admin.MenuModel;
import com.ett.drv.model.admin.RoleModel;
import com.ett.drv.model.admin.UserModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;
import com.smartken.kia.core.enums.DataFormatEnum;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.pager.PageBounds;
import com.ett.drv.web.action.BaseDrvAction;

public class MenuAction extends BaseDrvAction 
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
			re = this.adminBiz.modifyModel(menu).getRe();
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
             int re=this.adminBiz.removeModelInPk(lListIds).getRe();
             writeHTML("xxxx"+re+"ssss");
             //return NONE;
		}else if(req.getMethod().equalsIgnoreCase(METHOD_POST))
		{
	    	lListIds.add(menu.getMenuid());
	    	this.adminBiz.removeModelInPk(lListIds);
	    	//return INPUT;
		} 
		}catch(Exception e)
		{
		  e.printStackTrace();	
		}finally{return ;}
	}




	
	
	public void tree_menu() throws Exception{
		UserModel userModel= this.getAuthUser();
		RoleModel roleModel=userModel.getRoleModel();
		String strRole=roleModel.getCRolestring();
		List<String> listPk=StringUtil.splitToList(strRole, ";");
		adminBiz.loadCrudMapper(MenuModel.class);
		List<MenuModel> lListMenu=adminBiz.getModelInPk(listPk);
		JSONArray lJsonMenu=this.loadTreeNode(lListMenu,null);
		this.writeHTML(lJsonMenu.toString());

	}
	
	
	public void comboTree_menu() throws Exception{
		ArrayList lListIds=StringUtil.toList(menu.getMenuid().toString());
		adminBiz.loadCrudMapper(MenuModel.class);
	    List<MenuModel> lListMenu =adminBiz.getModelNotInPk(lListIds);
	    JSONArray lJsonMenu=this.loadTreeNode(lListMenu,null);
	    this.writePlainText(lJsonMenu.toString());
	}



	
	public void datagrid_menu() throws Exception {
		// TODO Auto-generated method stub
		PageBounds pb=this.getPager();
		adminBiz.loadCrudMapper(MenuModel.class);
		List listMenu=adminBiz.getModel(pb);
		//System.out.println("list:"+lArrJson.toString());
		JSONArray jarrMenu=ObjectUtil.toJsonArray(listMenu);
		 JSONObject lJsonDg=EasyUiUtil.toJsonDataGrid(jarrMenu,adminBiz.count());
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
	
	
	
	
	private JSONArray loadTreeNode(List<MenuModel> pArrTreeNode,Integer pParentId) 
	{
		JSONArray lArrJson=new JSONArray();
		try
		{
		for (MenuModel mtn : pArrTreeNode) {
			if(ObjectUtil.isEquals(pParentId, mtn.getParentid()))
			{
				JSONObject json=new JSONObject();
				JSONObject jsonAttrs=new JSONObject();
				jsonAttrs.put("url", mtn.getJavaUrl());
				json.put(EasyUiUtil.JSON_TREE_ID, mtn.getMenuid());
				json.put(EasyUiUtil.JSON_TREE_TEXT, mtn.getMenutext());
				json.put(EasyUiUtil.JSON_TREE_CHILDREN, loadTreeNode(pArrTreeNode,mtn.getMenuid()));
				json.put(EasyUiUtil.JSON_TREE_ICONCLS, mtn.getIconCls());
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
		int re=adminBiz.addModel(menu).getRe();
		return ResultEnum.jsp.name();
	}

}
