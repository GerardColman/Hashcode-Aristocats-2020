package real;

public class Library
{
    Book books = null;
    int signUpTime = -1;
    int booksPerDay = -1;
    int totalValue = -1;

    public Library(Book books, int signUpTime, int booksPerDay)
    {
        this.books = books;
        this.signUpTime = signUpTime;
        this.booksPerDay = booksPerDay;
    }

    public Library(Book books, int signUpTime, int booksPerDay, int totalValue) {
        this.books = books;
        this.signUpTime = signUpTime;
        this.booksPerDay = booksPerDay;
        this.totalValue = totalValue;
    }

    public void setTotalValue(int val)
    {
        if(val > 0)
        {
            this.totalValue = val;
        }
        else
        {
            throw new IllegalArgumentException("Total value can't be negative.");
        }
    }
}
