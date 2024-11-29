package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage extends BasePage {

	public BasicAuthPage(WebDriver driver) {
		super(driver);
	}

	// ***** WebElements *****

	@FindBy(xpath = "//p[contains(text(), 'Congratulations!')]")
	WebElement msgAuth;

	
	
	// ***** Actions *****

	// Navigate to Basic Authentication with credentials in the URL
	public void navigateToBasicAuth(String username, String password) {
		String authURL = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
		driver.get(authURL);
	}

	// Check if the success message is displayed
	public boolean isAuthSuccessMessageDisplayed() {
		return msgAuth.isDisplayed();
	}

}
