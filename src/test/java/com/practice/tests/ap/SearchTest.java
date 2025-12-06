package com.practice.tests.ap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.base.AutomationBaseTest;
import com.practice.pages.ap.SearchPage;

public class SearchTest extends AutomationBaseTest {

	@BeforeMethod
	public void launchSite() {
		openURL("automationpractice.url");
	}

	@Test
	public void testSearchValidItem() {
		SearchPage search = new SearchPage(driver);
		search.enterSearchText("dress");
		search.clickSearchButton();
		Assert.assertTrue(search.getItemCount() > 0, "No results were found for your search!");// search shows results
		Assert.assertTrue(search.isItemDisplayed("dress"), "Expected item not found");
	}

	@Test
	public void testSearchInValidItem() {
		SearchPage search = new SearchPage(driver);
		search.enterSearchText("watch");
		search.clickSearchButton();
		Assert.assertEquals(search.getItemCount(), 0, "No results were found for your search!");// search shows results

	}

}
