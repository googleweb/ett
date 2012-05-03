package com.ett.visual;

import java.sql.Driver;

import com.ett.visual.model.drv.DriverFileModel;
import com.ett.visual.model.drv.DriverInfoModel;
import com.smartken.toyz4j.ToyzApp;
import com.smartken.toyz4j.util.EasyUiUtil;

public class App extends ToyzApp {

	
	public static void main(String[] args){
		
		try {
			out(EasyUiUtil.genDatagirdContext(DriverInfoModel.class).toScirpt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
