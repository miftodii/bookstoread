package bookstoread;

import java.util.Map;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({BooksParameterResolver.class, LoggingTestExecutionExceptionHandler.class})
@EnableRuleMigrationSupport
public class BookShelfSpecWithRules {

    private BookShelf shelf;
    private Book effectiveJava;
    private Book codeComplete;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void init(Map<String, Book> books) {
        this.effectiveJava = books.get("Effective Java");
        this.codeComplete = books.get("Code Complete");


    }

    @Test
    void throwsExceptionWhenBooksAreAddedAfterCapacityIsReached()
            throws BookShelfCapacityReached
    {
        shelf = new BookShelf(1);
        expectedException.expect(BookShelfCapacityReached.class);
        expectedException.expectMessage("BookShelf capacity of 1 is reached. You can't add more books.");
        shelf.add(effectiveJava, codeComplete);
    }

    @RepeatedTest(10)
    void i_am_a_repeated_test() {
        assertTrue(true);
    }
}
