package real;

import java.util.ArrayList;

public class Library
{
    int l_id;
    ArrayList<Book> books = null;
    int signUpTime = -1;
    int booksPerDay = -1;
    int totalValue = -1;

    public Library(int id, ArrayList<Book> books, int signUpTime, int booksPerDay)
    {
        this.l_id = id;
        this.books = books;
        this.signUpTime = signUpTime;
        this.booksPerDay = booksPerDay;
    }

    public Library(int id, ArrayList<Book> books, int signUpTime, int booksPerDay, int totalValue) {
        this.l_id = id;
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
