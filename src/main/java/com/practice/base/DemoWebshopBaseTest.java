package com.practice.base;

import org.testng.annotations.BeforeClass;

import com.practice.utilities.ConfigReader;

public class DemoWebshopBaseTest extends BaseTest {
	@BeforeClass
	public void loadDemoConfig() {
		ConfigReader.load("config-demowebshop.properties");
	}

}
