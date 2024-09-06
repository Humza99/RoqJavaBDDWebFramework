package Framework.Hooks;

import Framework.WebAppDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private DriverInjection testContext; // Acting like IObjectContainer in C#

    private WebAppDriver webDriver; // Holds the instance of WebAppDriver

    public Hooks(DriverInjection testContext) {
        this.testContext = testContext;
    }

    // Before Hooks

    @Before("@WebApplication")
    public void beforeWebApplication() {
        // Init the driver
        webDriver = new WebAppDriver();

        // Register the driver instance
        testContext.setWebDriver(webDriver);
    }

    // After Hooks

    @After("@WebApplication")
    public void afterWebApplication(Scenario scenarioContext) {

        if (scenarioContext.isFailed()) {
            webDriver.takeScreenshotOnFailure(scenarioContext);
        }
        webDriver.killDriver();
    }
}
