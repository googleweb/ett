package com.ett.drv.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ett.drv.mapper.admin.IBusAllInfoMapper;
import com.ett.drv.mapper.admin.IBusLogMapper;
import com.ett.drv.mapper.admin.IDepartmentMapper;
import com.ett.drv.mapper.admin.IDictMapper;
import com.ett.drv.mapper.admin.IDictTypeMapper;
import com.ett.drv.mapper.admin.IMenuMapper;
import com.ett.drv.mapper.admin.IRoleMapper;
import com.ett.drv.mapper.admin.IUserMapper;
import com.ett.drv.mapper.booked.IBookedDayLimitMapper;
import com.ett.drv.mapper.booked.ICarOwnerChangeMapper;
import com.ett.drv.mapper.booked.ILimitMapper;
import com.ett.drv.mapper.booked.IOrderInfoMapper;
import com.ett.drv.mapper.booked.IPersonChangeMapper;
import com.ett.drv.mapper.booked.ISchoolCarMapper;
import com.ett.drv.mapper.booked.IWeekRecordMapper;
import com.ett.drv.mapper.preinput.IStudentApplyInfoMapper;
import com.ett.drv.mapper.self.IDeviceMapper;
import com.ett.drv.mapper.self.IDeviceSnMapper;
import com.ett.drv.mapper.self.IDrivingLicenseMapper;
import com.ett.drv.mapper.self.IDrvFlowMapper;
import com.ett.drv.mapper.self.IFeeLogMapper;
import com.ett.drv.mapper.self.IHardwareMapper;
import com.ett.drv.mapper.self.IKm1CheckRecordMapper;
import com.ett.drv.mapper.self.IKm1PreasignRecordMapper;
import com.ett.drv.mapper.self.ITerminalMapper;
import com.ett.drv.mapper.self.ITransactDriverMapper;
import com.ett.drv.mapper.self.ITransactResourceMapper;
import com.ett.drv.mapper.self.ITransactVehicleMapper;
import com.ett.drv.mapper.self.IVehFlowMapper;
import com.ett.drv.mapper.self.IVehicleMapper;
import com.ett.drv.mapper.statis.*;
import com.ett.drv.model.admin.BusAllInfoModel;
import com.ett.drv.model.admin.BusLogModel;
import com.ett.drv.model.admin.DepartmentModel;
import com.ett.drv.model.admin.DictModel;
import com.ett.drv.model.admin.DictTypeModel;
import com.ett.drv.model.admin.MenuModel;
import com.ett.drv.model.admin.RoleModel;
import com.ett.drv.model.admin.UserModel;
import com.ett.drv.model.booked.BookedDayLimitModel;
import com.ett.drv.model.booked.BookedLimitModel;
import com.ett.drv.model.booked.BookedOrderInfoModel;
import com.ett.drv.model.booked.BookedWeekRecordModel;
import com.ett.drv.model.booked.CarOwnerChangeModel;
import com.ett.drv.model.booked.PersonChangeModel;
import com.ett.drv.model.booked.SchoolCarModel;
import com.ett.drv.model.preinput.StudentApplyInfoModel;
import com.ett.drv.model.self.DeviceModel;
import com.ett.drv.model.self.DeviceSnModel;
import com.ett.drv.model.self.DrivingLicenseModel;
import com.ett.drv.model.self.DrvFlowModel;
import com.ett.drv.model.self.FeeLogModel;
import com.ett.drv.model.self.HardwareModel;
import com.ett.drv.model.self.Km1CheckRecordModel;
import com.ett.drv.model.self.Km1PreasignRecordModel;
import com.ett.drv.model.self.TerminalModel;
import com.ett.drv.model.self.TransactDriverModel;
import com.ett.drv.model.self.TransactResourceModel;
import com.ett.drv.model.self.TransactVehicleModel;
import com.ett.drv.model.self.VehFlowModel;
import com.ett.drv.model.self.VehicleModel;
import com.ett.drvinterface.IDrvInterface;
import com.ett.drvinterface.IVehicleInterface;
import com.ett.drvinterface.IVioInterface;
import com.ett.drvinterface.entity.BaseDrvRequest;
import com.ett.drvinterface.entity.DrvPreasignRequest;
import com.smartken.kia.core.model.impl.BaseCurdBiz;

