package WebApp.StepDefs;

import Framework.Hooks.DriverInjection;
import Framework.WebAppDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends BaseSteps
{
    public LoginPageSteps(DriverInjection testContext) {
        super(testContext);
    }

    @Then("A error message is outputted on the screen")
    public void aErrorMessageIsOutputtedOnTheScreen()
    {
        String errorMessage = loginPage.getErrorMessage();
        helperMethods.assertAreEqual("Epic sadface: Username and password do not match any user in this service", errorMessage);
    }

    @Then("I am logged in successfully")
    public void iAmLoggedInSuccessfully()
    {
        helperMethods.assertIsTrue(productsPage.isPageTitleDisplayed());
    }

    @Given("I am on the SwagLabs Website")
    public void iAmOnTheSwagLabsWebsite()
    {
        helperMethods.assertPageUrl("https://www.saucedemo.com/");
    }

    @When("I enter invalid credentials to login")
    public void iEnterInvalidCredentialsToLogin()
    {
        loginPage.enterUsername("fail_user")
                .enterPassword("fail_password")
                .clickLoginButton();
    }

    @When("I log in with valid credentials")
    public void iLogInWithValidCredentials()
    {
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton();
        helperMethods.assertPageUrl("https://www.saucedemo.com/inventory.html");
    }
}
