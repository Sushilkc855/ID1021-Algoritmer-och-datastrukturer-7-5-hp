package UppD;

import java.util.Random;
import java.util.function.IntToDoubleFunction;

/**
 * main
 */
public class Aclass {
    public static void main(String[] args) {
        long t0 = 0; 
        long t1 = 0;
        int removedItem; 
        int k = 4; // number of rounds 
        int n = 4; // List length
        long sum = 0; 
        long sum2 = 0;
        int[] sequence = new int[k];
        Random rnd = new Random();
        for (int i = 0; i < k; i++) {
            sequence[i] = rnd.nextInt(n-1);
            System.out.println(sequence[i]);
        }

        DoubleLinkedList object = new DoubleLinkedList(1, null ); 
        LinkedList object2 = new LinkedList(1, null );
        for(int z = 2; z <= n; z++) {
            object.addItem(z);
            object2.addItem(z);
        }

        DoubleLinkedList[] lists= new DoubleLinkedList[sequence.length]; 
        lists = object.copyList(sequence); 
        //object.print();
        for(int i = 0; i<k; i++){
            System.out.println("");
            System.out.println(lists[i].head);
        }
        
       // object2.print();    
        System.out.println("");
        int z = 0; 

        

    
            for(int i = 0; i<k; i++){
                t0 = System.nanoTime(); 
                removedItem = object.removeItem(sequence[i]);
                object.addItem(removedItem);
                t1 = System.nanoTime();
                sum += t1-t0; 
    
                t0 = System.nanoTime(); 
                removedItem = object2.removeItem(sequence[i]);
                object2.addItem(removedItem);
                t1 = System.nanoTime();
                sum2 += t1-t0;
            } 
        
        
    
        
        System.out.println("For DoubleLinkedList the time was: " + sum);
        //object.print();

        System.out.println("For linkedlist the time was: " + sum2);
        System.out.println("");
        //object2.print();

    }    
}

public class DoubleLinkedList {
    int head;
    DoubleLinkedList next;
    DoubleLinkedList prev; 
    DoubleLinkedList top; 

    public DoubleLinkedList(int item, DoubleLinkedList list) {
        this.head = item;
        this.next = list;
        this.prev = null; 
        this.top  = this;
    }
    
    public void addItem(int item){
        DoubleLinkedList first = new DoubleLinkedList(item, null ); 
        first.next = top; 
        top.prev = first; 
        top = first; 
    }

    public int removeItem(int index){
        DoubleLinkedList current = top;

        for(int i = 0; i<index; i++){
            current = current.next; 
        }
        
        int removedItem = current.head; 
        // Change next only if node to be deleted
        // is NOT the last node
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        
        else if (current.next == null) {
            current.prev.next = null;
        }

         // Change prev only if node to be deleted
        // is NOT the first node
        if (current.prev != null) {
            current.prev.next = current.next; 
        }

        else if (current.prev == null) {
            current.next.prev = null;
            top = current.next;
        }
        return removedItem; 
    }

    public DoubleLinkedList[] copyList(int[] sequence){
        int z = 0; 
        DoubleLinkedList[] lists= new DoubleLinkedList[sequence.length]; 
        DoubleLinkedList nxt = top;

        for(int i = 0; i < sequence.length; i++){
            z = 0;
            nxt = top;
            //System.out.println(sequence[i]);
            while(z < sequence[i]){
                nxt = nxt.next;  
                z++;
            }
            //System.out.println(nxt.head);
            lists[i] = nxt; 
        }

        return lists; 
    }

    public int head() {
        return this.head;
    }

    public DoubleLinkedList tail() {
        return this.next;
    }

    public void append(DoubleLinkedList b) {
        DoubleLinkedList current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = b;
        b.prev = current;
    }

    public void print() {
		DoubleLinkedList nxt = top;
		while (nxt != null) {
			System.out.println(nxt.head);
			nxt = nxt.next;
		}
	}
}













public class LinkedList {
    int head;
    LinkedList next;
    LinkedList top = null; 
    public LinkedList(int item, LinkedList list) {
        this.head = item;
        this.next = list;
        this.top = this;
    }

    public int removeItem(int index){
        LinkedList current = top;
        LinkedList prev = top;
        for(int i = 0; i<index; i++){
            prev = current;
            current = current.next; 
        }
        
        int removedItem = current.head; 
        if (current == top) {
            top = current.next; 
        }
        else{
        prev.next = current.next; 
        }
        return removedItem; 
    }

    public void addItem(int item){
        LinkedList first = new LinkedList(item, null ); 
        first.next = top; 
        top = first;   
    }

    public int head() {
        return this.head;
    }

    public LinkedList tail() {
        return this.next;
    }

    public void append(LinkedList b) {
        LinkedList nxt = this;
       // LinkedList before = this;
        while (nxt.next != null) {
            nxt = nxt.next;
        }
        nxt.next = b;
    }


    public void print() {
		LinkedList nxt = top;
		while (nxt != null) {
			System.out.println(nxt.head);
			nxt = nxt.next;
		}
	}
    
}
