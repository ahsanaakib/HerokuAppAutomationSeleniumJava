package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FloatingMenuPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC007_VerifyFloatingMenuFunctionality extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_FloatingMenuFunctionality() {

		logger.info("***** Starting verify_FloatingMenuFunctionality *****");

		HomePage hp = new HomePage(driver);
		hp.clickFloatingMenu();

		FloatingMenuPage fmp = new FloatingMenuPage(driver);

		fmp.scrollDown();

		// Verify that the floating menu is still visible
		Assert.assertTrue(fmp.isFloatingMenuVisible(), 
				"Floating menu is not visible after scrolling!");

		// Verify links are click able
		Assert.assertTrue(fmp.verifyMenuLinks(), 
				"Some floating menu links are not functional!");

		logger.info("***** Ending verify_FloatingMenuFunctionality *****");
	}
}
