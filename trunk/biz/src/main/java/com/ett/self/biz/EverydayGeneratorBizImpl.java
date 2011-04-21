/**
 * 
 */
package com.ett.self.biz;

import com.ett.self.dao.IIdGenerator;

/**
 * @author austin
 *
 */
public class EverydayGeneratorBizImpl implements IIdGeneratorBiz {
	
	IIdGenerator iIdGenerator;
	

	public IIdGenerator getiIdGenerator() {
		return iIdGenerator;
	}


	public void setiIdGenerator(IIdGenerator iIdGenerator) {
		this.iIdGenerator = iIdGenerator;
	}


	/* (non-Javadoc)
	 * @see com.ett.self.biz.IIdGeneratorBiz#createNewId()
	 */
	public int createNewId() {
		return this.iIdGenerator.getNewId();
	}

}
