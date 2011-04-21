/**
 * 
 */
package com.ett.self.preasign.biz;

import org.apache.log4j.Logger;

import java.util.List;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Date;

import com.ett.AbstractBaseDrvBiz;
import com.ett.common.util.DateUtil;
import com.ett.dao.IBaseDao;
import com.ett.drv.biz.IDrvQueryHelper;
import com.ett.drvinterface.IDrvInterface;
import com.ett.drvinterface.entity.DrvPreasignRequest;
import com.ett.model.DrvUser;
import com.ett.self.dao.ISelfDeviceSnDao;
import com.ett.self.model.PrintObject;
import com.ett.self.model.SelfDeviceObject;
import com.ett.self.model.SelfDeviceSnObject;
import com.ett.self.preasign.model.Km1CheckRecord;
import com.ett.self.preasign.model.Km1PreasignRecord;

/**
 * @author austin
 * 自助终端业务类的实现
 */
public class PreasignBizImpl extends AbstractBaseDrvBiz  implements IPreasignBiz {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(PreasignBizImpl.class);
	
	private ISelfDeviceSnDao iSelfDeviceSnDao;
	
	private IDrvQueryHelper iDrvQueryHelper;
	
	private IDrvInterface iDrvInterface;
	
	private IBaseDao baseDao;
	
	
	
	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public IDrvInterface getiDrvInterface() {
		return iDrvInterface;
	}

	public void setiDrvInterface(IDrvInterface iDrvInterface) {
		this.iDrvInterface = iDrvInterface;
	}

	public IDrvQueryHelper getiDrvQueryHelper() {
		return iDrvQueryHelper;
	}

	public void setiDrvQueryHelper(IDrvQueryHelper iDrvQueryHelper) {
		this.iDrvQueryHelper = iDrvQueryHelper;
	}

	public ISelfDeviceSnDao getiSelfDeviceSnDao() {
		return iSelfDeviceSnDao;
	}

	public void setiSelfDeviceSnDao(ISelfDeviceSnDao iSelfDeviceSnDao) {
		this.iSelfDeviceSnDao = iSelfDeviceSnDao;
	}

	//TODO: 是否当天
	private final String PreasignPrinter="select '''' \"fee\",'''' \"hphm\",'''' \"zjcx\",sysdate \"slrq\",'''' \"jdsbh\"," +
	"a.lsh,'''' \"ywlx\",'''' \"dabh\",a.sfzmhm,a.xm,a.yyrq \"yyrq\",a.ykrq \"ksrq\" from "
	+ " drv_admin.drv_preasign a where a.kskm=1 and a.sfzmhm=''{0}'' and ksdd=''{1}'' and trunc(ykrq)=trunc(to_date(''{2}'',''yyyy-MM-dd'')) order by a.lsh desc";

	public PrintObject getPrintObject(String idcard,String ksdd,Date ykrq) throws ParseException {
		String queryStr=MessageFormat.format(PreasignPrinter,idcard,ksdd,DateUtil.parseString(ykrq));
		return this.searchPrinterFromSql(queryStr);
	}

	public void createPreasignKm1(DrvUser user,SelfDeviceObject device,Date date,String ksddCode) throws ParseException {
	   
		DrvUser tmpUser=this.iDrvQueryHelper.getUserWithLicense(user);
		DrvPreasignRequest request=new DrvPreasignRequest();
		SelfDeviceSnObject snObject=iSelfDeviceSnDao.getSelfDeviceSn(device.getIp1(), SelfDeviceSnObject.Preasign);
		snObject.CopyToBaseDrvRequest(request);
		request.setLsh(tmpUser.getLsh());
		request.setKskm("1");
		request.setJbr(user.getXm());
		request.setYkrq(DateUtil.parseString(date));
		request.setKscc(device.getDefaulKsccCode());
		request.setKsdd(ksddCode);
		request.setDlr(user.getJxdm());
		this.iDrvInterface.setTimeout(device.getDrvInterfaceTimeout());
		this.iDrvInterface.setUrl(device.getDrvInterfaceUrl());
		this.iDrvInterface.preasign(request);
		
		Km1PreasignRecord record=new Km1PreasignRecord();
		record.setCreateIp(device.getIp1());
		record.setCreateTime(new Date());
		record.setJxdm(tmpUser.getJxdm());
		record.setJxmc(tmpUser.getJxmc());
		record.setKsccCode(device.getDefaulKsccCode());
		record.setKsccName(device.getDefaultKsccName());
		record.setKsddCode(ksddCode);
		record.setKsddName("");
		record.setKsrq(date);
		record.setLsh(user.getLsh());
		record.setSfzmhm(user.getSfzmhm());
		record.setXm(user.getXm());
		this.getBaseDao().save(record);
		
		
		
	}

	public boolean getChecked(String idcard, String ksdd, Date ykrq)
			throws ParseException {
		String sql=" from Km1CheckRecord a where ksdd='"+ksdd+"' and to_char(createTime,'yyyy-MM-dd')='"+DateUtil.parseString(ykrq)+"'";
		logger.debug(" 查看是否已经签到过一次了！");
		List list=this.getBaseDao().getAll(sql);
		logger.debug("查看签到结果为："+list);
		return list!=null&&list.size()==1;
	}

	public void createKm1CheckRecord(DrvUser user,SelfDeviceObject device) {
		
		Km1CheckRecord record=new Km1CheckRecord();
		record.setCreateIp(device.getIp1());
		record.setCreateTime(new Date());
		try {
			logger.debug("设置签到时间为："+DateUtil.parseString(record.getCreateTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		record.setCreator(user.getXm());
		record.setKsdd(device.getKsddCode());
		record.setKsddName(device.getKsddName());
		record.setLsh(user.getLsh());
		record.setSfzmhm(user.getSfzmhm());
		record.setXm(user.getXm());
		baseDao.save(record);
		
	}
	

	

	
	

}
