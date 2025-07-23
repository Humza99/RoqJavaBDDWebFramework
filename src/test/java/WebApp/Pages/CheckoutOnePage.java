package WebApp.Pages;

import Framework.CustomElements.CustomFieldDecorator;
import Framework.CustomElements.FindByImpl.Button;
import Framework.CustomElements.FindByImpl.InputBox;
import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage extends BasePage
{
    @FindBy(id = "first-name")
    private InputBox firstNameInput;

    @FindBy(id = "last-name")
    private InputBox lastNameInput;

    @FindBy(id = "postal-code")
    private InputBox postalCodeInput;

    @FindBy(id = "continue")
    private Button continueBtn;

    @FindBy(id = "cancel")
    private Button cancelBtn;

    public void clickContinueButton()
    {
        continueBtn.click();
    }

    public CheckoutOnePage enterFirstName(String firstName)
    {
        firstNameInput.WriteText(firstName);
        return this;
    }

    public CheckoutOnePage enterLastName(String lastName)
    {
        lastNameInput.WriteText(lastName);
        return this;
    }

    public CheckoutOnePage enterPostalCode(String postalCode)
    {
        postalCodeInput.WriteText(postalCode);
        return this;
    }

    public CheckoutOnePage(WebAppDriver webAppDriver)
    {
        super(webAppDriver);
    }
}
