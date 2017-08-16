package com.unicorn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class PropertiesUtils {
	//配置文件properties的对象
	private static Properties prop = new Properties();
	
	//构造方法外部不可访问
	private PropertiesUtils() {
		// TODO Auto-generated constructor stub
	}
	
	static{
		try {
			//初始化文件的读取流
			InputStream is = Thread.currentThread().
					getContextClassLoader().
					getResourceAsStream("com/unicorn/properties/jdbc.properties");
//		InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			prop.load(br);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("jdbc propertise read failed!");
		}
	}
	
	//通过key值获得properties的值
	public static String getValue(String key){
		return prop.getProperty(key);
	}
	
}
