package com.ett.self.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ett.dao.GenericJdbcTemplateImpl;
import com.ett.self.model.VehicleObject;
import com.ett.self.model.VioFlowObject;

public class VioFlowDaoImpl extends GenericJdbcTemplateImpl<VioFlowObject>  {

	@Override
	public RowMapper defaultRowMapper() {
		return new RowMapper() {   
			  
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {   
            	VioFlowObject demo = new VioFlowObject();   
            	demo.setDabh(rs.getString("dabh"));
            	demo.setDsr(rs.getString("dsr"));
            	demo.setFkje(rs.getInt("fkje"));
            	demo.setFzjg(rs.getString("fzjg"));
            	demo.setHphm(rs.getString("hphm"));
            	demo.setJdsbh(rs.getString("jdsbh"));
            	demo.setJszh(rs.getString("jszh"));
            	demo.setWfbh(rs.getString("wfbh"));
            	demo.setWfdd(rs.getString("wfdd"));
            	demo.setWfdz(rs.getString("wfdz"));
            	demo.setWfjfs(rs.getDouble("wfjfs"));
            	demo.setWfsj(rs.getDate("wfsj"));
            	demo.setWfxw(rs.getString("wfxw"));
            	demo.setZnj(rs.getInt("znj"));
                return demo;   
            }   
  
        };   
	}

	

	

}
