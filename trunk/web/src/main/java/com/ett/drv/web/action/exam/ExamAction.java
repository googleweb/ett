package com.ett.drv.web.action.exam;

import java.util.List;

import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.ett.drv.web.action.BaseDrvAction;

public class ExamAction extends BaseDrvAction{
	private String cartype;
	private String idcard;
	
	
	
	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String to_exam(){
		return "jsp";
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public void check_idcard(){
		String data=this.idcard;
		this.preBiz.loadCrudMapper(StudentApplyInfoModel.class);
		StudentApplyInfoModel queryidcard=new StudentApplyInfoModel();
		queryidcard.setSfzmhm(data);
		List list=this.preBiz.getView(queryidcard);
		if(list.size()==0){
			this.writePlainText("0");	
		}
		else{
			this.writePlainText("1");
		}
		
		
	}
	
	public String to_topic(){
		this.setRequestAttribute(cartype, cartype);
		return "jsp";
	}
	

}
