package com.ett.visual.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;


import com.ett.visual.mapper.admin.IDictMapper;
import com.ett.visual.mapper.admin.IRoleMapper;
import com.ett.visual.mapper.driver.IDriverFileMapper;
import com.ett.visual.mapper.driver.IDriverInfoMapper;
import com.ett.visual.model.admin.DictModel;
import com.ett.visual.model.admin.RoleModel;
import com.ett.visual.model.driver.DriverFileModel;
import com.ett.visual.model.driver.DriverInfoModel;
import com.smartken.toyz4j.mybatis.MapperFactory;
import com.smartken.toyz4j.mybatis.MapperTemplate;
import com.smartken.toyz4j.mybatis.OracleMapperTemplate;

public class MapperGenTool {

	
	public static enum Table{
		TABLE_BUS_ALL_INFO,TABLE_BUSLOGS,TABLE_CAR_OWNER_CHANGE_INFO,TABLE_DEPARTMENTS,TABLE_DICTS,TABLE_DICTTYPE,TABLE_EXTRA_ASSIGN
		,DRV_ADMIN_MENU,TABLE_PERSON_CHANGE_INFO,TABLE_ROLES,TABLE_SCHOOL_CAR_INFO,TABLE_USERS,TABLE_WEEK_RECORD,TABLE_YUYUE_DAY_LIMIT,TABLE_YUYUE_INFO,TABLE_YUYUE_LIMIT
	    ,SELF_SYS_DEVICE,SELF_SYS_TERMINAL,PIC,SELF_TRANSACT_DRIVER,SELF_TRANSACT_VEHICLE,PERSON,DRV_FLOW
	    ,DRIVINGLICENSE,VEHICLE,VEH_FLOW,SELF_TRANSACT_RESOURCE,DRV_CODE,VEH_CODE
	    
	    ,TABLE_SELF_KM1_CHECK_RECORD,TABLE_SELF_KM1_PREASIGN_RECORD,TABLE_SELF_FEE_LOG
	    
	    ,TABLE_SELF_DEVICE,TABLE_SELF_DEVICE_SN,TABLE_SELF_HARD,TABLE_MENUS,TABLE_STUDENT_APPLY_INFO
	    
	    ,EXAM_TK_CN ,VIS_ADMIN_ROLE,VIS_DRIVER_INFO,VIS_DRIVER_FILE,VIS_ADMIN_DICT
	}
	
	public static enum Seqs{
		seq_bus_all_info,seq_buslog,seq_car_owner_change_info,seq_department,seq_dict,seq_dicttype,seq_extra_assign,seq_fp_approve,seq_role,seq_school_car_info
		,seq_self_device,seq_self_devicesn,seq_self_hardware,seq_self_transact_driver,seq_self_transact_vehicle,seq_student,seq_table_person_change_info
		,seq_user,seq_week_record,seq_yuyue_day_limit,seq_yuyue_info,seq_yuyue_limit,seq_menu,SEQ_STUDENT_APPLY_INFO,seq_exam_tk_cn
	}
	
	public static String NEXTVAL=".nextval";
	
	public static Map<Table,MapperTemplate> getMappers(Connection con,Class<? extends MapperTemplate> cls){
		MapperFactory mf=new MapperFactory(con,cls);
		Map<Table,MapperTemplate> mappers=new HashMap<Table, MapperTemplate>();
		
		try{
		//	mappers.put(Table.TABLE_MENUS,mf.createMapperTemplate(Table.TABLE_MENUS.name().toUpperCase(), "menuid".toUpperCase(),IMenuMapper.class, MenuModel.class,Seqs.seq_menu+NEXTVAL));
		//	mappers.put(Table.TABLE_DEPARTMENTS,mf.createMapperTemplate(Table.TABLE_DEPARTMENTS.name().toUpperCase(), "id".toUpperCase(),IDepartmentModel.class, DepartmentModel.class,Seqs.seq_department+NEXTVAL ));
		//	mappers.put(Table.TABLE_DICTS,mf.createMapperTemplate(Table.TABLE_DICTS.name().toUpperCase(), "id".toUpperCase(),IDictMapper.class,DictModel.class,Seqs.seq_dict+NEXTVAL ));
		//	mappers.put(Table.TABLE_DICTTYPE,mf.createMapperTemplate(Table.TABLE_DICTTYPE.name().toUpperCase(), "id".toUpperCase(),IDictTypeMapper.class, DictTypeModel.class,Seqs.seq_dicttype+NEXTVAL ));
        //    mappers.put(Table.VIS_ADMIN_ROLE,mf.createMapperTemplate(Table.VIS_ADMIN_ROLE.name(), "id", IRoleMapper.class, RoleModel.class));
		//	mappers.put(Table.VIS_DRIVER_FILE,mf.createMapperTemplate(Table.VIS_DRIVER_FILE.name(), "id", IDriverFileMapper.class, DriverFileModel.class));
		//	mappers.put(Table.VIS_DRIVER_INFO,mf.createMapperTemplate(Table.VIS_DRIVER_INFO.name(), "id", IDriverInfoMapper.class, DriverInfoModel.class));
			mappers.put(Table.VIS_ADMIN_DICT,mf.createMapperTemplate(Table.VIS_ADMIN_DICT.name(), "id", IDictMapper.class, DictModel.class));
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return mappers;
	}
	
	public static Connection getConnection(){
		Connection c=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//c=  DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.10:1521:oradrvde", "drv_admin", "stjj117");
			c=  DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.10:1521:oradrvde", "aspnet", "stjj117");
			//c=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hrsystem", "ken147");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{return c;}

	}
	
	public static void main(String[] args){
		Map<Table, MapperTemplate> mappers=getMappers(getConnection(), OracleMapperTemplate.class);
		//String srcPath="D:/tempProject/ett/dao/src/main/java/";
		String srcPath="D:/sts/base-parent/visual-biz/src/main/resources/";
		Table[] enTables=Table.values();
		for (Enum<Table> et : enTables) {
			try{
			MapperTemplate mapper=mappers.get(et);
		    //MapperTemplate mapper=mappers.get(Table.EXAM_TK_CN);
			System.out.println(mapper.generalMapplerXML(srcPath,"oracle"));
			}catch(Exception ex){}
		}

		
		
		//D:\tempProject\smartken-drv\drv-dao\src\main\java\com\smartken\drv\mapper\admin
	}
	
}
