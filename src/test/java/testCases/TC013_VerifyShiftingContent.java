package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ShiftingContentPage;
import testBase.BaseClass;

public class TC013_VerifyShiftingContent extends BaseClass {

	@Test(groups = { "Sanity", "Regression", "Master" })
	public void verifyImageDoesNotShift() {

		logger.info("***** Starting verifyImageDoesNotShift *****");
		
		HomePage hp = new HomePage(driver);
		hp.clickShiftingContent();
		
		ShiftingContentPage shiftContentPage = new ShiftingContentPage(driver);
		shiftContentPage.clickImageLink();			
		
		Assert.assertFalse(shiftContentPage.isImagePositionChanged(),
				"Image position has shifted!");
		
		logger.info("***** Ending verifyImageDoesNotShift *****");
		
	}
}
