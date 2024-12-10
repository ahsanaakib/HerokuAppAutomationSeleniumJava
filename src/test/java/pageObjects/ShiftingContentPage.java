package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class ShiftingContentPage extends BasePage {

	public ShiftingContentPage(WebDriver driver) {
		super(driver);
	}

	
	// ***** Locators *****

	private By anImageLink = By.linkText("Example 2: An image");
	private By image = By.xpath("//img[@class='shift']");

	
	// ***** Actions *****

	public void clickImageLink() {
		driver.findElement(anImageLink).click();
	}

	public boolean isImagePositionChanged() {

		Point initialPosition = driver.findElement(image).getLocation();
		driver.navigate().refresh();

		Point newPosition = driver.findElement(image).getLocation();

		return !initialPosition.equals(newPosition);
	}

}
