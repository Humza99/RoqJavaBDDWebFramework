package Framework.Hooks;

import Framework.WebAppDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks
{
    private DriverInjection testContext;

    public Hooks(DriverInjection testContext)
    {
        this.testContext = testContext;
    }

    // Before Hooks
    @Before
    public void before()
    {
        WebAppDriver driver = new WebAppDriver();
        testContext.setWebDriver(driver);
    }

    // After Hooks
    @After
    public void after(Scenario scenarioContext)
    {
        WebAppDriver driver = testContext.getWebDriver();
        if (driver != null) {
            driver.takeScreenshotOnFailure(scenarioContext);
            driver.killDriver();
        }
    }
}