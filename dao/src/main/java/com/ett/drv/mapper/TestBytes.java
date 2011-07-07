package com.ett.drv.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ett.drv.mapper.self.ITransactResourceMapper;
import com.ett.drv.mapper.statis.IStatisCoachCarMapper;
import com.ett.drv.mapper.statis.IStatisDriverMapper;
import com.ett.drv.mapper.statis.IStatisKmMapper;
import com.ett.drv.mapper.statis.IStatisSchoolMapper;
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
//			ITransactResourceMapper<TransactResourceModel> trm=se.getMapper(ITransactResourceMapper.class);
//			List<TransactResourceModel> listTr=trm.selectAll();
//			TransactResourceModel tr=(TransactResourceModel)trm.selectEqPk("120110425037090");
//			byte[] bs;
//			for(TransactResourceModel tem: listTr){
//				bs= tem.getAgentIdBackImg();
//				System.err.println(bs.length);
//			}
//			
//			System.err.println(tr.getAgentIdFrontImg().length);
			Calendar cal=Calendar.getInstance();
			Date startDate=cal.getTime();
			cal.add(Calendar.DATE, 30);
			Date endDate=cal.getTime();
			String glbm="454364";
			String fzjg="xdfad";
			String idCard="440103198408241530";
			String hphm="粤A32423";
			int gtTimes=10;
			IStatisCoachCarMapper statisCoachCarMapper=se.getMapper(IStatisCoachCarMapper.class);
			IStatisDriverMapper statisDriverMapper=se.getMapper(IStatisDriverMapper.class);
			IStatisKmMapper statisKmMapper=se.getMapper(IStatisKmMapper.class);
			IStatisSchoolMapper statisSchoolMapper=se.getMapper(IStatisSchoolMapper.class);
			
			statisCoachCarMapper.selectViewCoachCar(fzjg, idCard, hphm);
			statisDriverMapper.selectViewAddreesRepeatGt(fzjg, startDate, endDate, gtTimes);
			statisDriverMapper.selectViewYdKsqkGt(fzjg, startDate, endDate, gtTimes);
			statisDriverMapper.selectViewYdsl(fzjg, glbm, startDate, endDate);
			statisDriverMapper.selectViewZzzRepeatGt(fzjg, startDate, endDate, gtTimes);
			statisKmMapper.selectViewKm3KscsGt(fzjg, startDate, endDate, gtTimes);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
