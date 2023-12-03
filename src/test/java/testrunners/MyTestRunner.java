package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "Features",
		glue = {"stepDefinitions"},
		plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"html:target/cucumber-Report.html",
				"json:target/report.json",
				},
		tags = "@end-to-end"
		)
public class MyTestRunner extends AbstractTestNGCucumberTests{}
