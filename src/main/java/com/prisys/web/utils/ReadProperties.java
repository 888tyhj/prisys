package com.prisys.web.utils;


import java.util.Properties;

/**
 * 读取Properties属性文件
 * @author yangl
 *
 */
public class ReadProperties {
	//根据key读取value
	public static String readValue(String filename,String key) {
	       Properties props = new Properties();
	       try {
	    	   props.load(ReadProperties.class.getClassLoader().getResourceAsStream(filename));
		        String value = props.getProperty (key);
	            return value;
	       } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	       }
	}
	public static void main(String[] args) {
		System.out.println(ReadProperties.readValue("url.properties", "CD"));
	}
}
