package Upp4;

import java.util.Arrays;
import java.util.Random;

public class sorting1 {
    static Random rnd = new Random();
    public static void main(String[] args) {
        long t0 = 0; 
        long t1 = 0;
        int n = 0; 
        long totTime = 0;  
        int k = 100_0;
        int [] sortedArray = new int[n]; 
    for(n = 1; n<700; n *=2 ){
        for(int i = 0; i < k; i++){
            int [] randonArray1 = generateUnsorted_array(n); 
            t0 = System.nanoTime(); 
            sortedArray = slectionSort(randonArray1); 
            t1 = System.nanoTime();
            totTime += t1-t0; 
        }
        //System.out.println(Arrays.toString(sortedArray));
        System.out.println("with n: " + n + " we get the time: " + totTime/k);
        totTime = 0;
    }
    }

    /**
        // let's set the first candidate to the index itself
        // If the element at position j is smaller than the value
        // at the candidate position - then you have a new candidate
        // posistion.
        // Swap the item at position i with the item at the candidate position.
    **/
    public static int[] slectionSort(int[] array){
        int swap; 
        for (int i = 0; i < array.length -1; i++) {  
            int cand = i;
            for (int j = i; j < array.length; j++) {
                if(array[cand] > array[j]){
                    cand = j;
                }
            }
            swap = array[cand]; 
            array[cand] = array[i];
            array[i] = swap;
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
