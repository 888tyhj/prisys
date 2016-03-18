package com.prisys.web.utils;

import java.io.IOException;
import java.util.Random;
/**
 * 公共方法
 * @author yangl
 *
 */
public class CommonUtil {
	
	/**
	 * 获得len位随机数字
	 * @param len 随机数的长度
	 * @return 随机数
	 */
	public static String getRandomNumber(int len){
		Random r=new Random();
		StringBuilder sb=new StringBuilder();
		int charLen=Constants.ALLNUMBER.length();
		for (int i = 0; i < len; i++) {
			sb.append(Constants.ALLNUMBER.charAt(r.nextInt(charLen)));
		}
		return sb.toString();
	}
	/**
	  * 文件保存的路径
	  * @return
	  */
	  public static String getPath(){
		  String path=null;
		 // String path=request.getSession().getServletContext().getRealPath("/")+"upload/";
		  try {
			path=Constants.getCD();
		  } catch (IOException e) {
			  path="";
			  e.printStackTrace();
		  }
		  return path;
	  }
	public static void main(String[] args) {
		System.out.println(CommonUtil.getRandomNumber(5));
	}
}
