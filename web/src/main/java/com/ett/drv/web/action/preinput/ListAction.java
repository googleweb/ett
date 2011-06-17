package com.ett.drv.web.action.preinput;

import java.util.List;

import org.json.JSONObject;


import com.ett.drv.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.model.preinput.*;

public class ListAction extends BaseAction implements ModelDriven<StudentApplyInfoModel>{
	
	private StudentApplyInfoModel studentApplyInfoModel;
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public String to_detail(){
	    return "jsp";
	}

	public StudentApplyInfoModel getModel() {
	
			if(isGet()){
				int id=ObjectUtil.formatInt(this.getParameter("id"));
				if(id==0)
				{
					studentApplyInfoModel=new StudentApplyInfoModel();
				}else{
					this.preBiz.loadCrudMapper(StudentApplyInfoModel.class);
					studentApplyInfoModel=(StudentApplyInfoModel) this.preBiz.getModelEqPk(id);
				}
			}
			return studentApplyInfoModel;
		
		
	}
	
	public void datagrid_list(){
		//查处所以User，输出json格式的datagrid    User/datagrid/users.action
		this.preBiz.loadCrudMapper(StudentApplyInfoModel.class);
		List<IFormatterModel> list=this.preBiz.getModel(this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,this.preBiz.count());
		this.writePlainText(jsonDG.toString());		
	}

}
