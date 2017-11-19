package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();
 String originaladdy;
    public void load(String s) {

        if(Data.size() == 1){
            Data.set(0,s);
        }
        else {
           originaladdy = s;
            Data.add(s);
        }
    }



    public void execute(VirtualMachine vir) {

        vir.setPc(Integer.parseInt(Data.get(0))   -  1 );   //go to the labal location

    }
    public ArrayList<String> getData(){
        return Data;
    }

    public String toString(){
        return ("GOTO " + originaladdy);
    }



}
