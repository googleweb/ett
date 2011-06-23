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
	public void stream_photo(){
		byte[] bs=studentApplyInfoModel.getBlobPhoto();
		if(bs!=null){
			this.writeStream(bs);
		}
				
  }
}
