package WebApp.Pages;

import Framework.CustomElements.CustomFieldDecorator;
import Framework.CustomElements.FindByImpl.Button;
import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage
{
    @FindBy(id = "remove-sauce-labs-backpack")
    private Button removeProductBtn;

    @FindBy(id = "continue-shopping")
    private Button continueShoppingBtn;

    @FindBy(id = "checkout")
    private Button checkoutBtn;

    public void clickCheckoutButton()
    {
        checkoutBtn.click();
    }

    public CartPage(WebAppDriver webAppDriver)
    {
        super(webAppDriver);
    }
}
