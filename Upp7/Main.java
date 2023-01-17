package Upp7;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(2);  
        queue.add(4);       
        queue.add(4); 
        queue.add(4); 
        //queue.print();
        int a = queue.remove(); 
        System.out.println(a);
    }
}
