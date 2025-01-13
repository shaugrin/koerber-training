package day3_day4;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class a4BookApp {


    public static void purchaseBook(a4Book book,int noOfCopies, LinkedList<a4Book> bookList) {
        while (noOfCopies > 0) {
            bookList.add(book);
            noOfCopies--;
        }
    }

    public static void sellBook(String ISBN, int noOfCopies, LinkedList<a4Book> bookList) throws NotSufficientBooksException {
        Iterator<a4Book> itr = bookList.iterator();
        int i=0;
        while (itr.hasNext()) {
            a4Book book = itr.next();
            if (book.ISBN.equals(ISBN)) {
                itr.remove();
                i++;
                if (i == noOfCopies) {
                    break;
                }
            }
        }

        if (i < noOfCopies) {
            throw new NotSufficientBooksException("Book not found");
        }
    }

    public a4Book searchBook(int id, LinkedList<a4Book> bookList) {
        for (a4Book book : bookList) {
            if (book.id == id) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) throws NotSufficientBooksException {
        LinkedList<a4Book> bookList = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\day3\\books.txt"));) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(":");
                a4Book book = new a4Book(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                bookList.add(book);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        sellBook("A234", 1, bookList);
        a4Book book2 = new a4Book(1,"Z234","spring","me",222);
        purchaseBook(book2,2,bookList);
        for (a4Book book : bookList) {
            System.out.println(book);
        }
    }
}

