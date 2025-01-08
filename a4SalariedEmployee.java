package day2;

public class a4SalariedEmployee extends a4Employee {
    double weeklySalary;
    public a4SalariedEmployee(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public void increaseSalary(double percentage) {
        weeklySalary += weeklySalary * percentage / 100;
    }
}
