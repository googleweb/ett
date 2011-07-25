package com.ett.drv.web.action.physical;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.ett.common.util.DateUtil;
import com.ett.drv.model.admin.BusAllInfoModel;
import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.web.action.BaseDrvAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class HospitalMessageAction extends BaseDrvAction implements ModelDriven<BusAllInfoModel>{

	private static final long serialVersionUID = 1L;
	private BusAllInfoModel busAllInfoModel;
	
	public String to_process(){
	
		return  "jsp";
	}
	public String to_import() {
		/*if(isPost()){
			*//**
			 * 根据证件号等查询
			 *//*
			this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
			List list=this.hospitalBiz.getModel(busAllInfoModel);
			if(list!=null){
					this.getRequest().setAttribute("busAllInfoModel", list.get(0));
			}else{
				ResultModel resultModel=new ResultModel();
				resultModel.setMsg("没有符合条件的信息");
			}
		}*/
		//this.writePlainText(resultModell.)
		return "jsp";
	}
	public String to_checkRecord() {
		return "jsp";
	}
	public String to_logMessage() {
		return "jsp";
	}
	public String to_statistics() {
		return "jsp";
	}
	public String to_hospitalwork(){
		return  "jsp";
	}
	public BusAllInfoModel getModel() {
		busAllInfoModel=new BusAllInfoModel();
		return busAllInfoModel;
	}
	/**
	 * 增加体检受理
	 */
	public void do_add(){
		
		//先根据把数据从数据库中取出
			BusAllInfoModel busAllInfoModel2=new BusAllInfoModel();
			try{
				 this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
				 busAllInfoModel2=(BusAllInfoModel)this.hospitalBiz.getModel(busAllInfoModel).get(0);
			}catch(Exception e){
				e.printStackTrace();
			}
			busAllInfoModel2.setId(busAllInfoModel.getId());
			busAllInfoModel2.setCIdcardtype(busAllInfoModel.getCIdcardtype());
			busAllInfoModel2.setCIdcard(busAllInfoModel.getCIdcard());
			busAllInfoModel2.setCDabh(busAllInfoModel.getCDabh());
			busAllInfoModel2.setCXm(busAllInfoModel.getCXm());
			busAllInfoModel2.setCSex(busAllInfoModel.getCSex());
			busAllInfoModel2.setRegdate(busAllInfoModel.getRegdate());
			busAllInfoModel2.setCBirthday(busAllInfoModel.getCBirthday());
			busAllInfoModel2.setCNation(busAllInfoModel.getCNation());
			busAllInfoModel2.setCCarType(busAllInfoModel.getCCarType());
			busAllInfoModel2.setCRegareaCode(busAllInfoModel.getCRegareaCode());
			busAllInfoModel2.setCRegarea(busAllInfoModel.getCRegarea());
			busAllInfoModel2.setCPhone(busAllInfoModel.getCPhone());
			busAllInfoModel2.setCPostcode(busAllInfoModel.getCPostcode());
			busAllInfoModel2.setIState(1);
			this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
			ResultModel resultModel=this.hospitalBiz.modifyOrAddModel(busAllInfoModel2);
			this.writePlainText(resultModel.toJson().toString());
		}
	/**
	 * 增加体检受理
	 */
	public void do_addimport(){
		
		//先根据把数据从数据库中取出
			BusAllInfoModel busAllInfoModel2=new BusAllInfoModel();
			try{
				 this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
				 busAllInfoModel2=(BusAllInfoModel)this.hospitalBiz.getModel(busAllInfoModel).get(0);
			}catch(Exception e){
				e.printStackTrace();
			}
			busAllInfoModel2.setId(busAllInfoModel.getId());
			busAllInfoModel2.setCIdcardtype(busAllInfoModel.getCIdcardtype());
			busAllInfoModel2.setCIdcard(busAllInfoModel.getCIdcard());
			busAllInfoModel2.setCDabh(busAllInfoModel.getCDabh());
			busAllInfoModel2.setCXm(busAllInfoModel.getCXm());
			busAllInfoModel2.setCSex(busAllInfoModel.getCSex());
			busAllInfoModel2.setRegdate(busAllInfoModel.getRegdate());
			busAllInfoModel2.setCBirthday(busAllInfoModel.getCBirthday());
			busAllInfoModel2.setCNation(busAllInfoModel.getCNation());
			busAllInfoModel2.setCCarType(busAllInfoModel.getCCarType());
			busAllInfoModel2.setCRegareaCode(busAllInfoModel.getCRegareaCode());
			busAllInfoModel2.setCRegarea(busAllInfoModel.getCRegarea());
			busAllInfoModel2.setCPhone(busAllInfoModel.getCPhone());
			busAllInfoModel2.setCPostcode(busAllInfoModel.getCPostcode());
			
			busAllInfoModel2.setCHeight(busAllInfoModel.getCHeight());
			busAllInfoModel2.setCZsl(busAllInfoModel.getCZsl());
			busAllInfoModel2.setCYsl(busAllInfoModel.getCYsl());
			busAllInfoModel2.setCBsl(busAllInfoModel.getCBsl());
			busAllInfoModel2.setCTl(busAllInfoModel.getCTl());
			busAllInfoModel2.setCSz(busAllInfoModel.getCSz());
			busAllInfoModel2.setCZxz(busAllInfoModel.getCZxz());
			busAllInfoModel2.setCYxz(busAllInfoModel.getCYxz());
			busAllInfoModel2.setCQgjb(busAllInfoModel.getCQgjb());
			busAllInfoModel2.setCHospital(busAllInfoModel.getCHospital());
			
			
			ResultModel resultModel=this.hospitalBiz.modifyOrAddModel(busAllInfoModel2);
			this.writePlainText(resultModel.toJson().toString());
	}
	/**
	 * 根据证件号等查询到受理页面
	 */
	@SuppressWarnings("unchecked")
	public void do_search(){
		
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		BusAllInfoModel busAllInfoModel=new BusAllInfoModel();
		String qCIdcard=this.getParameter("CIdcard1");
		String qCDabh=this.getParameter("CDabh1");
		if(StringUtil.isBlank(qCIdcard)){
			qCIdcard=null;
		}
		if(StringUtil.isBlank(qCDabh)){
			qCDabh=null;
		}
		String qCIdcardtype=this.getParameter("CIdcardtype1");
		if(StringUtil.isBlank(qCIdcardtype)){
			qCIdcardtype=null;
		}
		busAllInfoModel.setCIdcardtype(qCIdcardtype);
		busAllInfoModel.setCIdcard(qCIdcard);
		busAllInfoModel.setCDabh(qCDabh);
		List<IFormatterModel> list=this.hospitalBiz.getModel(busAllInfoModel);
		if(list.size()==0){
			this.writePlainText(new BusAllInfoModel().toJson().toString());
		}else{
			this.writePlainText(list.get(0).toJson().toString());
		}
	}
	/**
	 * 根据证件号等查询到页面
	 */
	@SuppressWarnings("unchecked")
	public void do_searchimport(){
		
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		BusAllInfoModel busAllInfoModel=new BusAllInfoModel();
		String qCIdcard=this.getParameter("CIdcard1");
		String qCDabh=this.getParameter("CDabh1");
		if(StringUtil.isBlank(qCIdcard)){
			qCIdcard=null;
		}
		if(StringUtil.isBlank(qCDabh)){
			qCDabh=null;
		}
		String qCIdcardtype=this.getParameter("CIdcardtype1");
		if(StringUtil.isBlank(qCIdcardtype)){
			qCIdcardtype=null;
		}
		busAllInfoModel.setCIdcardtype(qCIdcardtype);
		busAllInfoModel.setCIdcard(qCIdcard);
		busAllInfoModel.setCDabh(qCDabh);
		List<IFormatterModel> list=this.hospitalBiz.getModel(busAllInfoModel);
		if(list.size()==0){
			this.writePlainText(new BusAllInfoModel().toJson().toString());
		}else{
			this.writePlainText(list.get(0).toJson().toString());
		}
	}
	/**
	 *查询出业务查询 
	 */
	@SuppressWarnings("unchecked")
	public void datagrid_busAllLog(){
		BusAllInfoModel busAllInfoModel=new BusAllInfoModel();
		String qCIdcard=this.getParameter("qCIdcard");
        if(StringUtil.isBlank(qCIdcard)){
        	qCIdcard=null;
        }
        String qCOperator=this.getParameter("qCOperator");
        if(StringUtil.isBlank(qCOperator)){
        	qCOperator=null;
        }
        String qCDabh=this.getParameter("qCDabh");
        if(StringUtil.isBlank(qCDabh)){
        	qCDabh=null;
        }
        String qCXm=this.getParameter("qCXm");
        if(StringUtil.isBlank(qCXm)){
        	qCXm=null;
        }
        String qCCarType=this.getParameter("qCCarType");
        if(StringUtil.isBlank(qCCarType)){
        	qCCarType=null;
        }
        String qbeginDate=this.getParameter("qbeginDate");
        if(StringUtil.isBlank(qbeginDate)){
        	qbeginDate=null;
        	Calendar cal=Calendar.getInstance();
    		cal.setTimeInMillis(0);
			busAllInfoModel.setBeginDate(cal.getTime());
        }else{
        	busAllInfoModel.setBeginDate(DateTimeUtil.parse(qbeginDate));
        }
        String qendDate=this.getParameter("qendDate");
        if(StringUtil.isBlank(qendDate)){
        	qendDate=null;
        	 busAllInfoModel.setEndDate(DateTimeUtil.parse("2050-01-01"));
        }else{
        	busAllInfoModel.setEndDate(DateTimeUtil.parse(qendDate));
        }
        busAllInfoModel.setCIdcard(qCIdcard);
        busAllInfoModel.setCOperator(qCOperator);
        busAllInfoModel.setCDabh(qCDabh);
        busAllInfoModel.setCXm(qCXm);
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		PageArrayList list=this.hospitalBiz.getModel(busAllInfoModel,this.getPager());
		/*
		 * 根据数据字典中的值，替换字母
		 * */
		for(int tu=0;tu<list.size();tu++){
			BusAllInfoModel busAllInfoModel2=(BusAllInfoModel) list.get(tu);
			String Sex=busAllInfoModel2.getCSex();
			String CarType=busAllInfoModel2.getCCarType();
			String Nation=busAllInfoModel2.getCNation();
			String Hospital=formatNull(busAllInfoModel2.getCHospital());
			String RegareaCode=busAllInfoModel2.getCRegareaCode();
			String IdCardType=busAllInfoModel2.getCIdcardtype();
			busAllInfoModel2.setCIdcardtype(Dictschange(IdCardType, "证件类型"));
			busAllInfoModel2.setCRegareaCode(Dictschange(RegareaCode, "联系住所"));
			busAllInfoModel2.setCHospital(Dictschange(Hospital, "体检医院"));
			busAllInfoModel2.setCNation(Dictschange(Nation, "国籍"));
			busAllInfoModel2.setCCarType(Dictschange(CarType, "车辆类型"));
			busAllInfoModel2.setCSex(Dictschange(Sex,"性别"));
		}
		JSONObject json=EasyUiUtil.toJsonDataGrid(list,list.getCount());
		this.writePlainText(json.toString());
	}
	/*
	 * 把空的字符串变成""
	 */
	private String formatNull(String str){
		if(StringUtil.isBlank(str)){
			return "";
		}
		return str;
	}
	/**
	 *@param 字典类型的代码
	 *@return 字典类型的具体数据 
	 */
	@SuppressWarnings("unchecked")
	private String Dictschange(String value,String type){
		this.adminBiz.loadCrudMapper(DictModel.class);
		DictModel dictModel=new DictModel();
		dictModel.setCDictValue(value);	
		dictModel.setCTypename(type);	
			List list=this.adminBiz.getModel(dictModel);
			if(list.size()==0){
				return "未填写";
			}else{
				DictModel  dictModel1=(DictModel)list.get(0);
				return dictModel1.getCDictText();
			}		
	}
	/**
	 *根据医院，或成员查询 
	 */
	@SuppressWarnings("unchecked")
	public void datagrid_hospital(){
		String qbeginDate=this.getParameter("qbeginDate");
        String qendDate=this.getParameter("qendDate");
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        if(StringUtil.isBlank(qbeginDate)){
        	qbeginDate="2000-1-1";
        }
        if(StringUtil.isBlank(qendDate)){
        	qendDate=sf.format(new Date());
        }
		int type=ObjectUtil.formatInt(this.getParameter("type"));
		List list = null;
		try {
			list = this.hospitalBiz.getViewGroupByHospital(type, DateUtil.parseDate(qbeginDate), DateUtil.parseDate(qendDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject json=EasyUiUtil.toJsonDataGrid(list);
		this.writePlainText(json.toString());
	}
	/*
	 * 退办受理，把I_State变成0
	 * */
	public void do_cancel(){
		//String CIdcard=this.getParameter("CIdcard");
		//System.out.println(CIdcard);
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		this.busAllInfoModel.setIState(0);
		this.hospitalBiz.addOrModifyModel(busAllInfoModel);
		ResultModel resultModel=new ResultModel();
		resultModel.setTitle("受理回执信息");
		resultModel.setMsg("成功退办业务");
		this.writePlainText(resultModel.toJson().toString());
	}
	/**
	 * 得到当前用户对应的部门名字
	 * */
	@SuppressWarnings("unchecked")
	public void get_departmentName(){
		UserModel userModel=(UserModel)this.getSessionAttribute("authUser");
		try {
			List list=this.adminBiz.listDepartmentName(userModel.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 打印出受理的信息成EXCEL表格
	 * */
	public void do_print(){
		this.hospitalBiz.loadCrudMapper(BusAllInfoModel.class);
		BusAllInfoModel busAllInfoModelprint=(BusAllInfoModel)this.hospitalBiz.getModel(busAllInfoModel).get(0);
		this.adminBiz.loadCrudMapper(DictModel.class);
		DictModel dictModel=new DictModel();
		dictModel.setCDictValue(busAllInfoModelprint.getCIdcardtype());
		dictModel.setCTypename("证件类型");
		DictModel dicModelprint=(DictModel)this.adminBiz.getModel(dictModel).get(0);
		busAllInfoModelprint.setCIdcardtype(dicModelprint.getCDictText());
		this.writePlainText(busAllInfoModelprint.toJson().toString());		
	}
	/**
	 * 根据身份证号码调用biz取出图片
	 * */
	public void get_photo(){
		String sfzmmc=this.getParameter("CIdcard");
		String sfzmhm=this.getParameter("CIdcardtype");
		//byte[] bt=this.hospitalBiz.getphotoByCIdcard(sfzmmc, sfzmhm);
		//this.writeStream(bt);
	}
	public void combobox_lxdz(){
		List list=new ArrayList<DictModel>();
		try {
			list=this.adminBiz.listdjzs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list);
		//this.writePlainText(jsonDG.toString());
		JSONObject jsonDG=EasyUiUtil.toJsonDataGrid(list);
		this.writePlainText(jsonDG.toString());
	}
	public void clear() {
	}
}
