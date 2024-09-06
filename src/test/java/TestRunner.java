import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"WebApp.StepDefs", "Framework/Hooks"}, // Add the package names where your step definitions and hooks are located
        tags = "@WebApplication",
        plugin = { "pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })

public class TestRunner extends AbstractTestNGCucumberTests {

}