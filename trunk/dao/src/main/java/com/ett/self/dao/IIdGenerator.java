package com.ett.self.dao;

public interface IIdGenerator {
	
	/**
	 * @return 获取每天最新产生的系统排队号
	 */
	public int getNewId();

}
