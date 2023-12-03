package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import com.pages.Homepage;
import com.qa.factory.DriverFactory;
import com.qa.util.Actions;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.*;


public class HomepageSteps {
	//public String url;
	ConfigReader confreader = new ConfigReader();
	Properties prop = confreader.init_prop("config");
	private Homepage HP = new Homepage(DriverFactory.getDriver());
	private Actions Act = new Actions(DriverFactory.getDriver());
	
//	public steps(String url) throws IOException {
//		url = readProperties.read("config").toString();	
//		System.out.println(url+"url test");
//	}
	
	@Given("I navigate to home page")
	public void i_navigate_to() throws IOException {
	    HP.gotoHomePage();
		//DriverFactory.getDriver().get("C:\\Users\\Rayha\\Desktop\\test\\OpenAthens\\RegistrationTest\\src\\main\\java\\registration-test\\index.html");
	}

	@When("Home Page is loaded")
	public void home_page_is_loaded() throws InterruptedException {
	    HP.regPageLoadAssert();
	    System.out.println(" Homepage loaded successfully");
	}

	@When("I click on register button")
	public void i_click_on_button() throws InterruptedException {
	    HP.clickRegLink();
	    System.out.println("registerLink button clicked successfully");
	}

	@Then("Registration page should open")
	public void page_should_open() {
	    HP.regLinkClickAssert();
	    System.out.println("reg page loaded successfully");
	}

}
