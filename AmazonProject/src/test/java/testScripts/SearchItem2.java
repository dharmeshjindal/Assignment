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
import org.testng.annotations.BeforeMethod;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ItemDetails;
import pages.LandingPage;
import reusableComponenets.AbstractComponenets;

public class SearchItem2 extends TestBase{
	
public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		initialize();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		  initialize();	
		  LandingPage landingPage = new LandingPage();
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
		  
		   commonMethod.switchToBrowserTab();
		   itemDetails.aboudThisItem();
		   
		   
	  
	}
	
	public static void initialize() {
		
			WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
		
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		  driver.manage().deleteAllCookies();
		  driver.get("https://www.amazon.in/");
	}
	
	
	
	
}
