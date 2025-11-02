package WebApp.Pages;

import Framework.CustomElements.CustomFieldDecorator;
import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage
{
    protected WebDriver driver;

    public BasePage(WebAppDriver webAppDriver)
    {
        this.driver = webAppDriver.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }
}
