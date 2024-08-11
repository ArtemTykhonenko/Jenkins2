package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainAmazonPage;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static utils.Constants.DEFAULT_TIMEOUT;

/**
 * Class with waiters
 *
 * @author Artem Tykhonenko
 */
public class WaitHelper {
    private final WebDriver driver;
    private final MainAmazonPage mainAmazonPage;

    public WaitHelper(final WebDriver driver, final MainAmazonPage mainAmazonPage) {
        this.driver = driver;
        this.mainAmazonPage = mainAmazonPage;
    }

    public void waitForLastElement() {
        new WebDriverWait(driver, ofSeconds(DEFAULT_TIMEOUT)).until(visibilityOf(mainAmazonPage.getLastElement()));
    }
}