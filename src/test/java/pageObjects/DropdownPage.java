package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

	public DropdownPage(WebDriver driver) {
		super(driver);
	}

	// ***** WebElements *****

	@FindBy(xpath = "//select[@id='dropdown']")
	WebElement selectDropDown;

	
	// ***** Actions *****

	public String getSelectedOption() {
		Select select = new Select(selectDropDown);
		return select.getFirstSelectedOption().getText();
	}

	public List<String> getAllDropdownOptions() {
		Select select = new Select(selectDropDown);
		return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public void clickDropDown() {
		selectDropDown.click();
	}

	public void selectOptionByText(String visibleText) {
		Select select = new Select(selectDropDown);
		select.selectByVisibleText(visibleText);
	}

	public boolean isDropdownEnabled() {
		return selectDropDown.isEnabled();
	}

}
