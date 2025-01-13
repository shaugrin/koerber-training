package day3_day4;

import java.io.FileReader;
import java.io.FileWriter;

public class a1FavoritePlayerFileReader {
    public static void main(String[] args) {
        try (FileReader br = new FileReader("src\\day3\\favorite_player.jpg");
             FileWriter bw = new FileWriter("src\\day3\\favoritePlayer_using_FileReader.jpg")) {

            int character;
            while ((character = br.read()) != -1) {
                bw.write(character);
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
