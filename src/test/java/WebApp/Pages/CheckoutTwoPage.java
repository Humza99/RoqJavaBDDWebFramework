package WebApp.Pages;

import Framework.CustomElements.CustomFieldDecorator;
import Framework.CustomElements.FindByImpl.Button;
import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutTwoPage {

    // locators
    @FindBy(id = "finish")
    public Button finishBtn;

    @FindBy(id = "cancel")
    private Button cancelBtn;

    // methods

    // instantiate driver
    private WebDriver driver;

    // constructor to initialise driver and pagefactory for the page
    public CheckoutTwoPage(WebAppDriver webAppDriver) {
        driver = webAppDriver.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

}
