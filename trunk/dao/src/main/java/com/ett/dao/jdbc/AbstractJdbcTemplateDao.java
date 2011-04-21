/**
 * 
 */
package com.ett.dao.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author austin
 * 
 */
public abstract class AbstractJdbcTemplateDao {
	
	protected JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void execute(String sql)
	{
		this.jdbcTemplate.execute(sql);
		
	}
	
	
	
	public abstract RowMapper defaultRowMapper();
	
	/*
	@Override  
    public Demo getById(int id) {   
        return (Demo) this.jdbcTemplate.queryForObject(   
                "select id,name,unitPrice from demo d where d.id = ?",   
                new Integer[] { id }, demoRowMapper());   
    }   
  
    @Override  
    public List<Demo> getAll() {   
        return this.jdbcTemplate.query("select id,name,unitPrice from demo",   
                demoRowMapper());   
    }   
  
    private RowMapper demoRowMapper() {   
        return new RowMapper() {   
  
            @Override  
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {   
                Demo demo = new Demo();   
                demo.setId(rs.getInt("id"));   
                demo.setName(rs.getString("name"));   
                demo.setUnitPrice(rs.getFloat("unitPrice"));   
                return demo;   
            }   
  
        };   
    }  
    
     */


}
