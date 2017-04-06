package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ReadProperties;

public class Driver extends ReadProperties {

	public static void main(String[] args) {

	}

	// Declare one field variable.
	// Create instance for WebDriver

	// initialize down by driver

	public static WebDriver driver;

	public void setDriver() {

		if (getProperty("browser").equalsIgnoreCase("fireFox")) {

			initFirefox();

		} else {

			initFirefox();
		}

		setDriverProperties();
		// driver.get(getProperty("appUrl")); remove from here due to transfer
		// testbase
	}

	private void initFirefox() {

		driver = new FirefoxDriver();

	}

	private void setDriverProperties() {

	}

}
