package Upp7;

import org.w3c.dom.ls.LSException;

public class Queue {
    Node head;
    Node last;
    public class Node {
        public Integer item;
        public Node tail;

        public Node(Integer item, Node list) {
            this.item = item;
            this.tail = list;
        }
    }
    
    public Queue() {
        this.head = this.last = null;  
    }
    
    public void add(Integer item) {
        if (head == null) {
            this.head = this.last = new Node(item, null);    
        }
        else{
            this.last.tail = new Node(item, null);  
            this.last = last.tail;
        } 
    }
    
    public Integer remove() {
        Node temp = this.head; 
        head = head.tail; 
        if (this.head == null){
            this.last = null;
        }
        return temp.item;
        
    }  
/* 
    public void print(){
        while (head != null) {
            System.out.println(head.item);
            head = head.tail; 
        }
    }
*/
}