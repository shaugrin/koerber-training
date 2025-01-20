package java9.features;
import java.util.*;
public class E_FactoryMethodsInCollectionAPI {
    public static void main(String[] args) {
        //how to create unmodificatiale collection
        List<String > list=new ArrayList<>();
//        list.add("foo");
//        list.add("bar");
//
//        List<String> list2=Collections.unmodifiableList(list);

    // java 9 way of creating immutable collection

        Map<String, Integer> map=Map.of("amit",90,"ekta",88,"raj",77);
        //map.put("amit",90);
        System.out.println(map);


//        Map.of vs Map.ofEntries

        Map<String, Integer> map2=Map.of("amit",90,"ekta",88,"raj",77);

        Map.Entry<String, Integer> e1=Map.entry("amit",90);
        Map.Entry<String, Integer> e2=Map.entry("sumit",97);
        Map.Entry<String, Integer> e3=Map.entry("kapil",70);

        Map<String, Integer> map3=Map.ofEntries(e1, e2,e3);

        Map<String, Integer> map4=Map.ofEntries(Map.entry("amit",90), Map.entry("sumit",97),Map.entry("kapil",70));


        list.add("java");
        myLogic(list);

    }

    private static void myLogic( final  List<String> list) {
        list.add(0,"raj");
    }
}
