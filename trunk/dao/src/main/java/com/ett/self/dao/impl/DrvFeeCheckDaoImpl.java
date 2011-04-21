/**
 * 
 */
package com.ett.self.dao.impl;

import org.apache.log4j.Logger;

import org.springframework.jdbc.core.RowMapper;

import com.ett.dao.jdbc.AbstractJdbcTemplateDao;
import com.ett.drvinterface.entity.DrvCheckRequest;
import com.ett.drvinterface.entity.VehCheckRequest;
import com.ett.self.dao.IDrvFeeCheckDao;

/**
 * @author austin
 *
 */
public class DrvFeeCheckDaoImpl extends AbstractJdbcTemplateDao implements
IDrvFeeCheckDao {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(DrvFeeCheckDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.ett.self.dao.IFeeCheckDao#deleteVehCheck(com.ett.drvinterface.entity.VehCheckRequest)
	 */
	public void deleteVehCheck(VehCheckRequest request) {
		String sql="delete from drv_admin.VEH_VALIDATE where lsh in "+toInCondition(request.getLsh());
		logger.debug("执行删除veh_validate的记录:"+sql);
		this.getJdbcTemplate().execute(sql);

	}
	
	public String toInCondition(String lsh)
	{
		StringBuffer sb=new StringBuffer(" (");
		String[] strs=lsh.split(",");
		for(int i=0;i<strs.length;i++)
		{
			if(strs[i].length()>0)
				sb.append("'"+strs[i]+"',");
		}
		sb.append("'-1')");
		return sb.toString();
		
	}

	/* (non-Javadoc)
	 * @see com.ett.self.dao.IFeeCheckDao#deleteDrvCheck(com.ett.drvinterface.entity.DrvCheckRequest)
	 */
	public void deleteDrvCheck(DrvCheckRequest request) {
		String sql="delete from drv_admin.drv_Check where lsh in "+toInCondition(request.getLsh());
		logger.debug("执行删除drv_Check的记录:"+sql);
		this.getJdbcTemplate().execute(sql);

	}
	
	

	/* (non-Javadoc)
	 * @see com.ett.dao.jdbc.AbstractJdbcTemplateDao#defaultRowMapper()
	 */
	@Override
	public RowMapper defaultRowMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
