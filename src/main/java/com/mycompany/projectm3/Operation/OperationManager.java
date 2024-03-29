package com.mycompany.projectm3.Operation;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.FileReader.OperationFileReader;

import java.util.ArrayList;

/**
 * Manages the operations of the bank
 */
public class OperationManager {
    private ArrayList<Operation> operations;

    /**
     * Creates a new OperationManager
     */
    public OperationManager(){
        this.operations = new OperationFileReader().readLines();
    }

    /**
     * Creates a new operation
     * @param type Type of the operation
     * @param source Source account
     * @param target Target account
     * @param amount Amount of money being transferred
     */
    public Operation createOperation(String type, Account source, Account target, float amount) {
        Operation opp = new Operation(type, source, target, amount);
        this.operations.add(opp);
        if (source == null){
            target.addOperation(opp);
        } else if (target == null){
            source.addOperation(opp);
        } else {
            source.addOperation(opp);
            target.addOperation(opp);
        }
        saveOperations();
        return opp;
    }


    /**
     * Gets all the operations
     * @return List of operations
     */
    public ArrayList<Operation> getOperations(){
        return this.operations;
    }

    /**
     * Saves the operations to file
     */
    public void saveOperations(){
        OperationFileReader operationFileReader = new OperationFileReader();
        operationFileReader.writeLines(this.operations);
    }
}
