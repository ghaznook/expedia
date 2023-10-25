package expedia.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import expedia.abstractcomponents.AbstractComponents;

public class FlightsPage extends AbstractComponents{
	
    public WebDriver driver;
    public FlightsPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-controls='search_form_product_selector_flights']") 
    private WebElement flightsTab;
    
    @FindBy(xpath = "//a[@href='#FlightSearchForm_ROUND_TRIP']") 
    private WebElement roundTrip;

    @FindBy(xpath = "//button[@aria-label='Leaving from']") 
    private WebElement leavingFromLabel;

    @FindBy(xpath = "//button[@aria-label='Going to']") 
    private WebElement goingToLabel;

    @FindBy(id = "slec28") 
    private WebElement departingLabel;

    @FindBy(id = "zl8jjq") 
    private WebElement returningLabel;

    @FindBy(id = "cabin_class") 
    private WebElement economyDropdown;
    
    @FindBy(xpath = "//button[4]") 
    private WebElement firstClass;
    
    
    @FindBy(css = ".uitk-pill-text")
    private WebElement dropdownText;
    
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]")
    private WebElement oneWayTab;
    
    @FindBy(xpath = "//div[@data-testid='date-selector-playback']/button")
    private List<WebElement> verifyingReturn;
    
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    private WebElement roundTripTab;
    
    
    
    public void clickingFlightsTab() {
    	flightsTab.click();
    }
    
    public boolean isRoundtripSelected() {
        String attributevalue = roundTrip.getAttribute("aria-selected");
        Boolean isSelected = attributevalue.equalsIgnoreCase("true");
        return isSelected ;
    }

    public boolean areLabelsVisible() {
        return leavingFromLabel.isDisplayed() &&
               goingToLabel.isDisplayed() &&
               departingLabel.isDisplayed() &&
               returningLabel.isDisplayed();
    }

    public void selectFirstClass() {
    	economyDropdown.click();
    	firstClass.click();
    }
    
    public String getDropDownValue() {
    	return dropdownText.getText();
    }
    
    public void clickOneWay() {
    	oneWayTab.click();
            }
    
    public void clickRoundtrip() {
    	roundTripTab.click();
    	
    }
    
    public boolean absenceofreturn() {
    	int size =verifyingReturn.size();
    	boolean absent = size < 2;
    	return absent;
    }
    
    public boolean presenceOfReturn() {
    	int size =verifyingReturn.size();
    	boolean present = size == 2;
    	return present;
    }
    
}

