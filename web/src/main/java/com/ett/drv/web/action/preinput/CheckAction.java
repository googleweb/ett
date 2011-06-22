package com.ett.drv.web.action.preinput;

import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.util.ObjectUtil;

public class CheckAction extends BaseDrvAction implements ModelDriven<StudentApplyInfoModel>{
	
	private StudentApplyInfoModel studentApplyInfoModel;

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public String to_detail(){
	    return "jsp";
	}

	public StudentApplyInfoModel getModel() {
		// TODO Auto-generated method stub
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

}
