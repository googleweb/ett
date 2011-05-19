package com.ett.drv.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.IvParameterSpec;


import com.ett.drv.mapper.admin.*;
import com.ett.drv.mapper.booked.*;
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
import com.ett.drv.model.admin.*;
import com.ett.drv.model.booked.*;
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


import com.smartken.kia.core.plugin.mybatis.Generator;
import com.smartken.kia.core.plugin.mybatis.MapperTemplate;

public class GenMapperTool {

	
	public static enum Table{
		TABLE_BUS_ALL_INFO,TABLE_BUSLOGS,TABLE_CAR_OWNER_CHANGE_INFO,TABLE_DEPARTMENTS,TABLE_DICTS,TABLE_DICTTYPE,TABLE_EXTRA_ASSIGN
		,DRV_ADMIN_MENU,TABLE_PERSON_CHANGE_INFO,TABLE_ROLES,TABLE_SCHOOL_CAR_INFO,TABLE_USERS,TABLE_WEEK_RECORD,TABLE_YUYUE_DAY_LIMIT,TABLE_YUYUE_INFO,TABLE_YUYUE_LIMIT
	    ,SELF_SYS_DEVICE,SELF_SYS_TERMINAL,PIC,SELF_TRANSACT_DRIVER,SELF_TRANSACT_VEHICLE,PERSON,DRV_FLOW
	    ,DRIVINGLICENSE,VEHICLE,VEH_FLOW,SELF_TRANSACT_RESOURCE,DRV_CODE,VEH_CODE
	    
	    ,TABLE_SELF_KM1_CHECK_RECORD,TABLE_SELF_KM1_PREASIGN_RECORD,TABLE_SELF_FEE_LOG
	    
	    ,TABLE_SELF_DEVICE,TABLE_SELF_DEVICE_SN,TABLE_SELF_HARD
	}
	
