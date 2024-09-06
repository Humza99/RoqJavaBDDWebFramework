package Framework.Hooks;

import Framework.WebAppDriver;

public class DriverInjection {

    // WebApp Injection
    private WebAppDriver webDriver;

    public WebAppDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebAppDriver webDriver) {
        this.webDriver = webDriver;
    }
}
