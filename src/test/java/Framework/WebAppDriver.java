package Framework;

import Utilites.SettingsLoader;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
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

import java.io.*;
import java.nio.file.Paths;
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

        String tempPath = System.getProperty("java.io.tmpdir") + File.separator + "AutomationFailScreenshots" + File.separator;
        File directory = new File(tempPath);

        if (!directory.exists()) {
            try {
                directory.mkdir();
            }
            catch (RuntimeException ex){
                System.out.print("Failed to create directory");
            }
        }

        String fileName = scenarioContext.getName() + LocalDateTime.now().format(DateTimeFormatter.ofPattern(" dd MMMM yyyy HH-mm-ss")) + ".png";
        String screenshotPath = Paths.get(tempPath, fileName).toString();

        if (webDriver != null && scenarioContext.isFailed()) {
            try {
                File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
                File targetFile = new File(screenshotPath);
                FileUtils.copyFile(screenshotFile, targetFile);

                byte[] fileContent = FileUtils.readFileToByteArray(screenshotFile);
                scenarioContext.attach(fileContent, "image/png", "Test Failed. Local screenshot saved at " + screenshotPath);

            } catch (IOException e) {
                System.err.println("Failed to take screenshot: " + e.getMessage());
            }
        }
    }

    public void killDriver(){
        webDriver.quit();
    }
}