package bookstoread;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookFilterTemplateSpec {

    @TestTemplate
    @ExtendWith(BookFilterTestInvocationContextProvider.class)
    void validateFilters(BookFilter filter, Book[] books) {
        assertNotNull(filter);
        assertFalse(filter.apply(books[0]));
        assertTrue(filter.apply(books[1]));
    }
}
