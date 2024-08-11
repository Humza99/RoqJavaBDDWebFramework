package Framework;

import com.opencsv.bean.CsvToBeanBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
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

    public void assertPageUrlContains(String expectedPageUrlFragment) { // NEED TO TEST THIS METHOD
        if (driver != null)
            Assert.assertTrue(driver.getCurrentUrl().contains(expectedPageUrlFragment));
        else {
            throw new RuntimeException("This method can only be used for web application testing.");
        }
    }

    public void assertPageTitleContains(String expectedPageTitleFragment) { // NEED TO TEST THIS METHOD
        if (driver != null)
            Assert.assertTrue(driver.getTitle().contains(expectedPageTitleFragment));
        else {
            throw new RuntimeException("This method can only be used for web application testing.");
        }
    }

    public List<CsvFileHeaders> csvReader(String csvPath) throws IOException {
        try (FileReader reader = new FileReader(csvPath)) {
            return new CsvToBeanBuilder<CsvFileHeaders>(reader)
                    .withType(CsvFileHeaders.class)
                    .build()
                    .parse();
        } catch (IOException ex) {
            throw new IOException("Csv file could not be found. Please use a valid path", ex);
        }
    }
}
