package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import base.TestBase;

public class ItemDetails extends TestBase {

	public ItemDetails() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='feature-bullets']")
	WebElement aboutThisItemSection;
	
	@FindBy(xpath="//div[@id='feature-bullets']/h1")
	WebElement AboutThisItem;
	
	
	
	public void aboudThisItemSection() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(aboutThisItemSection).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		System.out.println(aboutThisItemSection.getText());
		Reporter.log(aboutThisItemSection.getText());
	}
	
	public String aboudThisItem() {
		Actions act = new Actions(driver);
		act.moveToElement(AboutThisItem).perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		return AboutThisItem.getText();
		
	}
	
	
}
