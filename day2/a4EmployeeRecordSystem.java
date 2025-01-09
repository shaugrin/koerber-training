package day2;

import java.util.ArrayList;

public class a4EmployeeRecordSystem {
    public static void main(String[] args) {
        ArrayList<a4Employee> employees = new ArrayList<>();

        a4Employee employee1 = new a4SalariedEmployee("John Doe", 50000);
        employees.add(employee1);
        System.out.println(employee1.getWeeklySalary());
        employee1.increaseSalary(10);
        System.out.println(employee1.getWeeklySalary());

        a4Employee employee2 = new a4HourlyEmployee("Jane Doe", 20, 40);
        employees.add(employee2);
        System.out.println(employee2.getWeeklySalary());
        employee2.increaseSalary(10);
        System.out.println(employee2.getWeeklySalary());

        a4Employee employee3 = new a4CommissionEmployee("Jack Doe", 10, 1000);
        employees.add(employee3);
        System.out.println(employee3.getWeeklySalary());
        employee3.increaseSalary(10);
        System.out.println(employee3.getWeeklySalary());

        a4CommissionEmployee employee4 = new a4CommissionEmployee("Jill Doe", 9, 9000);
        employees.add(employee4);
        for (a4Employee emp : employees) {
            if (emp instanceof a4CommissionEmployee) {
                emp.increaseSalary(10);
                System.out.println("weekly commision: " + emp.getWeeklySalary());
            }
        }
    }
}
