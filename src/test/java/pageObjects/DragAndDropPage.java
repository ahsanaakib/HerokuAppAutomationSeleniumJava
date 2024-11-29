package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

	public DragAndDropPage(WebDriver driver) {
		super(driver);
	}

	//***** WebElements *****
	
	@FindBy(xpath = "//div[@id='column-a']")
	WebElement dragMe;
	@FindBy(xpath = "//div[@id='column-b']")
	WebElement dropHere;


	//***** Actions *****
	
	Actions act = new Actions(driver);

	public void performDragAndDrop() {
		act.dragAndDrop(dragMe, dropHere).perform();
	}

	public boolean isDragAndDropSuccessful() {
		return dropHere.getText().equals("A");
	}

}
