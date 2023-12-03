package testrunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"html:target/cucumber-Report.html",
				"json:target/report.json",
				"rerun:target/failed_test.txt"
				}, 
		monochrome = true,
		glue = { "stepDefinitions" },
		features = { "@target/failed_test.txt" })

public class FailedRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
}
		}

	