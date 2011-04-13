/**
 * 
 */
package test.com.ett.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import com.ett.dao.DaoTestCase;
import com.ett.dao.IBaseDao;
import com.ett.model.Person;
import com.ett.self.print.model.PrintLog;

/**
 * @author austin
 *
 */
public class DependTest extends DaoTestCase {
	
	protected IBaseDao baseDao;
	
	public DependTest()
	{
		
	}
	
	public void testXmlEncode() throws UnsupportedEncodingException
	{
		String result="：<?xml version=\"1.0\" encoding=\"GBK\"?><ROOT><TEMPBEAN><LSH>2101202120883</LSH><KSKM>3</KSKM><XXSJ>0</XXSJ><KSDD>4405001</KSDD><JBR>范文惜</JBR><DLR>4405X</DLR><YKRQ>2011-03-17</YKRQ><KSCC>44051</KSCC><KCHP>粤D41537</KCHP><PXSHRQ>2011-02-14</PXSHRQ><JLY></JLY><SN>33241887000354645126235194204787</SN></TEMPBEAN></ROOT>";
		result=URLEncoder.encode(result, "utf-8");
		System.out.println(result);
		result=URLEncoder.encode("350128198403194910", "utf-8");
		System.out.println(result);
		result=URLEncoder.encode("范文惜", "utf-8");
		System.out.println(result);
		
		
		
		result=URLDecoder.decode("35AAaD0128198403194910", "utf-8");
		System.out.println(result);
		//%e8%8c%83%e6%96%87%e6%83%9c
		result=URLDecoder.decode("%e8%8c%83%e6%96%87%e6%83%9c", "utf-8");
		System.out.println(result);
		
		result=URLDecoder.decode("范文惜", "utf-8");
		System.out.println(result);
		
		
	}

	public void mtestHasMatchUser(){
		System.out.println("baseDao:"+baseDao);
		//Assert.assertNull(baseDao);
		/*
		Employee ee=new Employee();
		//ee.setId(50L);
		ee.setCreator("testcase");
		ee.setCreateIp("127.0.0.1");
		ee.setCreateTime(new Date());
		ee.setDeleted(false);
		ee.setPwd("pwd");
		System.out.println("begininsertEmployee!");
		baseDao.save(ee);
		*/
		Person pp=new Person();
		//ee.setId(50L);
		pp.setCreator("testcase");
		pp.setCreateIp("127.0.0.1");
		pp.setCreateTime(new Date());
		pp.setDeleted(false);
		System.out.println("begininsertPerson!");
		baseDao.save(pp);
		
		
		for(int i=0;i<95;i++)
		{
		PrintLog log=new PrintLog();
		log.setCreator("自助终端");
		log.setCreateIp("127.0.0.1");
		log.setCreateTime(new Date());
		log.setDeleted(false);
		log.setIdCard("350128198303030304");
		log.setYxlsh("1235435345345");
		baseDao.save(log);
		}
		this.setComplete();
		} 
	

}
