package bookstoread;

public class BookShelfCapacityReached extends RuntimeException
{
    public BookShelfCapacityReached(String format)
    {
        super(format);
    }
}
