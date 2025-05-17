package Framework;

import com.opencsv.bean.CsvToBeanBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public class HelperMethods {

    // drivers for page
    private WebDriver driver;

    // setting driver in use to this driver
    public HelperMethods(WebAppDriver webAppDriver)
    {
        this.driver = webAppDriver.getDriver();
    }

    public void sleep(int numOfSeconds)
    {
        try {
            Thread.sleep(Duration.ofSeconds(numOfSeconds).toMillis());
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void assertAreEqual(String expected, String actual) {
        Assert.assertEquals(actual, expected);
    }

    public void assertPageUrl(String expectedPageUrl) {
        if (driver != null)
            Assert.assertEquals(driver.getCurrentUrl(), expectedPageUrl);
        else {
            throw new RuntimeException("This method can only be used for web application testing.");
        }
    }

    public void assertPageTitle(String expectedPageTitle) {
        if (driver != null)
            Assert.assertEquals(driver.getTitle(), expectedPageTitle);
        else {
            throw new RuntimeException("This method can only be used for web application testing.");
        }
    }

    public void assertPageUrlContains(String expectedPageUrlFragment) {
        if (driver != null)
            Assert.assertTrue(driver.getCurrentUrl().contains(expectedPageUrlFragment));
        else {
            throw new RuntimeException("This method can only be used for web application testing.");
        }
    }

    public void assertPageTitleContains(String expectedPageTitleFragment) { 
        if (driver != null)
            Assert.assertTrue(driver.getTitle().contains(expectedPageTitleFragment));
        else {
            throw new RuntimeException("This method can only be used for web application testing.");
        }
    }

    public static <T> List<T> csvReader(String csvFileName, Class<T> csvClass)
    {
        Path csvPath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "CSVFiles", csvFileName + ".csv");
        try (FileReader reader = new FileReader(csvPath.toString())) {
            return new CsvToBeanBuilder<T>(reader)
                    .withType(csvClass)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
            } catch (Exception e) {
                throw new RuntimeException("CSV file '" + csvFileName + "' could not be found");
            }
    }
}