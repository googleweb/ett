package com.ett.common.tools;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 */

/**
 * 基本的对文件夹进行处理导入的籄1�7
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public abstract class BaseDirectoryImporter implements Importer {
	
	protected Logger log = Logger.getLogger(this.getClass());
	
	/**
	 *导入的文件夹的绝对路径1�7 
	 */
	private String path;
	
	/**
	 * 导入的文件夹的绝对路径1�7
	 * @return 导入的文件夹的绝对路径1�7
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 导入的文件夹的绝对路径1�7
	 * @param path 导入的文件夹的绝对路径1�7
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 *  弄1�7始导入数捄1�7
	 * @throws IOException
	 */
	public  void beginImport() throws IOException
	{
		log.debug("弄1�7始导入数据！");
		File file=new File(this.path);
		boolean tmp=file.exists();
		if(tmp&&file.isDirectory())
			this.LoopFile(file);
		else
		{
			log.debug("文件夹路径错误！"+this.path);
		}
		log.debug("结束数据导入＄1�7");
	}
	
	/**
	 * 子类必须继承的对豄1�7
	 * @param file 对文件进行相应处琄1�7
	 * @throws IOException IO流异帄1�7
	 */
	protected abstract void parseFile(File file) throws IOException;
	
	/**
	 * 对文件夹执行循环
	 * @param f 文件对象
	 * @throws IOException IO流异帄1�7
	 */
	private  void LoopFile(File f) throws IOException
	{
		for(File tmp : f.listFiles())
		{
			if(tmp.isFile())
			{
				log.debug("找到文件路径为："+tmp.getCanonicalPath());
				parseFile(tmp);
			}
			else
			{
				LoopFile(tmp);
			}
		}
	}

}
