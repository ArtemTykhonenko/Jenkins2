package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Page factory which contains all needed elements for {@link MainAmazonPage}
 *
 * @author Artem Tykhonenko
 */
public class MainAmazonPage {

    private final WebDriver driver;

    public MainAmazonPage(final WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }

    private final String captchaLink = "//a[normalize-space()='Try different image']";
    private final String filter = "//div[@class='nav-search-scope nav-sprite']";
    private final String filterDropdown = "//option[text()='%s']";
    private final String searchField = "//input[@id='twotabsearchtextbox']";
    private final String searchSubmitText = "//*[@id='nav-search-submit-text']";
    private final String nextPageButton = "//a[normalize-space()='Next']";
    private final String lastElementOnThePage = "(//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[.//span[@class='a-size-medium a-color-base a-text-normal']])[16]";
    private final String findAllBooksOnPage = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[.//span[@class='a-size-medium a-color-base a-text-normal']]";
    private final String findNameOfTheBook = "(//span[@class='a-size-medium a-color-base a-text-normal'])[%d]";
    private final String findAuthorOfTheBook = "(//div[@class='a-row a-size-base a-color-secondary']/div[@class='a-row'])[%d]";
    private final String findPriceOfTheBook = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[.//span[@class='a-size-medium a-color-base a-text-normal']][%d]//div[@class='a-row']//span[@class='a-price']//span[@class='a-price-whole']";
    private final String findBestSellerLabel = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[.//span[@class='a-size-medium a-color-base a-text-normal']][%d]//span[@class='a-badge-text']";
    private final String findNameOfTheSearchingBook = "//span[@class='a-size-medium a-color-base a-text-normal' and contains(text(), '%s')]";

    @FindBy(xpath = findNameOfTheSearchingBook)
    private WebElement nameOfTheSearchingBook;

    @Getter
    @FindBy(xpath = findAllBooksOnPage)
    private List<WebElement> allBooks;

    @Getter
    @FindBy(xpath = lastElementOnThePage)
    private WebElement lastElement;

    @Getter
    @FindBy(xpath = nextPageButton)
    private WebElement nextButton;

    @Getter
    @FindBy(xpath = filter)
    private WebElement Filter;

    @FindBy(xpath = searchField)
    private WebElement searchFieldOnMAinPage;

    @Getter
    @FindBy(xpath = searchSubmitText)
    private WebElement searchSubmitTextOnMainPage;

    @FindBy(xpath = findNameOfTheBook)
    private WebElement nameOfTheBook;

    @FindBy(xpath = findAuthorOfTheBook)
    private WebElement authorOfTheBook;

    @FindBy(xpath = findPriceOfTheBook)
    private List<WebElement> pricesOfTheBook;

    @Getter
    @FindBy(xpath = captchaLink)
    private WebElement findCaptchaLink;

    public WebElement getSearchFieldOnMainPage() {
        return searchFieldOnMAinPage;
    }


    public WebElement getNameOfTheBook(final int index) {
        return driver.findElement(xpath(format(findNameOfTheBook, index)));
    }

    public WebElement getAuthorOfTheBook(final int index) {
        return driver.findElement(xpath(format(findAuthorOfTheBook, index)));
    }

    public List<WebElement> getPricesOfTheBook(final int bookIndex) {
        return driver.findElements(xpath(format(findPriceOfTheBook, bookIndex)));

    }

    public WebElement getBestSellerLabel(final int index) {
        return driver.findElement(xpath(format(findBestSellerLabel, index)));
    }

    public WebElement getDropdown(final String option) {
        return driver.findElement(xpath(format(filterDropdown, option)));
    }
}