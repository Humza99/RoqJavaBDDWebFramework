package WebApp.Pages;

import Framework.CustomElements.FindByImpl.Button;
import Framework.CustomElements.FindByImpl.InputBox;
import Framework.CustomElements.FindByImpl.Text;
import Framework.WebAppDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    @FindBy(id = "user-name")
    private InputBox usernameInput;

    @FindBy(id = "password")
    private InputBox passwordInput;

    @FindBy(xpath = "//h3[@data-test='error']")
    private Text errorMessage;

    @FindBy(id = "login-button")
    private Button loginBtn;

    public void clickLoginButton()
    {
        loginBtn.click();
    }

    public String getErrorMessage()
    {
        return errorMessage.getText();
    }

    public LoginPage enterUsername(String username)
    {
        usernameInput.WriteText(username);
        return this;
    }

    public LoginPage enterPassword(String password)
    {
        passwordInput.WriteText(password);
        return this;
    }

    public LoginPage(WebAppDriver webAppDriver)
    {
        super(webAppDriver);
    }
}
