package com.institute.validation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class PropertiesReading {
	public static  Hashtable<String,String> getLoginUsersList(String fileName) {
		Hashtable<String, String> userList = new Hashtable<String, String>();
		// System.out.println("Reading XML prperties file ");
		InputStream in;
		try {
			in = new FileInputStream(fileName);
			// "c:/aruna/temp/dataLoginUsersXML.xml");

			Properties prop = new Properties();

			prop.loadFromXML(in);

			for (String key : prop.stringPropertyNames()) {
				String value = prop.getProperty(key);
				userList.put(key, value);
				// System.out.println(key + " = " + value);
			}
			
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
