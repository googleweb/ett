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
		  * 鎻愪緵锛堢浉?锛夌簿?鐨勯櫎娉�绠椼�傚綋?鐢熼櫎涓嶅敖鐨勬儏鍐�锛岀敱scale鍙傛暟鎸� 瀹氱簿搴︼紝浠ュ悗鐨勬暟瀛楀洓鑸嶄簲鍏ャ��
		  * 
		  * @param v1
		  *            琚櫎鏁�
		  * @param v2
		  *            闄ゆ暟
		  * @param scale
		  *            琛ㄧず琛ㄧず闇�瑕佺簿?鍒板皬鏁扮偣浠ュ悗鍑犱綅銆�
		  * @return ?涓弬鏁扮殑鍟�
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
		  * 鎻愪緵绮�鐨勫皬鏁颁綅鍥涜垗浜斿叆?鐞嗐��
		  * 
		  * @param v
		  *            闇�瑕佸洓鑸嶄簲鍏ョ殑鏁板瓧
		  * @param scale
		  *            灏忔暟鐐瑰悗淇濈暀鍑犱綅
		  * @return 鍥涜垗浜斿叆鍚庣殑?鏋�
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
