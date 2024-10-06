package Framework.CustomElements.DynamicImpl;

import Framework.CustomElements.IText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicText extends DynamicBaseElement implements IText {

    public DynamicText(WebDriver driver, By locator)
    {
        super(driver, locator);
    }
}
