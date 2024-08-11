import helpers.BookHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pages.MainAmazonPage;
import utils.BrowserFactory;

/**
 * This class contains all common methods and serves to declare methods
 */
public class BaseTest {
    private WebDriver driver;
    MainAmazonPage mainAmazonPage;
    BookHelper bookHelper;

    @BeforeMethod
    public void setUpBrowser() {
        driver = BrowserFactory.getDriver();
        mainAmazonPage = new MainAmazonPage(driver);
        bookHelper = new BookHelper(driver, mainAmazonPage);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}