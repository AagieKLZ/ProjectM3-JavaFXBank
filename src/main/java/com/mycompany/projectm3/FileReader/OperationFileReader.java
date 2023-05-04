package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Operation.Operation;

import java.util.ArrayList;


/**
 * Reads and writes from the operations.csv file
 */
public class OperationFileReader extends FileReader {
    private final String path = "operations.csv";

    /**
     * Constructor
     */
    public OperationFileReader() {
        super("operations.csv");
    }

    /**
     * Reads the lines from the file and returns an ArrayList of operations
     * @return ArrayList of operations from the file
     */
    public ArrayList<Operation> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<Operation> operations = new ArrayList<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
    }

    /**
     * Writes the operations to the file
     * @param operations
     */
    public void writeLines(ArrayList<Operation> operations){
        ArrayList<String> lines = new ArrayList<>();
        for (Operation operation : operations){
            lines.add(operation.toString());
        }
        this.write(lines);
    }

}
