package Upp4;

import java.util.Arrays;
import java.util.Random;

import javax.lang.model.element.Element;

public class mergeSort {
    static Random rnd = new Random();
    //static int [] randonArray1 = generateUnsorted_array(7); 
    public static void main(String[] args) {
        long t0 = 0; 
        long t1 = 0;
        int n = 0; 
        long totTime = 0; 
        int k = 10_000;
        //System.out.println("1");
        //System.out.println(Arrays.toString(randonArray1));
        for(n = 1; n<10000; n *=2 ){
            for(int i = 0; i < k; i++){
                int [] randonArray1 = generateUnsorted_array(n); 
                t0 = System.nanoTime(); 
                sort(randonArray1);
                t1 = System.nanoTime();
                totTime += t1-t0; 
            }
            System.out.println("with n: " + n + " we get the time: " + totTime/k);
            totTime = 0;
        }
        //System.out.println("4");
        //System.out.println(Arrays.toString(randonArray1));
        //System.out.println("with n: " + n + " we get the time: " + totTime/k);
    }

    public static void sort(int[] org) {
        if (org.length == 0)
        return;
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length -1);
    }
      


    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
        int mid = lo + (hi-lo)/2;
        // sort the items from lo to mid
           sort(org, aux, lo, mid);
        //   System.out.println("2"); 
        //   System.out.println(Arrays.toString(randonArray1));
        // sort the items from mid+1 to hi
           sort(org, aux, mid+1, hi);
        //   System.out.println("3");
        //   System.out.println(Arrays.toString(randonArray1));
        // merge the two sections using the additional array
           merge(org, aux, lo, mid, hi);
        }
    }


    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for (int i = lo; i <= hi; i++ ) {
            aux[i] = org[i];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
        // for all indeces from lo to hi
        for ( int k = lo; k <= hi; k++) {
        // if i is greater than mid, move the j item to the org array, update j
            if(i > mid){
                org[k] = aux[j]; 
                j++; 
            }
        // else if j is greate than hi, move the i item to the org array, update i
            else if(j > hi){
                org[k] = aux[i]; 
                i++;
            }
        // else if the i item is smaller than the j item,
        // move it to the org array, update i
            else if(aux[i] < aux[j]){
                org[k] = aux[i]; 
                i++; 
            }
        // else you can move the j item to the org array, update j
            else{
                org[k] = aux[j]; 
                j++;
            }
        }
    }

    public static int[] generateUnsorted_array(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rnd.nextInt(length * 5);
        }
        return arr;
    }
    
      
}
