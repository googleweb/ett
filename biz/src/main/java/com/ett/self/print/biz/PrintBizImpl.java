/**
 * 
 */
package com.ett.self.print.biz;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.ett.AbstractBaseDrvBiz;
import com.ett.dao.IBaseDao;
import com.ett.self.dao.IIdGenerator;
import com.ett.self.model.DrvPersonFlowObject;
import com.ett.self.model.PrintObject;

/**
 * @author austin
 * 打印业务的实现
 */
public class PrintBizImpl extends AbstractBaseDrvBiz implements IPrintBiz {
	
	

	private IBaseDao drvPersonFlowDaoImpl;
	
	private IBaseDao vehicleFlowDaoImpl;
	
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

	public String getVioFlow() {
		return VioFlow;
	}

	private IBaseDao vioFlowDaoImpl;
	
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(PrintBizImpl.class);
	
	
	
	/**
	 * 查询返回的List 
	 */
	protected List lists;
	
	
	protected PrintObject searchPrinterFromSql(String sql,String lsh){
		String queryStr=MessageFormat.format(sql,lsh);
		return this.searchPrinterFromSql(queryStr);
	}
	
	private final String PersonFlow="select '''' \"ywyy\",'''' \"hphm\",'''' \"fee\", a.zjcx  \"zjcx\",sysdate \"slrq\",'''' \"jdsbh\"," +
	"a.lsh,b.dmmc1 \"ywlx\",a.dabh,a.sfzmhm,a.xm,a.kssj \"yyrq\",a.jssj \"ksrq\" from drv_admin.drv_flow a left join"
	+ " drv_admin.drv_code b on a.ywlx=b.dmz and b.dmlb=8 where a.sfzmhm=''{0}'' order by a.lsh desc";
	private final String CarFlow="select '''' \"ywyy\",'''' \"jdsbh\",'''' \"sfzmhm\",'''' \"zjcx\",'''' \"dabh\",'''' \"fee\", sqrq \"yyrq\",bjrq \"ksrq\"," +
	"a.lsh,b.dmmc1 \"ywlx\",a.syr \"xm\",a.hphm,a.sqrq \"slrq\" from drv_admin.veh_flow a left join "
	 +" drv_admin.drv_code b on a.ywlx=b.dmz and b.dmlb=8 where exists(select 1 from drv_admin.vehicle m where m.hphm=a.hphm and m.sfzmhm=''{0}'')  order by lsh desc";
	//TODO 读取医院体检信息列表
	private final String HospitalFlow="select a.tjyymc,a.tjrq \"slrq\",a.dabh,b.xm,b.ywlx,b.ywyy,b.zjcx," +
			"a.lsh,b.sfzmhm,sysdate \"yyrq\",sysdate \"ksrq\",'''' \"fee\",'''' hphm,'''' jdsbh" +
			" from drv_admin.drv_health a left join drv_admin.drv_flow b on a.lsh=b.lsh and b.sfzmhm=''{0}''";
	private final String VioFlow="select a.wfdz \"ywyy\",'''' \"ywlx\",a.fkje \"fee\", wfsj \"yyrq\",wfsj \"ksrq\"," +
	"wfsj \"slrq\",a.wfbh \"lsh\",a.dsr \"xm\",a.hphm,a.jdsbh ,b.sfzmhm,a.znj \"zjcx\",a.wfjfs \"dabh\" from drv_admin.vio_violation a left" +
	" join drv_admin.drivingLicense b on a.jszh=b.sfzmhm where a.jszh=''{0}'' order by wfbh desc";
	
	private final String PersonPrinter="select '''' \"hphm\",'''' \"fee\",'''' \"zjcx\",sysdate \"slrq\",'''' \"jdsbh\"," +
			"a.lsh,b.dmmc1 \"ywlx\",a.dabh,a.sfzmhm,a.xm,a.kssj \"yyrq\",a.jssj \"ksrq\" from drv_admin.drv_flow a left join"
+ " drv_admin.drv_code b on a.ywlx=b.dmz and b.dmlb=8 where a.lsh=''{0}''";
	private final String CarPrinter="select '''' \"jdsbh\",'''' \"sfzmhm\",'''' \"zjcx\",'''' \"dabh\",'''' \"fee\", sysdate \"yyrq\",sysdate \"ksrq\"," +
			"a.lsh,b.dmmc1 \"ywlx\",a.syr \"xm\",a.hphm,a.sqrq \"slrq\" from drv_admin.veh_flow a left join "
 +" drv_admin.drv_code b on a.ywlx=b.dmz and b.dmlb=8 where a.lsh=''{0}''";
	
