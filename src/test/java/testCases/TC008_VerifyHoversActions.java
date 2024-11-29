package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.HoversPage;
import testBase.BaseClass;

public class TC008_VerifyHoversActions extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_HoversActions() {

		logger.info("***** Starting verify_HoversActions *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickHovers();

			HoversPage hoversPage = new HoversPage(driver);

			int totalImages = hoversPage.getTotalImages();

			for (int i = 0; i < totalImages; i++) {

				hoversPage.hoverOverImage(i);

				Assert.assertTrue(hoversPage.isCaptionDisplayed(i), 
						"Caption is not displayed for image #" + (i + 1));

				String expectedCaption = "name: user" + (i + 1);
				String actualCaption = hoversPage.getCaptions(i);
			
				Assert.assertEquals(actualCaption, expectedCaption, 
						"Caption text mismatch for image #" + (i + 1));
			}
		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_HoversActions *****");
	}
}
