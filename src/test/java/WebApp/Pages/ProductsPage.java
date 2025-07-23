package WebApp.Pages;

import Framework.CustomElements.CustomFieldDecorator;
import Framework.CustomElements.DynamicImpl.DynamicButton;
import Framework.CustomElements.DynamicImpl.DynamicText;
import Framework.CustomElements.FindByImpl.Button;
import Framework.CustomElements.FindByImpl.Text;
import Framework.WebAppDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage
{
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private Button goToCartBtn;

    @FindBy(xpath = "//span[@class='title' and text()='Products']")
    private Text pageTitle;

    public void addProductToCart(String productName)
    {
        DynamicButton addToCartBtn = new DynamicButton(driver, By.id("add-to-cart-" + productName));
        addToCartBtn.click();
    }

    public void clickGoToCartButton()
    {
        goToCartBtn.click();
    }

    public boolean isPageTitleDisplayed()
    {
        return pageTitle.isDisplayed();
    }

    public String getProductPrice(String product)
    {
        return new DynamicText(driver, By.xpath("//div[@class='inventory_item_name ' and text()='" + product + "']//parent::a//parent::div//parent::div//div[@class='inventory_item_price']")).getText();
    }

    public ProductsPage(WebAppDriver webAppDriver)
    {
        super(webAppDriver);
    }
}
