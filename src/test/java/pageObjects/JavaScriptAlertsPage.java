package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

	public JavaScriptAlertsPage(WebDriver driver) {
		super(driver);
	}

	
	// ***** WebElements *****

	@FindBy(xpath = "//button[normalize-space()='Click for JS Alert']")
	WebElement btnJsAlert;

	@FindBy(xpath = "//button[normalize-space()='Click for JS Confirm']")
	WebElement btnJsConfirm;

	@FindBy(xpath = "//button[normalize-space()='Click for JS Prompt']")
	WebElement btnJsPrompt;

	@FindBy(xpath = "//p[@id='result']")
	WebElement textResult;

	
	// ***** Actions *****

	public void clickJsAlert() {
		btnJsAlert.click();
	}

	public void clickJsConfirm() {
		btnJsConfirm.click();
	}

	public void clickJsPrompt() {
		btnJsPrompt.click();
	}

	public String getResultText() {
		return textResult.getText();
	}

}
