package UppC;

import java.util.Random;

public class quickSortArray {
    static Random rnd = new Random();
    public static void main(String[] args) {
        long t0 = 0; 
        long t1 = 0;
        int n = 0; 
        long totTime = 0; 
        int k = 500;
        int [] randonArray1;
        //System.out.println("1");
        //System.out.println(Arrays.toString(randonArray1));
        
            for(int i = 0; i < 100_000; i++){
                randonArray1 = generateUnsorted_array(k); 
                t0 = System.nanoTime(); 
                quickSort(randonArray1, 0, randonArray1.length - 1);
                t1 = System.nanoTime();
                totTime += t1-t0;
            }     
        
        
    
        System.out.println("with n: " + k + " we get the time: " + totTime/100000);

    
        for(int i = 0; i< k; i++){
           // System.out.println(randonArray1[i]);
        }
    }

    public static void quickSort(int[] array, int firstI, int laslI) {
        int index; 
        if (firstI < laslI) {
            index = partition(array, firstI, laslI);

            quickSort(array, firstI, index-1);
            quickSort(array, index+1, laslI);
        }
 
    }

    public static int partition(int[] array, int firstI, int laslI) {
        int pivot = array[firstI];
        int i = (laslI+1);

        for (int j = laslI; j > firstI; j--) {
            if (array[j] >= pivot) {
                i--;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i-1];
        array[i-1] = array[firstI];
        array[firstI] = swapTemp;

        return i-1;
    }


    public static int[] generateUnsorted_array(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rnd.nextInt(length * 5);
        }
        return arr;
    }
}
