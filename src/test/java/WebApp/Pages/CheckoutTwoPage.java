package WebApp.Pages;

import Framework.CustomElements.CustomFieldDecorator;
import Framework.CustomElements.FindByImpl.Button;
import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutTwoPage extends BasePage
{
    @FindBy(id = "finish")
    private Button finishBtn;

    @FindBy(id = "cancel")
    private Button cancelBtn;

    public void clickFinishButton()
    {
        finishBtn.click();
    }

    public CheckoutTwoPage(WebAppDriver webAppDriver)
    {
        super(webAppDriver);
    }
}
