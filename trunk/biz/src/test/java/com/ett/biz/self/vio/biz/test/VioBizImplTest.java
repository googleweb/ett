/**
 * 
 */
package com.ett.biz.self.vio.biz.test;

import java.util.List;

import org.junit.Assert;

import com.ett.dao.DaoTestCase;
import com.ett.self.model.VehicleObject;
import com.ett.self.vio.biz.IVioBiz;

/**
 * @author austin
 *
 */
public class VioBizImplTest extends DaoTestCase {
	
	protected IVioBiz iVioBiz;
	
	private String sfzmhm="350128198403194910";
	
	private String hphm="湘C32876";
	
	public void AtestGetVehList()
	{
		List list=this.iVioBiz.getVehList(sfzmhm);
		
	   Assert.assertTrue(list.size()>0);
	}
	
	public void AtestGetVioDetail()
	{
		List list=this.iVioBiz.getVioDetail(hphm);
		 //Assert.assertTrue(list.size()>0);
		//System.out.println("获取到车辆的数量为："+list.size());
	}
	
	public void AtestGetVehicle()
	{
		VehicleObject vehicle=this.iVioBiz.getVehicle(hphm);
		Assert.assertNotNull(vehicle);
	}
	public void testABC()
	{
		
	}

}
