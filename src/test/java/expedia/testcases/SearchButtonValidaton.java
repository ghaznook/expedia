package expedia.testcases;


import org.testng.annotations.Test;
import org.testng.Assert;

import expedia.pageobjects.HomePage;


public class SearchButtonValidaton extends BaseTest {
	
	@Test
	public void searchButton() throws InterruptedException {
	HomePage homepage = new HomePage(driver);
	Assert.assertTrue(homepage.verifyingSearch(),"search button was not displayed ..");
	}
	
}
