package interpreter;

import interpreter.ByteCode.ArgsCode;
import interpreter.ByteCode.ByteCode;
import interpreter.ByteCode.CallCode;
import interpreter.ByteCode.DumpCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    int size;

    public void dump(ByteCode code) {

        if (code instanceof ArgsCode) {
            size = Integer.parseInt(code.getData().get(0));
            System.out.println(code);
        } else if (code instanceof CallCode) {
            System.out.print(code);
            System.out.print("   ");
            System.out.print("f(");
            for (int i = 0; i < size; i++) {
                System.out.print(runTimeStack.get(runTimeStack.size() - 1 - i));
                if (!(i + 1 == size)) {
                    System.out.print(",");
                }
            }
            System.out.print(")");
            System.out.println();
        } else {
            System.out.println(code);
        }


        Iterator<Integer> itRun = runTimeStack.iterator();
        Iterator<Integer> itFrme = framePointer.iterator();


        if (!(code instanceof DumpCode)) {
            int index = 0;
            int frameInt = 0;
            boolean closed = false;
            while (itFrme.hasNext() && frameInt == 0) {   //if there is a non zero frame pointer you want the frame pointer not to be 0
                frameInt = itFrme.next();
            }
            System.out.print("[");              //start with an open frame
            while (itRun.hasNext()) {
                System.out.print(itRun.next()); //print next number in frame
                index++;                        //index of array goes up by 1
                if (itRun.hasNext() && index != frameInt) {
                    System.out.print(",");      //check if I need a comma between every int
                }
                if (frameInt == index) {
                    System.out.print("]");
                    closed = true;
                    if (itRun.hasNext()) {
                        closed = false;
                        System.out.print("[" + itRun.next());
                        if (itRun.hasNext()) {
                            System.out.print(",");      //check if I need a comma between every int
                        }
                        if (itFrme.hasNext()) {
                            frameInt = itFrme.next();
                        }

                    }
                }
            }
            if (!closed) {
                System.out.print("]");
            }

            System.out.println();

        }
    }

    public int peek() {         //returns the top of the runtime stack

        return (int) runTimeStack.get(runTimeStack.size() - 1);

    }

    public int pop() {          // pop the item from the runtime stack and return that item
        int temp = (int) runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return temp;
    }

    public int push(int i) {       //push this item on the runtime stack, and return the item just pushed
        runTimeStack.add(i);
        return i;
    }


    public void newFrameAt(int offset) { //offeset indicated the number of slots down from the top of the runtime stack for starting a new frame

        framePointer.add(offset);
    }

    public void popframe() {
        framePointer.pop();
    }                                  //we pop frame when returning from a function, before popping, we save the top of the stack value,
    //than pop top frame and push the return value

    public void store(int offset, int newNum) {       //Used to store into variables
        runTimeStack.set(offset + framePointer.peek(), newNum);
    }

    public int load(int offset) {        //Used to load variables onto the stack
        return (int) runTimeStack.get(offset + framePointer.peek());
    }

    public Integer push(Integer i) {    //Used to store literals onto the stack, ex. lit 5 we will call push with 5
        runTimeStack.add(i);
        return i;
    }

    public int getSizeRunTimeStack() {
        return runTimeStack.size();
    }

    public int peekFrame() {
        return framePointer.peek();
    }
}