package Framework.CustomElements.DynamicImpl;

import Framework.CustomElements.IInputBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicInputBox extends DynamicBaseElement implements IInputBox {

    public DynamicInputBox(WebDriver driver, By locator) {
        super(driver, locator);
    }

    @Override
    public void WriteText(String text) {
        findElement().clear();
        findElement().sendKeys(text);
    }

    @Override
    public void AppendText(String text) {
        findElement().sendKeys(text);
    }
}
