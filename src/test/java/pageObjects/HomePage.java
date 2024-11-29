package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	// ***** WebElements *****

	@FindBy(xpath = "//a[normalize-space()='Drag and Drop']")
	WebElement linkDragAndDrop;

	@FindBy(xpath = "//a[normalize-space()='Disappearing Elements']")
	WebElement linkDisappearingElements;

	@FindBy(xpath = "//a[normalize-space()='File Upload']")
	WebElement linkFileUpload;

	@FindBy(xpath = "//a[normalize-space()='Floating Menu']")
	WebElement linkFloatingMenu;

	@FindBy(xpath = "//a[normalize-space()='Frames']")
	WebElement linkFrames;

	@FindBy(xpath = "//a[normalize-space()='Dropdown']")
	WebElement linkDropdown;

	@FindBy(xpath = "//a[normalize-space()='Hovers']")
	WebElement linkHovers;

	@FindBy(xpath = "//a[normalize-space()='Form Authentication']")
	WebElement linkFormAuthentication;

	@FindBy(xpath = "//a[normalize-space()='JavaScript Alerts']")
	WebElement linkJavaScriptAlerts;

	@FindBy(xpath = "//a[normalize-space()='Key Presses']")
	WebElement linkKeyPresses;

	@FindBy(xpath = "//a[normalize-space()='Add/Remove Elements']")
	WebElement linkAddRemoveElements;
	
	
	// ***** Actions *****

	public void clickDragAndDrop() {
		linkDragAndDrop.click();
	}

	public void clickDisappearingElements() {
		linkDisappearingElements.click();
	}

	public void clickFileUpload() {
		linkFileUpload.click();
	}

	public void clickFloatingMenu() {
		linkFloatingMenu.click();
	}

	public void clickFrames() {
		linkFrames.click();
	}

	public void clickDropdown() {
		linkDropdown.click();
	}

	public void clickHovers() {
		linkHovers.click();
	}

	public void clickFormAuthentication() {
		linkFormAuthentication.click();
	}

	public void clickJavaScriptAlerts() {
		linkJavaScriptAlerts.click();
	}

	public void clickKeyPresses() {
		linkKeyPresses.click();
	}
	
	public void clickAddRemoveElements() {		
		linkAddRemoveElements.click();
	}
}
