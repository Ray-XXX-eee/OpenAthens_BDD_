package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import com.pages.DashBoard;
import com.pages.Homepage;
import com.qa.factory.DriverFactory;
import com.qa.util.Actions;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.*;


public class DashboardSteps {
	
	ConfigReader confreader = new ConfigReader();
	Properties prop = confreader.init_prop("config");
	private DashBoard DB = new DashBoard(DriverFactory.getDriver());
	private Actions Act = new Actions(DriverFactory.getDriver());
	

	@Given("I navigate to Dashboard page")
	public void i_navigate_to_dashboard_page() throws IOException {
	    DB.gotoDashBoard();
	}
	
	@Then("Dashboard should show {int} jobs")
	public void then_dashboard_should_show_5_jobs(Integer int_ ) {
		DB.countTr(int_);    
	}
	
	@Then("{string} should have {string} color")
	public void then_blue_color(String job, String color){
		DB.color(job,color);    
	}
  
	}

