package com.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.util.Actions;
import com.qa.util.ConfigReader;

import org.openqa.selenium.support.Color;

public class DashBoard {
	
		//Loc Var
		private WebDriver driver;
		private ConfigReader confreader = new ConfigReader();
		private Properties conf = confreader.init_prop("config");
		private Properties locators = confreader.init_prop("locators");
		private Actions Action = new Actions(DriverFactory.getDriver());
		
		
		//Locators (Read from locators.properties)--------------------------------------------------------------------------------------
//		private By RegHeader = By.xpath("//h1[text()='Registration']");
		private By table_tr = By.xpath(locators.getProperty("table_tr"));
		private By gradColor = By.xpath(locators.getProperty("gradColor"));
		private By gradScColor = By.xpath(locators.getProperty("gradScColor"));
		private By lawColor = By.xpath(locators.getProperty("lawColor"));
		
		
		//Constructor------------------------------------------------------------------------------------------------------------------
		public DashBoard(WebDriver driver) {
			this.driver = driver;
		}
		
		//Page Actions------------------------------------------------------------------------------------------------------------------
		public void gotoDashBoard() throws IOException {
			String link = conf.getProperty("dashboard_page");
			driver.get(System.getProperty("user.dir")+link);
		}
		
		public void countTr(Integer int_) {
			int rowCount = driver.findElements(table_tr).size();
			Assert.assertTrue(rowCount==int_);
			
		}

		public void color(String job, String color) {
			String clr;
			switch (job) {
			case "graduate job":
				clr = Color.fromString(driver.findElement(gradColor).getCssValue("background-color")).asHex();
				Assert.assertEquals(clr, color);
				break;
			case "graduate scheme":
				clr = Color.fromString(driver.findElement(gradScColor).getCssValue("background-color")).asHex();
				Assert.assertEquals(clr, color);
				break;
			case "law training contract":
				clr = Color.fromString(driver.findElement(lawColor).getCssValue("background-color")).asHex();
				Assert.assertEquals(clr, color);
				break;
				
			}
			
			
		}
			
}
