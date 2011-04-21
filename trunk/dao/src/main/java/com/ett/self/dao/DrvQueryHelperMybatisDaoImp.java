package com.ett.self.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ett.model.ComboxObject;
import com.ett.model.DrvUser;
import com.ett.self.dao.mapper.DrvUserMapper;


public class DrvQueryHelperMybatisDaoImp extends SqlSessionDaoSupport
 implements IDrvQueryHelperDao {
	

	
	
	private DrvUserMapper userMapper;

	public DrvUserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(DrvUserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public List<ComboxObject> getDict(String xtlb, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ComboxObject> getDict(String xtlb, String type, String glbm) {
		// TODO Auto-generated method stub
		return null;
	}

	public DrvUser getDrvUser(String idcard, String glbm) {
		//return (DrvUser)getSqlMapClientTemplate().queryForObject("getDrvUser", new Object[]{idcard,glbm});
		//return (DrvUser)getSqlMapClientTemplate().queryForObject("getDrvUser", idcard);
		//userMapper.
		return (DrvUser)this.getSqlSession().selectOne("getDrvUser", idcard);
		//return userMapper.getDrvUser(idcard);
	}

	public DrvUser getUserWithExamCard(String idcard, String glbm) {
		// TODO Auto-generated method stub
		return null;
	}

	public DrvUser getUserWithVehile(String idcard, String glbm) {
		// TODO Auto-generated method stub
		return null;
	}

	public DrvUser getUserWithLicense(String idcard, String glbm) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
