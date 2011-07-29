package com.ett.drv.schedule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.SendingContext.RunTime;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;




import com.ett.drv.biz.ICacheBiz;
import com.smartken.kia.core.enums.ECode;
import com.smartken.kia.core.model.impl.JsContextModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.FileUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class CacheFileSchedule extends QuartzJobBean {


	private ICacheBiz cacheBiz;
	
	
	


	public void setCacheBiz(ICacheBiz cacheBiz) {
		this.cacheBiz = cacheBiz;
	}





	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		try {
			this.cacheBiz.updateCache();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCache(){
		try {
			this.cacheBiz.updateCache();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