	public static Map<Enum<Table>,MapperTemplate> getMappers(){
		Generator gener=new Generator();
		gener.setConnection(getConnection());
		Map<Enum<Table>,MapperTemplate> mappers=new HashMap<Enum<Table>, MapperTemplate>();
		mappers.put(Table.DRV_ADMIN_MENU,gener.getMapperTemplate(Table.DRV_ADMIN_MENU.name().toUpperCase(), "id".toUpperCase(),IMenuMapper.class, MenuModel.class ));
//		mappers.put(Table.TABLE_BUS_ALL_INFO,gener.getMapperTemplate(Table.TABLE_BUS_ALL_INFO.name().toUpperCase(), "id".toUpperCase(),IBusAllInfoMapper.class, BusAllInfoModel.class ));
//		mappers.put(Table.TABLE_BUSLOGS,gener.getMapperTemplate(Table.TABLE_BUSLOGS.name().toUpperCase(), "id".toUpperCase(),IBusLogMapper.class, BusLogModel.class ));
//		mappers.put(Table.TABLE_CAR_OWNER_CHANGE_INFO,gener.getMapperTemplate(Table.TABLE_CAR_OWNER_CHANGE_INFO.name().toUpperCase(), "id".toUpperCase(),ICarOwnerChangeMapper.class, CarOwnerChangeModel.class ));
//		mappers.put(Table.TABLE_DEPARTMENTS,gener.getMapperTemplate(Table.TABLE_DEPARTMENTS.name().toUpperCase(), "id".toUpperCase(),IDepartmentMapper.class, DepartmentModel.class ));
//		mappers.put(Table.TABLE_DICTS,gener.getMapperTemplate(Table.TABLE_DICTS.name().toUpperCase(), "id".toUpperCase(),IDictMapper.class,DictModel.class ));
//		mappers.put(Table.TABLE_DICTTYPE,gener.getMapperTemplate(Table.TABLE_DICTTYPE.name().toUpperCase(), "id".toUpperCase(),IDictTypeMapper.class, DictTypeModel.class ));
//		mappers.put(Table.TABLE_EXTRA_ASSIGN,gener.getMapperTemplate(Table.TABLE_EXTRA_ASSIGN.name().toUpperCase(), "id".toUpperCase(),IExtraAssignMapper.class, ExtraAssignModel.class ));
//		mappers.put(Table.TABLE_PERSON_CHANGE_INFO,gener.getMapperTemplate(Table.TABLE_PERSON_CHANGE_INFO.name().toUpperCase(), "id".toUpperCase(),IPersonChangeMapper.class, PersonChangeModel.class ));
//		mappers.put(Table.TABLE_ROLES,gener.getMapperTemplate(Table.TABLE_ROLES.name().toUpperCase(), "id".toUpperCase(),IRoleMapper.class, RoleModel.class ));
//		mappers.put(Table.TABLE_SCHOOL_CAR_INFO,gener.getMapperTemplate(Table.TABLE_SCHOOL_CAR_INFO.name().toUpperCase(), "id".toUpperCase(),ISchoolCarMapper.class, SchoolCarModel.class ));
//		mappers.put(Table.TABLE_USERS,gener.getMapperTemplate(Table.TABLE_USERS.name().toUpperCase(), "id".toUpperCase(),IUserMapper.class, UserModel.class ));
//		mappers.put(Table.TABLE_WEEK_RECORD,gener.getMapperTemplate(Table.TABLE_WEEK_RECORD.name().toUpperCase(), "id".toUpperCase(),IWeekRecordMapper.class, BookedWeekRecordModel.class ));
//		mappers.put(Table.TABLE_YUYUE_DAY_LIMIT,gener.getMapperTemplate(Table.TABLE_YUYUE_DAY_LIMIT.name().toUpperCase(), "id".toUpperCase(),IMenuMapper.class, MenuModel.class ));
//		mappers.put(Table.TABLE_YUYUE_INFO,gener.getMapperTemplate(Table.TABLE_YUYUE_INFO.name().toUpperCase(), "id".toUpperCase(),IOrderInfoMapper.class, BookedOrderInfoModel .class ));
//		mappers.put(Table.TABLE_YUYUE_LIMIT,gener.getMapperTemplate(Table.TABLE_YUYUE_LIMIT.name().toUpperCase(), "id".toUpperCase(),ILimitMapper.class, BookedLimitModel.class ));
//		mappers.put(Table.SELF_SYS_DEVICE,gener.getMapperTemplate(Table.SELF_SYS_DEVICE.name().toUpperCase(), "id".toUpperCase(),IDeviceMapper.class, DeviceModel.class ));
//		mappers.put(Table.SELF_SYS_TERMINAL,gener.getMapperTemplate(Table.SELF_SYS_TERMINAL.name().toUpperCase(), "id".toUpperCase(),ITerminalMapper.class, TerminalModel.class ));
//		mappers.put(Table.PIC,gener.getMapperTemplate(Table.PIC.name().toUpperCase(), "id".toUpperCase(),IPicMapper.class, PicModel.class ));
		mappers.put(Table.SELF_TRANSACT_DRIVER,gener.getMapperTemplate(Table.SELF_TRANSACT_DRIVER.name().toUpperCase(), "flow_no".toUpperCase(),ITransactDriverMapper.class, TransactDriverModel.class ));
		mappers.put(Table.SELF_TRANSACT_VEHICLE,gener.getMapperTemplate(Table.SELF_TRANSACT_VEHICLE.name().toUpperCase(), "flow_no".toUpperCase(),ITransactVehicleMapper.class, TransactVehicleModel.class ));
		mappers.put(Table.SELF_TRANSACT_RESOURCE,gener.getMapperTemplate(Table.SELF_TRANSACT_RESOURCE.name().toUpperCase(), "flow_no".toUpperCase(),ITransactResourceMapper.class, TransactResourceModel.class ));

//		mappers.put(Table.PERSON,gener.getMapperTemplate(Table.PERSON.name().toUpperCase(), "id".toUpperCase(),IPersonMapper.class, PersonModel.class ));
//		mappers.put(Table.DRV_FLOW,gener.getMapperTemplate(Table.DRV_FLOW.name().toUpperCase(), "id".toUpperCase(),IDrvFlowMapper.class, DrvFlowModel.class ));
		mappers.put(Table.DRIVINGLICENSE,gener.getMapperTemplate(Table.DRIVINGLICENSE.name().toUpperCase(), "dabh".toUpperCase(),IDrivingLicenseMapper.class, DrivingLicenseModel.class ));
//
//		mappers.put(Table.VEHICLE,gener.getMapperTemplate(Table.VEHICLE.name().toUpperCase(), "xh".toUpperCase(),IVehicleMapper.class, VehicleModel.class ));
//		
//		mappers.put(Table.VEH_FLOW,gener.getMapperTemplate(Table.VEH_FLOW.name().toUpperCase(), "lsh".toUpperCase(),IVehFlowMapper.class, VehFlowModel.class ));
		mappers.put(Table.VEH_CODE,gener.getMapperTemplate(Table.VEH_CODE.name().toUpperCase(), "lsh".toUpperCase(),IVehFlowMapper.class, VehFlowModel.class ));
		mappers.put(Table.DRV_CODE,gener.getMapperTemplate(Table.DRV_CODE.name().toUpperCase(), "lsh".toUpperCase(),IVehFlowMapper.class, VehFlowModel.class ));
		    
		mappers.put(Table.TABLE_SELF_KM1_CHECK_RECORD,gener.getMapperTemplate(Table.TABLE_SELF_KM1_CHECK_RECORD.name().toUpperCase(), "id".toUpperCase(),IKm1CheckRecordMapper.class, Km1CheckRecordModel.class ));
		mappers.put(Table.TABLE_SELF_KM1_PREASIGN_RECORD,gener.getMapperTemplate(Table.TABLE_SELF_KM1_PREASIGN_RECORD.name().toUpperCase(), "id".toUpperCase(),IKm1PreasignRecordMapper.class, Km1PreasignRecordModel.class ));
		mappers.put(Table.TABLE_SELF_FEE_LOG,gener.getMapperTemplate(Table.TABLE_SELF_FEE_LOG.name().toUpperCase(), "id".toUpperCase(),IFeeLogMapper.class, FeeLogModel.class ));

		mappers.put(Table.TABLE_SELF_DEVICE,gener.getMapperTemplate(Table.TABLE_SELF_DEVICE.name().toUpperCase(), "id".toUpperCase(),IDeviceMapper.class, DeviceModel.class ));
		mappers.put(Table.TABLE_SELF_DEVICE_SN,gener.getMapperTemplate(Table.TABLE_SELF_DEVICE_SN.name().toUpperCase(), "id".toUpperCase(),IDeviceSnMapper.class, DeviceSnModel.class ));
		mappers.put(Table.TABLE_SELF_HARD,gener.getMapperTemplate(Table.TABLE_SELF_HARD.name().toUpperCase(), "id".toUpperCase(),IHardwareMapper.class, HardwareModel.class ));

		
		return mappers;
	}
	
	public static Connection getConnection(){
		Connection c=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//c=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oradrvde", "drv_admin", "stjj117");
			c=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oradrvde", "aspnet", "stjj117");
			//c=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hrsystem", "ken147");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{return c;}

	}
	
	public static void main(String[] args){
		Generator gener=new Generator();
		gener.setConnection(getConnection());
		Map<Enum<Table>, MapperTemplate> mappers=getMappers();
		String srcPath="D:/tempProject/smartken-drv/drv-dao/src/main/java/";
		MapperTemplate mapper=mappers.get(Table.TABLE_SELF_HARD);
		System.out.println(mapper.generalMapplerXML(srcPath));
		
		
		//D:\tempProject\smartken-drv\drv-dao\src\main\java\com\smartken\drv\mapper\admin
	}
	
}
