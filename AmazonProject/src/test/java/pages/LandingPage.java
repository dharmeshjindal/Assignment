package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LandingPage extends TestBase{

	public LandingPage() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@id='nav-hamburger-menu']/i")
	WebElement hamburgerIcon;
	
	@FindBy(xpath="//div[text()='TV, Appliances, Electronics']")
	WebElement shopByDepartment;
	
	@FindBy(xpath="//a[text()='Televisions']")
	WebElement television;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none']/div/span")
	List<WebElement> leftNavigation;
	
	@FindBy(xpath="//div[@id='s-refinements']/div")
	List<WebElement> itemList;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none']/div/span[text()='Brands']")
	WebElement brand;
	
	@FindBy(xpath="//span[@id='a-autoid-0-announce']")
	WebElement sorting;
	
	@FindBy(xpath="//div[@id='a-popover-2']/div/div/ul/li")
	List<WebElement> sortByList;
	
	@FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']/div")
	List<WebElement> resultSet;
	
	
	//Actions
	public void clickHamburgerMenu() {
		hamburgerIcon.click();
	}
	
	public void clickShopByDepartmentSection() {
		
		Actions action = new Actions(driver);
		action.moveToElement(shopByDepartment).perform();
		shopByDepartment.click();
	}
	
	public void television() {
		television.click();
	}
	
	public void brandSectionElements(String selectBrand) {
		
		 int size = leftNavigation.size();
		 int index = 0;
		 //System.out.println("Number of elements in Brand Section :"+size);
		 
		  for(int i=0; i<size; i++) {
			if(itemList.get(i).isDisplayed()) {
				if(itemList.get(i).findElement(By.xpath("./child::div")).getText().equalsIgnoreCase("Brands")) {	
					//System.out.println("item found at index: "+i);
					Actions act = new Actions(driver);
					act.moveToElement(leftNavigation.get(i)).perform();
					
				index=i;
				break;
				
				}
				
			}
		  }	
		  
		  List<WebElement> brandList =  itemList.get(index).findElements(By.xpath("./child::ul/li"));
			
			//System.out.println(brandList.size());
			for(WebElement itr : brandList) {
			
				if(itr.isDisplayed()) {
					if(itr.getText().equalsIgnoreCase(selectBrand)) {
						Actions act = new Actions(driver);
						act.moveToElement(itr).perform();
						itr.findElement(By.xpath("./child::span/a")).click();
						break;
						
					}
					
				}
			}
		  }
	
	public void sortResults() throws InterruptedException {
		
	sorting.click();
	Thread.sleep(2000);	
	int totalSortOptions = sortByList.size();
		//System.out.println(totalSortOptions);
		
		for(int i=0; i<totalSortOptions; i++) {
			if(sortByList.get(i).getText().equalsIgnoreCase("Price: High to Low")) {
				sortByList.get(i).click();
				break;
			}
		}
		
	}
	
	public void selectItemFromResultSet() {
		for(WebElement i : resultSet) {
			//System.out.println( i.getAttribute("data-index"));
			if(i.getAttribute("data-index").equalsIgnoreCase("2")) {
				i.click();
			}
		}
	}
}
