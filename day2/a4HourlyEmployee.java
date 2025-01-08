package day2;

public class a4HourlyEmployee extends a4Employee{
    double hourlyRate;
    double hoursWorkedPerWeek;
    public a4HourlyEmployee(String name, double hourlyRate, double hoursWorkedPerWeek) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorkedPerWeek = hoursWorkedPerWeek;
    }
    public double getWeeklySalary() {
        return hourlyRate * hoursWorkedPerWeek;
    }

    public void increaseSalary(double percentage) {
        hourlyRate += hourlyRate * percentage / 100;
    }
}
