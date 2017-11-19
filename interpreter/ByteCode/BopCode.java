package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

import java.util.HashMap;

public class BopCode extends ByteCode {

    private ArrayList<String> Data = new ArrayList<>();
    private static HashMap<String, Integer> bopTable;

    public void load(String s) {
        Data.add(s);
    }

    public void execute(VirtualMachine vir) {
        bopTable = new HashMap<>();


        int firstLevel = vir.pop();
        int secondLevel = vir.pop();

        bopTable.put("+", (secondLevel + firstLevel));
        bopTable.put("-", (secondLevel - firstLevel));
        try {
            bopTable.put("/", (secondLevel / firstLevel));
        } catch (ArithmeticException e) {

        }
        bopTable.put("*", (secondLevel * firstLevel));
        bopTable.put("==", ((secondLevel == firstLevel) ? 1 : 0));
        bopTable.put("!=", ((secondLevel != firstLevel) ? 1 : 0));
        bopTable.put("<=", ((secondLevel <= firstLevel) ? 1 : 0));             // true = 1
        bopTable.put(">=", ((secondLevel >= firstLevel) ? 1 : 0));             // false = 0
        bopTable.put(">", ((secondLevel > firstLevel) ? 1 : 0));
        bopTable.put("<", ((secondLevel < firstLevel) ? 1 : 0));
        bopTable.put("|", ((secondLevel | firstLevel)));
        bopTable.put("&", (secondLevel & firstLevel));

        vir.push(bopTable.get(Data.get(0)));
    }





    public ArrayList<String> getData() {
        return Data;
    }

    public String toString() {
        return ("BOP " + Data.get(0));
    }

}
