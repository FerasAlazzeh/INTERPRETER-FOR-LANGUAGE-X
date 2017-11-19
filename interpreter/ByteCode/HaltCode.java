package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {

    public void load(String s){

    }

   public void execute(VirtualMachine vir) {
    vir.haltProgram();
    }

    public ArrayList<String> getData(){
        return null;
    }

    public String toString(){
        return ("HALT ");
    }


}
