package testCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.KeyPressesPage;
import testBase.BaseClass;

public class TC011_VerifyKeyPresses extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_KeyPresses() {

		logger.info("***** Starting verify_KeyPresses *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickKeyPresses();

			KeyPressesPage kpp = new KeyPressesPage(driver);

			kpp.enterKey(Keys.SHIFT);
			Assert.assertTrue(kpp.getResultText().contains("You entered: SHIFT"), "Result text mismatch!");

			kpp.enterKey(Keys.BACK_SPACE);
			Assert.assertTrue(kpp.getResultText().contains("You entered: BACK_SPACE"), "Result text mismatch!");

			kpp.enterKey(Keys.SPACE);
			Assert.assertTrue(kpp.getResultText().contains("You entered: SPACE"), "Result text mismatch!");

			kpp.enterKey(Keys.CONTROL);
			Assert.assertTrue(kpp.getResultText().contains("You entered: CONTROL"), "Result text mismatch!");

			kpp.enterKey(Keys.ESCAPE);
			Assert.assertTrue(kpp.getResultText().contains("You entered: ESCAPE"), "Result text mismatch!");

			kpp.enterKey(Keys.PAGE_DOWN);
			Assert.assertTrue(kpp.getResultText().contains("You entered: PAGE_DOWN"), "Result text mismatch!");

			kpp.enterKey(Keys.PAGE_UP);
			Assert.assertTrue(kpp.getResultText().contains("You entered: PAGE_UP"), "Result text mismatch!");

			kpp.enterKey(Keys.HOME);
			Assert.assertTrue(kpp.getResultText().contains("You entered: HOME"), "Result text mismatch!");

			kpp.enterKey(Keys.END);
			Assert.assertTrue(kpp.getResultText().contains("You entered: END"), "Result text mismatch!");

			kpp.enterKey("A");
			Assert.assertTrue(kpp.getResultText().contains("You entered: A"), "Result text mismatch!");

		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_KeyPresses *****");
	}
}
