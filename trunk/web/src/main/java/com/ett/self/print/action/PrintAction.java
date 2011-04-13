/**
 * 
 */
package com.ett.self.print.action;

import java.util.List;

import com.ett.self.BaseSelfAction;
import com.ett.self.print.biz.IPrintBiz;
import com.ett.self.print.model.PrintObject;

/**
 * @author austin
 *
 */
public class PrintAction extends BaseSelfAction {
	private IPrintBiz iPrintBiz;
	
	
	public IPrintBiz getiPrintBiz() {
		return iPrintBiz;
	}
	public void setiPrintBiz(IPrintBiz iPrintBiz) {
		this.iPrintBiz = iPrintBiz;
	}
	public String func()
	{
		
		String idcard=this.getHtmlAttributeOrParamter("idcard");
		this.setUser(iPrintBiz.getUser(idcard));
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
		this.lists=iPrintBiz.searchPersonFlow(this.getUser().getSfzmhm());
		return "personlist";
	}
	public String personPrint()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.printObject=iPrintBiz.searchPersonPrintObject(lsh);
		return "personprint";
	}
	public String car()
	{
		this.lists=iPrintBiz.searchCarFlow(this.getUser().getSfzmhm());
		return "carlist";
	}
	public String carPrint()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.printObject=iPrintBiz.searchCarPrintObject(lsh);
		return "carprint";
	}
	public String vio()
	{
		this.lists=iPrintBiz.searchVioFlow(this.getUser().getSfzmhm());
		return "violist";
	}
	public String vioPrint()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.printObject=iPrintBiz.searchVioPrintObject(lsh);
		return "vioprint";
	}
	public String hospital()
	{
		this.lists=iPrintBiz.searchHospitalFlow(this.getUser().getSfzmhm());
		return "hospitallist";
	}
	
	public String hospitalPrint()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.printObject=iPrintBiz.searchHospitalPrintObject(lsh);
		return "hospitalprint";
	}
	private PrintObject printObject;

	public PrintObject getPrintObject() {
		return printObject;
	}
	public void setPrintObject(PrintObject printObject) {
		this.printObject = printObject;
	}
	@Override
	public boolean checkUserRight(String rightId) {
		// TODO Auto-generated method stub
		return false;
	}

}
