package datamanagement;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class AppProperties {

	//self will hold a singleton object of AppProperties Class
	private static AppProperties self = null;
	private Properties properties;

	/**
	 * This method will return a singleton object of AppProperties variable
	 * @return AppProperties instance
	 */
	public static AppProperties getInstance() {
		if (self == null) {
			self = new AppProperties();
		}
		return self;
	}

	private AppProperties() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("Properties.prop"));
		} catch (IOException ioException) {
			//Convert the checked exception to a runtime exception
			throw new RuntimeException("Could not read property file");
		}
	}

	/**
	 * Getter method for properties variable;
	 * @return
	 */
	public Properties getProperties() {
		return properties;
	}
}
