package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DisappearingElementsPage extends BasePage {

	public DisappearingElementsPage(WebDriver driver) {
		super(driver);
	}

	
	//***** WebElements *****
	
	@FindBy(xpath = "//div[@class='example']//li")
	List<WebElement> menuItems;

	
	//***** Actions *****
	
	public List<String> getMenuItemTexts() {
		return menuItems.stream().map(WebElement::getText).toList();
	}

}
