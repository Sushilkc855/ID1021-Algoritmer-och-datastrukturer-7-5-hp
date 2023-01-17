public class bAppend {
    public static void main(String[] args) {
        long t0 = 0; 
        long t1 = 0;
        int n = 10000;
       long sum = 0; 
       LinkedList object = new LinkedList(1, null ); 
        
        for(int z = 2; z <= 10; z++) {
            object.addItem(z);
        }
    
        LinkedList b = new LinkedList(n+1, null ); 
        for(int z = 2; z <= n; z++) {
            b.addItem(z);
        }


            t0 = System.nanoTime(); 
            object.append(b);
            t1 = System.nanoTime();
            sum += t1-t0; 

            //object.print();
        System.out.println( "With size"+ n +": " + (sum));
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
    
}
