package day5;
import java.io.*;
import java.util.HashMap;

public class a1CountFrequency {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\day5\\test.txt"))) {
            String line;
            while ((line=br.readLine()) != null) {
                String[] tokens = line.split(" ");
                HashMap<String, Integer> map = new HashMap<>();
                for (String token : tokens) {
                    if (map.containsKey(token)) {
                        map.put(token, map.get(token) + 1);
                    } else {
                        map.put(token, 1);
                    }
                }
                for (String key : map.keySet()) {
                    System.out.println(key + " appears " + map.get(key) + " times");
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
