//package testrunners;
//
//import org.testng.annotations.DataProvider;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//		plugin = {"pretty",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//				"timeline:test-output-thread/"
//				}, 
//		monochrome = true,
//		glue = { "stepDefinitions" },
//		features = { "Features" })
//
//public class ParallelTestRunner extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//}
//		}
//
