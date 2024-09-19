package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static utils.Constants.DEFAULT_TIMEOUT;

public class BrowserFactory {
    private static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver";
    private static final String GECKO_DRIVER_PATH = "src/main/resources/geckodriver.exe";

    private BrowserFactory() {
        // Private constructor to prevent external instantiation
    }

    private static class LazyHolder {
        private static final WebDriver INSTANCE = createDriver();

        private static WebDriver createDriver() {
            String driverName = System.getProperty("browser", "chrome");
            WebDriver driver;

            if ("firefox".equalsIgnoreCase(driverName)) {
                System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
                driver = new FirefoxDriver();
            } else if ("chrome".equalsIgnoreCase(driverName)) {
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
            } else {
                System.out.println("This driver is absent");
                driver = null;
            }

            if (driver != null) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_TIMEOUT));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT));
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT));
                driver.manage().window().maximize();
            }

            return driver;
        }
    }

    public static WebDriver getDriver() {
        return LazyHolder.INSTANCE;
    }
}