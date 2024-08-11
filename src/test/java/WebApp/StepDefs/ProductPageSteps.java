package WebApp.StepDefs;

import Hooks.DriverInjection;
import WebApp.WebAppPagesInit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

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
    @When("I proceed to the basket")
    public void i_proceed_to_the_basket() {
        webApp.productsPage.goToCartBtn.click();
        webApp.helperMethods.assertPageUrl("https://www.saucedemo.com/cart.html");
    }

    // Scenario 2

    @Then("I check website prices and iterate over each product in the csv and me sure it matches")
    public void i_check_website_prices_and_iterate_over_each_product_in_the_csv_and_me_sure_it_matches() throws IOException { // TODO: Sort out hard coded CSV reader
        String csvFilePath = "C:\\Users\\humza\\IdeaProjects\\Selenium4WebFramework\\src\\test\\resources\\Products.csv";
        var csvFile = webApp.helperMethods.csvReader(csvFilePath);

        for (var product : csvFile) {
            String productPrice = webApp.productsPage.getProductPrice(product.getName());
            webApp.helperMethods.assertAreEqual(product.getPrice(), productPrice);
            //System.out.println(product.getName());
        }
    }
}
