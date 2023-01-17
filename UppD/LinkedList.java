import java.util.Random;

/**
 * LinkedList
 */
public class TestLinkedList {
    public static void main(String[] args) {
        long t0 = 0; 
        long t1 = 0;
        long sum = 0;

        int k = 5; // number of rounds 
        int n = 5; // List length

        int[] sequence = new int[k];
        Random rnd = new Random();
        for (int i = 0; i < k; i++) {
            sequence[i] = rnd.nextInt(n-1);
        }
                
        LinkedList object = new LinkedList(1, null ); 
        object.addItem(2);
        object.addItem(3);
        object.addItem(4);
        object.addItem(5);
        object.print();
        System.out.println(sequence[0]);
        int removedItem = object.removeItem(sequence[0]);
        System.out.println("");
        object.print();
        object.addItem(removedItem);
        System.out.println("");
        object.print();
    
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

        prev.next = current.next; 
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

