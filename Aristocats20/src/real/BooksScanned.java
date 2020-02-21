package real;

import java.util.ArrayList;
import java.util.HashMap;

public class BooksScanned {
    ArrayList<Library> libraries = null;
    HashMap<Integer, Integer> booksScanned = null; //
    int totalBooksScanned = -1;
    int totalScore;
    int daysLeft;

    public BooksScanned(int daysLeft) {
        this.daysLeft = daysLeft;
        this.booksScanned = new HashMap<>(); // Initialise
        this.libraries = new ArrayList<>(); // Initialise
        this.totalScore = 0;
        this.totalBooksScanned = 0;
    }

    public int getNumLibsSignedUp() {
        return this.libraries.size();
    }

    // Make sure we are scanning from the library in the Array list pls

    public void scanBook(Library l, Book b) {
        // Increment score
        this.totalScore += b.value;

        // Increment books scanned
        this.totalBooksScanned++;

        // Add to booksScanned
        this.booksScanned.put(b.b_id, l.l_id);

        // Add to scan records
        l.scanRecords += (b.b_id + " ");
        l.booksScanned++;

        // Remove from library
        l.books.remove(b);
    }

    // Sign up library
    public int signUpLibrary(Library l) {

        removeBooksScanned(l);

        libraries.add(l);

        return l.signUpTime;
    }

    private void removeBooksScanned(Library l) {

        for (int i = 0; i < l.books.size(); i++) // For all books
        {
            if (this.booksScanned.containsKey(l.books.get(i).b_id)) // If scanned
            {
                l.totalValue = l.totalValue - l.books.get(i).value; // Reduce total value
                l.books.remove(l.books.get(i)); // Remove from library
            }
        }
    }

    public void removeEmptyLibraries() {
        for (int i = 0; i < libraries.size(); i++) {
            if (libraries.get(i).booksScanned == 0) {
                libraries.remove(i);
            }
        }
    }

}
