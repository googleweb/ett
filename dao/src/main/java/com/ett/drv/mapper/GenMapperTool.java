package com.ett.drv.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.IvParameterSpec;

import oracle.jdbc.OracleDriver;


import com.ett.drv.mapper.admin.*;
import com.ett.drv.mapper.booked.*;
import com.ett.drv.mapper.dict.IDrvCodeMapper;
import com.ett.drv.mapper.dict.IVehCodeMapper;
import com.ett.drv.mapper.preinput.IStudentApplyInfoMapper;
import com.ett.drv.mapper.self.IDeviceMapper;
import com.ett.drv.mapper.self.IDeviceSnMapper;
import com.ett.drv.mapper.self.IDrivingLicenseMapper;
import com.ett.drv.mapper.self.IDrvFlowMapper;
import com.ett.drv.mapper.self.IFeeLogMapper;
import com.ett.drv.mapper.self.IHardwareMapper;
import com.ett.drv.mapper.self.IKm1CheckRecordMapper;
import com.ett.drv.mapper.self.IKm1PreasignRecordMapper;
import com.ett.drv.mapper.self.IPersonMapper;
import com.ett.drv.mapper.self.IPicMapper;
import com.ett.drv.mapper.self.ITerminalMapper;
import com.ett.drv.mapper.self.ITransactDriverMapper;
import com.ett.drv.mapper.self.ITransactResourceMapper;
import com.ett.drv.mapper.self.ITransactVehicleMapper;
import com.ett.drv.mapper.self.IVehFlowMapper;
import com.ett.drv.mapper.self.IVehicleMapper;
import com.ett.drv.mapper.exam.IExamTKcnMapper;
import com.ett.drv.model.admin.*;
import com.ett.drv.model.booked.*;
import com.ett.drv.model.dict.DrvCodeModel;
import com.ett.drv.model.dict.VehCodeModel;
import com.ett.drv.model.exam.ExamTKcnModel;
import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.ett.drv.model.self.DeviceModel;
import com.ett.drv.model.self.DeviceSnModel;
import com.ett.drv.model.self.DrivingLicenseModel;
import com.ett.drv.model.self.DrvFlowModel;
import com.ett.drv.model.self.FeeLogModel;
import com.ett.drv.model.self.HardwareModel;
import com.ett.drv.model.self.Km1CheckRecordModel;
import com.ett.drv.model.self.Km1PreasignRecordModel;
import com.ett.drv.model.self.PersonModel;
import com.ett.drv.model.self.PicModel;
import com.ett.drv.model.self.TerminalModel;
import com.ett.drv.model.self.TransactDriverModel;
import com.ett.drv.model.self.TransactResourceModel;
import com.ett.drv.model.self.TransactVehicleModel;
import com.ett.drv.model.self.VehFlowModel;
import com.ett.drv.model.self.VehicleModel;


import com.smartken.kia.core.plugin.mybatis.MapperFactory;
import com.smartken.kia.core.plugin.mybatis.MapperTemplate;
import com.smartken.kia.core.plugin.mybatis.OracleMapperTemplate;

public class GenMapperTool {

	
	public static enum Table{
		TABLE_BUS_ALL_INFO,TABLE_BUSLOGS,TABLE_CAR_OWNER_CHANGE_INFO,TABLE_DEPARTMENTS,TABLE_DICTS,TABLE_DICTTYPE,TABLE_EXTRA_ASSIGN
		,DRV_ADMIN_MENU,TABLE_PERSON_CHANGE_INFO,TABLE_ROLES,TABLE_SCHOOL_CAR_INFO,TABLE_USERS,TABLE_WEEK_RECORD,TABLE_YUYUE_DAY_LIMIT,TABLE_YUYUE_INFO,TABLE_YUYUE_LIMIT
	    ,SELF_SYS_DEVICE,SELF_SYS_TERMINAL,PIC,SELF_TRANSACT_DRIVER,SELF_TRANSACT_VEHICLE,PERSON,DRV_FLOW
	    ,DRIVINGLICENSE,VEHICLE,VEH_FLOW,SELF_TRANSACT_RESOURCE,DRV_CODE,VEH_CODE
	    
