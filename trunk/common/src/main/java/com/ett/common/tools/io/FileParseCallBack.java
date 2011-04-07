package com.ett.common.tools.io;
import java.io.File;
import java.io.IOException;

/**
 * FileParseCallBack.java create by chen at 2008-11-23 ,上午11:18:46
 * NotMavenTest by ft.comp
 */

/**
 * 对文件执行的操作
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public interface FileParseCallBack {
	
	void parse(File file) throws IOException;
}
