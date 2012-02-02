package com.ett.visual.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ett.visual.model.admin.MenuModel;

public class TestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Map<String, String> cols=new MenuModel().getEasyuiDatagridColumms();
        for(Iterator<String> it=cols.keySet().iterator();it.hasNext();){
        	String key=it.next();
        	System.out.println(cols.get(key));
        }
	}

}
