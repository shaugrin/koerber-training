package day3_day4;

import java.io.Serializable;

public class a3Employee implements Serializable {
    int id;
    String name;
    a3Address address;
    transient double salary;

    public a3Employee(int id, String name, a3Address address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address.exactAddress + "\nCity: " + address.city + "State: " + address.state + "Country: " + address.country);
        System.out.println("Salary: " + salary);
    }
}
