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
                new Object[]{new BookEntity("100 Java Mistakes and How to Avoid Them", "by Tagir Valeev | Apr 30, 2024", List.of("50"), false)},
        };
    }
}