	    ,TABLE_SELF_KM1_CHECK_RECORD,TABLE_SELF_KM1_PREASIGN_RECORD,TABLE_SELF_FEE_LOG
	    
	    ,TABLE_SELF_DEVICE,TABLE_SELF_DEVICE_SN,TABLE_SELF_HARD,TABLE_MENUS,TABLE_STUDENT_APPLY_INFO
	    
	    ,EXAM_TK_CN
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
		mappers.put(Table.TABLE_MENUS,mf.createMapperTemplate(Table.TABLE_MENUS.name().toUpperCase(), "menuid".toUpperCase(),IMenuMapper.class, MenuModel.class,Seqs.seq_menu+NEXTVAL));
		mappers.put(Table.TABLE_BUS_ALL_INFO,mf.createMapperTemplate(Table.TABLE_BUS_ALL_INFO.name().toUpperCase(), "id".toUpperCase(),IBusAllInfoMapper.class, BusAllInfoModel.class,Seqs.seq_bus_all_info+NEXTVAL ));
		mappers.put(Table.TABLE_BUSLOGS,mf.createMapperTemplate(Table.TABLE_BUSLOGS.name().toUpperCase(), "id".toUpperCase(),IBusLogMapper.class, BusLogModel.class,Seqs.seq_buslog+NEXTVAL ));
		mappers.put(Table.TABLE_CAR_OWNER_CHANGE_INFO,mf.createMapperTemplate(Table.TABLE_CAR_OWNER_CHANGE_INFO.name().toUpperCase(), "id".toUpperCase(),ICarOwnerChangeMapper.class, CarOwnerChangeModel.class,Seqs.seq_car_owner_change_info+NEXTVAL ));
		mappers.put(Table.TABLE_DEPARTMENTS,mf.createMapperTemplate(Table.TABLE_DEPARTMENTS.name().toUpperCase(), "id".toUpperCase(),IDepartmentMapper.class, DepartmentModel.class,Seqs.seq_department+NEXTVAL ));
		mappers.put(Table.TABLE_DICTS,mf.createMapperTemplate(Table.TABLE_DICTS.name().toUpperCase(), "id".toUpperCase(),IDictMapper.class,DictModel.class,Seqs.seq_dict+NEXTVAL ));
		mappers.put(Table.TABLE_DICTTYPE,mf.createMapperTemplate(Table.TABLE_DICTTYPE.name().toUpperCase(), "id".toUpperCase(),IDictTypeMapper.class, DictTypeModel.class,Seqs.seq_dicttype+NEXTVAL ));
		mappers.put(Table.TABLE_EXTRA_ASSIGN,mf.createMapperTemplate(Table.TABLE_EXTRA_ASSIGN.name().toUpperCase(), "id".toUpperCase(),IExtraAssignMapper.class, ExtraAssignModel.class,Seqs.seq_extra_assign+NEXTVAL ));
		mappers.put(Table.TABLE_PERSON_CHANGE_INFO,mf.createMapperTemplate(Table.TABLE_PERSON_CHANGE_INFO.name().toUpperCase(), "id".toUpperCase(),IPersonChangeMapper.class, PersonChangeModel.class ));
		mappers.put(Table.TABLE_ROLES,mf.createMapperTemplate(Table.TABLE_ROLES.name().toUpperCase(), "id".toUpperCase(),IRoleMapper.class, RoleModel.class,Seqs.seq_role+NEXTVAL ));
		mappers.put(Table.TABLE_SCHOOL_CAR_INFO,mf.createMapperTemplate(Table.TABLE_SCHOOL_CAR_INFO.name().toUpperCase(), "id".toUpperCase(),ISchoolCarMapper.class, SchoolCarModel.class,Seqs.seq_school_car_info+NEXTVAL ));
		mappers.put(Table.TABLE_USERS,mf.createMapperTemplate(Table.TABLE_USERS.name().toUpperCase(), "id".toUpperCase(),IUserMapper.class, UserModel.class,Seqs.seq_user+NEXTVAL ));
		mappers.put(Table.TABLE_WEEK_RECORD,mf.createMapperTemplate(Table.TABLE_WEEK_RECORD.name().toUpperCase(), "id".toUpperCase(),IWeekRecordMapper.class, BookedWeekRecordModel.class,Seqs.seq_week_record+NEXTVAL ));
		mappers.put(Table.TABLE_YUYUE_DAY_LIMIT,mf.createMapperTemplate(Table.TABLE_YUYUE_DAY_LIMIT.name().toUpperCase(), "id".toUpperCase(),IBookedDayLimitMapper.class, BookedDayLimitModel.class,Seqs.seq_yuyue_day_limit+NEXTVAL ));
		mappers.put(Table.TABLE_YUYUE_INFO,mf.createMapperTemplate(Table.TABLE_YUYUE_INFO.name().toUpperCase(), "id".toUpperCase(),IOrderInfoMapper.class, BookedOrderInfoModel .class,Seqs.seq_yuyue_info+NEXTVAL ));
		mappers.put(Table.TABLE_YUYUE_LIMIT,mf.createMapperTemplate(Table.TABLE_YUYUE_LIMIT.name().toUpperCase(), "id".toUpperCase(),ILimitMapper.class, BookedLimitModel.class,Seqs.seq_yuyue_limit+NEXTVAL ));
		mappers.put(Table.SELF_TRANSACT_DRIVER,mf.createMapperTemplate(Table.SELF_TRANSACT_DRIVER.name().toUpperCase(), "flow_no".toUpperCase(),ITransactDriverMapper.class, TransactDriverModel.class ));
		mappers.put(Table.SELF_TRANSACT_VEHICLE,mf.createMapperTemplate(Table.SELF_TRANSACT_VEHICLE.name().toUpperCase(), "flow_no".toUpperCase(),ITransactVehicleMapper.class, TransactVehicleModel.class));
		mappers.put(Table.SELF_TRANSACT_RESOURCE,mf.createMapperTemplate(Table.SELF_TRANSACT_RESOURCE.name().toUpperCase(), "flow_no".toUpperCase(),ITransactResourceMapper.class, TransactResourceModel.class ));

