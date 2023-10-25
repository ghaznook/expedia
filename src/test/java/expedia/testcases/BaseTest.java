package expedia.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import expedia.abstractcomponents.AbstractComponents;
import expedia.pageobjects.StaysPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
public WebDriver driver;
public StaysPage stayspage;
	
	public WebDriver browserInitilization() throws IOException {
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/expedia/resources/Globaldata.properties");
		property.load(fis);
		String browser = property.getProperty("browser");
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			
		}
	
		else if (browser.equalsIgnoreCase("gecko")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			
			
	}
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    
	    return driver ;
	    
}
	@BeforeTest
	public StaysPage launchingApp() throws IOException {
		driver = browserInitilization();
		AbstractComponents component = new AbstractComponents(driver);
	    component.goTo();
	    stayspage = new StaysPage(driver);
	    return stayspage ;
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
