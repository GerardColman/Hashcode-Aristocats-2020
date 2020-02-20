package real;

import java.util.ArrayList;
import java.util.HashMap;

public class BooksScanned
{
    ArrayList<Library> libraries = null;
    HashMap<Integer, Boolean> booksScanned = null;
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

    public void scanBook(Book b)
    {
        // Increment score
        this.totalScore += b.value;

        // Increment books scanned
        this.totalBooksScanned++;

        // Add to booksScanned
        this.booksScanned.put(b.id, true);
    }

    // Sign up library
    public int signUpLibrary(Library l)
    {
        libraries.add(l);

        return l.signUpTime;
    }
}
