package com.ett.common.tools.io;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.*;

/**
 * 文件过滤器，可用分号分割.xls;.txt
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public class FileFilter implements SwitchCallBack{
	
	protected Logger log = Logger.getLogger(this.getClass());
	
	private Map<String,String> suffixTables;
	
	/**
	 * 文件过滤噄1�7
	 * @param suffix 过滤器后缄1�7，可用分号分剄1�7.xls;.txt
	 */
	public FileFilter(String suffix)
	{
		if(suffix==null||suffix.length()==0)
		{
			throw new java.lang.IllegalArgumentException("必须设置过滤器后缄1�7!");
		}
		String[] suffixs=suffix.split(";");
		if(suffixs.length<0)
		{
			throw new java.lang.IllegalArgumentException("必须设置过滤器后缄1�7!");
		}
		else
		{
			this.suffixTables=new HashMap<String,String>();
		}
		for(String tmp :suffixs)
		{
			this.suffixTables.put(tmp, tmp);
		}
		this.log.debug("文件过滤器的过滤后缀朄1�7"+this.suffixTables.size()+"丄1�7");
	}
	
	/**
	 * 过滤丄1�7个文仄1�7
	 * @param file 待判断文件夹
	 * @return 是否过滤成功
	 */
	private boolean verify(File file)
	{
		boolean result=false;
		if(file.isFile())
		{
			String fileName=file.getName();
			int index=fileName.indexOf(".");
			String key=fileName.substring(index);
			log.debug("文件过滤器取得文件的后缀为："+key);
			result=this.suffixTables.containsKey(key);
			log.debug("过滤结果"+result);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see tools.io.SwitchCallBack#verify(java.lang.Object)
	 */
	public boolean verify(Object obj) {
		if(obj.getClass()==File.class)
		{
			return verify((File)obj);
		}
		return false;
	}

}
