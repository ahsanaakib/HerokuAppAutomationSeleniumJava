package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {

	public FileUploadPage(WebDriver driver) {
		super(driver);
	}

	// ***** WebElements *****

	@FindBy(xpath = "//input[@id='file-upload']")
	WebElement inputChooseFile;

	@FindBy(xpath = "//input[@id='file-submit']")
	WebElement buttonUpload;

	@FindBy(xpath = "//div[@id='uploaded-files']")
	WebElement uploadedFileName;

	
	// ***** Actions *****

	public void uploadFile(String filePath) {
		inputChooseFile.sendKeys(filePath);
		buttonUpload.click();
	}

	public String getUploadedFileName() {
		return uploadedFileName.getText();
	}

}
