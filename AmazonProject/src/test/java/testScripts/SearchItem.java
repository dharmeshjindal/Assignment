package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
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
		  
		  landingPage.clickHamburgerMenu();
		  commonMethod.implicitWaitApply();
		  commonMethod.waitForElementToAppear(By.xpath("//div[text()='TV, Appliances, Electronics']"));
		  commonMethod.implicitWaitApply();
		  landingPage.clickShopByDepartmentSection();
		  commonMethod.implicitWaitApply();
		  //AbstractComponenets.waitForElementToAppear(By.xpath("//a[text()='Televisions']"));
		  landingPage.television();
		  commonMethod.implicitWaitApply();
		  
		  landingPage.brandSectionElements();
		  commonMethod.implicitWaitApply();
		  landingPage.sortResults();
		  
		  commonMethod.implicitWaitApply();
		  landingPage.selectItemFromResultSet();
		  
		  commonMethod.implicitWaitApply();
		  commonMethod.switchToBrowserTab();
		   
		   commonMethod.implicitWaitApply();
		   Assert.assertEquals(itemDetails.aboudThisItem(), "About this item") ;
		   itemDetails.aboudThisItemSection();
	}
	
}
