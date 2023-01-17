package Upp6;
import java.util.ArrayList;
import java.util.Iterator;
import Upp6.BinaryTree.Node;

public class Stack<Node>{
    public ArrayList<Node> nodes; 
    private int pointer;

    public Stack() {
        this.nodes = new ArrayList<Node>(1);
        this.pointer = -1;
    }
/****************
    public void addItem(int item){
        Stack newLL = new    Stack(item, null); 
        append(newLL);  
    }
**********/
    public void push(Node item){
        nodes.add(item);
        pointer++; 
    }

    public Node pop(){
        if(!nodes.isEmpty()){
            Node temp = nodes.get(pointer);
            nodes.remove(pointer);
            pointer--;
            System.out.println("Popped");
            return temp;
        }
        System.out.println("The stack was empty!");
        return null;
    }
/******************* 
    public int head() {
        return this.head;
    }

    public  Stack tail() {
        return this.tail;
    }


    public void removeLastItem() {
        Stack nxt = this;
        Stack before = this;
        while (nxt.tail != null) {
            before = nxt;
            nxt = nxt.tail;
        }
        before.tail = null;
    }

    public void append (Stack b) {
        Stack nxt = top;
       //   Stack before = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public void print() {
        Stack nxt = top;
        while (nxt != null) {
            System.out.println(nxt.head);
            nxt = nxt.tail;
        }
    }  
****************/
}
