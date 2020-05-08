import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("<= BookShelf Specification =>")
class BookShelfSpec
{
    private BookShelfSpec(TestInfo testInfo) {
        /*
        This constructor is private
         */
        System.out.println("Working on test " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("is empty when no book is added to it")
    void shelf_empty_when_no_book_added(TestInfo testInfo) {
        System.out.println("Working on test case " + testInfo.getDisplayName());
        BookShelf shelf = new BookShelf();
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), "BookShelf should be empty.");
    }

    @Test
    void shouldCheckForEvenNumbers() {
        int number = new Random(10).nextInt();
        assertTrue(() -> number%2 == 0, number+ " is not an even number.");

        BiFunction<Integer, Integer, Boolean> divisible = (x, y) -> x % y == 0;
        Function<Integer, Boolean> multipleOf2 = (x) -> divisible.apply(x, 2);
        assertTrue(() -> multipleOf2.apply(number), () -> " 2 is not factor of " + number);

        List<Integer> numbers = Arrays.asList(1, 1, 1, 1, 2);
        assertTrue(() -> numbers.stream().distinct().anyMatch(this::isEven), "Did not find an even number in the list");
    }

    boolean isEven(int number) {
        return number % 2 == 0;
    }
}
