package real;

import java.util.Comparator;
import java.util.HashMap;

public class BookSelection
{
    HashMap<Integer, Integer> booksScanned = null;
    Library l =  null;
    int top = 0;

    // Sort books by value
    public void sortBooks()
    {
        l.books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });


    }

    public Book getBestBook()
    {
        Book best = l.books.get(top++);

        return best;
    }

}
