package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {
    ArrayList<String> Data = new ArrayList<>();
    public void load(String s) {
        return;
    }

    public void execute(VirtualMachine vir) {

        System.out.println(vir.peek());
        Data.add(Integer.toString(vir.peek()));
    }
    public ArrayList<String> getData(){
        return Data;
    }

    public String toString(){


        return ("WRITE " + Data.get(0));
    }
}
