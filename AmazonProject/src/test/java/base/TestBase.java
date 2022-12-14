package base;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
public static WebDriver driver;
	
	
	public static void initialize() {
		
			WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			  driver.manage().deleteAllCookies();
			  //driver.get("https://www.amazon.in/");
			  
	}
	
	public void closeWebBrowser() {
		driver.close();
	}
	
	
}
