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
        if (stack() == stackSize){
            system.out.print("stack is full");
        }

        else{
        stack[++pointer] = value; // pointer is pointing -1 så we add 1 and add the value in that postion so it will always point to the first value. 
        }
    }



    public int pop(){
        if(pointer<0){
            system.out.print("stack is empty");  
        }
        else{
        return stack[pointer--]; // returns the value it is pointhing to and then points to the value before it.
        }
    }

    public int stackSize(){
        return pointer + 1; 
    }
}