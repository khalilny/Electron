package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestRegisterPage extends TestBase {

	@BeforeClass

	public void classSetUp() {

		menuBar.registerLink.click();

	}

	@Test

	public void testFirstNameWithOneChar() {
		registerPage.processTextField(registerPage.firstNameField, "a");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(),
				"* FirstName can not be less than 2 character.");

	}

	@Test

	public void testFirstNameWithTwoChar() {
		registerPage.processTextField(registerPage.firstNameField, "ab");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "*");

	}

	@Test

	public void testFirstNameWithThirtyChar() {
		registerPage.processTextField(registerPage.firstNameField, "abcdefghijklmnopqurstxyyyyyyyp");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "*");

	}

	@Test

	public void testFirstNameWithThirtyOneChar() {
		registerPage.processTextField(registerPage.firstNameField, "abcdefghijklmnopqurstxyyyyyyypp");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(),
				"* FirstName can not be greater than 30 character.");

	}

	@Test

	public void testFirstNameWithEmptyField() {
		registerPage.processTextField(registerPage.firstNameField, "");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "* FirstName can not be empty.");

	}

	@Test

	public void testFirstNameWithNumericData() {
		registerPage.processTextField(registerPage.firstNameField, "12345");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(0).getText(), "*");

	}

	@Test

	public void testLastNameWithOneChar() {
		registerPage.processTextField(registerPage.lastNameField, "a");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "* LastName can not be less than 2 character.");

	}

	@Test

	public void testLastNameWithTwoChar() {
		registerPage.processTextField(registerPage.lastNameField, "ab");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "*");

	}

	@Test

	public void testLastNameWithThirtyChar() {
		registerPage.processTextField(registerPage.lastNameField, "abcdefghijklmnopqurstxyyyyyyyp");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "*");

	}

	@Test

	public void testLastNameWithThirtyOneChar() {
		registerPage.processTextField(registerPage.lastNameField, "abcdefghijklmnopqurstxyyyyyyypp");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(),
				"* LastName can not be greater than 30 character.");

	}

	@Test

	public void testLastNameWithEmptyField() {
		registerPage.processTextField(registerPage.lastNameField, "");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "* LastName can not be empty.");

	}

	@Test

	public void testLastNameWithNumericData() {
		registerPage.processTextField(registerPage.lastNameField, "12345");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(1).getText(), "*");

	}

	@Test

	public void testGenderWithRandomOption() {
		registerPage.processDropDownList(registerPage.genderDropDownList);
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(2).getText(), "*");

	}

	@Test

	public void testGenderWithoutSelectedOption() {
		// reload for drop down list empty field
		menuBar.registerLink.click();
		registerPage.submitButton.click();
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(2).getText(), "* Gender can not be empty.");

	}

	@Test
	public void testDateOfBirthWithValidCredential() {
		registerPage.dateOfBirthField.sendKeys("1980-02-15");
		registerPage.submitButton.click();
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(3).getText(), "*");

	}

	@Test
   
	public void testDateOfBirthWithFutureDateCredential() {
		menuBar.registerLink.click();
		registerPage.dateOfBirthField.sendKeys("2020-02-15");
		registerPage.submitButton.click();
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(3).getText(), "*");

	}

	@Test
	public void testDateOfBirthWithEmptyCredential() {
		registerPage.processTextField(registerPage.dateOfBirthField, "");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(3).getText(), "* DateOfBirth can not be empty.");

	}
	
	
	@Test

	public void testPhoneNumberWithThreeDigitNumber() {
		registerPage.processTextField(registerPage.phoneNoField, "123");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(4).getText(), "*");

	}
	
	
	

	@Test

	public void testPhoneNumberWithThirtyDigitNumber() {
		registerPage.processTextField(registerPage.phoneNoField, "123456789123456789123456789123");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(4).getText(), "*");

	}

	@Test

	public void testPhoneNumberWithTwpDigitNumber() {
		registerPage.processTextField(registerPage.phoneNoField, "12");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(4).getText(), "* PhoneNo can not be less than 3 character.");

	}

	@Test

	public void testPhoneNumberWithEmptyDigitNumber() {
		registerPage.processTextField(registerPage.phoneNoField, "");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(4).getText(), "* PhoneNo can not be empty.");

	}

	@Test
	public void testUserTypeWithRandomOption() {

		registerPage.processDropDownList(registerPage.userTypeDropDownList);
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(5).getText(), "*");

	}

	@Test

	public void testUserTypeWithoutSelectedOption() {
		// reload for drop down list empty field
		menuBar.registerLink.click();
		registerPage.submitButton.click();
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(5).getText(), "* UserType can not be empty.");

	}

	@Test
	public void testEmailFieldWithValidEmailID() {
		registerPage.processTextField(registerPage.emailField, "ibrahim10346@yahoo.com");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(6).getText(), "*");

	}

	@Test
	public void testEmailFieldWithInValidEmailId() {
		registerPage.processTextField(registerPage.emailField, "6@yahoo");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(6).getText(), "* Invalid Email");

	}

	@Test
	public void testEmailFieldWithEmptyEmail() {
		registerPage.processTextField(registerPage.emailField, "");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(6).getText(), "* Email can not be empty.");

	}

	@Test
	public void testPasswordFieldWithSixCharacter() {
		registerPage.processTextField(registerPage.passwordField, "365827");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(), "*");

	}

	@Test
	public void testPasswordFieldWithNumberAndCharacter() {
		registerPage.processTextField(registerPage.passwordField, "abcd123");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(), "*");

	}
	@Test
	public void testPasswordFieldWithTwentyCharacter() {
		registerPage.processTextField(registerPage.passwordField, "abcdefghijklmnopqrst");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(), "*");

	}

	@Test
	public void testPasswordFieldWithTwentyOneCharacter() {
		registerPage.processTextField(registerPage.passwordField, "asdfghjklqwertyuiopas");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(),
				"* Password can not be greater than 20 character.");

	}

	@Test
	public void testPasswordFieldWithEmptyPassword() {
		registerPage.processTextField(registerPage.passwordField, "");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(), "* Password can not be empty.");

	}

	@Test
	public void testPasswordFieldWithFiveCharacter() {
		registerPage.processTextField(registerPage.passwordField, "abcde");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(7).getText(), "* Password can not be less than 6 character.");

	}

	@Test
	public void testConfirmPasswordFieldWithValidPasswordAndSameConfirmPassword() {
		registerPage.passwordField.sendKeys("365827");
		registerPage.processTextField(registerPage.confirmPasswordField, "365827");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(8).getText(), "*");

	}
	
	@Test
	public void testConfirmPasswordFieldWithValidPasswordAndDifferentConfirmPassword() {
		registerPage.passwordField.sendKeys("365827");
		registerPage.processTextField(registerPage.confirmPasswordField, "365826");
		Assert.assertTrue(registerPage.getCurrentUrl().contains("/register"));
		Assert.assertEquals(registerPage.errorMessage.get(8).getText(), "* ConfirmPassword did not match.");

	}
	
	
	
	@AfterClass
	void classTearDown() {
		menuBar.jobSearchPageLink.click();

	}

}
