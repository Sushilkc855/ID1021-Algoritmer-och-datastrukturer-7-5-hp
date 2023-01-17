package upp5;

public class ArraysAP {
    static int arrayLeng = 8012; 
    static int array1[] = new int[arrayLeng]; 
     
    public static void main(String[] args) {
        long t0 = 0; 
        long t1 = 0;
        int n = 5;
        for(int i = 0; i<arrayLeng; i++){
            array1[i] = i; 
        }
        for(int i = 0; i< arrayLeng; i++){
          //  System.out.println(array1[i]);
        }
        
        int array2[] = new int[n];
        for(int i = 0; i<n; i++){
            array2[i] = i*100; 
        }
        t0 = System.nanoTime(); 
        append(array2);
        t1 = System.nanoTime();

        System.out.println(t1-t0);
        /* 
        for(int i = 0; i< array1.length; i++){
            System.out.println(array1[i]);
        }
        */
    }

    public static void append(int array[]) {
        int sum = array.length + array1.length; 
        int[] newArray = new int[sum];
        for(int i = 0; i < array1.length; i++){
            newArray[i] = array1[i]; 
        }
        for(int i = array1.length; i < sum; i++){
            newArray[i] = array[i-array1.length]; 
        }
        array1 = newArray;
    }
}
