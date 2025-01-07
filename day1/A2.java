import java.util.Scanner;

public class A2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents=sc.nextInt();
        int[] grades = new int[numStudents];
        int sum=0;
        for (int i=0;i<numStudents;i++){
            System.out.print("Enter the grade for student"+(i+1)+": ");
            int a = sc.nextInt();
            if (a<0 || a>100) {
                System.out.println("Invalid grade, try again...");
                i--;
                continue;
            }
            grades[i]=a;
            sum+=a;
        }

        System.out.println("The average is: "+sum/numStudents);
    }
}
