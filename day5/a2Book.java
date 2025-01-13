package day5;

import java.util.Objects;

public class a2Book {
    private String title;
    private String author;

    public a2Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("a2Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        a2Book a2Book = (a2Book) o;
        return Objects.equals(title, a2Book.title) && Objects.equals(author, a2Book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
