package datamanagement;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class AppProperties {

	//self will hold a singleton object of AppProperties Class
	private static AppProperties self_ = null;
	private Properties properties_;

	/**
	 * This method will return a singleton object of AppProperties variable
	 * @return AppProperties instance
	 */
	public static AppProperties getInstance() {
		if (self_ == null) {
			self_ = new AppProperties();
		}
		return self_;
	}

	/**
	 * Private constructor of the singleton class
	 */
	private AppProperties() {
		properties_ = new Properties();
		try {
			properties_.load(new FileInputStream("Properties.prop"));
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
		return properties_;
	}
}

