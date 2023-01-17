package Upp8;

import java.net.http.HttpClient;
import java.util.Random;

public class Tree {
    public static Random rnd = new Random();
    public static int stats = 0; 
    public static void main(String[] args) {
        Tree queue = new Tree(); 

         /* 
        queue.enqueue(50);
        for(int i = 1; i<65; i++){
            queue.enqueue(rnd.nextInt(i*5));
        } 
        */
        System.out.println(queue.enqueue(15));
        System.out.println(queue.enqueue(5));
        System.out.println(queue.enqueue(324));
        System.out.println(queue.enqueue(6));
        System.out.println(queue.enqueue(464));
        System.out.println(queue.enqueue(4564));
        System.out.println(queue.enqueue(423));
        queue.print();
       // queue.root.print2();
        //queue.print();
       // queue.denqueue(); 
        queue.denqueue();
        queue.root.print2();
        queue.push(20);
        System.out.println(stats);
        queue.print();
        
    }

    Node root; 

    public class Node {
        Integer priority; 
        Integer size; 
        Node left; 
        Node right; 
        
        private Node(Integer prio){
            this.size = 1; 
            this.priority = prio; 
            this.left = null; 
            this.right = null; 
        }

        private Integer add(Integer prio){
            this.size +=1; 
            if (prio < this.priority) {
                Integer temp = this.priority; 
                this.priority = prio; 
                prio = temp; 
            }

            if (this.left == null) {
                this.left = new Node(prio); 
                return 1; 
            }

            else if (this.right == null) {
                this.right = new Node(prio); 
                return 1;
            }

            else if(this.right.size < this.left.size){
                return this.right.add(prio)+1;
            }

            else{
                return this.left.add(prio)+1;
            }
        }

        private Node remove(){
            if(this.left == null && this.right == null){
                return null; 
            }
            else if (this.left == null){
                return this.right; 
            }
            else if(this.right == null){
                return this.left; 
            }
            else if(this.left.priority < this.right.priority){
                this.priority = this.left.priority; 
                this.left = this.left.remove(); 
            }
            else{
                this.priority = this.right.priority; 
                this.right = this.right.remove(); 
            }
            this.size -=1; 
            return this; 
        }



        
        private void print(Integer n){
            System.out.println(" ".repeat(n) + this.priority + "(" + this.size + ")" );
            if(this.left != null){
                this.left.print(n+2);
            }
            else
                System.out.println(" ".repeat(n) + "-----");

            if(this.right != null){
                this.right.print(n+2);
            }
            else
                System.out.println(" ".repeat(n) + "-----");
        }

        public void print2() {
            if(left != null)
                left.print2();
            System.out.println(" key: " +  this.priority  + "\tvalue: " + this.size);
            if(right != null)
                right.print2();
        }

        public Node pushRoot(){
            Integer temp;
            stats = 0;
            if(this.right == null && this.left == null){
                return this;
            }
            if(this.right == null && this.left != null && this.left.priority < this.priority){
                temp = this.priority; 
                this.priority =  this.left.priority; 
                this.left.priority = temp;
                this.left.pushRoot();
                stats++; 
            }
            else if(this.left == null && this.right != null && this.right.priority < this.priority){
                temp = this.priority; 
                this.priority =  this.right.priority; 
                this.right.priority = temp;
                this.right.pushRoot();
                stats++;
            }
            else if(this.left.priority < this.right.priority && this.left.priority < this.priority){
                temp = this.priority; 
                this.priority =  this.left.priority; 
                this.left.priority = temp;
                this.left.pushRoot();
                stats++; 
            }
            else if(this.right.priority < this.left.priority && this.right.priority < this.priority){
                temp = this.priority; 
                this.priority =  this.right.priority; 
                this.right.priority = temp;
                this.right.pushRoot();
                stats++; 
            }
          
            return this;
             
        }
        
    }

    public Integer denqueue(){
        if(root != null){
            Integer ret = root.priority; 
            root = root.remove(); 
            return ret; 
        }
        else 
            return null; 
    }

    public Integer enqueue(Integer prio){
        if(root != null){
           return root.add(prio); 
        }
        root = new Node(prio);
        return 0;  
    }

    public void push(Integer incr){
        if (root != null) {
            root.priority += incr; 
            root = root.pushRoot(); 
        }

    }

    public void print(){
        if (root != null){
            root.print(2); 
        }
    }

}
