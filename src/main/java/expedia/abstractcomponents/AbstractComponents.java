package expedia.abstractcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {


	public WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}

	
	public  void waitingForTheVisibilityOfElement(WebElement w) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(w));
	}
	
	
	
	public String gettingProperties (String name ) throws IOException {
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/expedia/src/main/java/expedia/resources/Globaldata.properties");
		property.load(fis);
		String value = property.getProperty(name);
		return value;
	}
	
	public  void goTo() throws IOException {
		String url = gettingProperties("url");
		driver.get(url);
	}
	
}
