package day2;

public abstract class a4Employee {
    private String name;

    public a4Employee(String name) {
        this.name = name;
    }

    public abstract double getWeeklySalary();

    public abstract void increaseSalary(double percentage);
}
