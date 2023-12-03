package com.qa.util;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Actions {

	private WebDriver driver;// = DriverFactory.getDriver()
	private ConfigReader configReader;
	//private Properties prop = configReader.init_prop("config");

	public Actions(WebDriver driver) {
		this.driver = driver;
	}

	public void click(By by) {
		driver.findElement(by).click();
	}

	public void insert(By by, String key) {
		driver.findElement(by).sendKeys(key);
	}

//	public void readProp(String propFile, String key) {
//		String data = prop.getProperty("home_page");
//	}

}
