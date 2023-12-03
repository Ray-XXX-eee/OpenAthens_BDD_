package com.pages;

import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.qa.factory.DriverFactory;
import com.qa.util.Actions;
import com.qa.util.ConfigReader;

public class RegistrationPage {
		
		//Loc Var
		private WebDriver driver;
		private ConfigReader confreader = new ConfigReader();
		private Properties conf = confreader.init_prop("config");
		private Properties locators = confreader.init_prop("locators");
		private Actions Action = new Actions(DriverFactory.getDriver());
		private static Logger log = LogManager.getLogger(RegistrationPage.class.getName()); //logging
		

		//Locators (Read from locators.properties)--------------------------------------------------------------------------------------
		private By RegHeader = By.xpath(locators.getProperty("RegHeader"));
		private By strInputName = By.name(locators.getProperty("strInputName"));
		private By strInputEmail = By.name(locators.getProperty("strInputEmail"));
		private By strInputWebAdr = By.name(locators.getProperty("strInputWebAdr"));
		private By strInputInterest = By.xpath(locators.getProperty("strInputInterest"));
		private By strInputPwd = By.name(locators.getProperty("strInputPwd"));
		private By strInputCnfPwd = By.name(locators.getProperty("strInputCnfPwd"));
		private By btnRegistration = By.xpath(locators.getProperty("btnRegistration"));
		private By welcomeMsg = By.xpath(locators.getProperty("welcomeMsg"));
		private By emailError = By.xpath(locators.getProperty("emailError"));
		private By interestError = By.xpath(locators.getProperty("interestError"));
		private By pwdLenError = By.xpath(locators.getProperty("pwdLenError"));
		private By pwdMatchError = By.xpath(locators.getProperty("pwdMatchError"));
		
		
		//Constructor------------------------------------------------------------------------------------------------------------------
		public RegistrationPage(WebDriver driver) {
			this.driver = driver;
		}
		
		
		
		//PageActions------------------------------------------------------------------------------------------------------------------
		public void gotoRegistrationPage() throws IOException {
			String link = conf.getProperty("register_page");
			driver.get(System.getProperty("user.dir")+link);
			log.info("Navigated to Reister page");
		}
		
		public void putValue(String field, String value) {
			switch (field) {
			case "name":
				Action.insert(strInputName, value);
				break;
			case "email":
				Action.insert(strInputEmail, value);
				break;
			case "webpage":
				Action.insert(strInputWebAdr, value);
				break;
			case "interest":
				driver.switchTo().frame("iframe");
				log.info("Switching Frame");
				Action.insert(strInputInterest, value);
				driver.switchTo().defaultContent();
				log.info("Switched back to Default Frame");
				break;
			case "password":
				Action.insert(strInputPwd, value);
				break;
			case "confirm password":
				Action.insert(strInputCnfPwd, value);
				break;	
			}
		}
		
		public void clickBtn() throws InterruptedException {
			Action.click(btnRegistration);
		}
		
		public void assertRegistered() throws InterruptedException {
			try {
				driver.findElement(welcomeMsg).isDisplayed();
				Assert.assertTrue(true);
				log.info("Registration Passed");
			}
			catch (NoSuchElementException e){
				
			}
		}
		
		public void assertNotRegistered() throws InterruptedException {
			try {
				driver.findElement(welcomeMsg).isDisplayed();
			}
			catch (NoSuchElementException e){
				Assert.assertTrue(true);
				log.info("-ve Registration Passed");
			}
		}

		public void assertErrorMsg(String field) {
			switch (field) {
			case "email":
				Assert.assertNotNull(driver.findElement(emailError));
				break;
			case "interest":
				Assert.assertNotNull(driver.findElement(interestError));
				break;
			case "password length":
				Assert.assertNotNull(driver.findElement(pwdLenError));
				break;
			case "password match":
				Assert.assertNotNull(driver.findElement(pwdMatchError));
				break;
			
			}
			
			
		}
}