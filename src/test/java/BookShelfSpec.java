import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BookShelfSpec
{

    private BookShelfSpec(TestInfo testInfo) {
        System.out.println("Working on test " + testInfo.getDisplayName());
    }

    @Test
    void shelfEmptyWhenNoBookAdded() {
        BookShelf shelf = new BookShelf();
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), "BookShelf should be empty.");
    }
}
