package reusableComponenets;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class AbstractComponenets extends TestBase{
	
	public ArrayList<String> browserTabs ;

	public void waitForElementToAppear(By findBy) {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void implicitWaitApply() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void switchToBrowserTab() {
		browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//System.out.print("Number of Open Tabs: " + browserTabs.size());
		   
		   driver.switchTo().window(browserTabs.get(1));
	}
	
	public void closeCurrentTabAndswitchToParentTab() {
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
	}
	
	public void navigateToURL(String url) {
		driver.get(url);
	}

}