		mappers.put(Table.PERSON,mf.createMapperTemplate(Table.PERSON.name().toUpperCase(), "id".toUpperCase(),IPersonMapper.class, PersonModel.class ));
		mappers.put(Table.DRV_FLOW,mf.createMapperTemplate(Table.DRV_FLOW.name().toUpperCase(), "lsh".toUpperCase(),IDrvFlowMapper.class, DrvFlowModel.class ));
		mappers.put(Table.DRIVINGLICENSE,mf.createMapperTemplate(Table.DRIVINGLICENSE.name().toUpperCase(), "dabh".toUpperCase(),IDrivingLicenseMapper.class, DrivingLicenseModel.class ));

		mappers.put(Table.VEHICLE,mf.createMapperTemplate(Table.VEHICLE.name().toUpperCase(), "xh".toUpperCase(),IVehicleMapper.class, VehicleModel.class ));
		
		mappers.put(Table.VEH_FLOW,mf.createMapperTemplate(Table.VEH_FLOW.name().toUpperCase(), "lsh".toUpperCase(),IVehFlowMapper.class, VehFlowModel.class ));
		mappers.put(Table.VEH_CODE,mf.createMapperTemplate(Table.VEH_CODE.name().toUpperCase(), "dmz".toUpperCase(),IVehCodeMapper.class, VehCodeModel.class ));
		mappers.put(Table.DRV_CODE,mf.createMapperTemplate(Table.DRV_CODE.name().toUpperCase(), "dmz".toUpperCase(),IDrvCodeMapper.class, DrvCodeModel.class ));
		    
