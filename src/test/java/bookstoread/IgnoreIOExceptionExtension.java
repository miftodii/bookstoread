package bookstoread;

import java.io.IOException;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IgnoreIOExceptionExtension
        implements TestExecutionExceptionHandler
{
    Logger logger = LoggerFactory
            .getLogger(IgnoreIOExceptionExtension.class);
    @Override
    public void handleTestExecutionException(ExtensionContext context,
            Throwable throwable) throws Throwable {

        if (throwable instanceof IOException) {
            logger.error("IO Exception {}", throwable);
            return;
        }
        throw throwable;
    }
}
