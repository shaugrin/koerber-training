package day3_day4;
import java.io.*;

public class a3SerializeEmployee {
    public static void main(String[] args) {
        a3Employee employee = new a3Employee(1, "John", new a3Address("New York", "NY", "USA", "123 Main Street"), 50000);
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("src\\day3\\employee.ser"))) {
            ois.writeObject(employee);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
