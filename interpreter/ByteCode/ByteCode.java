package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

abstract public class ByteCode {

abstract public void load(String s);

abstract public void execute(VirtualMachine vir);

public abstract ArrayList<String> getData();



}
