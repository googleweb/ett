package com.ett.self.vio.biz;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ett.AbstractBaseBiz;
import com.ett.dao.IBaseDao;
import com.ett.self.model.VehicleObject;

public class VioBizImpl extends AbstractBaseBiz implements IVioBiz {
	
	private IBaseDao drvPersonFlowDaoImpl;
	
	private IBaseDao vehicleDaoImpl;
	
	private IBaseDao vioFlowDaoImpl;
	

	public IBaseDao getDrvPersonFlowDaoImpl() {
		return drvPersonFlowDaoImpl;
	}

	public void setDrvPersonFlowDaoImpl(IBaseDao drvPersonFlowDaoImpl) {
		this.drvPersonFlowDaoImpl = drvPersonFlowDaoImpl;
	}

	public IBaseDao getVehicleDaoImpl() {
		return vehicleDaoImpl;
	}

	public void setVehicleDaoImpl(IBaseDao vehicleDaoImpl) {
		this.vehicleDaoImpl = vehicleDaoImpl;
	}

	public IBaseDao getVioFlowDaoImpl() {
		return vioFlowDaoImpl;
	}

	public void setVioFlowDaoImpl(IBaseDao vioFlowDaoImpl) {
		this.vioFlowDaoImpl = vioFlowDaoImpl;
	}

	public List getVioDetail(String hphm) {
		String sql="select * from drv_admin.vio_violation where hphm='"+hphm+"'";
		return this.vioFlowDaoImpl.getAll(sql);
	}

	public List getVioUnProcessDetail(String hphm) {
		String sql="select * from drv_admin.vio_violation where jkbj='0' and hphm='"+hphm+"'";
		return this.vioFlowDaoImpl.getAll(sql);
	}

	public void saveProcessVioDetail(String[] jdsbh) {
		// TODO 处理未发的内容并缴费

	}

	

	public List getVehList(String sfzmhm) {
		String sql="select t.* from drv_admin.vehicle t where t.sfzmhm='"+sfzmhm+"'";
		return this.vehicleDaoImpl.getAll(sql);
	}

	public VehicleObject getVehicle(String xh) {
		String sql="select * from drv_admin.vehicle where xh='"+xh+"'";
		return (VehicleObject)this.vehicleDaoImpl.executeObject(sql);
	}

}
