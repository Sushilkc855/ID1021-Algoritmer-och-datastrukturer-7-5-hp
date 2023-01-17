/**
 * upp2
 */

import java.util.Scanner;

//import Item.ItemType;
public class upp2 {
    static Scanner scanner = new Scanner(System.in); 
    
    Calculator cal; 
    public static void main(String[] args) {
       /* 
        int num = 0;
        char character; 
        System.out.println("\nEnter a value or expresstion ");
        String str= scanner.nextLine();              //reads string  

        for(int i=0; i < str.length(); i++) {
            Boolean flag = Character.isDigit(str.charAt(i)); // looks if it is or number or not. if number then true. 
            if(flag) {
               character = str.charAt(i);
                num = Character.getNumericValue(character);  
                System.out.println(num);
            }
            else {
               System.out.println("'"+ str.charAt(i)+"' is a letter");
            }
         }
*/
Item[] items = new Item[6];
items[0] = new Item(4);
items[1] = new Item(4);
items[2] = new Item(4);
items[3] = new Item(4);
items[4] = new Item(4);
items[5] = new Item(ItemType.ADD);
Calculator cal = new Calculator(items);
int test = cal.run();
System.out.println(test);

    }
}

public class Calculator {
    Item[] expr;
    int ip;
    Upp2Stack stack = new Upp2Stack();
    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Upp2Stack();
    }

    


    public int run() {
        while ( ip < expr.length ) {
        step();
        }
        return stack.pop();
    }

    public void step() {
        Item nxt = expr[ip++];
        switch(nxt.type()) {
        case ADD: 
        int y = stack.pop();
        int x = stack.pop();
        stack.push(x + y);
        break;

        case SUB: 
            y = stack.pop();
            x = stack.pop();
            stack.push(x - y);
            break;

        case MUL: 
            y = stack.pop();
            x = stack.pop();
            stack.push(x * y);
            break;
        
        case DIV: 
            y = stack.pop();
            x = stack.pop();
            stack.push(x / y);
            break;
        
        case VALUE: 
            stack.push(nxt.value());
            break;
    }
}
}




public class Item {
    private ItemType type;
    private int value = 0;

    Item(int value){
        this.value = value; 
        this.type = ItemType.VALUE; 
    }

    Item(ItemType type){
        this.type = type; 
    }

    public  ItemType type(){
        return type; 
    }

    public  int value(){
        return value; 
    }

    
}       

public enum ItemType {
    ADD,
    SUB,
    MUL,
    DIV,
    VALUE
}









/**
 * Upp2Stack
 */
public class Upp2Stack {
    static final int stackSize = 4;
    int[] stack = new int[stackSize]; 
// It ponts one position above stack because when you push a number,
//it will point to first place and add the number there so it will never point to a place after the stacksize.
    int pointer = -1; 


    public void push(int value){
        if (stackSize() == stackSize){
            throw new StackOverflowError("Stack is full");
        }

        else{
        stack[++pointer] = value; // pointer is pointing -1 så we add 1 and add the value in that postion so it will always point to the first value. 
        }
    }



    public int pop(){
        if(pointer<0){
            System.out.print("stack is empty");  
        }
       
        return stack[pointer--]; // returns the value it is pointhing to and then points to the value before it.   
    }

    public int stackSize(){
        return pointer + 1; 
    }

    
}