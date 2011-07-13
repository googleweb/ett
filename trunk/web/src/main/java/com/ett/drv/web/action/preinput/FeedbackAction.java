package com.ett.drv.web.action.preinput;

import org.json.JSONObject;

import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class FeedbackAction extends BaseDrvAction implements ModelDriven<StudentApplyInfoModel>{
	private StudentApplyInfoModel studentApplyInfoModel;


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	public void datagrid_list(){
		//查处所以User，输出json格式的datagrid    User/datagrid/users.action
		String qIDCard=this.getParameter("qIDCard");
		if(StringUtil.isBlank(qIDCard)){
			qIDCard="0";//不显示任何数据
			//qIDCard=null;//显示所有数据
		}else{
			qIDCard=qIDCard.trim();
		}
		StudentApplyInfoModel qModel=new StudentApplyInfoModel();
		qModel.setSfzmhm(qIDCard);
		
		this.preBiz.loadCrudMapper(StudentApplyInfoModel.class);
		PageArrayList list=this.preBiz.getModel(qModel,this.getPager());
		for(Object obj :list){
		     ((StudentApplyInfoModel)obj).setBlobPhoto(null);
		}
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,list.getCount());
		this.writePlainText(jsonDG.toString());		
	}
	public StudentApplyInfoModel getModel() {
		
		if(isGet()){
			int id=ObjectUtil.formatInt(this.getParameter("id"),-1);
			if(id==0)
			{
				studentApplyInfoModel=new StudentApplyInfoModel();
			}
			else if(id!=-1){
				
				this.preBiz.loadCrudMapper(StudentApplyInfoModel.class);
				studentApplyInfoModel=(StudentApplyInfoModel) this.preBiz.getModelEqPk(id);
			}
		}else if(isPost()){
			
		}
		return studentApplyInfoModel;
	
	

   }
}
