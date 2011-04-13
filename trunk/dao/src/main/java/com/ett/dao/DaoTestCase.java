package com.ett.dao;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 * Dao测试基类,继承于AbstractTransactionalDataSourceSpringContextTests.
 * 该类带OpenSessionInTest与事务默认回滚能力,
 * 并带有一个jdbcTemplate变量可在同一事务内检查数据库变化.
 * 实现了基类的getConfigLocations()函数,设置默认的applicationContext, 
 * 在子类可重载此函数以减少载入的applicaitonContext.xml,加快测试速度.
 * 设置AUTOWIRE_BY_NAME ,因为Spring的测试基类默认为BY_TYPE,在有多个相同类型的Bean时冲突.
 * */
public abstract class DaoTestCase extends AbstractTransactionalDataSourceSpringContextTests {
	/**
	 * spring配置文件放置路径
	 */
	private static final String SpringConfigPath="classpath*:spring.xml";
	
	
	/**m
	 * 测试需要特别设置的配置文件
	 */
	private static final String SpringTestPath="classpath:**/spring/test/*.xml";
	
	/**
	 * 测试需要特别设置的配置文件
	 */
	private static final String OtherPath="classpath:**/applicationContext-*.xml";
	
	/**
	 * @see AbstractTransactionalDataSourceSpringContextTests#getConfigLocations()
	 */
	@Override
	protected String[] getConfigLocations() {
		setAutowireMode(AUTOWIRE_BY_NAME);
		this.setPopulateProtectedVariables(true);
		return new String[]{SpringConfigPath,SpringTestPath,OtherPath};//, SpringTestPath,OtherPath
	}
}
