package WebApp.Pages;

import Framework.WebAppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // locators
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    // methods
    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    private WebDriver driver;

    // constructor to initialise driver and pagefactory for the page
    public LoginPage(WebAppDriver webAppDriver) {
        this.driver = webAppDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
}
