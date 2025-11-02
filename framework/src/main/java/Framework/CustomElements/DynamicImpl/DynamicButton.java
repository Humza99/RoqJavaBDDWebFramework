package Framework.CustomElements.DynamicImpl;

import Framework.CustomElements.IButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicButton extends DynamicBaseElement implements IButton {

    public DynamicButton(WebDriver driver, By locator)
    {
        super(driver, locator);
    }
}
