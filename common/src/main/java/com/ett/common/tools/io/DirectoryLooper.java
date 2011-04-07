package com.ett.common.tools.io;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * DirectoryLooper.java create by chen at 2008-11-23 ,上午11:11:34
 * NotMavenTest by ft.comp
 */

/**
 * 文件夹遍历工兄1�7
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public class DirectoryLooper {
	
	protected Logger log = Logger.getLogger(this.getClass());
	
	
	/**
	 * 待遍历路径1�7
	 */
	private File dir;
	
	/**
	 * 构�1�7�函敄1�7
	 * @param dir 待遍历路径1�7
	 */
	public DirectoryLooper(File dir)
	{
		if(dir==null)
		{
			throw new IllegalArgumentException("构�1�7�函数参数dir不得为空＄1�7");
		}
		if(!dir.exists())
		{
			throw new IllegalArgumentException("不存在路径！"+dir.getAbsolutePath());
		}
	    if(dir.isFile())
		{
	    	throw new IllegalArgumentException("路径"+dir.getAbsolutePath()+"不是文件夹！");
		}
	    this.dir=dir;

	}
	
	/**
	 * 构�1�7�函敄1�7
	 * @param path 文件夹路径1�7
	 */
	public DirectoryLooper(String path)
	{
		this(new File(path));
	}
	
	
	/**
	 * 默认解析扄1�7有文仄1�7
	 * @param fileParse 对文件如何处理的解析噄1�7
	 * @throws IOException
	 */
	public void loop(FileParseCallBack fileParse) throws IOException
	{
		loop(fileParse,null);
	}
	/**
	 * 弄1�7始遍厄1�7
	 * @param fileParse 遍历回调
	 * @param filter 过滤噄1�7
	 * @throws IOException 
	 */
	public void loop(FileParseCallBack fileParse,SwitchCallBack filter) throws IOException
	{
		loop(dir,fileParse,filter);
	}
	
	
	/**
	 * @param file 文件夹名秄1�7
	 * @param fileParse 文件处理噄1�7
	 * @param filter 文件过滤噄1�7
	 * @throws IOException
	 */
	protected void loop(File file,FileParseCallBack fileParse,SwitchCallBack filter)  throws IOException
	{
		for(File tmp : file.listFiles())
		{
			if(tmp.isFile())
			{
				log.debug("文件夹遍历找到文件路径为＄1�7"+tmp.getCanonicalPath());
				if(filter!=null)
				{
					if(filter.verify(tmp))
					{
						log.debug("文件符合过滤条件");
						fileParse.parse(tmp);
					}
					else
					{
						log.debug("文件不符合过滤条仄1�7");
					}
				}
				else
				{
					fileParse.parse(tmp);
				}
				
			}
			else
			{
				loop(tmp,fileParse,filter);
			}
		}
	}

}