public abstract class BaseDrvBiz extends BaseCurdBiz {

    
	
	protected IDictMapper<DictModel> dictMapper;
	protected IDictTypeMapper<DictTypeModel> dictTypeMapper;


	protected IDepartmentMapper<DepartmentModel> departmentMapper;
	protected IRoleMapper<RoleModel> roleMapper;
	protected IMenuMapper<MenuModel> menuMapper;
	protected IUserMapper<UserModel> userMapper;
	protected IWeekRecordMapper<BookedWeekRecordModel> weekRecordMapper;
	protected ILimitMapper<BookedLimitModel> limitMapper;
	protected IOrderInfoMapper<BookedOrderInfoModel> orderInfoMapper;
	protected ITerminalMapper<TerminalModel> terminalMapper;
	protected ITransactDriverMapper<TransactDriverModel> transactDriverMapper;
	protected ITransactVehicleMapper<TransactVehicleModel> transactVehicleMapper;
	protected IDrivingLicenseMapper<DrivingLicenseModel> drivingLicenseMapper;
	protected IVehicleMapper<VehicleModel> vehicleMapper;
	protected IVehFlowMapper<VehFlowModel> vehFlowMapper;
	protected IDrvFlowMapper<DrvFlowModel> drvFlowMapper;
	protected ITransactResourceMapper<TransactResourceModel> transactResourceMapper;
	protected IKm1CheckRecordMapper<Km1CheckRecordModel> km1CheckRecordMapper;
	protected IKm1PreasignRecordMapper<Km1PreasignRecordModel> km1PreasignRecordMapper;
	protected IFeeLogMapper<FeeLogModel> feeLogMapper;
	protected IDeviceMapper<DeviceModel> deviceMapper;
	protected IDeviceSnMapper<DeviceSnModel> deviceSnMapper;
	protected IHardwareMapper<HardwareModel> hardwareMapper;
    protected IPersonChangeMapper<PersonChangeModel> personChangeMapper;
    protected ICarOwnerChangeMapper<CarOwnerChangeModel> carOwnerChangeMapper;
    protected IBookedDayLimitMapper<BookedDayLimitModel> bookedDayLimitMapper;
    protected ISchoolCarMapper<SchoolCarModel>  schoolCarMapper;
    protected IStudentApplyInfoMapper<StudentApplyInfoModel> studentApplyInfoMapper;
    protected IBusAllInfoMapper<BusAllInfoModel> busAllInfoMapper;
    protected IBusLogMapper<BusLogModel> busLogMapper;
    protected IStatisCoachCarMapper statisCoachCarMapper;
    protected IStatisDriverMapper statisDriverMapper;
    protected IStatisKmMapper statisKmMapper;
    protected IStatisSchoolMapper statisSchoolMapper;
    

    protected IDrvInterface drvInterface;
    protected IVehicleInterface vehicleInterface;
    protected IVioInterface vioInterface;


	public IBusAllInfoMapper<BusAllInfoModel> getBusAllInfoMapper() {
		return busAllInfoMapper;
	}



	public void setBusAllInfoMapper(
			IBusAllInfoMapper<BusAllInfoModel> busAllInfoMapper) {
		this.addCrudMapper(BusAllInfoModel.class, busAllInfoMapper);
		this.busAllInfoMapper = busAllInfoMapper;
		
	}



	public void setDictMapper(IDictMapper<DictModel> dictMapper) {
		this.dictMapper = dictMapper;
		this.addCrudMapper(DictModel.class, dictMapper);
	}



	public void setDepartmentMapper(
			IDepartmentMapper<DepartmentModel> departmentMapper) {
		this.departmentMapper = departmentMapper;
		this.addCrudMapper(DepartmentModel.class, departmentMapper);
	}

	public void setMenuMapper(IMenuMapper<MenuModel> menuMapper) {
		this.menuMapper = menuMapper;
		this.addCrudMapper(MenuModel.class, menuMapper);
	}



	public void setUserMapper(IUserMapper<UserModel> userMapper) {
		this.userMapper = userMapper;
		this.addCrudMapper(UserModel.class, userMapper);
	}

	
	public void setLimitMapper(ILimitMapper<BookedLimitModel> iLimitMapper) {
		this.limitMapper = iLimitMapper;
		this.addCrudMapper(BookedLimitModel.class, iLimitMapper);
	}
	

