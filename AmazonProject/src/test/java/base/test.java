package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	
	public  test() {
		System.out.println("Test");

		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();

	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	  driver.manage().deleteAllCookies();
	  driver.get("https://www.amazon.in/");
	  //driver.get(prop.getProperty("url"));
	}
}
