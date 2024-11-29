package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends BasePage {

	public FloatingMenuPage(WebDriver driver) {
		super(driver);
	}

	// ***** WebElements *****

	@FindBy(xpath = "//div[@id='menu']")
	WebElement floatingMenu;

	@FindBy(xpath = "//div[@id='menu']//a")
	List<WebElement> linkFloatingMenu;

	
	// ***** Actions *****

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000);");
	}

	public boolean isFloatingMenuVisible() {
		return floatingMenu.isDisplayed();
	}

	public boolean verifyMenuLinks() {
		for (WebElement links : linkFloatingMenu) {
			if (!links.isEnabled()) {
				return false;
			}
		}
		return true;
	}
}
