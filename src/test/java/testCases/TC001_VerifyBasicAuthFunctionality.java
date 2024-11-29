package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasicAuthPage;
import testBase.BaseClass;

public class TC001_VerifyBasicAuthFunctionality extends BaseClass {

	@Test(groups = { "Sanity", "Smoke", "Regression", "Master" })
	public void verify_BasicAuthFunctionality() {

		logger.info("***** Starting verify_BasicAuthFunctionality *****");
		try {
			BasicAuthPage bap = new BasicAuthPage(driver);

			bap.navigateToBasicAuth("admin", "admin");

			boolean authStatus = bap.isAuthSuccessMessageDisplayed();

			// Validate the success message
			Assert.assertTrue(authStatus, "Basic Auth success message is not displayed.");

		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_BasicAuthFunctionality *****");
	}
}
