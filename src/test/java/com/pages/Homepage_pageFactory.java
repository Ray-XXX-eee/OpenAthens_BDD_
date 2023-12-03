//package com.pages;
//
//
//import java.io.IOException;
//import java.util.Properties;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
//import org.openqa.selenium.support.FindBy;
//import org.testng.Assert;
//
//import com.qa.factory.DriverFactory;
//import com.qa.util.Actions;
//import com.qa.util.ConfigReader;
//
//public class Homepage_pageFactory {
//	private WebDriver driver;
//	private ConfigReader confreader = new ConfigReader();
//	private Properties conf = confreader.init_prop("config");
//	private Properties locators = confreader.init_prop("locators");
//	private Actions Action = new Actions(DriverFactory.getDriver());
//	
//	
//	String btnRegisterLink_ = locators.getProperty("btnRegisterLink");
//	@FindBy(xpath = btnRegisterLink_ )
//	WebElement btnRegisterLink_pF;
//	
//	
//	//Constructor
//		public Homepage_pageFactory(WebDriver driver) {
//			this.driver = driver;
//		}
//	
//	// By locators
//	private By btnRegisterLink = By.xpath(locators.getProperty("btnRegisterLink"));
//	private By RegHeader = By.xpath(locators.getProperty("RegHeader"));
//	
//	
//
//	//Page Actions
//	public void gotoHomePage() throws IOException {
//		String link = conf.getProperty("home_page");
//		driver.get(System.getProperty("user.dir")+link);
//	}
//	public void regPageLoadAssert() throws InterruptedException {
//		Assert.assertNotNull(driver.findElement(btnRegisterLink));
//	}
//	public void clickRegLink() throws InterruptedException {
//		Action.click(btnRegisterLink);
//	}
//	
//	public void regLinkClickAssert() {
//		
//		Assert.assertNotNull(driver.findElement(RegHeader));
//		System.out.println("Index to Registration Page Navigation success");
//	}
//	
//	
//}
//	
//
//
