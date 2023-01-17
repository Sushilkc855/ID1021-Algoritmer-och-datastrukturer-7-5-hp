package Upp6;
import java.util.Iterator;

import Upp6.BinaryTree.*;

public class TreeIterator implements Iterator<Integer> {
    private Node next;
    private Stack<Node> stack;
    public TreeIterator(Node obj) {
        next = obj; 
        stack = new Stack<Node>();
        while(next!=null){
            stack.push(next);
            System.out.println("pushed value: "+ next.key);
            next=next.left;
            
        }
    }

    @Override
    public boolean hasNext() {
        return stack != null; 
    }


    @Override
    public Integer next() {
       Node popED = stack.pop(); 
       Node temp = popED;
       if (popED.right != null){
            popED = popED.right;
            stack.push(popED); 
            while(popED.left != null){
                popED = popED.left; 
                stack.push(popED); 
            }
       } 
       System.out.println("pop value: " + temp.value);
       return temp.value; 
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}