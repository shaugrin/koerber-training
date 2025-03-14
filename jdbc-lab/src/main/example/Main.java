package org.example;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);
        System.out.println("------printing map------");

        System.out.println("-------------------------");

        System.out.println(" print map using stream");

        // print map using stream
        map.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("print only that recrods that contain key contains raj");

        //print only that recrods that contain key contains raj
        map.forEach((key, value) -> {
            if (key.contains("raj")) {
                System.out.println(key + " : " + value);
            }
        });

        System.out.println("print map sorted by key");

        //print map sorted by key
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


        System.out.println("print map sorted by values");
        //print map sorted by values
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


        System.out.println("print map reverse sorted by the key");
        //print map reverse sorted by the key
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));



        //consider key as user define key
        Map<Student, Integer> map2=new HashMap<>();
        map2.put(new Student(109, "raj", 95), 95);
        map2.put(new Student(61, "keta", 78), 78);
        map2.put(new Student(11, "gunika", 98), 98);
        map2.put(new Student(19, "keshav", 97), 97);
        System.out.println("print map2");

        System.out.println("Print all records sorted as per name of the student");

        //Print all records sorted as per name of the student
        map2.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getName)))
                .forEachOrdered(entry -> System.out.println(entry.getKey().getName()+" : "+entry.getKey().getId()));


        System.out.println("Print all records as per id of the student");
        //Print all records as per id of the student
        map2.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(Student::getId)))
                .forEachOrdered(entry -> System.out.println(entry.getKey().getId()+" : "+entry.getKey().getName()));



    }
}