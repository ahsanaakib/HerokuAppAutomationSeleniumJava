package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAuthenticationPage extends BasePage {

	public FormAuthenticationPage(WebDriver driver) {
		super(driver);
	}

	// ***** WebElements *****

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//div[@id='flash']")
	WebElement flashMessage;

	@FindBy(xpath = "//a[@class='button secondary radius']")
	WebElement btnLogout;

	
	// ***** Actions *****

	public void login(String uname, String pwd) {
		username.clear();
		username.sendKeys(uname);

		password.clear();
		password.sendKeys(pwd);

		btnSubmit.click();
	}

	public String getFlashMessage() {
		return flashMessage.getText();
	}

	public void clickLogout() {
		btnLogout.click();
	}

}
