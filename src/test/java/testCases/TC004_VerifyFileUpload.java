package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FileUploadPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC004_VerifyFileUpload extends BaseClass {

	@Test(groups = { "Smoke", "Regression", "Master" })
	public void verify_FileUpload() {
		
		logger.info("***** Starting verify_FileUpload *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickFileUpload();

			FileUploadPage fup = new FileUploadPage(driver);

			String filePath = System.getProperty("user.dir") + "/testData/test.txt";

			fup.uploadFile(filePath);

			String uploadedFileName = fup.getUploadedFileName();			

			Assert.assertEquals(uploadedFileName, "test.txt", 
					"Uploaded file name does not match!");

		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_FileUpload *****");
	}
}
