package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private ArrayList<String> Data = new ArrayList<>();

    public void load(String s) {
     Data.add(s);
    }

    public void execute(VirtualMachine vir) {

        for (int i = 1; i < Integer.parseInt(Data.get(0)); i++){
                       vir.pop();
        }


    }
    public ArrayList<String> getData(){
        return Data;
    }

    public String toString(){
        return ("POP " + Data.get(0));
    }

}
