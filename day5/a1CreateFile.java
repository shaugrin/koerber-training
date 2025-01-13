package day5;

import java.io.*;
import java.util.Scanner;

public class a1CreateFile {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);BufferedWriter bw = new BufferedWriter(new FileWriter("src\\day5\\test.txt"))) {
            String line=sc.nextLine();
            bw.write(line);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
