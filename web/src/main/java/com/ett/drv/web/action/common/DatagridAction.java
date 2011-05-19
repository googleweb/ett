package com.ett.drv.web.action.common;

import java.util.ArrayList;
import java.util.Iterator;


import com.ett.drv.biz.IAdminBiz;
import com.ett.drv.web.action.BaseAction;
import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.IMapper;
import com.smartken.kia.core.model.impl.BaseModel;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class DatagridAction extends BaseAction {

	private Class modelClass;
	private String ids;
	private String pk="id";
	

	public void setPk(String pk) {
		this.pk = pk;
	}

	public void setModelClass(String modelClass) {
		try {
			Class c=Class.forName(modelClass);
			this.modelClass=c;
			this.adminBiz.loadCrudMapper(c);
//            for (IBaseCrudBiz biz : listCrudBiz) {
//				if(biz.loadCrudMapper(c)){
//					this.crudBiz=biz;
//					break;
//				}
//			}
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	

	public void setIds(String ids) {
		this.ids = ids;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	
	public void do_removeRows(){
		ArrayList listPk=StringUtil.splitToList(ids, ",");
		ResultModel rm=new ResultModel();
		if(listPk.size()<1)return;
		try {
			int result=this.adminBiz.removeModelInPk(listPk);
			rm.setTitle("操作成功");
			rm.setMsg("成功从数据库删除{0}条记录",result);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			rm.setTitle("操作异常");
			rm.setMsg("异常信息:"+e.getMessage());
		}finally{
			this.writePlainText(rm.toJson().toString());
		}
	}
	
	public void do_saveRow(){
        BaseModel bm;
        int result;
        ResultModel rm=new ResultModel();
		try {
			bm = (BaseModel)this.modelClass.newInstance();
	        Enum[] ens=bm.enumFields();
	        for(int i=0;i<ens.length;i++){
	        	try {
					bm.eval(ens[i],this.getParameter(ens[i]));
				} catch (Exception e) {e.printStackTrace();}
	        }
//	        Object pkObj= bm.generalPK();
//	        if(StringUtil.isBlank(ObjectUtil.formatString(bm.eval(this.pk)))){
//	        	bm.eval(pk,pkObj);
//	        }
	        result=this.adminBiz.modifyOrAddModel(bm);
			rm.setTitle("操作成功");
			rm.setMsg("成功保存{0}条记录",result);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rm.setTitle("操作异常");
			rm.setMsg("异常信息:"+e.getMessage());
		}finally{
			this.writePlainText(rm.toJson().toString());
		}

	}

	
	

}
