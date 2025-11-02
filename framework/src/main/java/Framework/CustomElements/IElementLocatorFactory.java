package Framework.CustomElements;

import org.openqa.selenium.WebElement;

/*
Interface responsible for creating instances of BaseElement implementations.
 */
public interface IElementLocatorFactory {
<E extends IBaseElement> E create(Class<E> elementClass, WebElement wrappedElement);
}
