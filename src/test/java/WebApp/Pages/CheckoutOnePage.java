package WebApp.Pages;

import Framework.CustomElements.CustomFieldDecorator;
import Framework.CustomElements.FindByImpl.Button;
import Framework.CustomElements.FindByImpl.InputBox;
import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage {

    // locators
    @FindBy(id = "first-name")
    private InputBox firstNameInput;

    @FindBy(id = "last-name")
    private InputBox lastNameInput;

    @FindBy(id = "postal-code")
    private InputBox postalCodeInput;

    @FindBy(id = "continue")
    public Button continueBtn;

    @FindBy(id = "cancel")
    public Button cancelBtn;

    // methods
    public void enterFirstName(String firstName){
        firstNameInput.WriteText(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.WriteText(lastName);
    }
    public void enterPostalCode(String postalCode){
        postalCodeInput.WriteText(postalCode);
    }

    // instantiate driver
    private WebDriver driver;

    // constructor to initialise driver and pagefactory for the page
    public CheckoutOnePage(WebAppDriver webAppDriver) {
        driver = webAppDriver.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

}
