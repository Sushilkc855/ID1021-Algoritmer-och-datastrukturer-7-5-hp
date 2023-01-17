import java.util.Random;

public class better {
    static Random rnd = new Random(); 
    public static void main(String[] args) {
        long timeTot = 0;
        int sum = 0;
        int n = 1024;
        int k = 1000;
        int[] array1 = sorted(n);
        int[] array2 = sorted(n);
        long t0 = 0; 
        long t1 = 0; 
        for(int i = 0; i < k; i++)
        {
            for (int j = 0; j < n ; j++) {
                array1 = sorted(n);
            }

            for (int j = 0; j < n ; j++) {
                array2 = sorted(n);
            }

            t0 = System.nanoTime(); 
                sum += evenBetter(array1, array2);
            t1 = System.nanoTime(); 
            timeTot += t1-t0;
        }   
        System.out.println(sum);
        System.out.println((timeTot)/k);
    }

    public static int evenBetter(int array1[], int array2[]){
        int sum = 0;
        int i = 0; 
        int j = 0; 
        while (i < array1.length && j < array2.length ) {
            if(array1[i] == array2[j]){ // we found a duplicate
                sum++;
                i++;
                j++; 
            }
            else if (array1[i] > array2[j]){ // the element in the first array is bigger then in the second array we move one step forward in the second array.
                j++;  
            }
            else if (array1[i] < array2[j]){ // if the element in the first array is smaller then in the second array we move one step forward in the first array.
                i++;  
            }
        }
        return sum; 
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
