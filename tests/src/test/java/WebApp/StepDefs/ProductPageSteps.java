package WebApp.StepDefs;

import Framework.CsvObjects.Products;
import Framework.Hooks.DriverInjection;
import Utilites.HelperMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class ProductPageSteps extends BaseSteps
{
    public ProductPageSteps(DriverInjection testContext) {
        super(testContext);
    }

    @When("I add a product to basket")
    public void iAddAProductToBasket()
    {
        productsPage.addProductToCart("sauce-labs-bike-light");
        helperMethods.assertPageTitle("Swag Labs");
    }

    @Then("I check website prices and iterate over each product in the csv and me sure it matches")
    public void iCheckWebsitePricesAndIterateOverEachProductInTheCsvAndMeSureItMatches()
    {
        List<Products> csvFile = HelperMethods.csvReader("Products", Products.class);

        for (Products product : csvFile) {
            String productPrice = productsPage.getProductPrice(product.getName());
            helperMethods.assertAreEqual(product.getPrice(), productPrice);
            //System.out.println(product.getName());
        }
    }

    @When("I go to the basket")
    public void iGoToTheBasket()
    {
        productsPage.clickGoToCartButton();
        helperMethods.assertPageUrl("https://www.saucedemo.com/cart.html");
    }
}
