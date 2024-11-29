package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoversPage extends BasePage {

	public HoversPage(WebDriver driver) {
		super(driver);
	}

	
	// ***** WebElements *****

	@FindBy(xpath = "//div[@class='figure']")
	List<WebElement> images;

	@FindBy(xpath = "//div[@class='figcaption']/h5")
	List<WebElement> captions;

	
	// ***** Actions *****

	public int getTotalImages() {
		return images.size();
	}

	public void hoverOverImage(int index) {
		Actions act = new Actions(driver);
		act.moveToElement(images.get(index)).perform();
	}

	public boolean isCaptionDisplayed(int index) {
		return captions.get(index).isDisplayed();
	}

	public String getCaptions(int index) {
		return captions.get(index).getText();
	}
}
