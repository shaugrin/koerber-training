package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//1. get all the link to be downloaded...
class FileUtil{
    //give u list of all vidoes/file
    public static List<String> readFiles(String fileName){
        List<String> files=new ArrayList<>();

        try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line=br.readLine())!=null){
                files.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return files;
    }
}
//2 .create filedownloader
class DownloadManager{
    public static void download(String url){
        System.out.println(Thread.currentThread().getName()+" is starting download "+ url);
//        try{
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName()+" is done download "+ url);
    }
}

public class a1FileDownloader {
    public static void main(String[] args) {
        List<String> urls=FileUtil.readFiles("src/day6/link.txt");

        for(String url: urls){
            Thread t=new Thread(new FileDownloader(url));
            t.start();
        }
    }
}

class FileDownloader implements Runnable{

    private final String url;

    public FileDownloader(String url){
        this.url=url;
    }

    @Override
    public void run() {
        DownloadManager.download(url);
    }

}
