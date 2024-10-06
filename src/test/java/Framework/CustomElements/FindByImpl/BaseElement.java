package Framework.CustomElements.FindByImpl;

import Framework.CustomElements.IBaseElement;
import org.openqa.selenium.WebElement;

public abstract class BaseElement implements IBaseElement {

    protected WebElement wrappedElement;

    protected BaseElement(WebElement wrappedElement){
        this.wrappedElement = wrappedElement;
    }

    @Override
    public void click(){
        wrappedElement.click();
    }

    @Override
    public String getText(){
        return wrappedElement.getText();
    }

    @Override
    public boolean isDisplayed(){
        return wrappedElement.isDisplayed();
    }
}