	//TODO: 医院体检回执单从哪里取数据
	private final String HospitalPrinter="select a.tjyymc ywlx,a.tjrq slrq,a.dabh,b.xm,b.ywlx,b.ywyy," +
			"b.zjcx,a.lsh,b.sfzmhm,sysdate yyrq,sysdate ksrq,'''' fee,'''' hphm,'''' jdsbh" +
			"  from drv_admin.drv_health a left join drv_admin.drv_flow b on a.lsh=b.lsh and a.lsh=''{0}''";
	private final String VioPrinter="select '''' \"ywlx\",'''' \"fee\", sysdate \"yyrq\",sysdate \"ksrq\"," +
			"sysdate \"slrq\",a.wfbh \"lsh\",a.dsr \"xm\",a.hphm,a.jdsbh ,b.sfzmhm,b.zjcx,a.dabh from drv_admin.vio_violation a left join drv_admin.drivingLicense b on a.jszh=b.sfzmhm"
+" where a.wfbh=''{0}''";
	
	protected void searchFlowFromSql(String sql,String idcard){
	
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryStr=MessageFormat.format(sql,idcard);
		log.debug("查询语句为："+queryStr.toString());
		SQLQuery query = session.createSQLQuery(queryStr.toString());
		query.addScalar("ywlx", new org.hibernate.type.StringType());
		query.addScalar("fee", new org.hibernate.type.StringType());
		query.addScalar("ywyy", new org.hibernate.type.StringType());
		query.addScalar("yyrq", new org.hibernate.type.TimestampType());
		query.addScalar("ksrq", new org.hibernate.type.TimestampType());
		query.addScalar("slrq", new org.hibernate.type.TimestampType());
		query.addScalar("lsh", new org.hibernate.type.StringType());
		query.addScalar("xm", new org.hibernate.type.StringType());
		query.addScalar("hphm", new org.hibernate.type.StringType());
		
		query.addScalar("jdsbh", new org.hibernate.type.StringType());
		query.addScalar("sfzmhm", new org.hibernate.type.StringType());
		query.addScalar("zjcx", new org.hibernate.type.StringType());
		query.addScalar("dabh", new org.hibernate.type.StringType());

		query.setResultTransformer(Transformers.aliasToBean(DrvPersonFlowObject.class));
		try {
			tx.begin();
			//query.uniqueResult()
			this.lists = query.list();
			
			if(log.isInfoEnabled())
			{
				log.info("统计语句返回的列表长度为：==》"+lists.size());
			}
			if(this.lists==null||this.lists.size()==0)
			{
				this.lists=new ArrayList();
				
				//this.lists.add(co);
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		//return null;
	}

	/* (non-Javadoc)
	 * @see com.ett.self.print.biz.IPrintBiz#searchPersonFlow(java.lang.String)
	 */
	public List getPersonFlow(String idcard) {
		 this.searchFlowFromSql(PersonFlow, idcard);
		 return this.lists;
	}

	/* (non-Javadoc)
	 * @see com.ett.self.print.biz.IPrintBiz#searchCarFlow(java.lang.String)
	 */
	public List getCarFlow(String idcard) {
		 this.searchFlowFromSql(CarFlow, idcard);
		 return this.lists;
	}

	/* (non-Javadoc)
	 * @see com.ett.self.print.biz.IPrintBiz#searchVioFlow(java.lang.String)
	 */
	public List getVioFlow(String idcard) {
		 this.searchFlowFromSql(VioFlow, idcard);
		 return this.lists;
	}

	/* (non-Javadoc)
	 * @see com.ett.self.print.biz.IPrintBiz#searchHospitalFlow(java.lang.String)
	 */
	public List getHospitalFlow(String idcard) {
		 this.searchFlowFromSql(HospitalFlow, idcard);
		 return this.lists;
	}

	public List getLists() {
		return lists;
	}

	public void setLists(List lists) {
		this.lists = lists;
	}

	public PrintObject getPersonPrintObject(String lsh) {
		return this.searchPrinterFromSql(PersonPrinter,lsh);
	}

	public PrintObject getCarPrintObject(String lsh) {
		return this.searchPrinterFromSql(CarPrinter,lsh);
	}

	public PrintObject getVioPrintObject(String lsh) {
		return this.searchPrinterFromSql(VioPrinter,lsh);
	}

	public PrintObject getHospitalPrintObject(String lsh) {
		return this.searchPrinterFromSql(HospitalPrinter,lsh);
	}

	

}
