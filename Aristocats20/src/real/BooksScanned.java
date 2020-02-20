package real;

import java.util.ArrayList;
import java.util.HashMap;

public class BooksScanned
{
    ArrayList<Library> libraries = null;
    HashMap<Integer, Integer> booksScanned = null;
    int totalBooksScanned = -1;
    int totalScore = -1;
    int daysLeft = -1;

    public BooksScanned(int daysLeft)
    {
        this.daysLeft = daysLeft;
        this.booksScanned = new HashMap<>(); // Initialise
        this.libraries = new ArrayList<>(); // Initialise
        this.totalScore = 0;
        this.totalBooksScanned = 0;
    }

    public void scanBook(Library l, Book b) {
        // Increment score
        this.totalScore += b.value;

        // Increment books scanned
        this.totalBooksScanned++;

        // Add to booksScanned
        this.booksScanned.put(b.b_id, l.l_id);

        //
    }

    // Sign up library
    public int signUpLibrary(Library l) {
        libraries.add(l);

        return l.signUpTime;
    }

    private void removeBooksScanned(Library l) {

        for(int i = 0; i < l.books.size(); i++) // For all books
        {
            if(this.booksScanned.containsKey(l.books.get(i).b_id)) // If scanned
            {
                l.books.remove(l.books.get(i)); // Remove
            }
        }
    }
}
