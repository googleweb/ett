package com.ett.drv.web.action.booked;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ett.drv.model.admin.DepartmentModel;
import com.ett.drv.model.booked.SchoolCarModel;
import com.ett.drv.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class SchoolCarAction extends BaseAction implements ModelDriven<SchoolCarModel> {

	private SchoolCarModel schoolCarModel;
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}
	
	
	public void datagrid_schoolCar(){
		
		this.bookedBiz.loadCrudMapper(SchoolCarModel.class);
		List list=this.bookedBiz.getModel(this.getPager());
		JSONObject jsonDatagrid=EasyUiUtil.toJsonDataGrid(list,this.bookedBiz.count());
		this.writePlainText(jsonDatagrid.toString());
	}


	public SchoolCarModel getModel() {
		// TODO Auto-generated method stub
		if(schoolCarModel==null){
			schoolCarModel=new SchoolCarModel();
		}
		return schoolCarModel;
	}

	public void do_removeSchoolCar(){
		String ids=ObjectUtil.formatString(this.getParameter("ids"));
		List listPk=StringUtil.splitToList(ids, ",");
		this.bookedBiz.loadCrudMapper(SchoolCarModel.class);
		ResultModel reModel=this.bookedBiz.removeModelInPk(listPk);
		this.writePlainText(reModel.toJson().toString());
	}
	
	public void do_saveSchoolCar(){
		String depCode=schoolCarModel.getDepcode();
		
		try {
			this.bookedBiz.loadCrudMapper(DepartmentModel.class);
			List listSchool = this.adminBiz.listSchool(depCode);
			if(listSchool.size()>0){
				DepartmentModel departmentModel=(DepartmentModel) this.adminBiz.listSchool(depCode).get(0);
				schoolCarModel.setDepname(departmentModel.getCDepfullname());
			}
			this.bookedBiz.loadCrudMapper(SchoolCarModel.class);
			ResultModel reModel=this.bookedBiz.modifyOrAddModel(schoolCarModel);
			this.writePlainText(reModel.toJson().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void combobox_school(){
		try {
			List listSchool=this.adminBiz.listSchool(null);
			JSONArray jarrSchool=ObjectUtil.toJsonArray(listSchool);
			this.writePlainText(jarrSchool.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
