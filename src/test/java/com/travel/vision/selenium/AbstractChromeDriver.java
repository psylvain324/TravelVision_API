package com.travel.vision.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

public abstract class AbstractChromeDriver {
	
	protected WebDriverManager webDriverManager;
	
	public AbstractChromeDriver() {
		super();
	}
	
	@Before
	public void SetUp() {
		WebDriverManager.chromedriver().setup();
	}
	
	@After
	public void AfterTests() {
		webDriverManager.clearCache();
	}

}
