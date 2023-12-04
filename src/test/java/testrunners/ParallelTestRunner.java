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
		publish = true,
		glue = { "stepDefinitions" },
		features = { "Features" },
		tags = "") //@register //excel-data //dashboard1

public class ParallelTestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
}
		}

	