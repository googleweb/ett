package com.ett.visual.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ett.visual.mapper.admin.IRoleMapper;
import com.ett.visual.model.admin.RoleModel;

public class TestMapper {

	
	public static void main(String[] args){
		
		String resource = "com/ett/visual/mapper/mybatis3.test.xml";
		Reader reader=null;
		SqlSessionFactory sf=null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sf=new SqlSessionFactoryBuilder().build(reader);
			IRoleMapper<RoleModel> roleMapper=sf.openSession().getMapper(IRoleMapper.class);
			List list= roleMapper.selectAll();
			System.out.println(((RoleModel)list.get(0)).toJson().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
