package Upp4;

import java.util.Arrays;
import java.util.Random;

public class insertion {
    static Random rnd = new Random();
    public static void main(String[] args) {
        long t0 = 0; 
        long t1 = 0;
        long totTime = 0; 
        int n = 128; 
        int k = 10_000;
        //int [] sortedArray = new int[n];
        for(n = 1; n<1200; n *=2 ){
            for(int i = 0; i < k; i++){
                int [] randonArray1 = generateUnsorted_array(n); 
                t0 = System.nanoTime(); 
                insertionSort(randonArray1); 
                t1 = System.nanoTime();
                totTime += t1-t0; 
            }
            System.out.println("with n: " + n + " we get the time: " + totTime/k);
             totTime = 0;
        }

        //System.out.println(Arrays.toString(sortedArray));
    }

    /**
        // let's set the first candidate to the index itself
        // If the element at position j is smaller than the value
        // at the candidate position - then you have a new candidate
        // posistion.
        // Swap the item at position i with the item at the candidate position.
          // for each element from i towards 1, swap the item found with the
            // item before it if it is smallers
    **/
    public static int[] insertionSort(int[] array){
        int key;
        int j; 
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            for ( j = i-1; j >= 0 && array[j] > key; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = key; 
        }
        return array; 
    }

    public static int[] generateUnsorted_array(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rnd.nextInt(length * 5);
        }
        return arr;
    }
}
