package bookstoread;

import java.time.LocalDate;

class BookPublishedYearFilter implements BookFilter {
    private LocalDate startDate;

    static BookPublishedYearFilter before(int year) {
        BookPublishedYearFilter filter = new BookPublishedYearFilter();
        filter.startDate = LocalDate.of(year, 12, 31);
        return filter;
    }

    static BookPublishedYearFilter after(int year) {
        BookPublishedYearFilter filter = new BookPublishedYearFilter();
        filter.startDate = LocalDate.of(year, 12, 31);
        return filter;
    }

    @Override
    public boolean apply(final Book b) {
        return b.getPublishedOn().isAfter(startDate);
    }
}
