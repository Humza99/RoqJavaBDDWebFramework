package WebApp.StepDefs;

import Framework.Hooks.DriverInjection;
import WebApp.WebAppPagesInit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    private WebAppPagesInit webApp;

    public LoginPageSteps(DriverInjection testContext) {
        webApp = new WebAppPagesInit(testContext.getWebDriver());
    }

    @Given("I am on the SwagLabs Website")
    public void i_am_on_the_swag_labs_website() {
        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/");
    }

    @Given("I log in with valid credentials")
    public void i_log_in_with_valid_credentials() {
        webApp.loginPage.enterUsername("standard_user");
        webApp.loginPage.enterPassword("secret_sauce");
        webApp.loginPage.loginBtn.click();
        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/inventory.html");
    }

    // Scenario 3

    @When("I enter invalid credentials to login")
    public void i_enter_invalid_credentials_to_login() {
        webApp.loginPage.enterUsername("fail_user");
        webApp.loginPage.enterPassword("fail_password");
        webApp.loginPage.loginBtn.click();
    }
    @Then("A error message is outputted on the screen")
    public void a_error_message_is_outputted_on_the_screen() {
        String errorMessage = webApp.loginPage.errorMessage.getText();
        webApp.helperMethods.assertAreEqual("Epic sadface: Username and password do not match any user in this service", errorMessage);
    }

    @Then("I am logged in successfully")
    public void iAmLoggedInSuccessfully() {
        webApp.productsPage.pageTitle.isDisplayed();
    }
}
