import java.util.Random;

public class unsorted {
    static Random rnd = new Random();
    public static void main(String[] args) {
        int n = 1_000;
        int k = 1_000_000;
        int[] array = generateUnsorted_array(n); 
        int key = rnd.nextInt(n*5); // because the smallest and the biggest tal is going to be between 0 to n times 5.
        long t0 = 0; 
        long t1 = 0; 
        
        t0 = System.nanoTime(); 
        for(int i = 0; i < k; i++){
            key = rnd.nextInt(n*5);
            search_unsorted(array, key); 
        }
        t1 = System.nanoTime();
        System.out.println("time i ns: "+ (t1-t0)/k);
    }

    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }
 

    public static int[] generateUnsorted_array(int length) {
        Random rnd = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rnd.nextInt(length * 5);
        }
        return arr;
    }

}
