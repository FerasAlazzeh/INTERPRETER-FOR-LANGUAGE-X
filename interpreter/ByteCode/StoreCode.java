package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private ArrayList<String> Data = new ArrayList<>();

    int storeNum;
    public void load(String s) {                //data[0] = value  data[1] = variable    ex. [5,j]
        Data.add(s);
    }

    public void execute(VirtualMachine vir) {
         storeNum = vir.pop();
        int offset = Integer.parseInt(Data.get(0));
        vir.store(offset,storeNum);
    }

    public ArrayList<String> getData() {
        return Data;
    }
    public String toString(){

        return ("STORE " + Data.get(0) + " " + Data.get(1) + "    "  + Data.get(1) + "=" + storeNum);
    }

}

