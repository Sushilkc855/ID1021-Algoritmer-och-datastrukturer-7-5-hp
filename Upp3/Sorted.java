//package upp3;

import java.util.Random;

/**
 * Searching for a key in an unsorted array is quite
 * expensive. If the elements in the array are not sorted, the only way to find
 * an element is to go through the whole data structure.In this assignment we will see how 
 * mush easier it is to search for a key if the array is sorted.

 * Let’s start by setting up a benchmark where we search through an unsorted
 * array. The search procedure is of course a simple loop through all the
 * elements in the array
 */
public class Sorted {

    static Random rnd = new Random();
    public static void main(String[] args) {
        int n = 5_000;
        int k = 1_000_000; // number of rounds. 
        int[] array = sorted(n); 
        int key = rnd.nextInt(n*5);
        long t0 = 0; 
        long t1 = 0; 
        
        t0 = System.nanoTime(); 
        for(int i = 0; i < k; i++){
            key = rnd.nextInt(n*5);
            search_sorted(array, key);
        }
        t1 = System.nanoTime(); 

        System.out.println((t1-t0)/k);
    }


    public static boolean search_sorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
            if(array[index] > key){
                return false; 
            }
        }
        return false;
    }
 
    /**
     * This is one way of generating a sorted array. (no duplicates)
     * @param n
     * @return
     */
    private static int[] sorted(int n) {
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

}