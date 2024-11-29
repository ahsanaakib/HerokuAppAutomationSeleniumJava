package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddRemoveElementsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC006_VerifyAddRemoveElements extends BaseClass {

	@Test(groups = { "Sanity", "Regression", "Master" })
	public void verify_AddRemoveElements() {

		logger.info("***** Starting verify_AddRemoveElements *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickAddRemoveElements();

			AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage(driver);

			int elementsToAdd = 5;

			for (int i = 0; i < elementsToAdd; i++) {
				addRemovePage.clickAddElementButton();
			}

			int countAfterAdd = addRemovePage.getDeleteButtonsCount();

			Assert.assertEquals(countAfterAdd, elementsToAdd, 
					"Mismatch in the number of added elements.");

			for (int i = countAfterAdd - 1; i >= 0; i--) {
				addRemovePage.clickDeleteButton(i);
				int countAfterRemove = addRemovePage.getDeleteButtonsCount();

				Assert.assertEquals(countAfterRemove, i, 
						"Mismatch in the number of remaining elements after removal.");
			}

			int finalCount = addRemovePage.getDeleteButtonsCount();
			
			Assert.assertEquals(finalCount, 0, 
					"Elements are still present after removing all.");

		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_AddRemoveElements *****");
	}
}
