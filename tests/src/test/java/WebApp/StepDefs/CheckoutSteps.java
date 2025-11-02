package WebApp.StepDefs;

import Framework.Hooks.DriverInjection;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends BaseSteps
{
    public CheckoutSteps(DriverInjection testContext) {
        super(testContext);
    }

    @When("I complete the checkout process")
    public void iCompleteTheCheckoutProcess()
    {
        cartPage.clickCheckoutButton();
        helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-step-one.html");

        checkoutOnePage.enterFirstName("Test")
                .enterLastName("User")
                .enterPostalCode("OX1 3RS")
                .clickContinueButton();
        helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-step-two.html");

        checkoutTwoPage.clickFinishButton();

        helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-complete.html");
    }

    @Then("I have completed my purchase")
    public void iHaveCompletedMyPurchase()
    {
        helperMethods.assertPageUrl("https://www.saucedemo.com/checkout-complete.html");
    }
}
