package com.ett.visual.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ett.visual.mapper.driver.IDriverFileMapper;
import com.ett.visual.model.driver.DriverFileModel;

public class TestMapper {

	
	public static void main(String[] args){
		String resource = "com/ett/visual/mapper/test.cfg.xml";
		Reader reader=null;
		DriverFileModel driver=new DriverFileModel();
		
		driver.setId("sdf");
		
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession se=sf.openSession();
		IDriverFileMapper mapper=se.getMapper(IDriverFileMapper.class);
		try {
			List<DriverFileModel> list= mapper.selectAll(null);
			driver=list.get(0);
			driver.setRemark("叼你");;
		    mapper.update(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
