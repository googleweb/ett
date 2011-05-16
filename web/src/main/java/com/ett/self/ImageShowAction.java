/**
 * 
 */
package com.ett.self;

import java.io.InputStream;

import com.ett.common.util.ImageUtil;
import com.ett.drvinterface.first.DrvServiceHelper;

/**
 * @author austin
 * 显示图片的Action
 */
public class ImageShowAction extends BaseSelfAction {
	
	private InputStream inputstream;

	public InputStream getInputstream() {
		return inputstream;
	}

	public void setInputstream(InputStream inputstream) {
		this.inputstream = inputstream;
	}
	
	public String person()
	{
		String path=this.getRealPath("images/no_photo.jpg");
		logger.debug("获取图片路径为："+path);
		String imgSrc=ImageUtil.imageToString(path);
		//DrvServiceHelper helper=new DrvServiceHelper();
		//helper.getPersonPhoto("A", this.getUser().getSfzmhm(), this.get)
		
		InputStream tmp=ImageUtil.stringToImage(imgSrc);
		this.setInputstream(tmp);
		return "success";
	}
	
	public String vio()
	{
		String jdsbh=this.getHtmlAttributeOrParamter("jdsbh");
		return "success";
	}
	
	
	
	


}
