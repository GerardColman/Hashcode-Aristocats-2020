package real;

import java.util.Comparator;

public class BookSelection {
    Library l = null;

    // Sort books by value
    public void sortBooks() {
        l.books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });
    }

    public Book getBestBook() {
        Book best = l.books.get(0);

        l.books.remove(0);

        return best;
    }

}
