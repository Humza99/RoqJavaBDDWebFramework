package WebApp.Pages;

import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage {

    // locators
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(id = "cancel")
    public WebElement cancelBtn;

    // methods
    public void enterFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }
    public void enterPostalCode(String postalCode){
        postalCodeInput.sendKeys(postalCode);
    }

    // instantiate driver
    private WebDriver driver;

    // constructor to initialise driver and pagefactory for the page
    public CheckoutOnePage(WebAppDriver webAppDriver) {
        driver = webAppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

}
