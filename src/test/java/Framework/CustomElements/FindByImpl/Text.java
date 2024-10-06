package Framework.CustomElements.FindByImpl;

import Framework.CustomElements.IText;
import org.openqa.selenium.WebElement;

public class Text extends BaseElement implements IText {

    protected Text(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
