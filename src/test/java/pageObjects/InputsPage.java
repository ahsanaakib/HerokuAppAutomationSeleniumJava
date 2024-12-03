package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class InputsPage extends BasePage {

	public InputsPage(WebDriver driver) {
		super(driver);
	}

	// ***** WebElements *****

	@FindBy(xpath = "//input[@type='number']")
	WebElement inputField;

	// ***** Actions *****

	Actions act = new Actions(driver); 
	
	public void enterValue(String value) {
		inputField.clear();
		inputField.sendKeys(value);
	}

	public String getInputValue() {
		return inputField.getDomProperty("value");
	}
	
	public void incrementValue() {
		act.sendKeys(Keys.ARROW_UP).perform();;
	}
	
	public void decrementValue() {
		act.sendKeys(Keys.ARROW_DOWN).perform();;
	}

}
