package upp5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList object = new LinkedList(1, null ); 
        for(int i = 0; i < 50; i++) {
            object.addItem(i);
        }
       
        
        object.print();

        LinkedList b = new LinkedList(1, null ); 
    }
}
