package entities;

import java.util.List;
import java.util.Objects;

/**
 * Entity with object data
 *
 * @author Artem Tykhonenko
 */
public class BookEntity {
    private String name;
    private String author;
    private List<String> prices;
    private boolean bestseller;

    public boolean isBestseller() {
        return bestseller;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getPrices() {
        return prices;
    }

    public BookEntity(String name, String author, List<String> prices, boolean bestseller) {
        this.name = name;
        this.author = author;
        this.prices = prices;
        this.bestseller = bestseller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(author, that.author) &&
                Objects.equals(prices, that.prices) &&
                bestseller == that.bestseller;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, prices, bestseller);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", prices=" + prices +
                ", bestseller=" + bestseller +
                '}';
    }
}
