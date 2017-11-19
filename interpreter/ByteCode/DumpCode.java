package interpreter.ByteCode;


import interpreter.VirtualMachine;



import java.util.ArrayList;


public class DumpCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();
    public void load(String s) {
   Data.add(s);
    }

    public void execute(VirtualMachine vir) {

        switch (Data.get(0)){
            case "ON": vir.DumpOn();
                    break;
            case "OFF": vir.DumpOff();
                    break;
        }


    }
    public ArrayList<String> getData(){
        return Data;
    }

    public String toString(){
        return ("");
    }

}
