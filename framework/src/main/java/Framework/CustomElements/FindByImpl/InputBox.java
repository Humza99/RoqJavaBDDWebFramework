package Framework.CustomElements.FindByImpl;

import Framework.CustomElements.IInputBox;
import org.openqa.selenium.WebElement;

public class InputBox extends BaseElement implements IInputBox {

    public InputBox(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void WriteText(String text){
        wrappedElement.clear();
        wrappedElement.sendKeys(text);
    }

    @Override
    public void AppendText(String text){
        wrappedElement.sendKeys(text);
    }
}
