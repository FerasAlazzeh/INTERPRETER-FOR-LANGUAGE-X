package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();


    public void load(String s) {                //data[0] = value  data[1] = variable    ex. [5,j]

        Data.add(s);
    }

    public void execute(VirtualMachine vir) {

            vir.push(Integer.parseInt(Data.get(0)));   //load literal value of n


    }

    public ArrayList<String> getData() {
        return Data;
    }

    public String toString(){

       if(Data.size() == 1){
           return ("LIT " + Data.get(0));
       }
        return ("LIT " + Data.get(0) + " " + Data.get(1) + "    "   + "int " + Data.get(1));
    }


}
