import java.util.Scanner;

public class A5 {
    private int day;
    private int month;
    private int year;
    private int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public A5(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void nextDay() {
        day++;
        if (day > getDaysInMonth()) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public int getDaysInMonth() {
        if (month == 2 && isLeapYear()) {
            return 29;
        } else {
            return daysInMonth[month - 1];
        }
    }

    public boolean isLeapYear() {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public String toString() {
        return String.format("%02d/%02d/%d", day, month, year);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter day: ");
        int day = sc.nextInt();
        System.out.print("Enter month: ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        A5 today = new A5(day, month, year);
        System.out.println("Today's date: " + today);

        A5 nextDay = new A5(day, month, year);
        nextDay.nextDay();
        System.out.println("Next date: " + nextDay);
    }
}