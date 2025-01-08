package day2;

public class a3CurrentAccount extends a3Account {
    private int tradeLicenseNumber;
    private double overdraft;
    public a3CurrentAccount(String name, int accountNumber, double accountBalance,int tradeLicenseNumber, double overdraft) {
        super(name, accountNumber, accountBalance);
        this.tradeLicenseNumber = tradeLicenseNumber;
        this.overdraft = overdraft;
    }

    public double getBalance() {
        return super.accountBalance;
    }

    public double withdraw(double amount) {
        if (amount <= super.accountBalance+overdraft) {
            super.accountBalance -= amount;
            return amount;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
            return 0;
        }
    }

}
