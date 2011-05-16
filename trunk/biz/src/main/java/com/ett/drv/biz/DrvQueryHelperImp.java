/**
 * 
 */
package com.ett.drv.biz;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.ett.common.exception.ObjectDontExistException;
import com.ett.dao.IBaseDao;
import com.ett.model.ComboxObject;
import com.ett.model.DrvUser;

/**
 * @author austin
 * 仅供查询统一版的数据库使用
 */
public class DrvQueryHelperImp implements IDrvQueryHelper {
   private DrvUser user;
	
	
	public DrvUser getUser() {
		return user;
	}

	public void setUser(DrvUser user) {
		this.user = user;
	}
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DrvQueryHelperImp.class);
	
	private IBaseDao baseDaoDrv;

	public IBaseDao getBaseDaoDrv() {
		return baseDaoDrv;
	}

	public void setBaseDaoDrv(IBaseDao baseDaoDrv) {
		this.baseDaoDrv = baseDaoDrv;
	}
	
	private final String DictSql="select distinct dmsm1 \"text\",dmz \"value\" from drv_admin.frm_code m where m.xtlb=''{0}'' and m.dmlb=''{1}''";
	private final String DictSqlWithGlbm="select distinct dmsm1 \"text\",dmz \"value\" from drv_admin.frm_code m where m.xtlb=''{0}'' and m.dmlb=''{1}'' and m.kybm like ''%{2}%''";
	
	public List<ComboxObject>  getDict(String xtlb,String type)
	{
		List<ComboxObject> listTmp=new ArrayList<ComboxObject>();
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryStr=MessageFormat.format(DictSql,xtlb,type);
		logger.debug("查询全局字典对象语句为："+queryStr.toString());
		SQLQuery query = session.createSQLQuery(queryStr.toString());
		query.addScalar("value", new org.hibernate.type.StringType());
		query.addScalar("text", new org.hibernate.type.StringType());
		

		query.setResultTransformer(Transformers.aliasToBean(ComboxObject.class));
		try {
			tx.begin();
			//query.uniqueResult()
			listTmp = query.list();
			
			if(logger.isInfoEnabled())
			{
				logger.info("查询字典对象返回的列表长度为：==》"+listTmp.size());
			}
			if(listTmp.size()==0)
			{
				throw new ObjectDontExistException("找不到的字典对象");
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e);
			if (tx != null) {
				tx.rollback();
			}
			throw new ObjectDontExistException(e);
		} finally {
			session.close();
		}
		return listTmp;
	}
	
	private final String getDrvUser="select distinct a.sfzmhm,a.xm,a.xb,a.csrq,a.lxzsxxdz,a.lxdh,a.sjhm,b.lsh"
		+" from drv_admin.person a left join drv_admin.drv_flow b on a.sfzmhm=b.sfzmhm  and" +
				" (b.jssj is null or b.jssj>sysdate) and b.glbm like ''{1}%'' and b.ywlx in (''A'',''B'') where a.sfzmhm=''{0}''";
		
		private final String getExamCard="select b.dabh,b.zkzmbh,b.zkcx,b.yxqs,b.yxqz,b.jxmc \"jxdm\",b.cclzrq,b.fzrq"
			+" from drv_admin.drv_examCard b where b.sfzmhm=''{0}''";
		private final String getLicense="select b.zjcx zkcx,b.lsh,b.qfrq,b.syrq,b.yxqs,b.yxqz,b.cclzrq,b.jxmc \"jxdm\",b.dabh "
			+" from drv_admin.drivingLicense b where b.sfzmhm=''{0}''";

	public DrvUser getDrvUser(String idcard,String glbm) {
		//System.out.println("注入的Dao");
		logger.debug("查询用户注入的DAO："+this.getBaseDaoDrv());
		logger.debug("查询是否已经存在用户对象："+this.user);
		if(this.user!=null)
		{
			
			return user;
		}
		logger.debug("准备查询身份证明号码为："+idcard+"管理部门代码为："+glbm+"的驾驶人信息！");
		List lists=new ArrayList();
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		logger.debug("打开baseDaoDrv的连接正常！");
		Transaction tx = session.beginTransaction();
		logger.debug("为Session打开一个执行原生sql的事务！");
		String queryStr=MessageFormat.format(getDrvUser,idcard,glbm);
		logger.debug("开始执行查询驾驶人信息的查询语句为："+queryStr.toString());
		SQLQuery query = session.createSQLQuery(queryStr.toString());
		query.addScalar("lsh", new org.hibernate.type.StringType());
		query.addScalar("sfzmhm", new org.hibernate.type.StringType());
		query.addScalar("xb", new org.hibernate.type.IntegerType());
		query.addScalar("xm", new org.hibernate.type.StringType());
		query.addScalar("csrq", new org.hibernate.type.DateType());
		query.addScalar("lxzsxxdz", new org.hibernate.type.StringType());
		query.addScalar("lxdh", new org.hibernate.type.StringType());
		query.addScalar("sjhm", new org.hibernate.type.StringType());

		query.setResultTransformer(Transformers.aliasToBean(DrvUser.class));
		try {
			tx.begin();
			//query.uniqueResult()
			 lists= query.list();
			
			if(logger.isInfoEnabled())
			{
				logger.info("查询驾驶人信息语句返回的列表长度为：==》"+lists.size());
			}
			if(lists.size()==0)
			{
				return null;
				//throw new ObjectDontExistException("没有找到驾驶人信息！");
			}
			
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			logger.info(e);
			if (tx != null) {
				tx.rollback();
			}
			
			throw new ObjectDontExistException(e);
		} finally {
			session.close();
		}
		this.user=(DrvUser)lists.get(0);
		return this.user;
	}

	public DrvUser getUserWithExamCard(DrvUser user) {
		DrvUser tmpuser=user; 
		List lists=new ArrayList();
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryStr=MessageFormat.format(getExamCard,tmpuser.getSfzmhm());
		logger.debug("查询准考证明语句为："+queryStr.toString());
		SQLQuery query = session.createSQLQuery(queryStr.toString());
		query.addScalar("dabh", new org.hibernate.type.StringType());
		query.addScalar("zkzmbh", new org.hibernate.type.StringType());
		query.addScalar("zkcx", new org.hibernate.type.StringType());
		query.addScalar("cclzrq", new org.hibernate.type.TimestampType());
		query.addScalar("fzrq", new org.hibernate.type.TimestampType());
		query.addScalar("jxdm", new org.hibernate.type.StringType());
		
		//GregorianCalendar
		query.addScalar("yxqz", new org.hibernate.type.TimestampType());
		query.addScalar("yxqs", new org.hibernate.type.TimestampType());
	

		query.setResultTransformer(Transformers.aliasToBean(DrvUser.class));
		try {
			tx.begin();
			//query.uniqueResult()
			 lists= query.list();
			
			if(logger.isInfoEnabled())
			{
				logger.info("getUserWithExamCard语句返回的列表长度为：==》"+lists.size());
			}
			if(lists.size()==0)
			{
				return null;
				//throw new ObjectDontExistException("没有找到驾驶人的准考证信息！");
			}
			
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			logger.info(e);
			if (tx != null) {
				tx.rollback();
			}
			
			throw new ObjectDontExistException(e);
		} finally {
			session.close();
		}
		DrvUser tmp=(DrvUser)lists.get(0);
		tmpuser.setDabh(tmp.getDabh());
		tmpuser.setZkzmbh(tmp.getZkzmbh());
		tmpuser.setYxqs(tmp.getYxqs());
		tmpuser.setYxqz(tmp.getYxqz());
		tmpuser.setZkcx(tmp.getZkcx());
		tmpuser.setCclzrq(tmp.getCclzrq());
		tmpuser.setFzrq(tmp.getFzrq());
		tmpuser.setJxdm(tmp.getJxdm());
		return tmpuser;
	}

	public DrvUser getUserWithVehile(DrvUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	public DrvUser getUserWithLicense(DrvUser user) {
		DrvUser tmpuser=user;
		List lists=new ArrayList();
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryStr=MessageFormat.format(getLicense,tmpuser.getSfzmhm());
		logger.debug("查询getUserWithLicense语句为："+queryStr.toString());
		SQLQuery query = session.createSQLQuery(queryStr.toString());
		query.addScalar("zkcx", new org.hibernate.type.StringType());
		query.addScalar("dabh", new org.hibernate.type.StringType());
		query.addScalar("yxqz", new org.hibernate.type.TimestampType());
		query.addScalar("yxqs", new org.hibernate.type.TimestampType());
		query.addScalar("cclzrq", new org.hibernate.type.TimestampType());
		query.addScalar("syrq", new org.hibernate.type.TimestampType());
		query.addScalar("qfrq", new org.hibernate.type.TimestampType());
		query.addScalar("jxdm", new org.hibernate.type.StringType());
	

		query.setResultTransformer(Transformers.aliasToBean(DrvUser.class));
		try {
			tx.begin();
			//query.uniqueResult()
			 lists= query.list();
			
			if(logger.isInfoEnabled())
			{
				logger.info("getUserWithLicense返回的列表长度为：==》"+lists.size());
			}
			if(lists.size()==0)
			{
				return null;
				//throw new ObjectDontExistException("没有找到驾驶人的驾驶证信息！");
			}
			
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			logger.info(e);
			if (tx != null) {
				tx.rollback();
			}
			
			throw new ObjectDontExistException(e);
		} finally {
			session.close();
		}
		DrvUser tmp=(DrvUser)lists.get(0);
		tmpuser.setDabh(tmp.getDabh());
		
		tmpuser.setYxqs(tmp.getYxqs());
		tmpuser.setYxqz(tmp.getYxqz());
		
		tmpuser.setCclzrq(tmp.getCclzrq());
		tmpuser.setQfrq(tmp.getQfrq());
		tmpuser.setSyrq(tmp.getSyrq());
		tmpuser.setJxdm(tmp.getJxdm());
		tmpuser.setZkcx(tmp.getZkcx());
		return tmpuser;
	}

	public List<ComboxObject> getDict(String xtlb, String type, String glbm) {
		List<ComboxObject> listTmp=new ArrayList<ComboxObject>();
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryStr=MessageFormat.format(DictSqlWithGlbm,xtlb,type,glbm);
		logger.debug("查询DictSqlWithGlbm对象语句为："+queryStr.toString());
		SQLQuery query = session.createSQLQuery(queryStr.toString());
		query.addScalar("value", new org.hibernate.type.StringType());
		query.addScalar("text", new org.hibernate.type.StringType());
		

		query.setResultTransformer(Transformers.aliasToBean(ComboxObject.class));
		try {
			tx.begin();
			//query.uniqueResult()
			listTmp = query.list();
			
			if(logger.isInfoEnabled())
			{
				logger.info("查询字典对象返回的列表长度为：==》"+listTmp.size());
			}
			if(listTmp.size()==0)
			{
				return null;
				//throw new ObjectDontExistException("找不到的字典对象");
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e);
			if (tx != null) {
				tx.rollback();
			}
			throw new ObjectDontExistException(e);
		} finally {
			session.close();
		}
		return listTmp;
	}
	
	

}
