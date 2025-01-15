package day6;

public class a2Main {

    public static void main(String[] args) {
        a2Account account = new a2Account(1000);
        a2Bank bank = new a2Bank(account);
        a2Company company = new a2Company(account);

        Thread t2 = new Thread(bank);
        Thread t3 = new Thread(company);
        t2.start();
        t3.start();

        try {
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance());
    }
}