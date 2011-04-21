package com.ett.self.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ett.dao.GenericJdbcTemplateImpl;
import com.ett.self.model.VehicleFlowObject;
import com.ett.self.model.VehicleObject;

public class VehicleFlowDaoImpl extends GenericJdbcTemplateImpl<VehicleFlowObject> {

	@Override
	public RowMapper defaultRowMapper() {
		 return new RowMapper() {   
			  
	            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {   
	            	VehicleFlowObject demo = new VehicleFlowObject();  
	            	//System.out.println("开始执行类型转换！");
	            	
		            demo.setBjrq(rs.getDate("bjrq"));
		            demo.setLsh(rs.getString("lsh"));
		            demo.setSqrq(rs.getDate("sqrq"));
		            demo.setYwlx(rs.getString("ywlx"));
		            demo.setYwyy(rs.getString("ywyy"));
		            demo.setHphm(rs.getString("hphm"));
		           demo.setSyr(rs.getString("syr"));
		           demo.setXh(rs.getString("xh"));

	                return demo;   
	            }   
	  
	        };   
	}

}
