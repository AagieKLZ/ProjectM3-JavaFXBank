package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Operation.Operation;

import java.util.ArrayList;

public class OperationFileReader extends FileReader {
    private final String path = "operations.json";

    public OperationFileReader() {
        super();
    }

    public ArrayList<Operation> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<Operation> operations = new ArrayList<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
    }

    public void writeLines(ArrayList<Operation> operations){
        ArrayList<String> lines = new ArrayList<>();
        for (Operation operation : operations){
            lines.add(operation.toString());
        }
        this.write(lines);
    }

}
