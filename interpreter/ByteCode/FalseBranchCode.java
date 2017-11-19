package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
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

        int boolVal = vir.pop();                //if false return pc stays same and execute next bytecode
        if (boolVal != 0) {
            return;
        } else {
            vir.setPc(Integer.parseInt(Data.get(0)) - 1);              // if true, jump to pc, change pc
        }

    }


    public ArrayList<String> getData() {
        return Data;
    }

    public String toString(){
        return ("FALSEBRANCH " + addy);
    }




}