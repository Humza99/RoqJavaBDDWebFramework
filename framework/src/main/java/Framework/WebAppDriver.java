package Framework;

import Utilites.SettingsLoader;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WebAppDriver {

    private WebDriver webDriver;

    public WebAppDriver() {
        webDriver = createDriver(SettingsLoader.get("BROWSER.TYPE").toLowerCase());
    }

    public WebDriver getDriver() { return webDriver; }

    private WebDriver createDriver(String browser) {
        MutableCapabilities options;
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                ((ChromeOptions) options).addArguments("--incognito");
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                options = new EdgeOptions();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                options = new FirefoxOptions();
                break;
            default: throw new RuntimeException("Invalid browser name provided '" + browser + "', Please use chrome, edge or firefox.");
        }

        return configureDriver(browser, SettingsLoader.getBoolean("HEADLESS.MODE"), SettingsLoader.getBoolean("ENABLE.REMOTE"), options);
    }

    private WebDriver configureDriver(String browser, boolean isHeadless, boolean isRemote, MutableCapabilities options){
        if (isHeadless && options instanceof ChromeOptions) {
            ((ChromeOptions) options).addArguments("--headless");
        } else if (isHeadless && options instanceof EdgeOptions) {
            ((EdgeOptions) options).addArguments("--headless");
        } else if (isHeadless) {
            ((FirefoxOptions) options).addArguments("--headless");
        }

        if (isRemote) {
            webDriver = new RemoteWebDriver(options);
        }
        else {
            switch (browser)
            {
                case "chrome":
                    webDriver = new ChromeDriver((ChromeOptions) options);
                    break;
                case "edge":
                    webDriver = new EdgeDriver((EdgeOptions) options);
                    break;
                case "firefox":
                    webDriver = new FirefoxDriver((FirefoxOptions) options);
                    break;
            }
        }

        String baseUrl = SettingsLoader.get("BASE.URL");
        webDriver.manage().window().maximize();
        webDriver.navigate().to(baseUrl);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return webDriver;
    }

    public void takeScreenshotOnFailure(Scenario scenarioContext) {
        if (webDriver != null && scenarioContext.isFailed()) {
            byte [] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String screenshotName = scenarioContext.getName().replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp;

            scenarioContext.attach(screenshot, "image/png", "FAILED_SCREENSHOT_" + screenshotName);
        }
    }

    public void killDriver(){
        webDriver.quit();
    }
}