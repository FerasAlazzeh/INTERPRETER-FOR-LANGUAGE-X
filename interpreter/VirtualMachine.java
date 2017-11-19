package interpreter;

import interpreter.ByteCode.ByteCode;


import java.util.ArrayList;
import java.util.Stack;


public class VirtualMachine {

    private RunTimeStack runStack;
    private int pc;  //program counter
    private Stack returnAddrs;    // push/pop when call/return functions
    private boolean isRunning; //Return True when the VM is running
    private Program program;  //byte code program
    private boolean DumpStatus;
    protected VirtualMachine(Program program) {
        this.program = program;
    }


    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;
        DumpStatus = false;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
           if(DumpStatus){
               runStack.dump(code);
           }
            pc++;
        }
    }
    public void DumpOn() {
        DumpStatus = true;
    }

    public void DumpOff() {
        DumpStatus = false;
    }

    public void dump(ByteCode byt) {

        this.runStack.dump(byt);


    }

    public int peek() {
        return this.runStack.peek();
    }

    public int pop() {
        return this.runStack.pop();
    }

    public void newFrameAt(int offset) {
        this.runStack.newFrameAt(offset);
    }

    public void popframe() {
        this.runStack.popframe();
    }

    public void store(int offset, int newNum) {
        this.runStack.store(offset, newNum);
    }

    public int load(int offset) {
        return this.runStack.load(offset);
    }

    public Integer push(Integer i) {
        return this.runStack.push(i);
    }

    public int push(int i) {
        return this.runStack.push(i);
    }

    public void setPc(int newpc) {
        pc = newpc;
    }

    public int getpc() {
        return pc;
    }

    public void haltProgram() {
        isRunning = false;
    }

    public void PushReturnAdd(int i) {
        this.returnAddrs.push(i);
    }

    public int GetReturnAdd() {
        return (int) this.returnAddrs.pop();
    }

    public int getSizeRunTimeStack() { return this.runStack.getSizeRunTimeStack(); }

    public int peekFrame(){
        return this.runStack.peekFrame();
    }
}





