package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRemoveElementsPage extends BasePage{

	public AddRemoveElementsPage(WebDriver driver) {
		super(driver);		
	}
	
	//***** WebElements *****
	
	@FindBy(xpath = "//button[normalize-space()='Add Element']")
	WebElement btnAddElement;
	
	@FindBy(xpath = "//button[normalize-space()='Delete']")
	List <WebElement> btnsDelete;
	
	
	//***** Actions *****
	
	public void clickAddElementButton() {
		btnAddElement.click();
	}
	
	public void clickDeleteButton(int index) {
		btnsDelete.get(index).click();
	}
	
	public int getDeleteButtonsCount() {
		return btnsDelete.size();
	}
	

}
