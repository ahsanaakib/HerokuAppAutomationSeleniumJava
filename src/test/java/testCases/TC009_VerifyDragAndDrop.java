package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DragAndDropPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC009_VerifyDragAndDrop extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_DragAndDrop() {

		logger.info("***** Starting verify_DragAndDrop *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickDragAndDrop();

			DragAndDropPage ddp = new DragAndDropPage(driver);

			ddp.performDragAndDrop();

			// Validate drag-and-drop success
			boolean isSuccessful = ddp.isDragAndDropSuccessful();

			Assert.assertTrue(isSuccessful, "Drag and drop operation failed.");

		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_DragAndDrop *****");
	}
}
