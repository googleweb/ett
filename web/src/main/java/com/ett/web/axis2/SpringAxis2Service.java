package com.ett.web.axis2;

import org.apache.log4j.Logger;

public class SpringAxis2Service {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(SpringAxis2Service.class);
	
	public String hello(String name)
	{
		logger.debug("传递的参数的姓名为:"+name);
		return "hello "+name+"!";
	}

}
