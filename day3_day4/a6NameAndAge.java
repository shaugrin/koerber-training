package day3_day4;

import java.util.Scanner;

public class a6NameAndAge {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            if (age<18 || age>60){
                throw new InvalidAge("Age should be between 18 and 60");
            }
        } catch (InvalidAge e) {
            System.out.println(e.getMessage());
        }
    }
}
