package day2;

public class a2BookStore {
    a2Book[] books = new a2Book[10];

    public void sell(String bookTitle, int noOfCopies) {
        for (a2Book book : books) {
            if (book != null && book.bookTitle.equals(bookTitle)) {
                book.numOfCopies -= noOfCopies;
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void order(String bookTitle, String author, String isbn, int noOfCopies) {
        for (a2Book book : books) {
            if (book != null && book.ISBN.equals(isbn)) {
                book.numOfCopies += noOfCopies;
                return;
            }
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = new a2Book(bookTitle, author, isbn, noOfCopies);
                return;
            }
        }
    }

    public void display() {
        for (a2Book book : books) {
            if (book != null) {
                book.display();
            }
        }
        boolean isEmpty = true;
        for (a2Book book : books) {
            if (book != null) {
                isEmpty = false;
                break;
            }
        }
        if (isEmpty) {
            System.out.println("Bookstore is empty");
        }
    }
}
