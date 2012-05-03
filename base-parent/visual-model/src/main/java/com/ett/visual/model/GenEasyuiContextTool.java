package com.ett.visual.model;

import com.ett.visual.model.drv.DriverFileModel;
import com.ett.visual.model.drv.DriverInfoModel;
import com.smartken.toyz4j.util.EasyUiUtil;

public class GenEasyuiContextTool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           System.out.println(EasyUiUtil.genDatagirdContext(DriverInfoModel.class, "Id").toScirpt());
	}

}
