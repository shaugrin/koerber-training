package day3_day4;

import java.io.*;

public class a3DeserializeEmployee {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\day3\\employee.ser"))) {
            a3Employee employee = (a3Employee) ois.readObject();
            employee.display();
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
