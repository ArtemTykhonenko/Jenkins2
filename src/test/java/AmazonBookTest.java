import dataproviders.AmazonBookTestDataProvider;
import entities.BookEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.Constants.AMAZON_URL;

/**
 * Main test class
 *
 * @author Artem Tykhonenko
 */
public class AmazonBookTest extends BaseTest {

    @Test(description = "Book is present in the result of search",
            priority = 1,
            dataProvider = "bookData",
            dataProviderClass = AmazonBookTestDataProvider.class)
    public void findBookTest(BookEntity bookToFind) {
        bookHelper.openPage(AMAZON_URL);
        bookHelper.skipCaptcha();
        bookHelper.findProduct("Books", "java");
        bookHelper.clickNextButtonAndWait(); //Needs if book absent on first page
        bookHelper.extractBookInfo();
        System.out.println("BOOK INFO: " + bookHelper.extractBookInfo());
        Assert.assertTrue(bookHelper.checkBookInList(bookToFind));
    }
}