package WebApp.StepDefs;

import Hooks.DriverInjection;
import WebApp.WebAppPagesInit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutTwoPageSteps {

    private final WebAppPagesInit webApp;

    public CheckoutTwoPageSteps(DriverInjection testContext) {
        webApp = new WebAppPagesInit(testContext.getWebDriver());
    }

    @When("I confirm my order")
    public void i_confirm_my_order() {
        webApp.checkoutTwoPage.finishBtn.click();
    }
    @Then("I have completed my purchase")
    public void i_have_completed_my_purchase() {
        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-complete.html");
    }

}
