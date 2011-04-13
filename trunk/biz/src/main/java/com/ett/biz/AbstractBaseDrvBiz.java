/**
 * 
 */
package com.ett.biz;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.ett.common.exception.ObjectDontExistException;
import com.ett.dao.IBaseDao;
import com.ett.self.ISelfBiz;
import com.ett.self.SelfDeviceUser;

/**
 * @author austin
 * 基本的操作车驾系统的数据库biz对象
 */
public abstract class AbstractBaseDrvBiz extends AbstractBaseBiz implements ISelfBiz {
	private final String getUser="select a.sfzmhm,a.xm,a.xb,a.csrq,a.lxzsxxdz,a.lxdh,a.sjhm"
	+" from drv_admin.person a where sfzmhm=''{0}''";
	
	private final String getExamCard="select b.zkzmbh,b.zkcx,b.yxqs,b.yxqz"
		+" from drv_admin.drv_examCard b where b.sfzmhm=''{0}''";
	
	
	public void getUserExamCard(SelfDeviceUser user) {
		List lists=new ArrayList();
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryStr=MessageFormat.format(getExamCard,user.getSfzmhm());
		logger.debug("查询语句为："+queryStr.toString());
		SQLQuery query = session.createSQLQuery(queryStr.toString());
		
		query.addScalar("zkzmbh", new org.hibernate.type.StringType());
		query.addScalar("zkcx", new org.hibernate.type.StringType());
		
		//GregorianCalendar
		query.addScalar("yxqz", new org.hibernate.type.TimeType());
		query.addScalar("yxqs", new org.hibernate.type.TimeType());
	

		query.setResultTransformer(Transformers.aliasToBean(SelfDeviceUser.class));
		try {
			tx.begin();
			//query.uniqueResult()
			 lists= query.list();
			
			if(logger.isInfoEnabled())
			{
				logger.info("统计语句返回的列表长度为：==》"+lists.size());
			}
			if(lists.size()==0)
			{
				throw new ObjectDontExistException("没有找到驾驶人的准考证信息！");
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
		SelfDeviceUser tmp=(SelfDeviceUser)lists.get(0);
		user.setZkzmbh(tmp.getZkzmbh());
		user.setYxqs(tmp.getYxqs());
		user.setYxqz(tmp.getYxqz());
		user.setZkcx(tmp.getZkcx());
	}

	public void getUserVehile(SelfDeviceUser user) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("rawtypes")
	public SelfDeviceUser getUser(String idcard) {
		List lists=new ArrayList();
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryStr=MessageFormat.format(getUser,idcard);
		logger.debug("查询语句为："+queryStr.toString());
		SQLQuery query = session.createSQLQuery(queryStr.toString());
		query.addScalar("sfzmhm", new org.hibernate.type.StringType());
		query.addScalar("xb", new org.hibernate.type.IntegerType());
		query.addScalar("xm", new org.hibernate.type.StringType());
		query.addScalar("csrq", new org.hibernate.type.DateType());
		query.addScalar("lxzsxxdz", new org.hibernate.type.StringType());
		query.addScalar("lxdh", new org.hibernate.type.StringType());
		query.addScalar("sjhm", new org.hibernate.type.StringType());

		query.setResultTransformer(Transformers.aliasToBean(SelfDeviceUser.class));
		try {
			tx.begin();
			//query.uniqueResult()
			 lists= query.list();
			
			if(logger.isInfoEnabled())
			{
				logger.info("统计语句返回的列表长度为：==》"+lists.size());
			}
			if(lists.size()==0)
			{
				throw new ObjectDontExistException("没有找到驾驶人信息！");
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
		return (SelfDeviceUser)lists.get(0);
	}

	private IBaseDao baseDaoDrv;

	public IBaseDao getBaseDaoDrv() {
		return baseDaoDrv;
	}

	public void setBaseDaoDrv(IBaseDao baseDaoDrv) {
		this.baseDaoDrv = baseDaoDrv;
	}
	
	
}
