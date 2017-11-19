package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();

    public void load(String s) {
     Data.add(s);

    }

    public void execute(VirtualMachine vir) {
        int pc = vir.GetReturnAdd();
       int temp = vir.pop();

       while (vir.getSizeRunTimeStack()  > vir.peekFrame()){
        vir.pop();
       }
        vir.popframe();
        vir.push(temp);
        vir.setPc(pc);
    }
    public ArrayList<String> getData(){
        return Data;
    }

    public String toString() {

        if (Data.size() == 0) {
            return ("RETURN ");
        } else {
            return ("RETURN " + Data.get(0));
        }
    }
}
