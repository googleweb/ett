/**
 * 
 */
package com.ett.self.fee.biz;

import java.util.Date;
import java.util.List;

import com.ett.AbstractBaseBiz;
import com.ett.dao.IBaseDao;
import com.ett.drv.biz.IFeeCheckHelper;
import com.ett.drvinterface.IDrvFeeCheckInterface;
import com.ett.drvinterface.entity.DrvCheckRequest;
import com.ett.drvinterface.entity.VehCheckRequest;
import com.ett.model.DrvUser;
import com.ett.self.fee.model.FeeObject;
import com.ett.self.model.SelfDeviceObject;

/**
 * @author austin
 *
 */
public  class FeeBizImpl extends AbstractBaseBiz implements IFeeBiz {
	
	private IBaseDao drvPersonFlowDaoImpl;
	
	private IBaseDao feeCheckRecordDaoImpl;
	
	private IBaseDao vehicleFlowDaoImpl;
	
	private IFeeCheckHelper iFeeCheckHelper;
	
	public IBaseDao getFeeCheckRecordDaoImpl() {
		return feeCheckRecordDaoImpl;
	}

	public void setFeeCheckRecordDaoImpl(IBaseDao feeCheckRecordDaoImpl) {
		this.feeCheckRecordDaoImpl = feeCheckRecordDaoImpl;
	}

	

	public IBaseDao getDrvPersonFlowDaoImpl() {
		return drvPersonFlowDaoImpl;
	}

	public void setDrvPersonFlowDaoImpl(IBaseDao drvPersonFlowDaoImpl) {
		this.drvPersonFlowDaoImpl = drvPersonFlowDaoImpl;
	}

	public IBaseDao getVehicleFlowDaoImpl() {
		return vehicleFlowDaoImpl;
	}

	public void setVehicleFlowDaoImpl(IBaseDao vehicleFlowDaoImpl) {
		this.vehicleFlowDaoImpl = vehicleFlowDaoImpl;
	}

	public IBaseDao getVioFlowDaoImpl() {
		return vioFlowDaoImpl;
	}

	public void setVioFlowDaoImpl(IBaseDao vioFlowDaoImpl) {
		this.vioFlowDaoImpl = vioFlowDaoImpl;
	}

	private IBaseDao vioFlowDaoImpl;

	/* (non-Javadoc)
	 * @see com.ett.self.fee.biz.IFeeBiz#feePerson(java.lang.String)
	 */
	public void saveFeePerson(DrvUser user,SelfDeviceObject device,FeeObject fee) {
		DrvCheckRequest request=new DrvCheckRequest();
		request.setDeptCode(device.getGlbm());
		request.setLsh(fee.getFeeLsh());
		request.setUserCode(user.getXm());
		request.setUserIp(device.getIp1());
		this.iFeeCheckHelper.deleteDrvCheck(request);
		String lsh=fee.getFeeLsh();
		//FeeObject fee=new FeeObject();
		fee.setCreateIp(device.getIp1());
		fee.setCreateTime(new Date());
		//fee.setBusType("驾驶证业务费用");
		fee.setCreator(user.getXm());
		fee.setDetail("缴纳流水号为 :"+lsh+"的费用");
		//fee.setFeeType("PersonFee");
		//fee.setMoney(money);
		fee.setSfzmhm(user.getSfzmhm());
		fee.setXm(user.getXm());
		this.getBaseDao().save(fee);
       
	}

	/* (non-Javadoc)
	 * @see com.ett.self.fee.biz.IFeeBiz#feeVio(java.lang.String)
	 */
	public void saveFeeVio(DrvUser user,SelfDeviceObject device,FeeObject fee) {
		StringBuffer sb=new StringBuffer();
		String lsh=fee.getFeeLsh();
		String[] wfbhs=lsh.split(",");
		for(int i=0;i<wfbhs.length;i++)
		{
			sb.append(wfbhs[i]+",");
		}
		sb.append("-1");
		String sql="update drv_admin.vio_violation set gxsj=sysdate,clbj='1' where wfbh in ("+sb.toString()+")";
		this.feeCheckRecordDaoImpl.batchUpdate(sql);
		fee.setCreateIp(device.getIp1());
		fee.setCreateTime(new Date());
		//fee.setBusType("违法业务费用");
		fee.setCreator(user.getXm());
		fee.setDetail("缴纳流水号为 :"+lsh+"的费用");
		//fee.setFeeType("VioFee");
		//fee.setMoney(money);
		fee.setSfzmhm(user.getSfzmhm());
		fee.setXm(user.getXm());
		this.getBaseDao().save(fee);

	}

