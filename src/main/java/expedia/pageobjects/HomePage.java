package expedia.pageobjects;

	import java.util.List;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import expedia.abstractcomponents.AbstractComponents;

	public class HomePage extends AbstractComponents {

	  public WebDriver driver;
	    public HomePage(WebDriver driver) {
	    	super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    
	    @FindBy(id = "search_button") 
	    private WebElement searchButton;

	    
	    @FindBy(xpath = "//ul[@class='uitk-tabs uitk-tabs-natural background-primary uitk-tabs-default uitk-tabs-with-border uitk-tabs-natural-center-align']")
	    private List<WebElement> tabs;
	    
	    public boolean verifyingSearch() throws InterruptedException {
	        boolean allTabsHaveSearchButton = true; 
	        
		        for (int i = 0; i < tabs.size() - 1; i++) {
		        	 tabs.get(i).click();
		        	 Thread.sleep(1000);
		            if (!searchButton.isDisplayed()) {
		                allTabsHaveSearchButton = false; 
		                break; 
		            }
		        }
	        return allTabsHaveSearchButton; 

	    }			
	}
	   



