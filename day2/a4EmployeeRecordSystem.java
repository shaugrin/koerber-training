package day2;

public class a4EmployeeRecordSystem {
    public static void main(String[] args) {
        a4Employee employee = new a4SalariedEmployee("John Doe", 50000);
        System.out.println(employee.getWeeklySalary());
        employee.increaseSalary(10);
        System.out.println(employee.getWeeklySalary());
        employee = new a4HourlyEmployee("Jane Doe", 20, 40);
        System.out.println(employee.getWeeklySalary());
        employee.increaseSalary(10);
        System.out.println(employee.getWeeklySalary());
        employee = new a4CommissionEmployee("Jack Doe", 10, 1000);
        System.out.println(employee.getWeeklySalary());
        employee.increaseSalary(10);
        System.out.println(employee.getWeeklySalary());
    }
}
