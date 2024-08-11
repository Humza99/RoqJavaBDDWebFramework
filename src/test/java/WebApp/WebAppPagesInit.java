package WebApp;

import Framework.HelperMethods;
import Framework.WebAppDriver;
import WebApp.Pages.*;

public class WebAppPagesInit {

    // Init Pages
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public CheckoutOnePage checkoutOnePage;
    public CheckoutTwoPage checkoutTwoPage;

    // Init Helpers
    public HelperMethods helperMethods;

    public WebAppPagesInit(WebAppDriver driver)
    {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutOnePage = new CheckoutOnePage(driver);
        checkoutTwoPage = new CheckoutTwoPage(driver);

        helperMethods = new HelperMethods(driver);
    }
}
