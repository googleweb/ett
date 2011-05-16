/**
 * 
 */
package com.austin.base.commons.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author austin
 *  图片处理工具
 */
public class ImageUtil {
	
	protected static  Log log = LogFactory.getLog(ImageUtil.class);
	
	public static String imageToString(String path)
	{
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try 
        {
            in = new FileInputStream(path);        
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符丄1�7

	}
	
	public static InputStream stringToImage(String imgSrc)
	{
		ByteArrayInputStream in=null;
		 if (imgSrc == null) //图像数据为空
	            return null;
	        BASE64Decoder decoder = new BASE64Decoder();
	        try 
	        {
	            //Base64解码
	            byte[] b = decoder.decodeBuffer(imgSrc);
	           in=new ByteArrayInputStream(b);
	            
	        } 
	        catch (Exception e) 
	        {
	            return in;
	        }
		return in;
		
		
		
	}
	
	/**
	 * @param imgSrc  图片的字符串
	 * @param out 输出的流
	 * @return 是否成功转换
	 */
	public static  boolean stringToImage(String imgSrc,OutputStream out)
	
	{
		 if (imgSrc == null||out==null) //图像数据为空
	            return false;
	        BASE64Decoder decoder = new BASE64Decoder();
	        try 
	        {
	            //Base64解码
	            byte[] b = decoder.decodeBuffer(imgSrc);
	            for(int i=0;i<b.length;++i)
	            {
	                if(b[i]<0)
	                {//调整异常数据
	                    b[i]+=256;
	                }
	            }
	            //生成jpeg囄1�7
	            out.write(b);
	            out.flush();
	            //out.close();
	            return true;
	        } 
	        catch (Exception e) 
	        {
	            return false;
	        }
	}

}
