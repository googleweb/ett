package com.ett.self.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ett.dao.GenericJdbcTemplateImpl;
import com.ett.self.model.FeeCheckRecordObject;
import com.ett.self.model.VioFlowObject;

public class FeeCheckRecordDaoImpl extends GenericJdbcTemplateImpl<FeeCheckRecordObject> {

	@Override
	public RowMapper defaultRowMapper() {
		return new RowMapper() {   
			  
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {   
            	FeeCheckRecordObject demo = new FeeCheckRecordObject();   
            	demo.setBz(rs.getString("bz"));
            	//demo.setHcxm(rs.getString("hcxm"));
            	demo.setHphm(rs.getString("hphm"));
            	demo.setHpzl(rs.getString("hpzl"));
            	demo.setLsh(rs.getString("lsh"));
            	demo.setSfzmhm(rs.getString("sfzmhm"));
            	demo.setXm(rs.getString("xm"));
            	demo.setYwlx(rs.getString("ywlx"));
            	demo.setYwyy(rs.getString("ywyy"));
            	demo.setJdsbh(rs.getString("jdsbh"));
                return demo;   
            }   
  
        };    
	}

}
