package WebApp.StepDefs;

import Hooks.DriverInjection;
import WebApp.WebAppPagesInit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    private final WebAppPagesInit webApp;

    public CheckoutSteps(DriverInjection testContext) {
        webApp = new WebAppPagesInit(testContext.getWebDriver());
    }

    @When("I complete the checkout process")
    public void iCompleteTheCheckoutProcess() {
        webApp.cartPage.checkoutBtn.click();
        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-step-one.html");

        webApp.checkoutOnePage.enterFirstName("Test");
        webApp.checkoutOnePage.enterLastName("User");
        webApp.checkoutOnePage.enterPostalCode("OX1 3RS");

        webApp.checkoutOnePage.continueBtn.click();
        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-step-two.html");

        webApp.checkoutTwoPage.finishBtn.click();

        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-complete.html");
    }

    @Then("I have completed my purchase")
    public void iHaveCompletedMyPurchase() {
        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-complete.html");
    }
}
