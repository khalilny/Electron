package tests;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestSigninPage extends TestBase {

	@BeforeClass
	public void classSetUp() {

		menuBar.signinLink.click();

	}

	@Test
	public void testWithValidEmailAndValidPassword() {
		// two way for crdential
		// signinPage.signin("shakil_ipe@yahoo.com", "365827");

		signinPage.signin(getProperty("empEmail"), getProperty("empPassword"));
		Assert.assertTrue(signinPage.getCurrentUrl().contains("/profile"));

		menuBar.logoutLink.click();
		menuBar.signinLink.click();
	}

	@Test
	public void testWithInValidEmailAndValidPassword() {
		// two way for crdential
		// signinPage.signin("shakil_ipe@yahoo.com", "365827");
		signinPage.signin("invalidshakil-ipe@yahoo.com", getProperty("empPassword"));
		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signinPage.errorList.get(0).getText(), "* Email or Password is incorrect.");

		
	}

	@Test
	public void testWithValidEmailAndInValidPassword() {
		// two way for crdential
		// signinPage.signin("shakil_ipe@yahoo.com", "365827");

		signinPage.signin(getProperty("empEmail"), "inValidPassword");

		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));

		Assert.assertEquals(signinPage.errorList.get(0).getText(), "* Email or Password is incorrect.");

		
	}

	@Test
	public void testWithEmptyEmailAndValidPassword() {
		// two way for crdential
		// signinPage.signin("shakil_ipe@yahoo.com", "365827");

		signinPage.signin("", getProperty("empPassword"));

		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signinPage.errorList.get(0).getText(), "* Email can not be empty.");

		
	}

	@Test
	public void testWithInvalidEmailAndInValidPassword() {
		// two way for crdential
		// signinPage.signin("shakil_ipe@yahoo.com", "365827");

		signinPage.signin("invalid@yahoo.com","invalidPassword");

		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));
		
		Assert.assertEquals(signinPage.errorList.get(0).getText(), "* Email or Password is incorrect.");

		
	}

	@Test
	public void testWithValidEmailAndEmptyPassword() {
		// two way for crdential
		// signinPage.signin("shakil_ipe@yahoo.com", "365827");
		signinPage.signin(getProperty("empEmail"), "");
		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signinPage.errorList.get(0).getText(), "* Email or Password is incorrect.");
		Assert.assertEquals(signinPage.errorList.get(1).getText(), "* Password can not be empty.");

		
	}

	@Test
	public void testWithEmptyEmailAndEmptyPassword() {
		// two way for crdential
		// signinPage.signin("shakil_ipe@yahoo.com", "365827");

		signinPage.signin("", "");
		Assert.assertTrue(signinPage.getCurrentUrl().contains("/signin"));
		Assert.assertEquals(signinPage.errorList.get(0).getText(), "* Email can not be empty.");
		Assert.assertEquals(signinPage.errorList.get(1).getText(), "* Password can not be empty.");
		menuBar.signinLink.click();
	}

	@AfterClass
	public void classTearDown() {
		menuBar.jobSearchPageLink.click();

	}

}
