package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the threadlocal driver on the basis of given
	 * @return this will return tldriver.
	 */
	
	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser); //chanhe to logger

		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();  
			//options.addArguments("--headless");
			options.addArguments("start-maximized"); 
			options.addArguments("disable-infobars"); 
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options));
			
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			
		} else if (browser.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
	        options.addArguments("--no-sandbox");
	        //options.addArguments("--headless");
	        options.addArguments("--disable-dev-shm-usage"); 
	        options.addArguments("disable-infobars"); 
	        options.addArguments("--disable-extensions");  
	        options.addArguments("--disable-dev-shm-usage");
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver(options));
		} else {
			System.out.println("Please pass the correct browser value: " + browser); //chanhe to logger
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
