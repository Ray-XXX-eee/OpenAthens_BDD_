package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.Homepage;
import com.pages.RegistrationPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;

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
	//Getting issue with Excel in my local -----
	
//	@When("User fills data from given {string} and {int}")
//	public void user_fills_data_from_given_and(String sheetName, Integer row) throws InvalidFormatException, IOException {
//		ExcelReader reader = new ExcelReader();
//		List<Map<String,String>> data = reader.getData("./testData.xlsx", sheetName);
//		String name = data.get(row).get("name");
//		String email = data.get(row).get("email");
//		String webpage = data.get(row).get("webpage");
//		String interest = data.get(row).get("interest");
//		String password = data.get(row).get("password");
//		String cnfPassword = data.get(row).get("cnfPassword");	
//		
//	}
	
	}
