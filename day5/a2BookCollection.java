package day5;

import java.util.*;

public class a2BookCollection {
    public static void main(String[] args) {
        String ownerName;
        List<a2Book> books = new ArrayList<>();

        a2Book book1 = new a2Book("The Lord of the Rings", "J.R.R. Tolkien");
        a2Book book2 = new a2Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling");
        a2Book book3 = new a2Book("The Hobbit", "I.R.R. Tolkien");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        System.out.println(hasBook(new a2Book("Lord","Me"),books));
        System.out.println(hasBook(new a2Book("The Lord of the Rings", "J.R.R. Tolkien"),books));
        sortBookByTitle(books);
        System.out.println(books);
        sortBookByAuthor(books);
        System.out.println(books);
    }

    public static boolean hasBook(a2Book b, List<a2Book> books){
        for (a2Book book : books)
        {
            if (book.equals(b)){
                return true;
            }
        }
        return false;
    }

    public static void sortBookByTitle(List<a2Book> books){
        a2BookSortByTitle sortByTitle = new a2BookSortByTitle();
        Collections.sort(books,sortByTitle);
    }

    public static void sortBookByAuthor(List<a2Book> books){
        a2BookSortByAuthor sortByAuthor = new a2BookSortByAuthor();
        Collections.sort(books,sortByAuthor);
    }

}
