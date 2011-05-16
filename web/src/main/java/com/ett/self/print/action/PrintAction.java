/**
 * 
 */
package com.ett.self.print.action;

import java.util.Date;
import java.util.List;

import com.ett.self.BaseSelfAction;
import com.ett.self.print.biz.IPrintBiz;

/**
 * @author austin
 *
 */
public class PrintAction extends BaseSelfAction {
	private IPrintBiz iPrintBiz;
	
	private Date testDate=new Date();
	
	
	public Date getTestDate() {
		return testDate;
	}
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	public IPrintBiz getiPrintBiz() {
		return iPrintBiz;
	}
	public void setiPrintBiz(IPrintBiz iPrintBiz) {
		this.iPrintBiz = iPrintBiz;
	}
	public String func()
	{
		this.getUser();
		return "funcselect";
	}
	
	private List lists;
	
	public List getLists() {
		return lists;
	}
	public void setLists(List lists) {
		this.lists = lists;
	}
	public String person()
	{
		this.lists=iPrintBiz.getPersonFlow(this.getUser().getSfzmhm());
		return "personlist";
	}
	public String personPrint()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.setPrintObject(iPrintBiz.getPersonPrintObject(lsh));
		this.getPrintObject().setGlbmName(this.getDevice().getGlbmName());
		return "personprint";
	}
	public String car()
	{
		this.lists=iPrintBiz.getCarFlow(this.getUser().getSfzmhm());
		return "carlist";
	}
	public String carPrint()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.setPrintObject(iPrintBiz.getCarPrintObject(lsh));
		this.getPrintObject().setGlbmName(this.getDevice().getGlbmName());
		return "carprint";
	}
	public String vio()
	{
		this.lists=iPrintBiz.getVioFlow(this.getUser().getSfzmhm());
		return "violist";
	}
	public String vioPrint()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.setPrintObject(iPrintBiz.getVioPrintObject(lsh));
		this.getPrintObject().setGlbmName(this.getDevice().getGlbmName());
		return "vioprint";
	}
	public String hospital()
	{
		this.lists=iPrintBiz.getHospitalFlow(this.getUser().getSfzmhm());
		return "hospitallist";
	}
	
	public String hospitalPrint()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.setPrintObject(iPrintBiz.getHospitalPrintObject(lsh));
		this.getPrintObject().setGlbmName(this.getDevice().getGlbmName());
		return "hospitalprint";
	}
	
	@Override
	public boolean checkUserRight(String rightId) {
		// TODO Auto-generated method stub
		return false;
	}

}
