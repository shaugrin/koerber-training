package day2;

public class a1EmployeeTest {
    public static void main(String[] args) {
        a1Employee employee = new a1Employee(1, "John", "Doe", 50000);
        System.out.println(employee.getId());
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getName());
        System.out.println(employee.getSalary());
        employee.setSalary(60000);
        System.out.println(employee.getSalary());
        System.out.println(employee.getAnnualSalary());
        System.out.println(employee.raiseSalary(10));
        System.out.println(employee.toString());
    }
}
