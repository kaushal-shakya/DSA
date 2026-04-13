package lld1.lec1.librarysystem;

public class Book {
    public String title;
    public String author;
    public String ISBN;
    public double price;
    public int pages;

    public boolean isBorrowed=false;
    public boolean isReturned = false;
    public boolean borrow() {
        isBorrowed = true;
        return isBorrowed;
    }

    public boolean returnBook() {
         isReturned = true;
        return isReturned;
    }

    public boolean isAvailable() {
        return isReturned == false;
    }
}
