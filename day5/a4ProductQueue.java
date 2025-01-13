package day5;

import java.util.PriorityQueue;

public class a4ProductQueue {
    public static void main(String[] args) {
        PriorityQueue<a4Product> pq = new PriorityQueue<>();
        pq.add(new a4Product(1, "A", 800));
        pq.add(new a4Product(2, "B", 200));
        pq.add(new a4Product(3, "C", 300));
        pq.add(new a4Product(4, "D", 700));
        pq.add(new a4Product(5, "E", 900));
        while (!pq.isEmpty()) {
            a4Product product = pq.poll();
            System.out.println(product.getProductName() + " : " + product.getProductPrice());
        }
    }
}
