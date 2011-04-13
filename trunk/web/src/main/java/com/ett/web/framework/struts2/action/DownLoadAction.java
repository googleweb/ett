package com.ett.web.framework.struts2.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author austin
 *
 */
public class DownLoadAction extends ActionSupport{
	
	/**
	 * @param path 图片路径
	 * @return
	 * @throws Exception
	 */
	public void renderImage(InputStream in) {
        HttpServletResponse response=null;
        ServletOutputStream out = null;  
        byte [] bytes = null;
        try {
             response=ServletActionContext.getResponse();
             //二进制输出流
             response.setContentType( "multipart/form-data" );
             
             //得到输出流
             out = response.getOutputStream();
             
             //从输入流读取数据到输出流
             bytes = new byte [ 1024 ];
             while ( -1 != in.read( bytes ) ){
                  out.write( bytes );
             }
             
             //强制刷新输出流
             out.flush();
        } catch ( IOException e ) {
             e.printStackTrace();
        } catch ( Exception e ) {
             e.printStackTrace();
        } finally {
             if ( in != null ) {
                  try {
                       in.close();
                  } catch ( IOException e ) {
                       e.printStackTrace();
                  }
             }
             if ( out != null ) try {
                  out.close();
             } catch ( IOException e ) {
                  e.printStackTrace();
             }
             bytes = null;
        }
    }

	
	/**
	 * @param path 图片路径
	 * @return
	 * @throws FileNotFoundException 
	 * @throws Exception
	 */
	public void renderImage(String path) throws FileNotFoundException {
        renderImage(new FileInputStream(path));
    }

}
