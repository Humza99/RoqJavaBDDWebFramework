package WebApp.StepDefs;

import Hooks.DriverInjection;
import WebApp.WebAppPagesInit;
import io.cucumber.java.en.When;

public class CartPageSteps {

    private final WebAppPagesInit webApp;

    public CartPageSteps(DriverInjection testContext) {
        webApp = new WebAppPagesInit(testContext.getWebDriver());
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        webApp.cartPage.checkoutBtn.click();
        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-step-one.html");
    }
}
