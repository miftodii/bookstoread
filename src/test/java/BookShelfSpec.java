import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("<= BookShelf Specification =>")
class BookShelfSpec
{
    private BookShelf shelf;

    @BeforeEach
    void init() throws Exception {
        shelf = new BookShelf();
    }

    @Test
    public void emptyBookShelfWhenNoBookAdded() {
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        shelf.add("Effective Java", "Code Complete");
        List<String> books = shelf.books();
        assertEquals(2, books.size(), () -> "BookShelf should have two books.");
    }

    @Test
    public void emptyBookShelfWhenAddIsCalledWithoutBooks() {
        shelf.add();
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }

    @Test
    void booksReturnedFromBookShelfIsImmutableForClient() {
        shelf.add("Effective Java", "Code Complete");
        List<String> books = shelf.books();
        try {
            books.add("The Mythical Man-Month");
            fail(() -> "Should not be able to add book to books");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException, () -> "Should throw UnsupportedOperationException.");
        }
    }

    @Test
    void bookshelfArrangedByBookTitle() {
        BookShelf shelf = new BookShelf();
        shelf.add("Effective Java", "Code Complete","The Mythical Man-Month" );
        List<String> books = shelf.arrange();
        assertEquals(Arrays.asList( "Code Complete", "Effective Java", "The Mythical Man-Month"), books, () -> "Books in a bookshelf should be arranged lexicographically by book title");
    }

    @Test
    void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
        BookShelf shelf = new BookShelf();
        shelf.add("Effective Java", "Code Complete", "The Mythical Man-Month");
        shelf.arrange();
        List<String> books = shelf.books();
        assertEquals(Arrays.asList("Effective Java", "Code Complete", "The Mythical Man-Month"), books, () -> "Books in bookshelf are in insertion order");
    }
}
