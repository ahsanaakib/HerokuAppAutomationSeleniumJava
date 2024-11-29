package testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.JavaScriptAlertsPage;
import testBase.BaseClass;

public class TC010_VerifyJavaScriptAlerts extends BaseClass {

	@Test(priority = 1, groups = { "Regression", "Master" })
	public void verify_JsAlert() {

		logger.info("***** Starting verify_JsAlert *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickJavaScriptAlerts();

			JavaScriptAlertsPage jap = new JavaScriptAlertsPage(driver);
			jap.clickJsAlert();

			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), "I am a JS Alert", 
					"Alert text mismatch!");
			alert.accept();

			Assert.assertEquals(jap.getResultText(), "You successfully clicked an alert", 
					"Result text mismatch!");

		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_JsAlert *****");
	}

	@Test(priority = 2, groups = { "Regression", "Master" })
	public void verify_JsConfirmAccept() {

		logger.info("***** Starting verify_JsConfirmAccept *****");
		try {
			JavaScriptAlertsPage jap = new JavaScriptAlertsPage(driver);
			jap.clickJsConfirm();

			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), "I am a JS Confirm", 
					"Alert text mismatch!");

			alert.accept();

			Assert.assertEquals(jap.getResultText(), "You clicked: Ok", 
					"Result text mismatch!");

		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_JsConfirmAccept *****");
	}

	@Test(priority = 3, groups = { "Regression", "Master" })
	public void verify_JsConfirmDismiss() {

		logger.info("***** Starting verify_JsConfirmDismiss *****");
		try {
			JavaScriptAlertsPage jap = new JavaScriptAlertsPage(driver);
			jap.clickJsConfirm();

			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), "I am a JS Confirm", 
					"Alert text mismatch!");

			alert.dismiss();

			Assert.assertEquals(jap.getResultText(), "You clicked: Cancel", 
					"Result text mismatch!");
			
		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_JsConfirmDismiss *****");
	}

	@Test(priority = 4, groups = { "Regression", "Master" })
	public void verify_JsPrompt() {

		logger.info("***** Starting verify_JsPrompt *****");
		try {
			JavaScriptAlertsPage jap = new JavaScriptAlertsPage(driver);
			jap.clickJsPrompt();
			;

			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), "I am a JS prompt", 
					"Alert text mismatch!");

			String input = "Testing";
			alert.sendKeys(input);
			alert.accept();

			Assert.assertEquals(jap.getResultText(), "You entered: " + input, 
					"Result text mismatch!");

		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_JsPrompt *****");
	}
}
