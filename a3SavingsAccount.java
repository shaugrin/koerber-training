package day2;

public class a3SavingsAccount extends a3Account{
    double interestRate=5;
    double maximumWithdrawalLimit;
    public a3SavingsAccount(String name, int accountNumber,double balance, double interestRate) {
        super(name, accountNumber, balance);
        this.interestRate=interestRate;
        this.maximumWithdrawalLimit=balance;
    }

    public double getBalance() {
        return super.accountBalance+(super.accountBalance*interestRate/100);
    }

    public double withdraw(double amount) {
        if (amount <= maximumWithdrawalLimit) {
            super.accountBalance -= amount;
            return amount;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
            return 0;
        }
    }
}
