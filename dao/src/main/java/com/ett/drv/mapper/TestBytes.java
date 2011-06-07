package com.ett.drv.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ett.drv.mapper.self.ITransactResourceMapper;
import com.ett.drv.model.self.TransactResourceModel;

public class TestBytes {

	
	
	public static void main(String[] agrs){
		
		String resource = "com/ett/drv/mapper/mybatis3.test.xml";
		Reader reader=null;
		SqlSessionFactory sf=null;
		SqlSession se=null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sf=new SqlSessionFactoryBuilder().build(reader);
			se=sf.openSession();
			ITransactResourceMapper<TransactResourceModel> trm=se.getMapper(ITransactResourceMapper.class);
			List<TransactResourceModel> listTr=trm.selectAll();
			TransactResourceModel tr=(TransactResourceModel)trm.selectEqPk("120110425037090");
			byte[] bs;
			for(TransactResourceModel tem: listTr){
				bs= tem.getAgentIdBackImg();
				System.err.println(bs.length);
			}
			
			System.err.println(tr.getAgentIdFrontImg().length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