		mappers.put(Table.TABLE_SELF_KM1_CHECK_RECORD,mf.createMapperTemplate(Table.TABLE_SELF_KM1_CHECK_RECORD.name().toUpperCase(), "id".toUpperCase(),IKm1CheckRecordMapper.class, Km1CheckRecordModel.class ));
		mappers.put(Table.TABLE_SELF_KM1_PREASIGN_RECORD,mf.createMapperTemplate(Table.TABLE_SELF_KM1_PREASIGN_RECORD.name().toUpperCase(), "id".toUpperCase(),IKm1PreasignRecordMapper.class, Km1PreasignRecordModel.class ));
		mappers.put(Table.TABLE_SELF_FEE_LOG,mf.createMapperTemplate(Table.TABLE_SELF_FEE_LOG.name().toUpperCase(), "id".toUpperCase(),IFeeLogMapper.class, FeeLogModel.class ));

		mappers.put(Table.TABLE_SELF_DEVICE,mf.createMapperTemplate(Table.TABLE_SELF_DEVICE.name().toUpperCase(), "id".toUpperCase(),IDeviceMapper.class, DeviceModel.class,Seqs.seq_self_device+NEXTVAL ));
		mappers.put(Table.TABLE_SELF_DEVICE_SN,mf.createMapperTemplate(Table.TABLE_SELF_DEVICE_SN.name().toUpperCase(), "id".toUpperCase(),IDeviceSnMapper.class, DeviceSnModel.class,Seqs.seq_self_devicesn+NEXTVAL ));
		mappers.put(Table.TABLE_SELF_HARD,mf.createMapperTemplate(Table.TABLE_SELF_HARD.name().toUpperCase(), "id".toUpperCase(),IHardwareMapper.class, HardwareModel.class,Seqs.seq_self_hardware+NEXTVAL ));
		mappers.put(Table.TABLE_STUDENT_APPLY_INFO,mf.createMapperTemplate(Table.TABLE_STUDENT_APPLY_INFO.name().toUpperCase(), "id".toUpperCase(), IStudentApplyInfoMapper.class, StudentApplyInfoModel.class,Seqs.SEQ_STUDENT_APPLY_INFO+NEXTVAL));
		
		mappers.put(Table.EXAM_TK_CN, mf.createMapperTemplate(Table.EXAM_TK_CN.name().toUpperCase(), "stxh".toUpperCase(), IExamTKcnMapper.class, ExamTKcnModel.class,Seqs.seq_exam_tk_cn+NEXTVAL));
		}catch(Exception ex){ex.printStackTrace();}
		
		return mappers;
	}
	
	public static Connection getConnection(){
		Connection c=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			c=  DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.10:1521:oradrvde", "drv_admin", "stjj117");
			//c=  DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.10:1521:oradrvde", "aspnet", "stjj117");
			//c=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hrsystem", "ken147");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{return c;}

	}
	
	public static void main(String[] args){
		Map<Table, MapperTemplate> mappers=getMappers(getConnection(), OracleMapperTemplate.class);
		//String srcPath="D:/tempProject/ett/dao/src/main/java/";
		String srcPath="F:/code/ett/dao/src/main/java/";
		Table[] enTables=Table.values();
		//for (Enum<Table> et : enTables) {
		//	try{
		//	MapperTemplate mapper=mappers.get(et);
		    MapperTemplate mapper=mappers.get(Table.EXAM_TK_CN);
			System.out.println(mapper.generalMapplerXML(srcPath,"oracle"));
		//	}catch(Exception ex){}
		//}

		
		
		//D:\tempProject\smartken-drv\drv-dao\src\main\java\com\smartken\drv\mapper\admin
	}
	
}
