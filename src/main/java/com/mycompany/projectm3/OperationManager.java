package com.mycompany.projectm3;

import java.util.ArrayList;
import java.util.HashMap;

public class OperationManager {
    private ArrayList<Operation> operations;

    public OperationManager(){

        operations = new ArrayList<Operation>();
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
}
