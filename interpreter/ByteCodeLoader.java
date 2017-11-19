
package interpreter;

import interpreter.ByteCode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program = new Program();
    private StringTokenizer stk;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts.
     * Grab correct class name for the given bytecode from CodeTable
     * create an instance of the bytecode class name returned from code table.
     * Parse any additional arguments for the given bytecode and send them to
     * the newly created bytecode instance via the init function.
     */


    public Program loadCodes() throws IOException {
        String line = null;
        String codeClass = null;
        try {
            while ((line = this.byteSource.readLine()) != null) {
                stk = new StringTokenizer(line);  //contructor delimeter is "" just a space
                codeClass = CodeTable.getClassName(stk.nextToken());
                try {
                    ByteCode ByteInstance = (ByteCode) (Class.forName("interpreter.ByteCode." + codeClass).newInstance());

                    while (stk.hasMoreElements()) {
                        ByteInstance.load(stk.nextToken());
                    }

                    this.program.addByte(ByteInstance);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

            }


        } catch (IOException e) {
            System.out.println(e.getMessage() + "Error reading file");
        }

        this.program.resolveAddrs(program);

        return program;
    }
}

