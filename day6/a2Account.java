package day6;

public class a2Account {
    private double balance;

    public a2Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addAmount(double amount) {
        balance += amount;
    }
    public void subtractAmount(double amount) {
        balance -= amount;
    }


}