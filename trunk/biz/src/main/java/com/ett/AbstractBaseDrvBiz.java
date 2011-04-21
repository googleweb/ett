/**
 * 
 */
package com.ett;

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
import com.ett.dao.jdbc.AbstractJdbcTemplateDao;
import com.ett.self.ISelfBiz;
import com.ett.self.model.PrintObject;

/**
 * @author austin
 * 基本的操作车驾系统的数据库biz对象
 */
public abstract class AbstractBaseDrvBiz  implements ISelfBiz {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(AbstractBaseDrvBiz.class);


	private IBaseDao baseDaoDrv;

	public IBaseDao getBaseDaoDrv() {
		return baseDaoDrv;
	}

	public void setBaseDaoDrv(IBaseDao baseDaoDrv) {
		this.baseDaoDrv = baseDaoDrv;
	}
	
    protected PrintObject searchPrinterFromSql(String sql){
		
		List listTmp=new ArrayList();
		SessionFactory sessionFactory =this.getBaseDaoDrv().getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		//String queryStr=MessageFormat.format(sql,lsh);
		logger.debug("查询打印对象语句为："+sql.toString());
		SQLQuery query = session.createSQLQuery(sql.toString());
		query.addScalar("ywlx", new org.hibernate.type.StringType());
		query.addScalar("fee", new org.hibernate.type.StringType());
		//query.addScalar("ywyy", new org.hibernate.type.StringType());
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

		query.setResultTransformer(Transformers.aliasToBean(PrintObject.class));
		try {
			tx.begin();
			//query.uniqueResult()
			listTmp = query.list();
			
			if(logger.isInfoEnabled())
			{
				logger.info("查询打印对象返回的列表长度为：==》"+listTmp.size());
			}
			if(listTmp.size()==0)
			{
				return null;
				//throw new ObjectDontExistException("找不到的打印对象");
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
		return (PrintObject)listTmp.get(0);
	}
	
	
}
