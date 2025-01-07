import java.util.Scanner;

public class A4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPascalTriangle(n);
    }

    public static void printPascalTriangle(int n) {
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            triangle[i][0] = 1;
            triangle[i][i] = 1;
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
