package UppC;

public class LinkedList {
    int head;
    LinkedList next;
    LinkedList top = null; 
    LinkedList last = null; 
    public LinkedList(int item, LinkedList list) {
        this.head = item;
        this.next = list;
        this.last = this; 
        this.top = this;
    }

    public int head() {
        return this.head;
    }

    public LinkedList getLastNode() {
        return last;
    }

    public LinkedList getFirsNode() {
        return top;
    }

    public void append(int item) {
       LinkedList newItem = new LinkedList(item, null ); 
       last.next = newItem; 
       last = newItem; 
    }


    public void print() {
		LinkedList nxt = top;
		while (nxt != null) {
			System.out.println(nxt.head);
			nxt = nxt.next;
		}
	}
    


}