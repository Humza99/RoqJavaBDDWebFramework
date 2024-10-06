package Framework.CustomElements.DynamicImpl;

import Framework.CustomElements.IDropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicDropdown extends DynamicBaseElement implements IDropdown {

    public DynamicDropdown(WebDriver driver, By locator) {
        super(driver, locator);
    }
}
