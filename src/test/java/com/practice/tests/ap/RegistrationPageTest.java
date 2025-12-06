package com.practice.tests.ap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.base.AutomationBaseTest;
import com.practice.pages.ap.CreateAccountStartPage;
import com.practice.pages.ap.HomePage;
import com.practice.pages.ap.RegistrationPage;

public class RegistrationPageTest extends AutomationBaseTest {

	@BeforeMethod
	public void launchSite() {
		openURL("automationpractice.url");
	}

	@Test
	public void testRegistrationPage() throws InterruptedException {

		HomePage homepage = new HomePage(driver);
		homepage.signIN();
		CreateAccountStartPage startpage = new CreateAccountStartPage(driver);
		startpage.enterEmail("ryan@testmail.com");
		startpage.clicksubmitCreateButton();
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.clickRadioButton();
		regPage.fillPersonalInformation("Ryan", "John", "ryanjohn");
		regPage.selectDOB();
		regPage.checkNewsLetterAndOffers(true, true);
		regPage.clickSubmitButton();

	}

}
