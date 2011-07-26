package com.ett.drv.view;

import org.json.JSONException;
import org.json.JSONObject;

import com.ett.drv.model.admin.BusAllInfoModel;
import com.ett.drv.model.admin.UserModel;


@SuppressWarnings("serial")
public class BusAllInfoView extends BusAllInfoModel {

	private String tjyy;
	public String getTjyy() {
		return tjyy;
	}
	public void setTjyy(String tjyy) {
		this.tjyy = tjyy;
	}
	public String getDzdm() {
		return dzdm;
	}
	public void setDzdm(String dzdm) {
		this.dzdm = dzdm;
	}
	public String getGj() {
		return gj;
	}
	public void setGj(String gj) {
		this.gj = gj;
	}
	public String getZjlx() {
		return zjlx;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	private String dzdm;
	private String gj;
	private String zjlx;
	public JSONObject toJson() {
	
		JSONObject json= super.toJson();
		try {
			json.put("tjyy", "tjyy");		
			json.put(dzdm,dzdm);
			json.put(gj,gj);
			json.put(zjlx,zjlx);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
}