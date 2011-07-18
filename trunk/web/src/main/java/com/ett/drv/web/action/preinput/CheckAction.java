package com.ett.drv.web.action.preinput;

import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.impl.ResultModel;
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
	public void do_check(){
		int re=0;
		if(this.isPost()){
		//	ResultModel resultmodel=this.preBiz.verify(studentApplyInfoModel,studentApplyInfoModel.getBlobPhoto());
			this.preBiz.loadCrudMapper(StudentApplyInfoModel.class);
			studentApplyInfoModel.setIChecked(1);
			re+=this.preBiz.modifyOrAddModel(studentApplyInfoModel).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			if(studentApplyInfoModel.getId()==null){
				pattern="预录入管理:{0}保存成功,再添加一个用户？";
				resultModel.setAction(ResultModel.ACTION_CONFIRM);
				//hardware=new HardwareModel();
			}else {
				pattern="预录入管理:{0}审核成功";
			}
			resultModel.setMsg(pattern,re);;
			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	public void  do_save(){
		int re=0;
		
		if(this.isPost()){
			
			this.preBiz.loadCrudMapper(StudentApplyInfoModel.class);
			re+=this.preBiz.modifyOrAddModel(studentApplyInfoModel).getRe();
			
		}
		ResultModel resultModel=new ResultModel();
		if(re==1){
			resultModel.setTitle("操作成功");
			String pattern="";
			if(studentApplyInfoModel.getId()==null){
				pattern="预录入管理:{0}保存成功,再添加一个？";
				resultModel.setAction(ResultModel.ACTION_CONFIRM);
				//hardware=new HardwareModel();
			}else {
				pattern="预录入管理:{0}保存成功";
			}
			resultModel.setMsg(pattern,re);;
			
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	
}
