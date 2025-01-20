package java9.features;
import  java.util.*;
import java.util.stream.Stream;

public class F_SteamEnhancement {
    public static void main(String[] args) {
   //takewhile
        List<Integer > list=List.of(4,6,8,9,50);
        list.stream().filter(n->n%2==0).forEach(System.out::println);
        System.out.println("filter");
        list.stream().takeWhile(n->n%2==0).forEach(System.out::println);
        System.out.println("takewhile");

//	dropwhile
        list.stream().dropWhile(n->n%2==0).forEach(System.out::println);
        System.out.println("dropwhile");
        Stream.iterate(1, x->x+1).limit(5).forEach(System.out::println);// what if somebody forget to call limit(5) : infinite loop
        System.out.println("iteration1");
        Stream.iterate(1, x->x<=5, x->x+1).forEach(System.out::println);
        System.out.println("iteration2");
    }
}
