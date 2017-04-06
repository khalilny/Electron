package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties {

//	public void main(String[]args){
	// System.out.println(getSaucelabsProperty("userName"));

//	}

	public static String getProperty(String key) {
		String value = null;

		Properties prop = loadProperty("testRun");
		value = prop.getProperty(key);

		if (value == null) {

			String testEnv = prop.getProperty("testEnv");
			// System.out.println(testEnv);

			prop = loadProperty(testEnv);

			value = prop.getProperty(key);

			// System.out.println(testEnv);

		}

		if (value != null) {

			value = value.trim();

		}
		// we can write- down way also- instead of up way
		// value = (value != null)? value.trim():value;

		// container = condition ? if-block:else-block

		return value;
	}

	public static String getSaucelabsProperty(String key) {

		String value = null;

		Properties prop = loadProperty("saucelabs");

		value = prop.getProperty(key);

		if (value != null) {

			value = value.trim();

		}

		return value;
	}

	public static Properties loadProperty(String propFileName) {

		Properties prop = new Properties();
		String filePath = "./src/main/resources/properties/" + propFileName.trim() + ".properties";

		// System.out.println(filePath);

		try {
			File file = new File(filePath);

			FileInputStream fileStream = new FileInputStream(file);

			prop.load(fileStream);

			// System.out.println(fileStream);
		} catch (Exception e) {

			e.printStackTrace();
		}
		// route --> filePath --> file --> fileStream --> prop.load(fileStream);
		// --> prop
		// String (filePath) Converted to File (file) Data Type
		// File file = new file("./src/main/resources/properties/" +
		// fileName.trim() + ".properties";);
		// file converted to FileInputStream (fileStream) Data Type
		// .load Method only Accept FileInputStream -- Data Type .

		return prop;
	}

}
