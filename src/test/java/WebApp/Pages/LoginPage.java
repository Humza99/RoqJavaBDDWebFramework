package WebApp.Pages;

import Framework.CustomElements.CustomFieldDecorator;
import Framework.CustomElements.FindByImpl.Button;
import Framework.CustomElements.FindByImpl.InputBox;
import Framework.CustomElements.FindByImpl.Text;
import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // locators
    @FindBy(id = "user-name")
    private InputBox usernameInput;

    @FindBy(id = "password")
    private InputBox passwordInput;

    @FindBy(xpath = "//h3[@data-test='error']")
    public Text errorMessage;

    @FindBy(id = "login-button")
    public Button loginBtn;

    // methods
    public void enterUsername(String username){
        usernameInput.WriteText(username);
    }

    public void enterPassword(String password){
        passwordInput.WriteText(password);
    }

    private WebDriver driver;

    // constructor to initialise driver and pagefactory for the page
    public LoginPage(WebAppDriver webAppDriver) {
        this.driver = webAppDriver.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }
}
