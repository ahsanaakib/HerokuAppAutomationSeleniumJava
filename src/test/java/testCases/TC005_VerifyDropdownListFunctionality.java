package testCases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DropdownPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC005_VerifyDropdownListFunctionality extends BaseClass {

	@Test(groups = { "Sanity", "Regression", "Master" })
	public void verify_DropdownList() {

		logger.info("***** Starting verify_DropdownList *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickDropdown();

			DropdownPage dp = new DropdownPage(driver);

			String defaultOption = dp.getSelectedOption();

			Assert.assertEquals(defaultOption, "Please select an option", 
					"Default option is incorrect!");

			List<String> expectedOptions = Arrays.asList("Please select an option", "Option 1", "Option 2");
			List<String> actualOptions = dp.getAllDropdownOptions();

			Assert.assertEquals(actualOptions, expectedOptions, 
					"Dropdown options do not match!");

			for (int i = 1; i < expectedOptions.size(); i++) {

				String optionToSelect = expectedOptions.get(i);

				dp.selectOptionByText(optionToSelect);

				String selectedOption = dp.getSelectedOption();

				Assert.assertEquals(selectedOption, optionToSelect,
						"Failed to select the correct option: " + optionToSelect);
			}

			Assert.assertTrue(dp.isDropdownEnabled(), "Dropdown is not enabled!");
			
		} catch (Exception e) {

			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending verify_DropdownList *****");
	}
}
