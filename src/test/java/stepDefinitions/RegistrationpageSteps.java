package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import com.pages.Homepage;
import com.pages.RegistrationPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.*;

public class RegistrationpageSteps {
//	ConfigReader confreader = new ConfigReader();
//	Properties prop = confreader.init_prop("config");
	private RegistrationPage RP = new RegistrationPage(DriverFactory.getDriver());
	
	@Given("I navigate to register page")
	public void i_navigate_to() throws IOException {
	    RP.gotoRegistrationPage();
		}

	@When("I give {string} input as {string}")
	public void i_give_input_as(String field, String value) {
		RP.putValue(field, value);
	}

	@When("Click register")
	public void click() throws InterruptedException {
	    RP.clickBtn();
	}
	
	@Then("Registration should be successfull")
	public void registration_should_be_successfull() throws InterruptedException {
	    RP.assertRegistered();
	}
	
	@Then("Should throw error message for {string}")
		public void should_throw_error_message(String field) throws InterruptedException {
		    RP.assertErrorMsg(field);
		}
	@And("Should not navigate to Dashboard")
	public void should_not_navigate_to_dashboard() throws InterruptedException {
		RP.assertNotRegistered();
	}
	}
