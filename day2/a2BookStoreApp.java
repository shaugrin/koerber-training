package day2;

public class a2BookStoreApp {
    public static void main(String[] args) {
        a2BookStore store = new a2BookStore();
        store.display();
        store.order("Welcome to Java","Digvijay","978-1-12345678", 3);
        store.display();
        store.sell("Welcome to Java", 2);
        store.display();
    }
}
