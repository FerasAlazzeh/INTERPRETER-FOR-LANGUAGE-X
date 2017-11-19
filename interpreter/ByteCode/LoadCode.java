package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();

    public void load(String s) {                //data[0] = value  data[1] = variable    ex. [5,j]
        Data.add(s);
    }

    public void execute(VirtualMachine vir) {
       int offset = Integer.parseInt(Data.get(0));
       int loadNum =  vir.load(offset);
       vir.push(loadNum);
    }

    public ArrayList<String> getData() {
        return Data;

    }

    public String toString(){
        return ("LOAD " + Data.get(0) + " " + Data.get(1) + "    " + "<load " + Data.get(1) + ">" );
    }

}

