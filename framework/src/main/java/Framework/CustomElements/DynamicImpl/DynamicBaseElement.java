package Framework.CustomElements.DynamicImpl;

import Framework.CustomElements.IBaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class DynamicBaseElement implements IBaseElement {

    protected WebDriver webDriver;
    protected By locator;

    private final Duration timeout = Duration.ofSeconds(20);

    public DynamicBaseElement(WebDriver driver, By locator)
    {
        this.webDriver = driver;
        this.locator = locator;
    }

    public WebElement findElement() {
        if (webDriver != null){
            WebDriverWait wait = new WebDriverWait(webDriver, timeout);
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        else {
            throw new UnsupportedOperationException("No driver is set");
        }
    }

    @Override
    public void click(){
        findElement().click();
    }

    @Override
    public String getText(){
        return findElement().getText();
    }

    @Override
    public boolean isDisplayed(){
        return findElement().isDisplayed();
    }
}