	/* (non-Javadoc)
	 * @see com.ett.self.fee.biz.IFeeBiz#feeVehicle(java.lang.String)
	 */
	public void saveFeeVehicle(DrvUser user,SelfDeviceObject device,FeeObject fee) {
		logger.debug(user.getXm()+"在机器"+device.getMachineName()+"开始缴纳"+fee.getMoney()+"费用！");
		VehCheckRequest request=new VehCheckRequest();
		request.setDeptCode(device.getGlbm());
		request.setLsh(fee.getFeeLsh());
		request.setUserCode(user.getXm());
		request.setUserIp(device.getIp1());
		this.iFeeCheckHelper.deleteVehCheck(request);
		String lsh=fee.getFeeLsh();
		//FeeObject fee=new FeeObject();
		fee.setCreateIp(device.getIp1());
		fee.setCreateTime(new Date());
		//fee.setBusType(busType)
		//fee.setBusType("机动车业务费用");
		fee.setCreator(user.getXm());
		fee.setDetail("缴纳流水号为 :"+lsh+"的费用");
		//fee.setFeeType("VehFee");
		//fee.setMoney(money);
		fee.setSfzmhm(user.getSfzmhm());
		fee.setXm(user.getXm());
		this.getBaseDao().save(fee);

	}

	public IFeeCheckHelper getiFeeCheckHelper() {
		return iFeeCheckHelper;
	}

	public void setiFeeCheckHelper(IFeeCheckHelper iFeeCheckHelper) {
		this.iFeeCheckHelper = iFeeCheckHelper;
	}

	//TODO 哪些属于未缴费系列
	public List getVehicleFlowList(DrvUser user) {
		//String sql="select * from drv_admin.veh_flow  t where exists(select 1 from drv_admin.vehicle m where m.hphm=t.hphm and  m.sfzmhm='"+sfzmhm+"')";
		//return this.vehicleFlowDaoImpl.getAll(sql);
		String sql="select c.ywyy,c.bz,d.dmmc1 ywlx,c.hphm,'' hpzl,'' jdsbh,c.lsh,c.sfzmhm,c.syr xm from (select b.syr,b.ywlx,b.ywyy,a.bz,a.hcxm," +
				"a.hphm,a.hpzl,a.lsh,'"+user.getSfzmhm()+"' sfzmhm from drv_admin.veh_validate a left join drv_admin.veh_flow" +
						" b on a.lsh=b.lsh  and b.bjrq is null where hcxm='1'  and" +
						" exists(select 1 from drv_admin.vehicle e where e.hphm=b.hphm " +
						"and e.sfzmhm='"+user.getSfzmhm()+"')) c left join drv_admin.drv_code d on c.ywlx=d.dmz and d.dmlb=8";
		logger.debug("查询机动车核实表语句："+sql);
		return this.feeCheckRecordDaoImpl.getAll(sql);
	}

	public List getVioFlowList(DrvUser user) {
		String sql="select * from drv_admin.vio_violation where sfzmhm='"+user.getSfzmhm()+"'";
		logger.debug("查询违法记录表语句："+sql);
		return this.vioFlowDaoImpl.getAll(sql);
		
	}
/*
 demo.setBz(rs.getString("bz"));
            	demo.setHcxm(rs.getString("hcxm"));
            	demo.setHphm(rs.getString("hphm"));
            	demo.setHpzl(rs.getString("hpzl"));
            	demo.setLsh(rs.getString("lsh"));
            	demo.setSfzmhm(rs.getString("sfzmhm")); 
 
 * */
	public List getPersonFlowList(DrvUser user) {
		/*
		String sql="select * from drv_admin.drv_flow where sfzmhm='"+sfzmhm+"'";
		return this.drvPersonFlowDaoImpl.getAll(sql);
		*/
		//String sql="select bz,hcxm,'' hphm,'' hpzl,lsh,'"+user.getSfzmhm()+"' sfzmhm from drv_admin.drv_check where hcxm='1' and lsh='"+user.getLsh()+"'";
		String sql="select c.bz,c.hphm,c.hpzl,'' jdsbh,c.lsh,c.sfzmhm,c.xm,d.dmmc1 ywlx,c.ywyy from " +
				"(select b.ywyy,b.ywlx,a.bz,a.hcxm,'' hphm,'' hpzl,a.lsh," +
				"b.sfzmhm,b.xm from drv_admin.drv_check a left join" +
				" drv_admin.drv_flow b on a.lsh=b.lsh" +
				" and b.sfzmhm='"+user.getSfzmhm()+"'" +
				" and b.jssj is null  where hcxm='1')" +
				" c left join drv_admin.drv_code d on c.ywlx=d.dmz and d.dmlb=8";
		logger.debug("查询驾驶证核实表语句："+sql);
		List list=this.feeCheckRecordDaoImpl.getAll(sql);
		logger.debug("返回的驾驶证核实记录的数据有多少："+list.size());
		return list;
	}
	

}
