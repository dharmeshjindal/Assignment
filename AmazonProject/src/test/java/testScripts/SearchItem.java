package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.ItemDetails;
import pages.LandingPage;
import reusableComponenets.AbstractComponenets;

public class SearchItem extends TestBase{
	
public static WebDriver driver;
	
	LandingPage landingPage;
	AbstractComponenets commonMethod;
	ItemDetails itemDetails;
	

	@BeforeMethod
	public void setUp() {
		initialize();
	}
	
	
	@Test()
	public void filterProduct() throws InterruptedException {
		landingPage = new LandingPage();
		AbstractComponenets commonMethod = new AbstractComponenets();
		  ItemDetails itemDetails = new ItemDetails();
		  commonMethod.navigateToURL("https://www.amazon.in/");
		  landingPage.clickHamburgerMenu();
		  commonMethod.implicitWaitApply();
		  commonMethod.waitForElementToAppear(By.xpath("//div[text()='TV, Appliances, Electronics']"));
		  commonMethod.implicitWaitApply();
		  landingPage.clickShopByDepartmentSection();
		  commonMethod.implicitWaitApply();
		  
		  landingPage.television();
		  commonMethod.implicitWaitApply();
		  
		  landingPage.brandSectionElements("Samsung");
		  commonMethod.implicitWaitApply();
		  landingPage.sortResults();
		  
		  commonMethod.implicitWaitApply();
		  landingPage.selectItemFromResultSet();
		  
		  commonMethod.implicitWaitApply();
		  commonMethod.switchToBrowserTab();
		   
		   commonMethod.implicitWaitApply();
		   Assert.assertEquals(itemDetails.aboudThisItem(), "About this item") ;
		   itemDetails.aboudThisItemSection();
		   commonMethod.closeCurrentTabAndswitchToParentTab();
	}
	
	@AfterMethod
	public void tearDown() {
		
		closeWebBrowser();
	}
	
}
