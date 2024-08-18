package WebApp.StepDefs;

import Framework.CsvObjects.Products;
import Framework.HelperMethods;
import Hooks.DriverInjection;
import WebApp.WebAppPagesInit;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps {

    private final WebAppPagesInit webApp;

    public ProductPageSteps(DriverInjection testContext) {
        webApp = new WebAppPagesInit(testContext.getWebDriver());
    }

    @When("I add a product to basket")
    public void i_add_a_product_to_basket() {
        webApp.productsPage.addProductToCart("sauce-labs-bike-light");
        webApp.helperMethods.assertPageTitle("Swag Labs");
    }

    @When("I go to the basket")
    public void iGoToTheBasket() {
        webApp.productsPage.goToCartBtn.click();
        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/cart.html");
    }

    // Scenario 2

    @Then("I check website prices and iterate over each product in the csv and me sure it matches")
    public void i_check_website_prices_and_iterate_over_each_product_in_the_csv_and_me_sure_it_matches() {
        var csvFile = HelperMethods.csvReader("Products", Products.class);

        for (Products product : csvFile) {
            String productPrice = webApp.productsPage.getProductPrice(product.getName());
            webApp.helperMethods.assertAreEqual(product.getPrice(), productPrice);
            //System.out.println(product.getName());
        }
    }
}
