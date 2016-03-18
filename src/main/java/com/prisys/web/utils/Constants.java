package com.prisys.web.utils;

import java.io.IOException;

/**
 * 
 * @ClassName: Constants
 * @Description: TODO
 * @author yangl
 * @date 2015-6-3 下午1:14:30
 * 
 */
public class Constants {
	public static final String CURRENT_USER = "user";
	public static final String ALLNUMBER = "0123456789";

	public static String getCD() throws IOException {
		return ReadProperties.readValue("url.properties", "CD");
	}
}
