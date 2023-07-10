package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConfigReader {
	
	private Properties prop;
	private static String os = System.getProperty("os.name").toLowerCase();
	private static final Logger log = LogManager.getLogger(ConfigReader.class);
	/**
	 * init_prop() : Used for load properties from config.properties file 
	 * @return Properties object
	 */
	public Properties init_prop(){
		prop = new Properties();
		log.info("OS detected as :"+os);
		FileInputStream ip = null;
		try {
			if(os.indexOf("win")>=0) {
				ip = new FileInputStream("src\\test\\resources\\config\\config.properties");	
			}
			
			if(os.indexOf("linux")>=0) {
				ip = new FileInputStream("src/test/resources/config/config.properties");
			}
			
			prop.load(ip);
			log.info("config.properties file loaded");
		} catch (FileNotFoundException e1) {
			e1.getMessage();
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return prop;
	}
}
