package com.Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private ConfigReader() {
		//singleton by making constructor private so that no one from outside this class creates extra objects.
	}
	//making this property private as is only available to this class and nobody can change it from outside
	private static Properties pro = null;
	private static void initialize() {
	try {
		pro = new Properties();
		FileReader file = new FileReader("src/test/resources/Config/config.properties");
		pro.load(file);
	    } catch (IOException e) {
		LoggerLoad.error("Eror while loading the properties file."+ e.getMessage());
	 }
    }
	
	public static Properties getPropertyObject() {
		if( pro == null ) {
			initialize();
		}
		return pro;
	}
}