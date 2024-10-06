package WebApp.Pages;

import Framework.CustomElements.CustomFieldDecorator;
import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    // locators
    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeProductBtn;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingBtn;

    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    // methods

    private WebDriver driver;

    // constructor to initialise driver and pagefactory for the page
    public CartPage(WebAppDriver webAppDriver) {
        driver = webAppDriver.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

}
