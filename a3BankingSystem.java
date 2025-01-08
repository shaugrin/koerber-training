package day2;

import java.util.Scanner;

public class a3BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to our banking system");
        System.out.println("Do you want to open an account? (yes/no)");
        int run = 1;
        String choice;
        while (run == 1) {
            choice = sc.next();
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Do you want to open a current account or a savings account? (current/savings)");
                String choice2;
                int run2 = 1;
                while (run2 == 1) {
                    choice2 = sc.next();
                    if (choice2.equalsIgnoreCase("current")) {
                        System.out.println("Enter your name: ");
                        String name = sc.next();
                        System.out.println("Enter your account number: ");
                        int accountNumber = sc.nextInt();
                        System.out.println("Enter your account balance: ");
                        double accountBalance = sc.nextDouble();
                        System.out.println("Enter your trade license number: ");
                        int tradeLicenseNumber = sc.nextInt();
                        System.out.println("Enter your overdraft: ");
                        double overdraft = sc.nextDouble();
                        a3CurrentAccount currentAccount = new a3CurrentAccount(name, accountNumber, accountBalance, tradeLicenseNumber, overdraft);
                        System.out.println("Account created successfully.");
                        System.out.println("Do you want to deposit/withdraw/check balance? (deposit/withdraw/check)");
                        String choice3 = sc.next();
                        if (choice3.equalsIgnoreCase("deposit")) {
                            System.out.println("Enter the amount to deposit: ");
                            double depositAmount = sc.nextDouble();
                            currentAccount.deposit(depositAmount);
                        } else if (choice3.equalsIgnoreCase("withdraw")) {
                            System.out.println("Enter the amount to withdraw: ");
                            double withdrawAmount = sc.nextDouble();
                            currentAccount.withdraw(withdrawAmount);
                        } else if (choice3.equalsIgnoreCase("check")) {
                            System.out.println("Your current balance is: " + currentAccount.getBalance());
                        }
                        run2 = 0;
                    } else if (choice2.equalsIgnoreCase("savings")) {
                        System.out.println("Enter your name: ");
                        String name = sc.next();
                        System.out.println("Enter your account number: ");
                        int accountNumber = sc.nextInt();
                        System.out.println("Enter your account balance: ");
                        double accountBalance = sc.nextDouble();
                        System.out.println("Enter the interest rate: ");
                        double interestRate = sc.nextDouble();
                        a3SavingsAccount savingsAccount = new a3SavingsAccount(name, accountNumber, accountBalance, interestRate);
                        System.out.println("Account created successfully.");
                        System.out.println("Do you want to deposit/withdraw/check balance? (deposit/withdraw/check)");
                        String choice3 = sc.next();
                        if (choice3.equalsIgnoreCase("deposit")) {
                            System.out.println("Enter the amount to deposit: ");
                            double depositAmount = sc.nextDouble();
                            savingsAccount.deposit(depositAmount);
                        } else if (choice3.equalsIgnoreCase("withdraw")) {
                            System.out.println("Enter the amount to withdraw: ");
                            double withdrawAmount = sc.nextDouble();
                            savingsAccount.withdraw(withdrawAmount);
                        } else if (choice3.equalsIgnoreCase("check")) {
                            System.out.println("Your current balance is: " + savingsAccount.getBalance());
                        }
                        run2 = 0;
                    } else {
                        System.out.println("Enter a valid option\n");
                    }
                }

            } else if (choice.equalsIgnoreCase("no")) {
                run = 0;
            } else {
                System.out.println("Enter valid option\n");
            }
        }

        System.out.println("Thank you for visiting! Have a nice day!");
    }
}