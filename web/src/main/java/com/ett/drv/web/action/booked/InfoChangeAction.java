package com.ett.drv.web.action.booked;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.booked.CarOwnerChangeModel;
import com.ett.drv.model.booked.PersonChangeModel;
import com.ett.drv.web.action.BaseAction;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.ObjectUtil;


public class InfoChangeAction extends BaseAction {

	private PersonChangeModel personChange;
	private CarOwnerChangeModel cardOwnerChange;
	
	
	
	public PersonChangeModel getPersonChange() {
		return personChange;
	}

	public CarOwnerChangeModel getCardOwnerChange() {
		return cardOwnerChange;
	}

	public void setPersonChange(PersonChangeModel personChange) {
		this.personChange = personChange;
	}

	public void setCardOwnerChange(CarOwnerChangeModel cardOwnerChange) {
		this.cardOwnerChange = cardOwnerChange;
	}
	
	
	
	
	public String to_carOwnerChange() throws Exception{
		return ResultEnum.jsp.name();
	}
	
	public String to_personChange() throws Exception{
		return ResultEnum.jsp.name();
	}
	
	public void do_savePersonChange(){
		ResultModel resultModel=new ResultModel();
		resultModel.setAction(ResultModel.ACTION_ALERT);
		this.bookedBiz.loadCrudMapper(PersonChangeModel.class);
//		PersonChangeModel q1=new PersonChangeModel();
//		q1.setCIdcard(personChange.getCIdcard());
//		List persons=this.bookedBiz.getModel(q1);
//		PersonChangeModel pcm;
//		if(persons.size()!=1){
//			resultModel.setTitle("操作失败");
//			resultModel.setMsg("没有身份证为{0}的驾驶人",personChange.getCIdcard());
//			this.writePlainText(resultModel.toJson().toString());
//			return;
//		}
//		pcm=(PersonChangeModel) persons.get(0);
//		
//		personChange.setId(pcm.getId());
		int re=0;
		re+=this.bookedBiz.addModel(personChange);

		if(re==1){
			resultModel.setTitle("操作成功");
			resultModel.setMsg("驾驶人信息变更成功");
		}else{
			resultModel.setTitle("操作失败");
			resultModel.setMsg("驾驶人信息变更失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	public void do_saveCarOwnerChange(){
		ResultModel resultModel=new ResultModel();
		resultModel.setAction(ResultModel.ACTION_ALERT);
		this.bookedBiz.loadCrudMapper(CarOwnerChangeModel.class);
		int re=0;
		re+=this.bookedBiz.addModel(cardOwnerChange);

		if(re==1){
			resultModel.setTitle("操作成功");
			resultModel.setMsg("车主联系方式变更成功");
		}else{
			resultModel.setTitle("操作失败");
			resultModel.setMsg("车主联系方式变更失败");
		}
		this.writePlainText(resultModel.toJson().toString());
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public void combobox_idcardType(){
		List listIdcardType=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try {
			listIdcardType=this.adminBiz.listIdcardType();
			jarr=ObjectUtil.toJsonArray(listIdcardType);
		} catch (Exception e) {e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}
	public void combobox_carType(){
		List listcarType=new ArrayList<DictModel>();
		JSONArray jarr=new JSONArray();
		try{
			listcarType=this.adminBiz.listCarType();
			jarr=ObjectUtil.toJsonArray(listcarType);
		}catch (Exception e) {e.printStackTrace();}
		this.writePlainText(jarr.toString());
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		super.prepare();
		if(personChange==null){
			personChange=new PersonChangeModel();
		}
	}

	
}
