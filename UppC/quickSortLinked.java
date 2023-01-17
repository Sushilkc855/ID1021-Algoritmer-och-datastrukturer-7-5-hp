package UppC;

import java.util.Random;
import java.util.spi.ToolProvider;

public class quickSortLinked {
    public static Random rnd = new Random();
    public static void main(String[] args) {
    
       

        long t0 = 0; 
        long t1 = 0;
        long totTime = 0; 
        int k = 512;
        int [] randonArray0;
        randonArray0 = generateUnsorted_array(k); 

        LinkedList list = new LinkedList(rnd.nextInt(k * 5), null); 
        LinkedList randonArray1;
        randonArray1 = generateUnsorted_array2(randonArray0, list); 
        for(int i = 0; i < 100_000; i++){
            
            t0 = System.nanoTime(); 
            quickSort(randonArray1.getFirsNode(), randonArray1.getLastNode());
            t1 = System.nanoTime();
            totTime += t1-t0;
        }
       
               
  
    
        System.out.println(totTime/100000);
       // list.print();
    }




    public static LinkedList generateUnsorted_array2(int[] length, LinkedList list){
        for(int i = 0; i <length.length -2; i++){
            list.append(length[i]);
        }
        return list;
    }

    public static void quickSort(LinkedList first, LinkedList last){
        if (first != last && first != last.next) {
            LinkedList list = partition(first, last);  
            quickSort(first, list);  
            quickSort(list.next, last);   
        }
       

    }

    public static LinkedList partition(LinkedList first, LinkedList last){
        LinkedList pivot = first; 
        LinkedList curr = first.next;
        LinkedList prev = first;


        while (curr != last.next) {
            if (pivot.head > curr.head) {
                int temp = prev.next.head; 
                prev.next.head = curr.head; 
                curr.head = temp;
            }
            curr = curr.next; 
        }
        int temp = prev.head; 
        prev.head = pivot.head; 
        pivot.head = temp;
        return prev; 
    }

   
    public static int[] generateUnsorted_array(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rnd.nextInt(length * 5);
        }
        return arr;
    }

}

