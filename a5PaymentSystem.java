package day2;

public class a5PaymentSystem {
    public static void main(String[] args) {
        a5Payable invoice = new a5Invoice("1234", "Laptop", 1, 1000);
        System.out.println(invoice.getPayment());
        System.out.println(invoice);
        a5Payable employee = new a5Employee(1, "John Doe", 50000);
        System.out.println(employee.getPayment());
    }
}
