package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();

    public void load(String s) {

       Data.add(s);

    }

    public void execute(VirtualMachine vir) {
        int offset = (vir.getSizeRunTimeStack()) - Integer.parseInt(Data.get(0));
            vir.newFrameAt(offset);

    }
    public ArrayList<String> getData(){
        return Data;
    }

    public String toString(){
        return ("ARGS " + Data.get(0));
    }
}
