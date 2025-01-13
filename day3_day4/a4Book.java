package day3_day4;

public class a4Book {
    int id;
    String ISBN;
    String title;
    String author;
    double price;

    public a4Book(int id, String ISBN, String title, String author, double price) {
        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
