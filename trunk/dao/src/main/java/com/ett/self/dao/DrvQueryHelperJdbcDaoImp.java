package com.ett.self.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ett.dao.jdbc.AbstractJdbcTemplateDao;
import com.ett.model.ComboxObject;
import com.ett.model.DrvUser;

public class DrvQueryHelperJdbcDaoImp extends AbstractJdbcTemplateDao implements IDrvQueryHelperDao {

	public List<ComboxObject> getDict(String xtlb, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ComboxObject> getDict(String xtlb, String type, String glbm) {
		// TODO Auto-generated method stub
		return null;
	}
	private final String Fianl_GetDrvUser="select a.sfzmhm,a.xm,a.xb,a.csrq,a.lxzsxxdz,a.lxdh,a.sjhm,b.lsh"
		+" from drv_admin.person a left join drv_admin.drv_flow b on a.sfzmhm=b.sfzmhm  and" +
				" (b.jssj is null or b.jssj>sysdate) and b.glbm like '";
	@SuppressWarnings("unchecked")
	public DrvUser getDrvUser(String idcard, String glbm) {
		return (DrvUser) this.jdbcTemplate.queryForObject(Fianl_GetDrvUser+glbm+"%' and b.ywlx in ('A','B') where a.sfzmhm=?", 
                new Object[] { idcard }, drvUserRowMapper()); 
	}
	
	private RowMapper drvUserRowMapper() {   
        return new RowMapper() {   
  
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {   
            	DrvUser demo = new DrvUser();   
              demo.setSfzmhm(rs.getString("sfzmhm"));
              demo.setXm(rs.getString("xm"));
              //demo.setXb(rs.getInt("xb"));
              demo.setCsrq(rs.getDate("csrq"));
              demo.setLxzsxxdz(rs.getString("lxzsxxdz"));
              demo.setLxdh(rs.getString("lxdh"));
              demo.setSjhm(rs.getString("sjhm"));
              demo.setLsh(rs.getString("lsh"));
                return demo;   
            }   
  
        };   
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

	@Override
	public RowMapper defaultRowMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
