package expedia.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import expedia.pageobjects.FlightsPage;

public class FlightsValidation extends BaseTest {
	
	@Test
	public  void validatingFlight() {
		FlightsPage flightspage = new FlightsPage(driver);
		Assert.assertTrue(flightspage.isRoundtripSelected(),"roundtrip is not selected by default");
		Assert.assertTrue(flightspage.areLabelsVisible(),"labels are not visible ");
		flightspage.selectFirstClass();
		Assert.assertEquals(flightspage.getDropDownValue(),"First class");
	}
	
	@Test
	public void validatingoneway() {
		FlightsPage flightspage = new FlightsPage(driver);
		flightspage.clickingFlightsTab();
		flightspage.clickOneWay();
		Assert.assertTrue(flightspage.absenceofreturn(), "the return is not absent");
		flightspage.clickRoundtrip();
		Assert.assertTrue(flightspage.presenceOfReturn(), "the return is not present");
	}
}
