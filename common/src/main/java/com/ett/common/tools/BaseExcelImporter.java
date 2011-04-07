package com.ett.common.tools;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 */

/**
 * 基本的Excel导入类，供子类继扄1�7
 * 使用方法，继承该类，并实现parseRow方法
 * 使用的时候，new丄1�7个子类，设置文件路径，执行beginImport方法即可
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public abstract class BaseExcelImporter implements Importer {
	
	protected Logger log = Logger.getLogger(this.getClass());
	
	private int beginRowIndex=1;
	
	private int endRowIndex=1;
	
	/**
	 * 弄1�7始执行导兄1�7
	 * @throws IOException
	 */
	public  void beginImport() throws IOException
	{
		log.debug("开始导入数据！");
		InputStream myxls = new FileInputStream(this.path);
		HSSFWorkbook wb = new HSSFWorkbook(myxls);
		HSSFSheet sheet = wb.getSheetAt(0);
		//怎么判断没有行可读了，没有列可读亄1�7
		for (int i = beginRowIndex; i <= endRowIndex; i++) {
			try
			{
				parseRow(sheet.getRow(i));
			}
			catch(Exception ex)
			{
				log.debug("数据行："+i+"数据不完整，请检查！");
				break;
			}
		}
		
		myxls.close();
		log.debug("结束数据导入＄1�7");
	}
	
	/**
	 * 子类必须实现的方泄1�7
	 * 解析丄1�7行记录并做处琄1�7
	 * @param row excel表的衄1�7
	 */
	protected abstract void parseRow(HSSFRow row) throws Exception;
	
	
	/**
	 *导入的excel文件的绝对路径1�7 
	 */
	private String path;
	
	/**
	 * 从Excel表格单元读取丄1�7个对象出杄1�7,如果对象
	 * 不是字符串和日期或�1�7�数字类型，仅仅读取对象的类刄1�7
	 * 不支持图像之类的读写
	 * @param cell 单元栄1�7
	 * @return 读取的结果对豄1�7
	 */
	protected  Object readFromCell(HSSFCell cell) {
		Object result=null;
		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
			result=cell.getStringCellValue();
			log.debug("单元格是字符串，值是＄1�7 " +result );
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				result=cell.getDateCellValue();
				log.debug("单元格是日期，�1�7�是＄1�7"
						+ result);
			}
			else
			{
				result=cell.getNumericCellValue();
				log.debug("单元格是数字，�1�7�是＄1�7 " +result );
			}
		} else {
			result=cell.getCellType();
			log.debug("单元格的值不是字符串或数值�1�7�类型是＄1�7"+result);
		}
		return result;

	}

	/**
	 * 导入的excel文件的绝对路径1�7
	 * @return 
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 导入的excel文件的绝对路径1�7
	 * @param path 
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * excel的起始行，从0算起
	 * @return
	 */
	public int getBeginRowIndex() {
		return beginRowIndex;
	}

	/**
	 * excel的起始行，从0算起
	 * @param beginRowIndex
	 */
	public void setBeginRowIndex(int beginRowIndex) {
		this.beginRowIndex = beginRowIndex;
	}

	/**
	 * excel的结束行，从0算起
	 * @return
	 */
	public int getEndRowIndex() {
		return endRowIndex;
	}

	/**
	 * excel的结束行，从0算起
	 * @param endRowIndex
	 */
	public void setEndRowIndex(int endRowIndex) {
		this.endRowIndex = endRowIndex;
	}


}
