package com.practice.base;

import org.testng.annotations.BeforeSuite;
import com.practice.utilities.ConfigReader;

public class AutomationBaseTest extends BaseTest {

	@BeforeSuite(alwaysRun = true)
	public void loadAutomationConfig() {
		ConfigReader.load("config-automationpractice.properties");
	}

}
