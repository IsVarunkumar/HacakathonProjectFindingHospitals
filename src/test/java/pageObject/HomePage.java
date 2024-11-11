package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseClass{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='practo-logo']//a[@class='nav-interact']") 
	WebElement homePageNavigation;
	@FindBy(xpath = "//a[@aria-label='Surgeries']")
	WebElement surgeriButton;
	@FindBy(xpath="//span[normalize-space()='Search for hospitals']") 
	WebElement SearchAllHospetials;
	@FindBy(xpath = "//a[@href=\"/plus/corporate\"]")
	WebElement wellnessLink;
	
	public void homepageNavigation() {
		homePageNavigation.click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickONSurgeries() {
		wait.until(ExpectedConditions.visibilityOf(surgeriButton));
		surgeriButton.click();
	}
	
	public void searchAllHospetials() {
		Actions action = new Actions(driver);
		action.moveToElement(SearchAllHospetials).perform();
		SearchAllHospetials.click();
	}
	
	public void clickOnWellnesslink() {
		wellnessLink.click();
	}
	
}
