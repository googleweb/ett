package com.ett.visual.applet;

import java.applet.Applet;
import java.text.MessageFormat;



import com.smartken.toyz4j.applet.FileUploadApplet;





public class JsonFileUploadApplet extends FileUploadApplet {
 

	@Override
	protected void doHandleResult(String context) {
		// TODO Auto-generated method stub
		
	
	this.alert("操作结果", context, true);
		
	}

	
}
