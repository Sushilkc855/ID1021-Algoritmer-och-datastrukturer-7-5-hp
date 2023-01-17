public class Stack {
        public static void main(String[] args) {
            long t0 = 0; 
            long t1 = 0;
            int n = 8192;
           long sum = 0; 
           LinkedList object = new LinkedList(3, null ); 
           object.push(2);
           object.push(1);
            
            object.print();
        object.pop();
        object.pop();
        object.print();
        }
            
        
}
    
    public class LinkedList {
        int head;
        LinkedList tail;
        LinkedList top = null; 
        public LinkedList(int item, LinkedList list) {
            this.head = item;
            this.tail = list;
            this.top = this;
        }
        
        public void addItem(int item){
            LinkedList newLL = new LinkedList(item, null); 
            append(newLL);  
        }

        public void push(int item){
            LinkedList first = new LinkedList(item, null ); 
            first.tail = top; 
            top = first; 
        }

        public void pop(){
            if (top == null){
                System.out.println("Stack is empty");
            }
            else{
                System.out.println("The popped elements is: " + top.head);
            }

            top = top.tail; 
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
            LinkedList nxt = top;
           // LinkedList before = this;
            while (nxt.tail != null) {
                nxt = nxt.tail;
            }
            nxt.tail = b;
        }
    
        public void print() {
            LinkedList nxt = top;
            while (nxt != null) {
                System.out.println(nxt.head);
                nxt = nxt.tail;
            }
        }
    }

