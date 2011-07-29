package com.ett.drv.web.action.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ett.drv.model.exam.ExamTKcnModel;
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
		//this.preBiz.loadCrudMapper(ExamTKcnModel.class);
		//System.out.println(cartype);
		List<ExamTKcnModel> list=this.preBiz.getTopic("%"+cartype+"%");
		List<ExamTKcnModel> judge=new ArrayList<ExamTKcnModel>();
		List<ExamTKcnModel> choose=new ArrayList<ExamTKcnModel>();
		if(list.size()!=0){
		for(ExamTKcnModel m:list){
			if(m.getSttx().equals("1")){
				judge.add(m);
			}else if(m.getSttx().equals("2")){
				choose.add(m);
			}
		}
		int js=judge.size();
		int cs=choose.size();
		List<ExamTKcnModel> jtopic=new ArrayList<ExamTKcnModel>();
		for(int i=0;i<15;i++){
		//Random jrand=new Random(js);
		int r=(int)(Math.random()*js);
		jtopic.add(judge.get(r));
		judge.remove(r);
		js--;
		}
		List<ExamTKcnModel> ctopic=new ArrayList<ExamTKcnModel>();
		for(int i=0;i<85;i++){
		//Random jrand=new Random(cs);
		int r=(int)(Math.random()*cs);
		ctopic.add(choose.get(r));
		choose.remove(r);
		cs--;
		}
		//System.out.println(jtopic.size()+":"+ctopic.size());
		this.setRequestAttribute("judge", jtopic);
		this.setRequestAttribute("choose", ctopic);
		return "jsp";
	}
		else {
			this.setRequestAttribute("judge", new ArrayList<ExamTKcnModel>());
			this.setRequestAttribute("choose", new ArrayList<ExamTKcnModel>());
		return "jsp";
		}
	}
	

}
