package Framework;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
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
        webDriver = initialiseDriver(SettingsLoader.get("BROWSER.TYPE").toLowerCase());
    }

    public WebDriver getDriver() { return webDriver; }

    private WebDriver initialiseDriver(String browser) {
        boolean headlessMode = SettingsLoader.getBoolean("HEADLESS.MODE");
        boolean enableRemote = SettingsLoader.getBoolean("ENABLE.REMOTE");
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                if (headlessMode){
                    chromeOptions.addArguments("--headless");
                    webDriver = new ChromeDriver(chromeOptions);
                }
                else if (enableRemote){
                    webDriver = new RemoteWebDriver(chromeOptions);
                }
                else {
                    webDriver = new ChromeDriver(chromeOptions);
                }
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headlessMode){
                    edgeOptions.addArguments("--headless");
                    webDriver = new EdgeDriver(edgeOptions);
                }
                else if (enableRemote){
                    webDriver = new RemoteWebDriver(edgeOptions);
                }
                else{
                    webDriver = new EdgeDriver(edgeOptions);
                }
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headlessMode){
                    firefoxOptions.addArguments("--headless");
                    webDriver = new FirefoxDriver(firefoxOptions);
                }
                else if(enableRemote){
                    webDriver = new RemoteWebDriver(firefoxOptions);
                }
                else {
                    webDriver = new FirefoxDriver(firefoxOptions);
                }
                break;
            default: throw new RuntimeException("Invalid browser name provided '" + browser + "', Please use chrome, edge or firefox.");
        }
        configDriver();

        return webDriver;
    }

    private void configDriver(){
        String baseUrl = SettingsLoader.get("BASE.URL");
        webDriver.manage().window().maximize();
        webDriver.navigate().to(baseUrl);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public String takeScreenshotOnFailure(Scenario scenarioContext) {

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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return screenshotPath;
    }

    public void killDriver(){
        webDriver.quit();
    }
}