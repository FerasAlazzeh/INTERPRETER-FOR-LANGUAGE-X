# INTERPRETER-FOR-LANGUAGE-X

* Project introduction

The interpreter’s job is to read machine code and execute it. For this project I programmed a functional Interpreter for the moc programming Language X. This language only runs machine code compiled down to FileName.x.cod.

* Assumptions 

I assumed that we only will be working with integer type variables.

* Implementation details

The program’s main method is contained in the Interpreter Class. Interpreter is the main class that starts the Interpreter. The Interpreter calls the ByteCodeLoader class whose job is to load codes from the “FileName.x.cod” compiled code, and tokenize it to create an instance of each token per their appropriate Bytecode type. ByteCodeLoader will create these objects using the Code Table class, and reflection. Once all the different ByteCode objects are created and initialized, ByteCodeLoader will call the Program class to resolve the addresses for the different objects. All the ByteCode's are then passed to the VirtualMachine class. The Virtual Machine will than begin to execute each bytecode. We utilize polymorphism to dynamically execute each ByteCode. Each respective ByteCode will use a function in Virtual Machine to carry out their operations through to the runtime Stack. The virtual machine will be the middle man to ensure encapsulation is maintained.


