/**
 * 
 */
package com.ett.self;

import org.apache.log4j.Logger;

/**
 * @author austin
 *
 */
public class TestStruts2Action {
	/**
 * Logger for this class
 */
private static final Logger logger = Logger.getLogger(TestStruts2Action.class);
	
	private String name;
	
	private String dep;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}
	public String execute()
	{
		return test();
	}
	
	public String test()
	{
		logger.debug("获取的用户名："+name);
		logger.debug("获取的部门名"+dep);
		return "success";
	}

}
