package day3_day4;

import java.io.*;

public class a1FavoritePlayerFileInputStream {

    public static void main(String[] args) {
        try (FileInputStream br = new FileInputStream("src\\day3\\favorite_player.jpg");
             FileOutputStream bw = new FileOutputStream("src\\day3\\favoritePlayer_using_FileInputStream.jpg")) {

            int bytesRead;
            while ((bytesRead = br.read()) != -1) {
                bw.write(bytesRead);
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
