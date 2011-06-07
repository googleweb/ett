package com.ett.drv.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ett.drv.mapper.booked.ILimitMapper;
import com.ett.drv.mapper.self.ITransactResourceMapper;
import com.ett.drv.model.booked.BookedLimitModel;
import com.ett.drv.model.self.TransactResourceModel;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.test.IMapperTestCase;

public class TestMapper {

	private static IMapperTestCase<TransactResourceModel> mapperTestCase;
	
	private static Object objTestPk;
	private static ArrayList listTestPk;
	private static TransactResourceModel objTest;
	private static TransactResourceModel q1;
	private static TransactResourceModel q2;
	private static ArrayList<TransactResourceModel> qs;
	
	static {
		String resource = "com/ett/drv/mapper/mybatis3.test.xml";
		Reader reader=null;
		SqlSessionFactory sf=null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sf=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapperTestCase=new IMapperTestCase<TransactResourceModel>(sf,ITransactResourceMapper.class);
		objTestPk="220110520075294";
		listTestPk=new ArrayList();
		listTestPk.add(1);
		listTestPk.add(2);
		q1=new TransactResourceModel();
		q2=new TransactResourceModel();
		q1.setFlowNo("120110425037090");
		q2.setFlowNo("220110520012727");
		qs=new ArrayList();
		qs.add(q1);
		qs.add(q2);
		//fail("Not yet implemented");
		objTest=new TransactResourceModel();
		objTest.setFlowNo("120110425037090");
	}
	
	@Test
	public void testIMapperTestCase() {

	}

	@Test
	public void testCount() throws Exception {
		mapperTestCase.count();
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEqPk() throws Exception {
		mapperTestCase.deleteEqPk(objTestPk);
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteInPk() throws Exception {
		mapperTestCase.deleteEqPk(listTestPk);
	}

	@Test
	public void testDeleteNotInPk() throws Exception {
		mapperTestCase.deleteNotInPk(listTestPk);
		fail("Not yet implemented");
	}

	@Test
	public void testInsertOne() throws Exception  {
		mapperTestCase.insertOne(objTest);
		fail("Not yet implemented");
	}

	@Test
	public void testSelectT() throws Exception {
		mapperTestCase.select(q1);
		fail("Not yet implemented");
	}

	@Test
	public void testSelectTPageBounds() throws Exception {
		mapperTestCase.select(q1,new PageBounds());
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() throws Exception {
		mapperTestCase.selectAll();
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAllPageBounds() throws Exception {
		mapperTestCase.selectAll(new PageBounds());
		fail("Not yet implemented");
	}

	@Test
	public void testSelectEqPk()  {
		TransactResourceModel transactResourceModel=null;
		try {
			transactResourceModel= mapperTestCase.selectEqPk(objTestPk);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		assertNull(transactResourceModel);
	}

	@Test
	public void testSelectInPkArrayList() throws Exception {
		mapperTestCase.selectInPk(listTestPk);
		fail("Not yet implemented");
	}

	@Test
	public void testSelectInPkArrayListPageBounds() throws Exception {
		mapperTestCase.selectInPk(listTestPk, new PageBounds());
		fail("Not yet implemented");
	}

	@Test
	public void testSelectNotInPkArrayList() throws Exception {
		mapperTestCase.selectNotInPk(listTestPk);
		fail("Not yet implemented");
	}

	@Test
	public void testSelectNotInPkArrayListPageBounds() throws Exception {
		mapperTestCase.selectNotInPk(listTestPk,new PageBounds());
		fail("Not yet implemented");
	}

	@Test
	public void testSelectUnion() throws Exception {
       		mapperTestCase.selectUnion(qs);
		fail("Not yet implemented");
	}

	@Test
	public void testSelectViewT() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectViewTPageBounds() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectViewAll() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectViewAllPageBounds() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectViewInPkArrayList() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectViewInPkArrayListPageBounds() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectViewNotInPkArrayList() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectViewNotInPkArrayListPageBounds() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectViewUnion() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOneT() throws Exception {
		this.mapperTestCase.updateOne(objTest);
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOneTObject() throws Exception {
	    this.mapperTestCase.updateOne(objTest, objTestPk);
		fail("Not yet implemented");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testToString() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testTestCase() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testTestCaseString() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testCountTestCases() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateResult() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testRun() {
		fail("Not yet implemented");
	}

	@Test
	public void testRunTestResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testRunBare() {
		fail("Not yet implemented");
	}

	@Test
	public void testRunTest() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testTearDown() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssert() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertTrueStringBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertTrueBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertFalseStringBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertFalseBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testFailString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFail() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringObjectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsObjectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringDoubleDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsDoubleDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringFloatFloatFloat() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsFloatFloatFloat() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringLongLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsLongLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringBooleanBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsBooleanBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringByteByte() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsByteByte() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringCharChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsCharChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringShortShort() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsShortShort() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsStringIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertEqualsIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotNullObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotNullStringObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNullObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNullStringObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertSameStringObjectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertSameObjectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotSameStringObjectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAssertNotSameObjectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testFailSame() {
		fail("Not yet implemented");
	}

	@Test
	public void testFailNotSame() {
		fail("Not yet implemented");
	}

	@Test
	public void testFailNotEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormat() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
