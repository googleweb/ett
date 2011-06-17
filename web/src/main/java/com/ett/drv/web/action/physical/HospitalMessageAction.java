package com.ett.drv.web.action.physical;

import com.ett.drv.web.action.BaseAction;

public class HospitalMessageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String to_process(){
		return  "jsp";
	}
	public String to_import() {
		return "jsp";
	}
	public String to_checkRecord() {
		return "jsp";
	}
	public String to_logMessage() {
		return "jsp";
	}
	public String to_statistics() {
		return "jsp";
	}
	public String to_hospitalwork(){
		return  "jsp";
	}
	public void clear() {
	}
}
