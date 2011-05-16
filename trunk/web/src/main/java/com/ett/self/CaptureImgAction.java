/**
 * 
 */
package com.ett.self;

import java.io.File;

import com.ett.common.util.FileUtil;
import com.ett.self.model.PhotoSuffixType;

/**
 * @author austin
 * 相片捕获的action
 */
public class CaptureImgAction extends BaseSelfAction {
	
	/**
	 * 上传的照片
	 */
	private File upload;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	public String cap()
	{
		String returnurl=this.getHtmlAttributeOrParamter("returnurl");
		if(returnurl==null||"".equals(returnurl))
		{
			logger.debug("捕获照片的returnurl为："+returnurl);
		}
		logger.debug("从参数获取的returnurl值为："+returnurl);
		this.setReturnUrl(returnurl);
		this.setFrontCapture(this.iDeviceHelper.getFrontCapture(this.getDevice().getId()));
		return "input";
	}
	
	
	public String execute()
	{
		/*
	    String returnurl=this.getHtmlAttributeOrParamter("returnurl");
		if(returnurl==null||"".equals(returnurl))
		{
			logger.debug("捕获照片的returnurl为："+returnurl);
			return "input";
		}
		logger.debug("从参数获取的returnurl值为："+returnurl);
		this.setReturnUrl(returnurl);
		*/
		if(upload!=null)
		{
			
			logger.debug("上传的文件不为空！路径："+upload.getAbsolutePath());
			String filename=this.getRealPath("/capture-img")+"/"+this.getUser().getSfzmhm()+PhotoSuffixType.IdCard_Capture_Suffix+".bmp";
		    File dst = new File(filename);

			FileUtil.copy(upload, dst);
			//upload.
		}
		else
		{
			logger.debug("没有照片上传！");
			
		}
		logger.debug("捕获照片后要跳转的页面url为 :"+this.getReturnUrl());
		
		return "success";
	}

}
