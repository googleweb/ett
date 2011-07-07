/**
 * 
 */
package com.ett.common.util;

import java.math.BigDecimal;

/**
 * @author austin
 *
 */
public class MathUtil {
	
	
	
	public   static  String percent( double  a,  double  b)
	{
		if(b==0.0D)
		{
			return "0%";
		}
		double c = divide(a, b, 2);
		return round(c,2) + "%";

	}

	public static double divide(double v1, double v2, int scale) {
		  double c = div(v1, v2, scale + 2);
		  // System.out.println(c+"%");
		  return div(c * 100.0, 1, scale);
		 }

		 /**
		  * 提供（相?）精?的除泄1�7算�1�7�当?生除不尽的情冄1�7，由scale参数挄1�7 定精度，以后的数字四舍五入�1�7�1�7
		  * 
		  * @param v1
		  *            被除敄1�7
		  * @param v2
		  *            除数
		  * @param scale
		  *            表示表示霄1�7要精?到小数点以后几位〄1�7
		  * @return ?个参数的啄1�7
		  */
		 public static double div(double v1, double v2, int scale) {
		  if (scale < 0) {
		   throw new IllegalArgumentException(
		     "The scale must be a positive integer or zero");
		  }
		  BigDecimal b1 = new BigDecimal(Double.toString(v1));
		  BigDecimal b2 = new BigDecimal(Double.toString(v2));
		  return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		 }

		 /**
		  * 提供粄1�7的小数位四舍五入?理�1�7�1�7
		  * 
		  * @param v
		  *            霄1�7要四舍五入的数字
		  * @param scale
		  *            小数点后保留几位
		  * @return 四舍五入后的?构1�7
		  */
		 public static double round(double v, int scale) {
		  if (scale < 0) {
		   throw new IllegalArgumentException(
		     "The scale must be a positive integer or zero");
		  }
		  BigDecimal b = new BigDecimal(Double.toString(v));
		  BigDecimal one = new BigDecimal("1");
		  return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		 }

		 public static String addZero(double v) {
		  StringBuffer s = null;
		  String temp = String.valueOf(v);
		  //String[] tempArray = temp.split(".");
		  int point = temp.indexOf(".");
		  int length = temp.length();
		  int n = length - 1 - point;
		  
		  if (n > 0) {
		   s = new StringBuffer(temp);
		   for ( int i = 0; i < n; i++) {
		    s.append(0);
		   }
		   return s.toString();
		  } else {
		   return temp;
		  }

		 }


		

}
