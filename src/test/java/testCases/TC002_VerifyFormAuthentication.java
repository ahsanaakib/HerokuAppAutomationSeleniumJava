package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.FormAuthenticationPage;
import testBase.BaseClass;

public class TC002_VerifyFormAuthentication extends BaseClass {

	@Test(priority = 1, groups = { "Sanity", "Smoke", "Regression", "Master" })
	public void verify_ValidLogin() {

		logger.info("***** Starting verify_ValidLogin *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickFormAuthentication();

			FormAuthenticationPage formAuthpage = new FormAuthenticationPage(driver);

			formAuthpage.login("tomsmith", "SuperSecretPassword!");

			String flashMessage = formAuthpage.getFlashMessage();

			Assert.assertTrue(flashMessage.contains("You logged into a secure area!"),
					"Login success message is incorrect.");

			formAuthpage.clickLogout();

			flashMessage = formAuthpage.getFlashMessage();
			
			Assert.assertTrue(flashMessage.contains("You logged out of the secure area!"),
					"Logout message is incorrect.");
			
		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_ValidLogin *****");
	}

	@Test(priority = 2, groups = { "Sanity", "Smoke", "Regression", "Master" })
	public void verify_InvalidLogin() {

		logger.info("***** Starting verify_InvalidLogin *****");
		try {
			FormAuthenticationPage formAuthpage = new FormAuthenticationPage(driver);

			formAuthpage.login("invalidUser", "invalidPassword");

			String flashMessage = formAuthpage.getFlashMessage();

			Assert.assertTrue(flashMessage.contains("Your username is invalid!"), 
					"Error message is incorrect.");
			
		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_InvalidLogin *****");
	}

	@Test(priority = 3, groups = { "Sanity", "Smoke", "Regression", "Master" })
	public void verify_BlankFieldsLogin() {

		logger.info("***** Starting verify_BlankFieldsLogin *****");
		try {
			FormAuthenticationPage formAuthpage = new FormAuthenticationPage(driver);

			formAuthpage.login("", "");

			String flashMessage = formAuthpage.getFlashMessage();

			Assert.assertTrue(flashMessage.contains("Your username is invalid!"), 
					"Error message is incorrect.");

		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_BlankFieldsLogin *****");
	}
}
