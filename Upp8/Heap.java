package Upp8;

public class Heap {

    public static void main(String[] args) {
        Heap queue = new Heap(); 
        queue.enqueue(12);
        queue.enqueue(14);
        queue.enqueue(112);
        queue.enqueue(1);
        queue.print();

    }

    Node root; 

    private class Node{
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
            if (prio < this.priority) {
                Integer tmp = this.priority; 
                this.priority = prio; 
                prio = tmp; 
            }
            this.size +=1; 
            if (this.left == null) {
                this.left = new Node(prio);
                return 1;  
            }
            else if(this.right==null){
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

        private Boolean check(){
            Integer prio = this.priority; 
            Boolean checkLeft = true;
            Boolean checkRight= true;  
            if (this.left != null){
                if (this.left.priority >= prio) {
                    checkLeft = this.left.check(); 
                }
                else{
                    System.out.println("Wrongt prio on the left branch. ");
                    checkLeft = false; 
                }
            }

            if (this.right != null){
                if (this.right.priority >= prio) {
                    checkRight = this.right.check(); 
                }
                else{
                    System.out.println("Wrongt prio on the left branch. ");
                    checkRight = false; 
                }
            }

            return (checkLeft && checkRight);
        }

        private void print(Integer n){
            System.out.println(" ".repeat(n) + this.priority + "(" + this.size + ")" );
            if(this.left != null){
                this.left.print(n+2);
            }
            else{
                System.out.println(" ".repeat(n) + "-----");
            }
            if(this.right != null){
                this.right.print(n+2);
            }
            else{
                System.out.println(" ".repeat(n) + "-----");
            }
        }
    }



    public Integer enqueue(Integer prio){
        if(root != null){
           return root.add(prio); 
        }
        root = new Node(prio);
        return 0;  
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

    public void print(){
        if (root != null){
            root.print(2); 
        }
    }

    
}
