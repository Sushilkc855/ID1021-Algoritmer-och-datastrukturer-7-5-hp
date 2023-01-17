package Upp6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Iterator;
import Upp6.BinaryTree;
import Upp6.Stack.*;
import Upp6.TreeIterator.*;

public class main {
    static Random rnd = new Random();
    
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(5,105);
        binaryTree.add(2,102);
        binaryTree.add(7,107);
        binaryTree.add(4,104);
        binaryTree.add(1,101);
        binaryTree.add(8,108);
        binaryTree.add(6,106);
        binaryTree.add(3,103);

        Iterator <Integer> treeIterator = binaryTree.iterator();
        System.out.println("done");
        while(treeIterator.hasNext()){
            System.out.println(treeIterator.next());
        }
        boolean value =  binaryTree.iterator().hasNext();
       System.out.println(value);
       int value2 =  binaryTree.iterator().next();
       System.out.println(value2); 
        /*****************
        int n = 32000;
        int k = 1_000_000; // number of rounds.
        int key; 
        long t0 = 0; 
        long t1 = 0; 
        long sum = 0; 
        ArrayList<Integer> randomNum = new ArrayList<Integer>();
        for(int i = 0; i< n; i++){
            randomNum.add(i);
        }
        Collections.shuffle(randomNum);

        BinaryTree object = new BinaryTree(); 
        for(int i = 0; i < n; i++){
            object.add(randomNum.get(i), 999);
        }
       
        for(int i = 0; i < k; i++){
            key = rnd.nextInt(n);
            t0 = System.nanoTime(); 
            object.lookup(key);
            t1 = System.nanoTime(); 
            sum += t1-t0;
        }
    


       // int value  = object.lookup(4); 
        System.out.println(sum/k);
        //System.out.println( object.lookup(5)); 
        //System.out.println( object.lookup(2));
        //object.root.print();

    *////////////////
    }
}
