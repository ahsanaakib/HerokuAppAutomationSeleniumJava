package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.InputsPage;
import testBase.BaseClass;

public class TC012_VerifyInputsFunctionality extends BaseClass {

	@Test(groups = { "Sanity", "Regression", "Master" })
	public void verifyNumericInput() {

		logger.info("***** Starting verifyNumericInput *****");

		HomePage hp = new HomePage(driver);
		hp.clickInputs();

		InputsPage inputsPage = new InputsPage(driver);

		String[] testInputs = { "123", "-123", "123.00", "-123.00", "9999999999", "-9999999999", "abcd" };
		boolean[] expectedResults = { true, true, true, true, true, true, false };

		for (int i = 0; i < testInputs.length; i++) {
			inputsPage.enterValue(testInputs[i]);
			String actualValue = inputsPage.getInputValue();

			if (expectedResults[i]) {
				Assert.assertEquals(actualValue, testInputs[i], 
						"Valid input failed:" + testInputs[i]);
			} else
				Assert.assertNotEquals(actualValue, testInputs[i], 
						"Invalid input accepted: " + testInputs[i]);
		}

		inputsPage.enterValue("0");
		String enteredValue = inputsPage.getInputValue();

		inputsPage.incrementValue();
		String valueAfterIncrement = inputsPage.getInputValue();

		Assert.assertEquals(Double.parseDouble(valueAfterIncrement), Double.parseDouble(enteredValue) + 1,
				"Increment failed!");

		inputsPage.decrementValue();
		String valueAfterDecrement = inputsPage.getInputValue();

		Assert.assertEquals(Double.parseDouble(valueAfterDecrement), Double.parseDouble(enteredValue),
				"Decrement failed!");

		logger.info("***** Ending verifyNumericInput *****");
	}
}
