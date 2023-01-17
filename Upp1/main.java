import java.security.AccessControlContext;
import java.util.Random; 


class Main {
    public static void main(String[] args) {
        
       //double num = access(50000); 
       double task2 = task2(); 
       System.out.print(task2);
       //System.out.print("\n" +num);
        //double task3 = task3(); 
        //System.out.print(task3);
    }


    /********** 
    private static double task3()
    {
     Random rnd = new Random();
  
      int k = 10000; 
      int sum = 0;
      int dup = 0;
      double t_total = 0; 
      int m = 1000; 
      int n = 1000; 
      int[] keys = new int[m];
      int[] array = new int[n];
      int[] array2 = new int[n];


    for (int j = 0; j < k; j++) {

    // fill the keys array with random number from 0 to 10*n
        for (int i = 0; i < n ; i++) {
            keys[i] = rnd.nextInt(10*n);
        }

  // fill the array with with random number from 0 to 10*n
        for (int i = 0; i < n ; i++) {
           array[i] = rnd.nextInt(10*n);
        }

        long t0 = System.nanoTime();
        for (int ki = 0; ki < n; ki++) {
            int key = keys[ki];
            for (int i = 0; i < n ; i++) {
                if (array[i] == key) {
                    dup++;
                }
                if (dup == 2){
                    sum++; 
                    dup = 0; 
                    break; 
                }
            }
            dup = 0;
           t_total += (System.nanoTime() - t0);
        }
    }
    return t_total / sum;
 }
****************************/









/*************************** 
    private static double task3()
    {
     Random rnd = new Random();
  
      int k = 10000; 
      int sum = 0;
      double t_total = 0; 
      int m = 1000; 
      int n = 1000; 
      int[] keys = new int[m];
      int[] array = new int[n];
      int[] array2 = new int[n];


    for (int j = 0; j < k; j++) {

    // fill the keys array with random number from 0 to 10*n
        for (int i = 0; i < m ; i++) {
            keys[i] = rnd.nextInt(10*n);
        }

  // fill the array with with random number from 0 to 10*n
        for (int i = 0; i < n ; i++) {
           array[i] = rnd.nextInt(10*n);
        }

        long t0 = System.nanoTime();
        for (int ki = 0; ki < n; ki++) {
            for (int i = ki +  1; i < n ; i++) {
                if (ki != i && array[ki] == array[i]) {
                    sum++;
                    break;
                }  
            }
           t_total += (System.nanoTime() - t0);
        }
    }
    return t_total / sum;
 }
**********************/





 private static double task2()
 {
    Random rnd = new Random();
  
    int k = 10000; 
    int sum = 0;
    double t_total = 0; 
    int m = 1000; 
    int n = 500; 
    int[] keys = new int[n];
    int[] array = new int[n];




    for (int j = 0; j < k; j++) {

     // fill the keys array with random number from 0 to 10*n
     for (int i = 0; i < n ; i++) {
        keys[i] = rnd.nextInt(10*n);
    }

  // fill the array with with random number from 0 to 10*n
        for (int i = 0; i < n ; i++) {
           array[i] = rnd.nextInt(10*n);
        }


        long t0 = System.nanoTime();
        for (int ki = 0; ki < n; ki++) {
        int key = keys[ki];
            for (int i = 0; i < n ; i++) {
                if (array[i] == key) {
                sum++;
                break;
                }
            }
        }
        t_total += (System.nanoTime() - t0);
    }

    return t_total / sum;
 }





/*************************** 

private static double access (int n) {
    int k = 1_000_000;
    int l = n;
    Random rnd = new Random();
    int[] indx = new int[l];
// fill the indx array with random number from 0 to n (not including n)
    for (int i = 0; i < n ; i++) {
         indx[i] = rnd.nextInt(n);
    }



    int[] array = new int[n];
// fill the array with dummy values (why not 1)
    for (int i = 0; i < n ; i++) {
        array[i] = 1;
        }


    int sum = 0;
    long t0 = System.nanoTime();
    for (int j = 0; j < k; j++) {
        for (int i = 0; i < l; i++) {
        // access the array with the index given by indx[i]
            // sum up the result
            sum += array[indx[i]];

        }
    }
    long t_access = (System.nanoTime() - t0);
    System.out.print(t_access);

     sum = 0;
    t0 = System.nanoTime();

// do the same loop iteration but only do a dummy add operation

for (int j = 0; j < k; j++) {
    for (int i = 0; i < l; i++) {
        sum += 1;
    }
}

    long t_dummy = (System.nanoTime() - t0);
    System.out.print("\n" + t_dummy);
    return ((double)(t_access - t_dummy))/((double)k*(double)l);

}
***********************/
}





