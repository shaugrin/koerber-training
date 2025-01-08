package day2;

public class a5Employee implements a5Payable {
    int id;
    String name;
    private double salary;

    public a5Employee(double salary, String name, int id) {
        this.salary = salary;
        this.name = name;
        this.id = id;
    }

    @Override
    public double getPayment() {
        return salary;
    }
}
