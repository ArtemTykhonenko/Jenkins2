package helpers;

import entities.BookEntity;
import org.openqa.selenium.*;
import pages.MainAmazonPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.DEFAULT_TIMEOUT;


/**
 * This class implements logic of the "findBookTest" in AmazonBookTest class
 *
 * @author Artem Tykhonenko
 */
public class BookHelper {

    private final WebDriver driver;
    private final MainAmazonPage mainAmazonPage;

    public BookHelper(final WebDriver driver, final MainAmazonPage mainAmazonPage) {
        this.driver = driver;
        this.mainAmazonPage = mainAmazonPage;
    }

    /**
     * Main method where implemented logic of searching books and adding them to the list
     *
     * @return {@link List} of the books
     */
    public List<BookEntity> extractBookInfo() {
        List<BookEntity> bookList = new ArrayList<>();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));

        List<WebElement> allBooksOnPage = mainAmazonPage.getAllBooks();
        for (int i = 1; i < allBooksOnPage.size(); i++) {
            String name = mainAmazonPage.getNameOfTheBook(i).getText();
            String author = mainAmazonPage.getAuthorOfTheBook(i).getText();

            List<WebElement> priceElemens = mainAmazonPage.getPricesOfTheBook(i);
            List<String> prices = new ArrayList<>();
            for (WebElement priceElement : priceElemens) {
                String priceText = priceElement.getText();
                prices.add(priceText);
            }

            boolean bestseller = false;
            try {
                WebElement bestSellerLabel = mainAmazonPage.getBestSellerLabel(i);
                bestseller = bestSellerLabel.isDisplayed();
            } catch (NoSuchElementException e) {
            }

            BookEntity book = new BookEntity(name, author, prices, bestseller);
            bookList.add(book);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_TIMEOUT));
        return bookList;
    }

    /**
     * Method checks that required book exists in the "BookList" list
     **/
    public boolean checkBookInList(BookEntity expectedBook) {
        List<BookEntity> bookList = extractBookInfo();
        for (BookEntity book : bookList) {
            if (book.equals(expectedBook)) {
                printBookInfo(book);
                return true;
            }
        }
        return false;

    }

    /**
     * Method opens url
     *
     * @param url - to open
     */
    public void openPage(final String url) {
        driver.get(url);
    }

    /**
     * Checking if captcha exists that clicking on the "Try different image" link. This helps continue without captcha
     */
    public void skipCaptcha() {
        try {
            WebElement captchaLink = mainAmazonPage.getFindCaptchaLink();
            if (captchaLink != null && captchaLink.isDisplayed()) {
                captchaLink.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Captcha link not found. Continuing without clicking.");
        }
    }

    /**
     * Method to search specific value in filter and search field on Amazon.com page
     *
     * @param keyword - query to search
     */
    public void findProduct(final String option, String keyword) {
        mainAmazonPage.getFilter().click();
        mainAmazonPage.getDropdown(option).click();
        mainAmazonPage.getSearchFieldOnMainPage().sendKeys(keyword);
        mainAmazonPage.getSearchSubmitTextOnMainPage().click();
    }

    /**
     * Method clicks on the 'Next' button and wait until last book vil be available
     */
    public void clickNextButtonAndWait() {
        mainAmazonPage.getNextButton().click();
        new WaitHelper(driver, mainAmazonPage).waitForLastElement();
    }

    /**
     * Print found book info
     */
    private void printBookInfo(BookEntity book) {
        System.out.println("Book found:");
        System.out.println("Name: " + book.getName());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Prices: " + book.getPrices());
        System.out.println("Bestseller: " + book.isBestseller());
    }
}