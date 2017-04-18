package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.JobDetailPage;
import pages.JobSearchPage;
import pages.JobSearchResultPage;
import pages.MenuBar;
import pages.RegisterPage;
import pages.SigninPage;

@Listeners(listener.EliteListener.class)

public class TestBase extends SauceLabs {

	public static MenuBar menuBar;
	public static SigninPage signinPage;
	public static RegisterPage registerPage;
	public static JobSearchPage jobsearchPage;
	public static JobDetailPage jobDetailPage;
	
	public static JobSearchResultPage jobsearchResultPage;

	@BeforeSuite
	public void setUp() {

		if (Boolean.valueOf(getProperty("saucelabs"))) {

			setSauceLabs();
		} else {

			setDriver();

		}

		driver.get(getProperty("appUrl"));

		menuBar = PageFactory.initElements(driver, MenuBar.class);
		signinPage = PageFactory.initElements(driver, SigninPage.class);
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		jobsearchPage = PageFactory.initElements(driver, JobSearchPage.class);
		jobsearchResultPage = PageFactory.initElements(driver, JobSearchResultPage.class);
		jobDetailPage = PageFactory.initElements(driver, JobDetailPage.class);

	}

	@AfterSuite
	public void tearDown() {

		driver.quit();
	}

}
