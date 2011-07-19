package com.ett.drvinterface.entity;

import java.io.File;
import java.io.FileInputStream;


public class DrvphotoRequest extends BaseDrvRequest{
	
	private String sfzhm;
	private File zp;
	private byte[] zpbyte;

	public File getZp() {
		return zp;
	}

	public void setZp(File zp) {
		this.zp = zp;
	}
	public void setZp(byte[] zp){
		this.zpbyte=zp;
	}

	@Override
	public String toXml() {
		StringBuffer sb=new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		sb.append("<root>");
		sb.append("<drvphoto>");
		this.appendTag(sb, "sfzhm", this.sfzhm);
		String photo="";
		try {
			photo = this.encodeBase64File(zp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.appendTag(sb, "zp", photo);
		sb.append("</drvphoto>");
		sb.append("</root>");
		return sb.toString();
	}
	
	public static String encodeBase64File(File file) {
//		   FileInputStream inputFile = new FileInputStream(file);
//	       byte[] buffer = new byte[(int)file.length()];
//	       inputFile.read(buffer);
//		   inputFile.close();
//     	   return new BASE64Encoder().encode(buffer);
		return null;
		    }

}
