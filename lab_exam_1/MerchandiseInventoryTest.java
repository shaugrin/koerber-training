package day5;

import java.io.*;
import java.util.*;

public class MerchandiseInventoryTest {
    public static void main(String[] args) {
        List<Merchandise> merchandiseList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\day5\\merch.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                Merchandise merchandise = new Merchandise(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
                merchandiseList.add(merchandise);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------sort by name in ascending order--------");
        MerchandiseSortByNames merchandiseSortByNames = new MerchandiseSortByNames();
        Collections.sort(merchandiseList, merchandiseSortByNames);
        for (Merchandise merchandise : merchandiseList) {
            System.out.println(merchandise);
        }

        System.out.println("--------sort by price in decending order--------");

        MerchandiseSortByPrices merchandiseSortByPrices = new MerchandiseSortByPrices();
        Collections.sort(merchandiseList, merchandiseSortByPrices);
        for (Merchandise merchandise : merchandiseList) {
            System.out.println(merchandise);
        }
    }
}
