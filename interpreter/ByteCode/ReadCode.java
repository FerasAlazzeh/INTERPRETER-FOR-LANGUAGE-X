package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    ArrayList<String> Data = new ArrayList<>();
    public void load(String s) {
        return;
    }

    public void execute(VirtualMachine vir) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a value");
        int temp = sc.nextInt();
        vir.push(temp);
        Data.add(Integer.toString(temp));

    }
    public ArrayList<String> getData(){
        return Data;
    }
    public String toString(){
        return ("READ " + Data.get(0));
    }

}
