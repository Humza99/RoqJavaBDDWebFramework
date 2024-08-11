package WebApp.Pages;

import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutTwoPage {

    // locators
    @FindBy(id = "finish")
    public WebElement finishBtn;

    @FindBy(id = "cancel")
    private WebElement cancelBtn;

    // methods

    // instantiate driver
    private WebDriver driver;

    // constructor to initialise driver and pagefactory for the page
    public CheckoutTwoPage(WebAppDriver webAppDriver) {
        driver = webAppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

}
