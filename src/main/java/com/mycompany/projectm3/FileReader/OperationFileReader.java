package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.Operation.Operation;

import java.lang.reflect.Array;
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
        ArrayList<Account> accounts = new AccountFileReader().readLines();
        for (String line : lines){
            String[] lineSplit = line.split(",");
            String oppType = lineSplit[0];
            int source_id = Integer.parseInt(lineSplit[1]);
            int target_id = Integer.parseInt(lineSplit[2]);
            float amount = Float.parseFloat(lineSplit[3]);
            long timestamp = Long.parseLong(lineSplit[4]);
            Account source = null;
            Account target = null;
            for (Account acc : accounts){
                if (acc.getAccountId() == source_id){
                    source = acc;
                }
                if (acc.getAccountId() == target_id){
                    target = acc;
                }
            }
            Operation operation = new Operation(oppType, source, target, amount, timestamp);
            operations.add(operation);
        }
        return operations;
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
