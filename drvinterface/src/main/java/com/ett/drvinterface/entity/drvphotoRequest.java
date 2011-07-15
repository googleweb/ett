package com.ett.drvinterface.entity;

import java.io.File;
import java.io.FileInputStream;


public class drvphotoRequest extends BaseDrvRequest{
	
	private String sfzhm;
	private byte[] zp;
	
	

	public void setZp(byte[] zp) {
		this.zp = zp;
	}

	@Override
	public String toXml() {
		StringBuffer sb=new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<root>");
		sb.append("<drvphoto>");
		this.appendTag(sb, "sfzhm", this.sfzhm);
		String photo="";
		try {
			photo = this.encodeBase64(zp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.appendTag(sb, "zp", photo);
		sb.append("</drvphoto>");
		sb.append("</root>");
		return sb.toString();
	}
	
	public static String encodeBase64(File file) {
//		   FileInputStream inputFile = new FileInputStream(file);
//	       byte[] buffer = new byte[(int)file.length()];
//	       inputFile.read(buffer);
//		   inputFile.close();
//     	   return new BASE64Encoder().encode(buffer);
		return null;
		    }
	public static String encodeBase64(byte[] bytes){
		return null;
		
	}

}
