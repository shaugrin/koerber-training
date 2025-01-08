package day2;

public abstract class a3Account {
    private String name;
    private int accountNumber;
    double accountBalance;

    public a3Account(String name, int accountNumber, double accountBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public double deposit(double amount) {
        accountBalance += amount;
        return accountBalance;
    }

    public abstract double getBalance();

    public abstract double withdraw(double amount);
}
