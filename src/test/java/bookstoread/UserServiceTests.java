package bookstoread;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({
        IgnoreIOExceptionExtension.class,
        BooksParameterResolver.class,
        RunOnCIExtension.class,
        TestSummaryExtension.class
})
@ExtendWith(LoggingExtension.class)
public class UserServiceTests{

}
