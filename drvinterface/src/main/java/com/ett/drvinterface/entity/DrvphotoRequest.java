package com.ett.drvinterface.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import biz.source_code.base64Coder.Base64Coder;


public class DrvphotoRequest extends BaseDrvRequest{
	
	private String sfzhm;
	private String zp;

	public String getZp() {
		return zp;
	}

	public void setZp(File zp) {
		this.zp=this.encodeBase64(zp);
	}
	
	public void setZp(byte[] bytes){
		this.zp=this.encodeBase64(bytes);
	}

	@Override
	public String toXml() {
		StringBuffer sb=new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<root>");
		sb.append("<drvphoto>");
		this.appendTag(sb, "sfzhm", this.sfzhm);
		try {
			this.appendTag(sb, "zp", URLEncoder.encode(this.zp,"UTF-8") );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sb.append("</drvphoto>");
		sb.append("</root>");
		return sb.toString();
	}
	
	public static String encodeBase64(File file) {
		   try {
			FileInputStream inputFile = new FileInputStream(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       byte[] buffer = new byte[(int)file.length()];
//	       inputFile.read(buffer);
//		   inputFile.close();
//     	   return new BASE64Encoder().encode(buffer);
		 return encodeBase64(buffer);
   }
	
    public static String encodeBase64(byte[] bytes){
    	return Base64Coder.encodeLines(bytes);
    }

}
