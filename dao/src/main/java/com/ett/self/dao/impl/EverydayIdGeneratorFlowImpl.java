/**
 * 
 */
package com.ett.self.dao.impl;

import org.apache.log4j.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ett.self.dao.IIdGenerator;

/**
 * @author austin
 * 每天依据今天的排队号产生，from 表 table_everyday_id_generator
 */
public class EverydayIdGeneratorFlowImpl implements IIdGenerator {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(EverydayIdGeneratorFlowImpl.class);
	
	protected JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see com.ett.self.dao.IIdGenerator#getNewId()
	 */
	public int getNewId() {
		//current_day current_id
		String sql="select * from table_everyday_id_generator where trunc(current_day)=trunc(sysdate)  for update";
		logger.debug("开始执行锁行语句！");
		this.getJdbcTemplate().execute(sql);
		sql="select nvl(max(current_id),0) from table_everyday_id_generator where trunc(current_day)=trunc(sysdate)";
		logger.debug("获取当天排队号的查询语句为->"+sql);
		int i=this.getJdbcTemplate().queryForInt(sql);
		logger.debug("获取当天排队号的结果为->"+i);
		i+=1;
		if(i==1)
		{
			sql="insert into table_everyday_id_generator(current_id,current_day) values("+i+",sysdate)";
		}
		else
		{
			sql="update table_everyday_id_generator set current_day=sysdate,current_id=current_id+1 where trunc(current_day)=trunc(sysdate)";
		}
		logger.debug("更新当天的排队号最大值的语句为->"+sql);
		int m=this.getJdbcTemplate().update(sql);
		logger.debug("更新当天的排队号结果影响的行数为->"+m);
		return i;
	}

}
