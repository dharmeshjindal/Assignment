package base;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ItemDetails;
import pages.LandingPage;
import reusableComponenets.AbstractComponenets;

public class TestBase {
	
public static WebDriver driver;
	
	public static Properties prop;
	
public TestBase() {
		
		prop = new Properties();
		String strPath = System.getProperty("user.dir")+
				"//src//test//resources//configFiles//config.properties";
		
		FileInputStream fin;
		try {
			fin = new FileInputStream(strPath);
			prop.load(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
