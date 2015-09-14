package com.institute.validation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class UserAuthentication {
	private static String userLoginFile = "c:/aruna/temp/dataLoginUsersXML.xml";

	public static boolean validateUser(String userId, String userPwd) {
		boolean isValid = false;
		Hashtable<String, String> hList = PropertiesReading
				.getLoginUsersList(userLoginFile);
		if (userId == null || userPwd == null) {
			isValid = false;
			return isValid;
		}
		if (hList.containsKey(userId) && hList.get(userId).equals(userPwd)) {
			isValid = true;
		}

		return isValid;
	}

	public void readXMLPropertiesTest() {
		System.out.println("Reading XML prperties file ");
		InputStream in;
		try {
			in = new FileInputStream("c:/aruna/temp/dataLoginUsersXML.xml");

			Properties prop = new Properties();

			prop.loadFromXML(in);

			for (String key : prop.stringPropertyNames()) {
				String value = prop.getProperty(key);
				System.out.println(key + " = " + value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
