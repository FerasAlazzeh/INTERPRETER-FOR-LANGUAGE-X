package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    private ArrayList<String> Data = new ArrayList<>();
    String addy;
    public void load(String s) {

        if(Data.size() == 1){
            Data.set(0,s);
        }
        else {
            Data.add(s);
            addy = s;
        }
    }

    public void execute(VirtualMachine vir) {
        vir.PushReturnAdd(vir.getpc());
        vir.setPc(Integer.parseInt(Data.get(0))  - 1);
    }
    public ArrayList<String> getData(){
        return Data;
    }
    public String toString(){





        return ("CALL " + addy);
    }
}
