package com.mycompany.projectm3;

import java.util.ArrayList;
import java.util.HashMap;

public class OperationManager {
    private ArrayList<Operation> operations;

    public OperationManager(){
        operations = new ArrayList<Operation>();
    }
    public void createOperation(Account source, Account target, float amount, HashMap<Integer, Integer> bills){
        Operation opp;
        if (bills == null){
            opp = new TransferOperation(source, target, amount);
            operations.add(opp);
        } else if (source == null){
            opp = new ATMInputOperation(target, amount, bills);
            operations.add(opp);
        } else if (target == null){
            opp = new ATMExtractOperation(source, amount, bills);
            operations.add(opp);
        }
    }

    public ArrayList<Operation> getOperations(Account account){
        return this.operations;
    }
}
