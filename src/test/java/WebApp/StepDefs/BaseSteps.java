package WebApp.StepDefs;

import Framework.Hooks.DriverInjection;
import Framework.WebAppDriver;
import Utilites.HelperMethods;
import WebApp.Pages.*;

public abstract class BaseSteps
{
    protected WebAppDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutOnePage checkoutOnePage;
    protected CheckoutTwoPage checkoutTwoPage;

    // Init Helpers
    public HelperMethods helperMethods;

    public BaseSteps(DriverInjection testContext)
    {
        driver = testContext.getWebDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutOnePage = new CheckoutOnePage(driver);
        checkoutTwoPage = new CheckoutTwoPage(driver);

        helperMethods = new HelperMethods(driver);
    }
}
