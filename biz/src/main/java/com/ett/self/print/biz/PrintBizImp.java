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

import com.ett.biz.AbstractBaseDrvBiz;
import com.ett.common.exception.ObjectDontExistException;
import com.ett.self.print.model.DrvFlowObject;
import com.ett.self.print.model.PrintObject;

/**
 * @author austin
 * 打印业务的实现
 */
public class PrintBizImp extends AbstractBaseDrvBiz implements IPrintBiz {
	/**
	 * Logger for this class
	 */
	private static final Logger log = Logger.getLogger(PrintBizImp.class);
	
	private final String PersonFlow="select '''' \"fee\",'''' \"zjcx\",sysdate \"slrq\",'''' \"jdsbh\"," +
	"a.lsh,b.dmmc1 \"ywlx\",a.dabh,a.sfzmhm,a.xm,a.kssj \"yyrq\",a.jssj \"ksrq\" from drv_admin.drv_flow a left join"
	+ " drv_admin.drv_code b on a.ywlx=b.dmz and b.dmlb=8 order by a.lsh desc";
	private final String CarFlow="select '''' \"jdsbh\",'''' \"sfzmhm\",'''' \"zjcx\",'''' \"dabh\",'''' \"fee\", sysdate \"yyrq\",sysdate \"ksrq\"," +
	"a.lsh,b.dmmc1 \"ywlx\",a.syr \"xm\",a.hphm,a.sqrq \"slrq\" from drv_admin.veh_flow a left join "
	 +" drv_admin.drv_code b on a.ywlx=b.dmz and b.dmlb=8 order by lsh desc";
	//TODO 读取医院体检信息列表
	private final String HospitalFlow="select  lsh,sfzmhm,xm,ywlx \"ywlx\",ywyy \"ywyy\",kssj,jssj from drv_admin.drv_flow" +
	" t where t.sfzmhm=''{0}'' order by kssj desc";
	private final String VioFlow="select '''' \"ywlx\",'''' \"fee\", sysdate \"yyrq\",sysdate \"ksrq\"," +
	"sysdate \"slrq\",a.wfbh \"lsh\",a.dsr \"xm\",a.hphm,a.jdsbh ,b.sfzmhm,b.zjcx,a.dabh from drv_admin.vio_violation a left" +
	" join drv_admin.drivingLicense b on a.jszh=b.sfzmhm order by wfbh desc";
	
	private final String PersonPrinter="select '''' \"fee\",'''' \"zjcx\",sysdate \"slrq\",'''' \"jdsbh\"," +
			"a.lsh,b.dmmc1 \"ywlx\",a.dabh,a.sfzmhm,a.xm,a.kssj \"yyrq\",a.jssj \"ksrq\" from drv_admin.drv_flow a left join"
+ " drv_admin.drv_code b on a.ywlx=b.dmz and b.dmlb=8 where a.lsh=''{0}''";
	private final String CarPrinter="select '''' \"jdsbh\",'''' \"sfzmhm\",'''' \"zjcx\",'''' \"dabh\",'''' \"fee\", sysdate \"yyrq\",sysdate \"ksrq\"," +
			"a.lsh,b.dmmc1 \"ywlx\",a.syr \"xm\",a.hphm,a.sqrq \"slrq\" from drv_admin.veh_flow a left join "
 +" drv_admin.drv_code b on a.ywlx=b.dmz and b.dmlb=8 where a.lsh=''{0}''";
	
	//TODO: 医院体检回执单从哪里取数据
	private final String HospitalPrinter="select  lsh,sfzmhm,xm,ywlx \"ywlx\",ywyy \"ywyy\",kssj,jssj from drv_admin.drv_flow" +
	" t where t.sfzmhm=''{0}'' order by kssj desc";
	private final String VioPrinter="select '''' \"ywlx\",'''' \"fee\", sysdate \"yyrq\",sysdate \"ksrq\"," +
			"sysdate \"slrq\",a.wfbh \"lsh\",a.dsr \"xm\",a.hphm,a.jdsbh ,b.sfzmhm,b.zjcx,a.dabh from drv_admin.vio_violation a left join drv_admin.drivingLicense b on a.jszh=b.sfzmhm"
+" where a.wfbh=''{0}''";
	
