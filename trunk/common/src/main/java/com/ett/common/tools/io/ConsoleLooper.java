/**
 * ConsoleLooper.java create by chen at 2008-11-23 ,下午12:11:12
 * NotMavenTest by ft.comp
 */
package com.ett.common.tools.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

/**
 * 提供控制台循环提示，只有输入命令符合条件才允许继续往下走
 * @author chen
 * @version 1.0
 * @since 1.5
 */
public class ConsoleLooper {

	protected Logger log = Logger.getLogger(this.getClass());
	
	public void loop(String hint,SwitchCallBack switcher) throws IOException
	{
		if(switcher==null)
		{
			throw new IllegalArgumentException("必须设置丄1�7个swither来判断！");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println(hint);
			String cmd = br.readLine();
			if(switcher.verify(cmd))
			{
				break;
			}
		}
	}
}
