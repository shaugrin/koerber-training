package java9.features;

import java.sql.Array;
import  java.util.*;
class A{
        void foo(){
            System.out.println("foo of class A");
        }
}
class B extends  A{
    void foo(){
        System.out.println("foo of class B override");
    }
}
public class C_DiamondOp {
    public static void main(String[] args) {
        List<A> list=new ArrayList<>(
                Arrays.asList(
                        new A(),
                        new B()
                )
        );
        list.add(new A());
        list.add(new B());
        list.forEach(A::foo);
    }
}
