package expedia.pageobjects;



import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import expedia.abstractcomponents.AbstractComponents;
	

	public class StaysPage extends AbstractComponents{

	    public WebDriver driver;
	    
	    public StaysPage(WebDriver driver) {
	    	super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//ul[@class='uitk-action-list']" ) 
	    private WebElement staysTab;
	    
	    @FindBy(xpath = "button[name='EGDSDateRange-date-selector-trigger']")
	    private WebElement dates;
	    
	    @FindBy(xpath = "button[aria-label='Going to']")
	    private WebElement goingTo;
	    
	    @FindBy(xpath = "div[@role='application']/child::div/child::span")
	    private List<WebElement> calendarm;
	    
	    @FindBy(xpath = "//div[@class='uitk-spacing uitk-typeahead-results uitk-spacing-padding-blockstart-three']/child::ul/child::li']")
	    private List<WebElement> options;
	    
	    @FindBy(className = ".uitk-day")
	    private List<WebElement> dateCalendar;
	    
	    @FindBy(xpath = "//button[normalize-space()='2 travelers, 1 room']")
	    private WebElement travelersDropdown;
	    
	    @FindBy(xpath ="(//button[@type='button'])[9]")
	    private WebElement adultsCounter;
	    
	    @FindBy(xpath = "(//button[@type='button'])[11]")
	    private WebElement childrensCounter;
	    
	    
	    @FindBy(css = "div table tbody tr td")
	    private List<WebElement> calendarDates;
	    
	    @FindBy(xpath = "(//select[@id='age-traveler_selector_children_age_selector-0-0'])[1]")
	    private WebElement childOneAge;

	    @FindBy(xpath = "(//select[@id='age-traveler_selector_children_age_selector-0-0'])[2]")
	    private WebElement childTwoAge;
	    
	    @FindBy(id = "search-button")
	    private WebElement search;

	    public void searchForUniversalOrlando() {
	        staysTab.click();
	        goingTo.sendKeys("Universal Orlando Resort");
	        for (WebElement i : options) {
		        String text = i.getText();
		        if (text.equalsIgnoreCase("Universal Orlando Resort")) {
		        	i.click();
	        }}}
	        
	    public void settingTheDates() {
	    	dates.click();		    
	        Date currentDate = new Date();
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(currentDate);
	        calendar.add(Calendar.DAY_OF_MONTH,7);
	        String checkInDate = calendar.getTime().toString();
	        String[] indateArr = checkInDate.split(" ",4);
	        String enterdate = indateArr[2];
	        int indate = Integer.parseInt(enterdate);
	        String inmonth = indateArr[1];
	        calendar.add(Calendar.DAY_OF_MONTH, 7);
	        String checkOutDate = calendar.getTime().toString();
	        String[] outdateArr = checkOutDate.split(" ",4);
	        String otdate = outdateArr[2];
	        int outdate = Integer.parseInt(otdate);
	        String outmonth = outdateArr[1];
    	    
	        for (WebElement I : calendarm) {
				String text = I.getText();
	        	if (text.contains(inmonth)) {
	        		for (WebElement d:calendarDates) {
	        		String s = d.getText();
	        		int integerDate = Integer.parseInt(s);
	        		if (indate==integerDate) {
	        			d.click();
	        			break;
	        	}}}}
	        
    	    for (WebElement f : calendarm) {
				String text = f.getText();
	        	if (text.contains(outmonth)) {
	        		for (WebElement d:calendarDates) {
	        		String s = d.getText();
	        		int integerDate = Integer.parseInt(s);
	        		if (outdate==integerDate) {
	        			d.click();
	        			break;
        	}}}}
    	  
	    }
	    
	    public void selectTravelers() {
	    	travelersDropdown.click(); 
	    	adultsCounter.click();
	    	for (int i=0; i<2; i++) {
	    	childrensCounter.click();
	        }
	    }
	    
	    public void selectTravelersAges() {
	    	waitingForTheVisibilityOfElement(childOneAge);
	    	Select s = new Select(childOneAge) ;
	    	s.selectByIndex(8);
	    	waitingForTheVisibilityOfElement(childTwoAge);
	    	Select sTwo = new Select(childTwoAge) ;
	    	sTwo.selectByIndex(10);
	    
	    }
	    
	    public boolean ageValidationOne() {
	    	Select s = new Select(childOneAge) ;
	    	String  age =  s.getFirstSelectedOption().getText();
	    	boolean validation = age.equalsIgnoreCase("8");
	    	return validation;
	    }
	    
	    public boolean ageValidationTwo() {
	    	Select s = new Select(childTwoAge) ;
	    	String  age =  s.getFirstSelectedOption().getText();
	    	boolean validation = age.equalsIgnoreCase("10");
	    	return validation;
	    }
	    
	    public void clickSearch () {
	    	search.click();
	    }
	    
	    }
	
	


