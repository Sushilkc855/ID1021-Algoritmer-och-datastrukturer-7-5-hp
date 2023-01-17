import java.util.Random;

public class benchMark {
    public static void main(String[] args) {
        long t0 = 0; 
        long t1 = 0;
        long sum = 0;

        LinkedList object = new LinkedList(1, null ); 
        int k = 10; // number of rounds 
        int n = 10; // List length

        int[] sequence = new int[k];
        Random rnd = new Random();
        for (int i = 0; i < k; i++) {
            sequence[i] = rnd.nextInt(n-1);
        }
        
    
}


public class LinkedList {
    int head;
    LinkedList tail;
    public LinkedList(int item, LinkedList list) {
        this.head = item;
        this.tail = list;
    }
    
    public void addItem(int item){
        LinkedList newLL = new LinkedList(item, null); 
        append(newLL);  
    }

    public int head() {
        return this.head;
    }

    public LinkedList tail() {
        return this.tail;
    }


    public void removeLastItem() {
        LinkedList nxt = this;
        LinkedList before = this;
        while (nxt.tail != null) {
            before = nxt;
            nxt = nxt.tail;
        }
        before.tail = null;
    }

    public void append(LinkedList b) {
        LinkedList nxt = this;
       // LinkedList before = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public void print() {
		LinkedList nxt = this;
		while (nxt != null) {
			System.out.println(nxt.head);
			nxt = nxt.tail;
		}
	}

    public int removeItem(int index){
        DoubleLinkedList prev = this;
        DoubleLinkedList nxt = prev.tail;

        for(int i = 1; i<index; i++){
            prev = nxt;
            nxt = nxt.tail; 
        }
        int removeItem = nxt.head; 
        prev.tail = nxt.tail;
        return removeItem; 
    }
    
}

