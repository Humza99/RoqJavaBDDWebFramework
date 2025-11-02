package Framework.CustomElements.FindByImpl;

import Framework.CustomElements.IButton;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement implements IButton {

    public Button(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
