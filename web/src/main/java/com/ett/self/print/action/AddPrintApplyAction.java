/**
 * 
 */
package com.ett.self.print.action;

import java.util.List;

import com.ett.self.BaseSelfAction;
import com.ett.self.print.biz.IAddPrintApplyBiz;
import com.ett.self.print.biz.IPrintBiz;
import com.ett.self.print.model.AddPrintApplyObject;

/**
 * @author austin
 *
 */
public class AddPrintApplyAction extends BaseSelfAction {
	
	private IPrintBiz iPrintBiz;
	
	private IAddPrintApplyBiz iAddPrintApplyBiz;
	
	public IAddPrintApplyBiz getiAddPrintApplyBiz() {
		return iAddPrintApplyBiz;
	}
	public void setiAddPrintApplyBiz(IAddPrintApplyBiz iAddPrintApplyBiz) {
		this.iAddPrintApplyBiz = iAddPrintApplyBiz;
	}

	private List lists;
	
	public List getLists() {
		return lists;
	}
	public void setLists(List lists) {
		this.lists = lists;
	}
	
	public String func()
	{
		this.getUser();
		return "funcselect";
	}
	
	public String vio()
	{
		this.lists=iPrintBiz.getVioFlow(this.getUser().getSfzmhm());
		return "violist";
	}
	
	private AddPrintApplyObject addPrintApplyObject;
	public IPrintBiz getiPrintBiz() {
		return iPrintBiz;
	}
	public void setiPrintBiz(IPrintBiz iPrintBiz) {
		this.iPrintBiz = iPrintBiz;
	}
	public AddPrintApplyObject getAddPrintApplyObject() {
		return addPrintApplyObject;
	}
	public void setAddPrintApplyObject(AddPrintApplyObject addPrintApplyObject) {
		this.addPrintApplyObject = addPrintApplyObject;
	}
	public String vioPrint()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.addPrintApplyObject=this.iAddPrintApplyBiz.addVioPrint(this.getUser(), this.getDevice(), lsh,this.createNewId());
		//this.printObject=iPrintBiz.getVioPrintObject(lsh);
		//this.printObject.setGlbmName(this.getDevice().getGlbmName());
		return this.goSuccessPage("申请补打成功,请取走您的凭条和证件！");
	}
	
	public String vioPrintConfirm()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.printObject=iPrintBiz.getVioPrintObject(lsh);
		return "vioprintconfirm";
	}
	public String hospital()
	{
		this.lists=iPrintBiz.getHospitalFlow(this.getUser().getSfzmhm());
		return "hospitallist";
	}
	
	public String hospitalPrint()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		this.addPrintApplyObject=this.iAddPrintApplyBiz.addHospitalPrint(this.getUser(), this.getDevice(), lsh,this.createNewId());
		//this.printObject=iPrintBiz.getHospitalPrintObject(lsh);
		//this.printObject.setGlbmName(this.getDevice().getGlbmName());
		return this.goSuccessPage("申请补打成功,请取走您的凭条和证件！");
	}
	
	public String hospitalPrintConfirm()
	{
		String lsh=this.getHtmlAttributeOrParamter("lsh");
		//this.addPrintApplyObject=this.iAddPrintApplyBiz.addHospitalPrint(this.getUser(), this.getDevice(), lsh);
		this.printObject=iPrintBiz.getHospitalPrintObject(lsh);
		//this.printObject.setGlbmName(this.getDevice().getGlbmName());
		return "hospitalprintconfirm";
	}

}
