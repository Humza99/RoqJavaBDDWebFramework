package WebApp.Pages;

import Framework.WebAppDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    // locators
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement goToCartBtn;

    @FindBy(xpath = "//span[@class='title' and text()='Products']")
    public WebElement pageTitle;

    // methods
    public void addProductToCart(String productName){
        WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-" + productName));
        addToCartBtn.click();
    }

    public String getProductPrice(String product){
        return driver.findElement(By.xpath("//div[@class='inventory_item_name ' and text()='" + product + "']//parent::a//parent::div//parent::div//div[@class='inventory_item_price']")).getText();
    }

    // instantiate driver
    private WebDriver driver;

    // constructor to initialise driver and pagefactory for the page
    public ProductsPage(WebAppDriver webAppDriver) {
        driver = webAppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
}
