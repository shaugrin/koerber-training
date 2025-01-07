import java.util.Arrays;

public class A3 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(copyOf(arr)));
    }

    public static int[] copyOf(int[] array){
        int[] copy = new int[array.length];
        for(int i=0; i<array.length; i++){
            copy[i] = array[i];
        }
        return copy;
    }
}
