package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();

    public void load(String s) {
        Data.add(s);

    }

    public void execute(VirtualMachine vir) {
    return;
    }
    public ArrayList<String> getData(){
        return Data;
    }

    public String toString(){
        return ("LABEL " + Data.get(0));
    }

}
