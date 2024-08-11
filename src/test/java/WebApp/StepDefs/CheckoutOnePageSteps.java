package WebApp.StepDefs;

import Hooks.DriverInjection;
import WebApp.WebAppPagesInit;
import io.cucumber.java.en.When;

public class CheckoutOnePageSteps {

    private final WebAppPagesInit webApp;

    public CheckoutOnePageSteps(DriverInjection testContext) {
        webApp = new WebAppPagesInit(testContext.getWebDriver());
    }

    @When("I enter my credentials")
    public void i_enter_my_credentials() {
        webApp.checkoutOnePage.enterFirstName("Test");
        webApp.checkoutOnePage.enterLastName("User");
        webApp.checkoutOnePage.enterPostalCode("OX1 3RS");
    }
    @When("I continue to the overview page")
    public void i_continue_to_the_overview_page() {
        webApp.checkoutOnePage.continueBtn.click();
        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-step-two.html");
    }
}
