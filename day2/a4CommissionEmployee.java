package day2;

public class a4CommissionEmployee extends a4Employee {
    double commissionPercentage;
    double totalWeeklySales;
    public a4CommissionEmployee(String name, double commissionPercentage, double totalWeeklySales) {
        super(name);
        this.commissionPercentage = commissionPercentage;
        this.totalWeeklySales = totalWeeklySales;
    }

    public double getWeeklySalary() {
        return totalWeeklySales * commissionPercentage / 100;
    }

    public void increaseSalary(double percentage) {
        commissionPercentage += commissionPercentage * percentage / 100;
    }
}
