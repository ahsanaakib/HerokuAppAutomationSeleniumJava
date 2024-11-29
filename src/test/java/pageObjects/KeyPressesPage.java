package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyPressesPage extends BasePage {

	public KeyPressesPage(WebDriver driver) {
		super(driver);
	}

	
	// ***** WebElements *****

	@FindBy(xpath = "//input[@id='target']")
	WebElement inputField;

	@FindBy(xpath = "//p[@id='result']")
	WebElement resultText;

	
	// ***** Actions *****

	public void enterKey(CharSequence key) {
		inputField.sendKeys(key);
	}

	public String getResultText() {
		return resultText.getText();
	}
}
