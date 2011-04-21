package com.ett.self.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ett.dao.GenericJdbcTemplateImpl;
import com.ett.model.DrvUser;
import com.ett.self.model.VehicleObject;

public class VehicleDaoImpl extends GenericJdbcTemplateImpl<VehicleObject>  {

	@Override
	public RowMapper defaultRowMapper() {
		 return new RowMapper() {   
			  
	            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {   
	            	VehicleObject demo = new VehicleObject();  
	            	//System.out.println("开始执行类型转换！");
	            	demo.setSfzmhm(rs.getString("sfzmhm"));
	            	
		         
		            demo.setClpp1(rs.getString("clpp1"));
		            demo.setClsbdh(rs.getString("clsbdh"));
		            demo.setClxh(rs.getString("clxh"));
		            
		            demo.setDjrq(rs.getDate("djrq"));
		            demo.setCcdjrq(rs.getDate("ccdjrq"));
		            demo.setYxqz(rs.getDate("yxqz"));
		            
		            demo.setHphm(rs.getString("hphm"));
		           demo.setSyr(rs.getString("syr"));
		           demo.setXh(rs.getString("xh"));
		           
		           demo.setZt(rs.getString("zt"));
	                return demo;   
	            }   
	  
	        };   
	}



}