	public void setWeekRecordMapper(
			IWeekRecordMapper<BookedWeekRecordModel> weekRecordMapper) {
		this.weekRecordMapper = weekRecordMapper;
		this.addCrudMapper(BookedWeekRecordModel.class, weekRecordMapper);
	}


	public void setOrderInfoMapper(
			IOrderInfoMapper<BookedOrderInfoModel> orderInfoMapper) {
		this.orderInfoMapper = orderInfoMapper;
		this.addCrudMapper(BookedOrderInfoModel.class, orderInfoMapper);
	}
	
	public void setDeviceMapper(IDeviceMapper<DeviceModel> deviceMapper) {
		this.deviceMapper = deviceMapper;
		this.addCrudMapper(DeviceModel.class, deviceMapper);
	}
	public void setTerminalMapper(ITerminalMapper<TerminalModel> terminalMapper) {
		this.terminalMapper = terminalMapper;
		this.addCrudMapper(TerminalModel.class, terminalMapper);
	}
	public void setTransactDriverMapper(
			ITransactDriverMapper<TransactDriverModel> transactDriverMapper) {
		this.transactDriverMapper = transactDriverMapper;
		this.addCrudMapper(TransactDriverModel.class, transactDriverMapper);
	}
	public void setTransactVehicleMapper(
			ITransactVehicleMapper<TransactVehicleModel> transactVehicleMapper) {
		this.transactVehicleMapper = transactVehicleMapper;
		this.addCrudMapper(TransactVehicleModel.class, transactVehicleMapper);
	}
	
	
	public void setDrivingLicenseMapper(
			IDrivingLicenseMapper<DrivingLicenseModel> drivingLicenseMapper) {
		this.drivingLicenseMapper = drivingLicenseMapper;
		this.addCrudMapper(DrivingLicenseModel.class, drivingLicenseMapper);
	}
	
	
	public void setVehicleMapper(IVehicleMapper<VehicleModel> vehicleMapper) {
		this.vehicleMapper = vehicleMapper;
		this.addCrudMapper(VehicleModel.class, vehicleMapper);
	}
	
	
	
	public void setVehFlowMapper(IVehFlowMapper<VehFlowModel> vehFlowMapper) {
		this.vehFlowMapper = vehFlowMapper;
		this.addCrudMapper(VehFlowModel.class, vehFlowMapper);
	}
	
	
	
	public void setDrvFlowMapper(IDrvFlowMapper<DrvFlowModel> drvFlowMapper) {
		this.drvFlowMapper = drvFlowMapper;
		this.addCrudMapper(DrvFlowModel.class, drvFlowMapper);
	}
	
	
	
	
	public void setTransactResourceMapper(
			ITransactResourceMapper<TransactResourceModel> transactResourceMapper) {
		this.transactResourceMapper = transactResourceMapper;
		this.addCrudMapper(TransactResourceModel.class, transactResourceMapper);
	}
	
	
	
	
	
	public void setKm1CheckRecordMapper(
			IKm1CheckRecordMapper<Km1CheckRecordModel> km1CheckRecordMapper) {
		this.km1CheckRecordMapper = km1CheckRecordMapper;
		this.addCrudMapper(Km1CheckRecordModel.class, km1CheckRecordMapper);
	}
	public void setKm1PreasignRecordMapper(
			IKm1PreasignRecordMapper<Km1PreasignRecordModel> km1PreasignRecordMapper) {
		this.km1PreasignRecordMapper = km1PreasignRecordMapper;
	    this.addCrudMapper(Km1PreasignRecordModel.class, km1PreasignRecordMapper);
	}
	public void setFeeLogMapper(IFeeLogMapper<FeeLogModel> feeLogMapper) {
		this.feeLogMapper = feeLogMapper;
		this.addCrudMapper(FeeLogModel.class, feeLogMapper);
	}



	public void setDeviceSnMapper(IDeviceSnMapper<DeviceSnModel> deviceSnMapper) {
		this.deviceSnMapper = deviceSnMapper;
		this.addCrudMapper(DeviceSnModel.class, deviceSnMapper);
	}



	public void setHardwareMapper(IHardwareMapper<HardwareModel> hardwareMapper) {
		this.hardwareMapper = hardwareMapper;
		this.addCrudMapper(HardwareModel.class, hardwareMapper);
	}



