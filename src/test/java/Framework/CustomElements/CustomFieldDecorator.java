package Framework.CustomElements;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import Framework.CustomElements.FindByImpl.CustomElementLocatorFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

/*
It uses the custom ElementFactory class (DefaultElementFactory) to create elements for fields that are subclasses of BaseElement.
The decorate() method checks if the field type is assignable from BaseElement and, if so, calls decorateElement() to create the decorated element.
 */

public class CustomFieldDecorator extends DefaultFieldDecorator {

    private IElementLocatorFactory elementFactory = new CustomElementLocatorFactory();

    public CustomFieldDecorator(final SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(final ClassLoader loader, final Field field) {
        if (IBaseElement.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return elementFactory.create((Class<? extends IBaseElement>) field.getType(), wrappedElement);
    }

    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }
}
