package Framework.CustomElements.FindByImpl;

import Framework.CustomElements.IDropdown;
import org.openqa.selenium.WebElement;

public class Dropdown extends BaseElement implements IDropdown {

    protected Dropdown(WebElement wrappedElement) {
        super(wrappedElement);
    }
}
