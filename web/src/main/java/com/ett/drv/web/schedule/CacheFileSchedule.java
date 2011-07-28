package com.ett.drv.web.schedule;

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




import com.smartken.kia.core.enums.ECode;
import com.smartken.kia.core.model.impl.JsContextModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.FileUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class CacheFileSchedule extends QuartzJobBean {


	
	
	private String cacheJsonPath;
	private String cacheXmlPath;
    private ArrayList<Class> cacheModels=new ArrayList<Class>();
		

	



	public void setCacheJsonPath(String cacheJsonPath) {
		this.cacheJsonPath = cacheJsonPath;
	}



	public void setCacheXmlPath(String cacheXmlPath) {
		this.cacheXmlPath = cacheXmlPath;
	}



	public void setCacheModels(ArrayList<String> cacheModels) {
		for(Iterator<String> it=cacheModels.iterator();it.hasNext();){
			String clsName=it.next();
			Class c;
			try {
				c = Class.forName(clsName);
				this.cacheModels.add(c);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				break;
			}
			
		}
		

	}



	public static void main(String[] args){
//		CacheFileSchedule cf=new CacheFileSchedule();
//		URL url=FileUtil.getClassPath(cf.getClass());
//        try {
//		    String cacheJsonPath=FileUtil.getParentDir(url,2).getPath()+cacheJsonPath;
//		    File f=new File(cacheJsonPath+"\\.model");
//		    if(f.exists()){
//		       	f.delete();
//		    }
//		    f.createNewFile();
//		    FileWriter fw=new FileWriter(f);
//		    JobModel jm=new JobModel();
//		    jm.setPk("xxx");
//		    fw.write(jm.toJson().toString());
//		    fw.flush();
//		    fw.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
	}

	
	
	public void loadCache(){
		//URL url=FileUtil.getWebRoot(this.getClass()));
		String path="";
		File f=null;
		//FileWriter fw=null;
	    OutputStreamWriter osw=null;
		try{
	    //path=FileUtil.getParentDir(url,2).getPath()+cacheJsonPath;
		path=FileUtil.getWebRoot(this.getClass())+cacheJsonPath;
	    path=StringUtil.decodeUtf8(path);
	    ArrayList<Class> clss =this.cacheModels;
	    JSONObject jsonCacheModel=new JSONObject();
	    for(Iterator<Class> it=clss.iterator();it.hasNext();){
	    	Class cls=it.next();

	    }
	    f=new File(path+"\\dict.share.json");
   	    if(f.exists()){
	       	f.delete();
	    }
	    f.createNewFile();
	    osw=new OutputStreamWriter(new FileOutputStream(f),ECode.utf8.name());
	    JsContextModel context=new JsContextModel();
	    context.appendScript("Class.forName(\"Kia.cache\"); ");
	    context.appendScript("Kia.cache.dict={0};",jsonCacheModel.toString());
	    osw.write(context.toScirpt());
	    osw.flush();
	    osw.close();
		}catch (Exception e) {e.printStackTrace();}
	}



	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		this.loadCache();
	}
}
