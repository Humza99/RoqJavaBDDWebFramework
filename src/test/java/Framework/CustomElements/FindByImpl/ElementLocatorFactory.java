package Framework.CustomElements.FindByImpl;

import Framework.CustomElements.IBaseElement;
import Framework.CustomElements.IElementLocatorFactory;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;
import static java.text.MessageFormat.format;

/*
create() method takes a class and a wrappedElement and uses reflection to create an instance of the specified class, passing the wrappedElement to its constructor.
findImplementationFor() method uses reflection to dynamically find the implementation class for a given element class.
 */

public class ElementLocatorFactory implements IElementLocatorFactory {

    private <E extends IBaseElement> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(format("{0}.{1}", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Class not found for: " + elementClass.getSimpleName(), ex);
        }
    }

    @Override
    public <E extends IBaseElement> E create(Class<E> elementClass, WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }
}
