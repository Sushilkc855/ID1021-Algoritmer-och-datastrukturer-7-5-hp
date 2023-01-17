import java.util.Random;

public class Binary {
    static Random rnd = new Random();
    public static void main(String[] args) {
        int n = 32_000;
        int k = 1_000_000; // number of rounds. 
        int[] array = sorted(n); 
        int key = rnd.nextInt(n*5);
        long t0 = 0; 
        long t1 = 0; 
        t0 = System.nanoTime(); 
        for(int i = 0; i < k; i++){
            key = rnd.nextInt(n*5);
            binary_search(array, key);
        }
        t1 = System.nanoTime(); 

        System.out.println((t1-t0)/k);
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
            // jump to the middle to start surching.
            int index = first + ((last-first)/2);
            if (array[index] == key) {
                //System.out.println("found"); 
                return true; 
            // if the key is found return true
            }
            if (array[index] < key && index < last) { 
            // The index position holds something that is less than
            // what we're looking for, what is the first possible page?
                first = index +1; 
            // if the key is not found and if the number in the sorted array index is smmar then the key 
            // we set the pointer that is pointing to the first posiotn in array to the index we are at now 
            // because the key is in the position above the index we are at now. 
            continue;
            }
            if (array[index] > key && index > first) {
            // The index position holds something that is larger than
            // what we're looking for, what is the last possible page?
                last = index - 1;
            // if the key is not found and if the number in the sorted array index is bigger then the key 
            // we set the pointer that is pointing to the last posiotn in array to the index we are at now 
            // because the key is in the position below the index we are at now. 
            continue;
            }
            // Why do we land here? What shoudl we do?
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