	/**
	 * 查询返回的List 
	 */
	protected List lists;
	
	
	protected PrintObject searchPrinterFromSql(String sql,String lsh){
		
		List listTmp=new ArrayList();
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryStr=MessageFormat.format(sql,lsh);
		log.debug("查询语句为："+queryStr.toString());
		SQLQuery query = session.createSQLQuery(queryStr.toString());
		query.addScalar("ywlx", new org.hibernate.type.StringType());
		query.addScalar("fee", new org.hibernate.type.StringType());
		query.addScalar("ywlx", new org.hibernate.type.StringType());
		query.addScalar("yyrq", new org.hibernate.type.DateType());
		query.addScalar("ksrq", new org.hibernate.type.DateType());
		query.addScalar("slrq", new org.hibernate.type.TimeType());
		query.addScalar("lsh", new org.hibernate.type.StringType());
		query.addScalar("xm", new org.hibernate.type.StringType());
		query.addScalar("hphm", new org.hibernate.type.StringType());
		
		query.addScalar("jdsbh", new org.hibernate.type.StringType());
		query.addScalar("sfzmhm", new org.hibernate.type.StringType());
		query.addScalar("zjcx", new org.hibernate.type.StringType());
		query.addScalar("dabh", new org.hibernate.type.StringType());

		query.setResultTransformer(Transformers.aliasToBean(PrintObject.class));
		try {
			tx.begin();
			//query.uniqueResult()
			listTmp = query.list();
			
			if(log.isInfoEnabled())
			{
				log.info("统计语句返回的列表长度为：==》"+lists.size());
			}
			if(listTmp.size()==0)
			{
				throw new ObjectDontExistException("找不到流水号为:"+lsh+"的打印对象");
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			if (tx != null) {
				tx.rollback();
			}
			throw new ObjectDontExistException(e);
		} finally {
			session.close();
		}
		return (PrintObject)listTmp.get(0);
	}
	
	protected void searchFlowFromSql(String sql,String idcard){
	
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryStr=MessageFormat.format(sql,idcard);
		log.debug("查询语句为："+queryStr.toString());
		SQLQuery query = session.createSQLQuery(queryStr.toString());
		query.addScalar("ywlx", new org.hibernate.type.StringType());
		query.addScalar("fee", new org.hibernate.type.StringType());
		query.addScalar("ywlx", new org.hibernate.type.StringType());
		query.addScalar("yyrq", new org.hibernate.type.DateType());
		query.addScalar("ksrq", new org.hibernate.type.DateType());
		query.addScalar("slrq", new org.hibernate.type.TimeType());
		query.addScalar("lsh", new org.hibernate.type.StringType());
		query.addScalar("xm", new org.hibernate.type.StringType());
		query.addScalar("hphm", new org.hibernate.type.StringType());
		
		query.addScalar("jdsbh", new org.hibernate.type.StringType());
		query.addScalar("sfzmhm", new org.hibernate.type.StringType());
		query.addScalar("zjcx", new org.hibernate.type.StringType());
		query.addScalar("dabh", new org.hibernate.type.StringType());

		query.setResultTransformer(Transformers.aliasToBean(DrvFlowObject.class));
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
	public List searchPersonFlow(String idcard) {
		 this.searchFlowFromSql(PersonFlow, idcard);
		 return this.lists;
	}

	/* (non-Javadoc)
	 * @see com.ett.self.print.biz.IPrintBiz#searchCarFlow(java.lang.String)
	 */
	public List searchCarFlow(String idcard) {
		 this.searchFlowFromSql(CarFlow, idcard);
		 return this.lists;
	}

	/* (non-Javadoc)
	 * @see com.ett.self.print.biz.IPrintBiz#searchVioFlow(java.lang.String)
	 */
	public List searchVioFlow(String idcard) {
		 this.searchFlowFromSql(VioFlow, idcard);
		 return this.lists;
	}

	/* (non-Javadoc)
	 * @see com.ett.self.print.biz.IPrintBiz#searchHospitalFlow(java.lang.String)
	 */
	public List searchHospitalFlow(String idcard) {
		 this.searchFlowFromSql(HospitalFlow, idcard);
		 return this.lists;
	}

	public List getLists() {
		return lists;
	}

	public void setLists(List lists) {
		this.lists = lists;
	}

	public PrintObject searchPersonPrintObject(String lsh) {
		return this.searchPrinterFromSql(PersonPrinter,lsh);
	}

	public PrintObject searchCarPrintObject(String lsh) {
		return this.searchPrinterFromSql(CarPrinter,lsh);
	}

	public PrintObject searchVioPrintObject(String lsh) {
		return this.searchPrinterFromSql(VioPrinter,lsh);
	}

	public PrintObject searchHospitalPrintObject(String lsh) {
		return this.searchPrinterFromSql(HospitalPrinter,lsh);
	}

}
