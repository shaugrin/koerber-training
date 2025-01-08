package day2;

public class a2Book {
    public String bookTitle;
    public String author;
    public String ISBN;
    public int numOfCopies;

    public a2Book(String bookTitle, String author, String ISBN, int numOfCopies) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.ISBN = ISBN;
        this.numOfCopies = numOfCopies;
    }

    public void display() {
        System.out.println(bookTitle+" - "+author+" - "+ISBN+" - "+numOfCopies);
    }
}
