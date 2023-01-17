package Upp7;

import javax.sound.midi.VoiceStatus;


/**
 * QueueArray
 */
public class QueueArray {
    static int last = 0; 
    static int first = 0; 
    static int n = 10;
    static Integer[] array = new Integer[n]; 
    public static void main(String[] args) {
        add(1); 
        add(2); 
        add(3); 
        add(1); 
        add(2); 
        add(3); 
        add(4); 
        add(5); 
        add(6); 
        add(7);
        

        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        
        add(8); 
        add(9); 
        add(10); 
        add(11); 
        /* 
        add(1); 
        add(2); 
        add(3);
        */
        print();
        
        /*System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        */
    }
    
    public static void add(int item) {
        if (last == first && array[first] != null) {
            System.out.println("Array is full");
        }
        if(array[last] == null){
            array[last++] = item; 
            if( last == n){
                last = 0; 
            }
        }
    }

    public static Integer remove(){
        if (last == first && array[first] == null) {
            last = 0; 
            first = 0; 
            System.out.println("Array is empty");
            return null; 
        }
        int temp = array[first];
        array[first++] = null;  
        if(first == n){
            first = 0; 
        }
        return temp; 
    }

    public static void print(){
        int i = 0;
        while (i < n) {
            System.out.println(array[i++]);
        }
    }
    
    public static void increaseSizeOfArray(){
        int newN = n*2; 
        Integer[] newArray = new Integer[newN];
        for(int i = 0; first < n; i++){
            newArray[i] = array[first++];
        }
        for(int i = 0; i < last - 1; i++){
            newArray[first++] = array[i];
        }
        n = newN;
        last = n; 
        first = 0; 
    }



}