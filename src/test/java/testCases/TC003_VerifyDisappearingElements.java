package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DisappearingElementsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC003_VerifyDisappearingElements extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_DisappearingElements() {
		
		logger.info("***** Starting verify_DisappearingElements *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickDisappearingElements();

			DisappearingElementsPage dep = new DisappearingElementsPage(driver);
			List<String> initialMenuItems = dep.getMenuItemTexts();			

			int reloadCount = 5;
			for (int i = 1; i <= reloadCount; i++) {
				driver.navigate().refresh();

				List<String> menuItemsAfterReload = dep.getMenuItemTexts();			

				Assert.assertEquals(menuItemsAfterReload, initialMenuItems, 
						"Menu items mismatch after reload #" + i);
			}
		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_DisappearingElements *****");
	}
}
