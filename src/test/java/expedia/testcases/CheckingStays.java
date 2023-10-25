package expedia.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;


public class CheckingStays extends BaseTest {
	@Test
	public void spotanddate() {
		stayspage.searchForUniversalOrlando();
		stayspage.settingTheDates();
		stayspage.clickSearch();		
	}

	@Test
	public void travelersDropDown() {
		stayspage.selectTravelers();
		stayspage.selectTravelersAges();
		Assert.assertTrue(stayspage.ageValidationOne(), "First child's age submission was incorrect.");
		Assert.assertTrue(stayspage.ageValidationTwo(), "Second child's age submission was incorrect.");
	}
	
}