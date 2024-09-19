package dataproviders;

import entities.BookEntity;
import org.testng.annotations.DataProvider;

import java.util.List;

/**
 * Data-provider with searching books
 *
 * @author Artem Tykhonenko
 */
public class AmazonBookTestDataProvider {

    @DataProvider(name = "bookData")
    public static Object[][] bookData() {
        return new Object[][]{
                new Object[]{new BookEntity("Java All-in-One For Dummies", "by Doug Lowe | Feb 14, 2023", List.of("27"), false)},
        };
    }
}

