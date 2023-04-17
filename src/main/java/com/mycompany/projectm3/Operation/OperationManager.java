package com.mycompany.projectm3.Operation;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.FileReader.OperationFileReader;

import java.util.ArrayList;

public class OperationManager {
    private ArrayList<Operation> operations;

    public OperationManager(){
        /* TODO - Read from file */
        this.operations = new ArrayList<Operation>();
    }
    public void createOperation(String type, Account source, Account target, float amount) {
        Operation opp = new Operation(type, source, target, amount);
        this.operations.add(opp);
    }

    public ArrayList<Operation> getOperations(Account account){
        ArrayList<Operation> opps = new ArrayList<Operation>();
        for (Operation opp : this.operations){
            if (opp.belongs(account)){
                opps.add(opp);
            }
        }
        return opps;
    }

    public ArrayList<Operation> getOperations(){
        return this.operations;
    }

    public void saveOperations(){
        OperationFileReader operationFileReader = new OperationFileReader();
        operationFileReader.writeLines(this.operations);
    }
}
