package com.ett.drv.web.action.preinput;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.json.JSONArray;
import org.json.JSONObject;


import com.ett.drv.web.action.BaseDrvAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.FileUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;
import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.model.preinput.*;

public class ListAction extends BaseDrvAction implements ModelDriven<StudentApplyInfoModel>{
	
	private StudentApplyInfoModel studentApplyInfoModel;

	private File photo;
	
	

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

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
	
	public void datagrid_list(){
		//查处所以User，输出json格式的datagrid    User/datagrid/users.action
		String qIDCard=this.getParameter("qIDCard");
		if(StringUtil.isBlank(qIDCard)){
			qIDCard=null;
		}else{
			qIDCard=qIDCard.trim();
		}
		StudentApplyInfoModel qModel=new StudentApplyInfoModel();
		qModel.setSfzmhm(qIDCard);
		
		this.preBiz.loadCrudMapper(StudentApplyInfoModel.class);
		PageArrayList list=this.preBiz.getModel(qModel,this.getPager());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list,list.getCount());
		this.writePlainText(jsonDG.toString());		
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
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
				pattern="预录入管理:{0}保存成功,再添加一个用户？";
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
	
	public void do_check(){
		int re=0;
		if(this.isPost()){
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
	
	public void combobox_check(){
		List listcheckstatus=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			listcheckstatus=this.adminBiz.listcheck(); 
			jarr=ObjectUtil.toJsonArray(listcheckstatus);
		}catch(Exception e){e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	
	public void combobox_sfzm(){
		List listdetail=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			listdetail=this.adminBiz.listDetail();
			jarr=ObjectUtil.toJsonArray(listdetail);
		}catch (Exception e) {e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	
	public void combobox_gj(){
		List l=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			l=this.adminBiz.listgj();
			jarr=ObjectUtil.toJsonArray(l);
		}catch(Exception e){e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	
	public void combobox_xb(){
		List l=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			l=this.adminBiz.listxb();
			jarr=ObjectUtil.toJsonArray(l);
		}catch(Exception e){e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	
	public void combobox_djzs(){
		List l=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			l=this.adminBiz.listdjzs();
			jarr=ObjectUtil.toJsonArray(l);
		}catch(Exception e){e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	
	public void combobox_cartype(){
		List l=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			l=this.adminBiz.listcartype();
			jarr=ObjectUtil.toJsonArray(l);
		}catch(Exception e){e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	
	public void combobox_driverfrom(){
		List l=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			l=this.adminBiz.listdriverfrom();
			jarr=ObjectUtil.toJsonArray(l);
		}catch(Exception e){e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	
	public void combobox_ifok(){
		List l=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			l=this.adminBiz.listifok();
			jarr=ObjectUtil.toJsonArray(l);
		}catch(Exception e){e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	
	public void combobox_hospital(){
		List l=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			l=this.adminBiz.listhospital();
			jarr=ObjectUtil.toJsonArray(l);
		}catch(Exception e){e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	
	public void do_delete(){
    	//根据id删除User，，并输出json格式的保存结果
    	ArrayList lListIds=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
	    if(ids!=null)
		{
             lListIds=StringUtil.splitToList(ids,",");
             this.adminBiz.loadCrudMapper(StudentApplyInfoModel.class);
             re+=this.adminBiz.removeModelInPk(lListIds).getRe();
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			//resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg("成功删除{0}个",re);
	
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有字典被删除");
		}
		this.writePlainText(resultModel.toJson().toString());   	
    }
	
	public void do_buntchcheck(){
		ArrayList a=new ArrayList();
		String ids=this.getParameter("ids");
		int re=0;
		if(ids!=null)
		{
             a=StringUtil.splitToList(ids,",");
             this.preBiz.loadCrudMapper(StudentApplyInfoModel.class);
             ArrayList<StudentApplyInfoModel> b=new ArrayList<StudentApplyInfoModel>();
             b=(ArrayList<StudentApplyInfoModel>)this.preBiz.getModelInPk(a);
            if(b.size()>0){
            	for(int i=0;i<b.size();i++){
            	StudentApplyInfoModel c=b.get(i);
            	c.setIChecked(1);
            	re+=this.preBiz.modifyOrAddModel(c).getRe();
            	}
            }
            
		}
		ResultModel resultModel=new ResultModel();
		if(re>0){
			resultModel.setTitle("操作成功");
			//resultModel.setAction(ResultModel.ACTION_CONFIRM);
			resultModel.setMsg("成功审核{0}个",re);
	
		}else {
			resultModel.setAction(ResultModel.ACTION_ALERT);
			resultModel.setTitle("操作失败");
			resultModel.setMsg("没有字典被删除");
		}
		this.writePlainText(resultModel.toJson().toString());   	
	}
	
	public void to_search(){
		StudentApplyInfoModel query=new StudentApplyInfoModel();
		String idcardNo=this.getParameter("idcardNo");
		if(StringUtil.isNotBlank(idcardNo)){
			idcardNo="%"+idcardNo+"%";
			query.setSfzmhm(idcardNo);
		}
		String IChecked=this.getParameter("IChecked");
		if(StringUtil.isNotBlank(IChecked)&&(3!=Integer.valueOf(IChecked))){
			query.setIChecked(Integer.valueOf(IChecked));
		}
		
        this.preBiz.loadCrudMapper(StudentApplyInfoModel.class);
        List list=this.preBiz.getView(query,this.getPager());
    
		JSONObject jsonDg=EasyUiUtil.toJsonDataGrid(list);
		this.writePlainText(jsonDg.toString());
	
	}
	
	public void stream_photo(){
			byte[] bs=studentApplyInfoModel.getBlobPhoto();
			if(bs!=null){
				this.writeStream(bs);
			}
					
	}
	
	public void upload_photo(){

	 if(this.photo!=null){
		 try {
			byte[] bs=FileUtil.toBytes(photo);
			this.studentApplyInfoModel.setBlobPhoto(bs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
		
	}
	
	public String to_upload(){
		return "jsp";
	}

}
