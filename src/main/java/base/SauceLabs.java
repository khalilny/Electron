package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs extends Driver {

	DesiredCapabilities caps;

	public void setSauceLabs() {

		String URL = "https://" + getSaucelabsProperty("userName") + ":" + getSaucelabsProperty("accessKey")
				+ "@ondemand.saucelabs.com:443/wd/hub";
		setCapabilities();

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		// command shift o import java . url

		// driver.get(getProperty("appUrl")); move to testbase no need here

	}

	public void setCapabilities() {

		if (getSaucelabsProperty("browser").equalsIgnoreCase("chrome")) {

			caps = DesiredCapabilities.chrome();

		} else if (getSaucelabsProperty("browser").equalsIgnoreCase("fireFox")) {

			caps = DesiredCapabilities.firefox();

		} else if (getSaucelabsProperty("browser").equalsIgnoreCase("safari")) {

			caps = DesiredCapabilities.safari();

		} else if (getSaucelabsProperty("browser").equalsIgnoreCase("IE")) {

			caps = DesiredCapabilities.internetExplorer();

		} else {
			caps = DesiredCapabilities.firefox();

		}

		caps.setCapability("platform", getSaucelabsProperty("operatingSystem"));
		caps.setCapability("version", getProperty("browserVersion"));

	}

}