	public void setPersonChangeMapper(
			IPersonChangeMapper<PersonChangeModel> personChangeMapper) {
		this.personChangeMapper = personChangeMapper;
		this.addCrudMapper(PersonChangeModel.class, personChangeMapper);
	}



	public void setCarOwnerChangeMapper(
			ICarOwnerChangeMapper<CarOwnerChangeModel> carOwnerChangeMapper) {
		this.carOwnerChangeMapper = carOwnerChangeMapper;
		this.addCrudMapper(CarOwnerChangeModel.class, carOwnerChangeMapper);
	}

	public void setRoleMapper(IRoleMapper<RoleModel> roleMapper) {
		this.roleMapper = roleMapper;
		this.addCrudMapper(RoleModel.class, roleMapper);
	}
	
	public void setDictTypeMapper(IDictTypeMapper<DictTypeModel> dictTypeMapper) {
		this.dictTypeMapper = dictTypeMapper;
		this.addCrudMapper(DictTypeModel.class, dictTypeMapper);
	}



	public void setBookedDayLimitMapper(
			IBookedDayLimitMapper<BookedDayLimitModel> bookedDayLimitMapper) {
		this.bookedDayLimitMapper = bookedDayLimitMapper;
		this.addCrudMapper(BookedDayLimitModel.class, bookedDayLimitMapper);
	}



	public void setSchoolCarMapper(ISchoolCarMapper<SchoolCarModel> schoolCarMapper) {
		this.schoolCarMapper = schoolCarMapper;
		this.addCrudMapper(SchoolCarModel.class, schoolCarMapper);
	}
	
	
	public void setStudentApplyInfoMapper(IStudentApplyInfoMapper<StudentApplyInfoModel> studentApplyInfoMapper){
		this.studentApplyInfoMapper=studentApplyInfoMapper;
		this.addCrudMapper(StudentApplyInfoModel.class, studentApplyInfoMapper);
	}



	public void setBusLogMapper(IBusLogMapper<BusLogModel> busLogMapper) {
		this.busLogMapper = busLogMapper;
		this.addCrudMapper(BusLogModel.class, busLogMapper);
	}



	public void setStatisCoachCarMapper(IStatisCoachCarMapper statisCoachCarMapper) {
		this.statisCoachCarMapper = statisCoachCarMapper;
	}



	public void setStatisDriverMapper(IStatisDriverMapper statisDriverMapper) {
		this.statisDriverMapper = statisDriverMapper;
	}



	public void setStatisKmMapper(IStatisKmMapper statisKmMapper) {
		this.statisKmMapper = statisKmMapper;
	}



	public void setStatisSchoolMapper(IStatisSchoolMapper statisSchoolMapper) {
		this.statisSchoolMapper = statisSchoolMapper;
	}



	public void setDrvInterface(IDrvInterface drvInterface) {
		this.drvInterface = drvInterface;
	}



	public void setVehicleInterface(IVehicleInterface vehicleInterface) {
		this.vehicleInterface = vehicleInterface;
	}



	public void setVioInterface(IVioInterface vioInterface) {
		this.vioInterface = vioInterface;
	}


    //根据接口名从本地数据表TABLE_SELF_DEVICE_SN中获取基本请求对象
    public void getLocalRequest(String jkName,BaseDrvRequest request){
    	BaseDrvRequest baseDrvRequest=new BaseDrvRequest() {			
			@Override
			public String toXml() {
				// TODO Auto-generated method stub
				return null;
			}
		};
    	
		DeviceSnModel q=new DeviceSnModel();
		q.setCCreateip("127.0.0.1");
		q.setCJkname(jkName);
		List<DeviceSnModel> listSnModels;
		try {
			listSnModels = this.deviceSnMapper.select(q);
			if(listSnModels.size()!=1){
				//return baseDrvRequest;
			}else{
				DeviceSnModel deviceSnModel=listSnModels.get(0);
				request.setJkid(deviceSnModel.getCJkid());
				request.setJkxlh(deviceSnModel.getCJkxlh());
				request.setSn(deviceSnModel.getCSn());
				request.setXtlb(deviceSnModel.getCXtlb());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//return baseDrvRequest;
		}

    	
    }

    

	
	
	
}
