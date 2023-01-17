import java.util.Random;

public class dupBinary {
    static Random rnd = new Random();
    public static void main(String[] args) {
        int n = 1024;
        int k = 1000; // number of rounds. 
        int[] array1 = sorted(n);
        int[] array2 = sorted(n);
        long t0 = 0; 
        long t1 = 0; 
        long timeTot = 0; 
        boolean sum; 
        int key = 0;

      for(int i = 0; i < k; i++)
        {
            for (int j = 0; j < n ; j++) {
                array1 = sorted(n);
            }

            for (int j = 0; j < n ; j++) {
                array2 = sorted(n);
            }
            
            for(int j = 0; j < n; j++){
                t0 = System.nanoTime(); 
                sum = binary_search(array1, array2[j]);
                t1 = System.nanoTime(); 
                timeTot += t1-t0; 
                if(sum){
                    key++; 
                }
                
            }
        }   
        System.out.println(key);
        System.out.println((timeTot)/k);
    }

    
    /**
     * This algorithm is called binary search and is very efficient
     * @param array
     * @param key
     * @return
     */
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
            int index = first + ((last-first)/2);
            if (array[index] == key) {
                return true; 
            }
            if (array[index] < key && index < last) { 
                first = index +1; 
            continue;
            }
            if (array[index] > key && index > first) {
                last = index - 1;
            continue;
            }
            break;     
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
