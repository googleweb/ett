package com.ett.visual.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import oracle.jdbc.driver.OracleDriver;




import com.ett.visual.mapper.admin.IDictMapper;
import com.ett.visual.mapper.admin.IDictTypeMapper;
import com.ett.visual.mapper.admin.IRoleMapper;
import com.ett.visual.mapper.drv.IDriverFileMapper;
import com.ett.visual.mapper.drv.IDriverInfoMapper;
import com.ett.visual.mapper.res.IResMapper;
import com.ett.visual.model.admin.DictModel;
import com.ett.visual.model.admin.DictTypeModel;
import com.ett.visual.model.admin.RoleModel;
import com.ett.visual.model.drv.DriverFileModel;
import com.ett.visual.model.drv.DriverInfoModel;
import com.smartken.toyz4j.ToyzApp;
import com.smartken.toyz4j.mybatis.MapperFactory;
import com.smartken.toyz4j.mybatis.MapperTemplate;
import com.smartken.toyz4j.mybatis.OracleMapperTemplate;
import com.smartken.toyz4j.util.FileUtil;
import com.smartken.toyz4j.util.JdbcUtil;

public class MapperGenApp extends ToyzApp {

	
	public static enum Table{
		TABLE_BUS_ALL_INFO,TABLE_BUSLOGS,TABLE_CAR_OWNER_CHANGE_INFO,TABLE_DEPARTMENTS,TABLE_DICTS,TABLE_DICTTYPE,TABLE_EXTRA_ASSIGN
		,DRV_ADMIN_MENU,TABLE_PERSON_CHANGE_INFO,TABLE_ROLES,TABLE_SCHOOL_CAR_INFO,TABLE_USERS,TABLE_WEEK_RECORD,TABLE_YUYUE_DAY_LIMIT,TABLE_YUYUE_INFO,TABLE_YUYUE_LIMIT
	    ,SELF_SYS_DEVICE,SELF_SYS_TERMINAL,PIC,SELF_TRANSACT_DRIVER,SELF_TRANSACT_VEHICLE,PERSON,DRV_FLOW
	    ,DRIVINGLICENSE,VEHICLE,VEH_FLOW,SELF_TRANSACT_RESOURCE,DRV_CODE,VEH_CODE
	    
	    ,TABLE_SELF_KM1_CHECK_RECORD,TABLE_SELF_KM1_PREASIGN_RECORD,TABLE_SELF_FEE_LOG
	    
	    ,TABLE_SELF_DEVICE,TABLE_SELF_DEVICE_SN,TABLE_SELF_HARD,TABLE_MENUS,TABLE_STUDENT_APPLY_INFO
	    
	    ,EXAM_TK_CN ,VIS_ADMIN_ROLE,SYS_DRV_INFO,VIS_DRV_FILE,VIS_ADMIN_DICT,VIS_ADMIN_DICT_TYPE,VIS_RES
	}
	
	public static enum Seqs{
		seq_bus_all_info,seq_buslog,seq_car_owner_change_info,seq_department,seq_dict,seq_dicttype,seq_extra_assign,seq_fp_approve,seq_role,seq_school_car_info
		,seq_self_device,seq_self_devicesn,seq_self_hardware,seq_self_transact_driver,seq_self_transact_vehicle,seq_student,seq_table_person_change_info
		,seq_user,seq_week_record,seq_yuyue_day_limit,seq_yuyue_info,seq_yuyue_limit,seq_menu,SEQ_STUDENT_APPLY_INFO,seq_exam_tk_cn
	}
	
	public static String NEXTVAL=".nextval";
	
	public static Set<MapperTemplate> getMappers(Connection con){
		MapperFactory mf=null;
		try {
			mf = new MapperFactory(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<MapperTemplate> mappers=new HashSet<MapperTemplate>();
		
		try{
			//mappers.put(Table.TABLE_MENUS,mf.createMapperTemplate(Table.TABLE_MENUS.name().toUpperCase(), "menuid".toUpperCase(),IMenuMapper.class, MenuModel.class,Seqs.seq_menu+NEXTVAL));
			//mappers.put(Table.TABLE_DEPARTMENTS,mf.createMapperTemplate(Table.TABLE_DEPARTMENTS.name().toUpperCase(), "id".toUpperCase(),IDepartmentModel.class, DepartmentModel.class,Seqs.seq_department+NEXTVAL ));
			mappers.add(mf.createMapperTemplate(IDictMapper.class,Table.TABLE_DICTS.name().toUpperCase(), "id".toUpperCase(),null,Seqs.seq_dict+NEXTVAL ));
			mappers.add(mf.createMapperTemplate(IDictTypeMapper.class,Table.TABLE_DICTTYPE.name().toUpperCase(), "id".toUpperCase(),null,Seqs.seq_dicttype+NEXTVAL ));
            mappers.add(mf.createMapperTemplate(IRoleMapper.class,Table.VIS_ADMIN_ROLE.name(), "id",null));
			mappers.add(mf.createMapperTemplate(IDriverFileMapper.class,Table.VIS_DRV_FILE.name(), "id",null));
	    	mappers.add(mf.createMapperTemplate(IDriverInfoMapper.class,Table.SYS_DRV_INFO.name(), "id",null));
	    	mappers.add(mf.createMapperTemplate(IResMapper.class,Table.VIS_RES.name(), "id",null));
			mappers.add(mf.createMapperTemplate(IDictMapper.class,Table.VIS_ADMIN_DICT.name(), "id" ,null));
			mappers.add(mf.createMapperTemplate(IDictTypeMapper.class,Table.VIS_ADMIN_DICT_TYPE.name(), "id",null ));
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return mappers;
	}
	

	
	public static void main(String[] args){
		Connection connection=null;
		try {
	    connection=JdbcUtil.createConnection(OracleDriver.class, "aspnet", "stjj117","oradrvde");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		Set<MapperTemplate> mappers=getMappers(connection);
		//String srcPath="D:/tempProject/ett/dao/src/main/java/";
		String workspacePath=FileUtil.TrimPath(FileUtil.WorkspacePath(FileUtil.TARGET_PATH_MAVEN));
		String recPath=workspacePath+"/visual-biz/src/main/resources/";
		String srcPath=workspacePath+"/visual-model/src/main/java/";
		for (MapperTemplate mapper : mappers) {
			try{

			//mapper.setOverWriterExtra(true);
		    //MapperTemplate mapper=mappers.get(Table.EXAM_TK_CN);
			mapper.generalBaseModel(srcPath);
			System.out.println(mapper.generalMapplerXML(recPath));
			}catch(Exception ex){ex.printStackTrace();}
		}

		
		
		//D:\tempProject\smartken-drv\drv-dao\src\main\java\com\smartken\drv\mapper\admin
	}
	
}
