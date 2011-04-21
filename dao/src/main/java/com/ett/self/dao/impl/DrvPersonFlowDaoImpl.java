package com.ett.self.dao.impl;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ett.dao.GenericJdbcTemplateImpl;
import com.ett.self.model.DrvPersonFlowObject;

public class DrvPersonFlowDaoImpl extends GenericJdbcTemplateImpl<DrvPersonFlowObject>  {

	@Override
	public RowMapper defaultRowMapper() {
		return new RowMapper() {   
			  
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {   
            	DrvPersonFlowObject demo = new DrvPersonFlowObject();   
            	demo.setSfzmhm(rs.getString("sfzmhm"));
	            demo.setDabh(rs.getString("dabh"));
	            demo.setJssj(rs.getDate("jssj"));
	            demo.setKssj(rs.getDate("kssj"));
	            demo.setXm(rs.getString("xm"));
	            demo.setYwlx(rs.getString("ywlx"));
	            demo.setYwyy(rs.getString("ywyy"));
	            demo.setZjcx(rs.getString("zjcx"));
                return demo;   
            }   
  
        };   
	}

	

}
