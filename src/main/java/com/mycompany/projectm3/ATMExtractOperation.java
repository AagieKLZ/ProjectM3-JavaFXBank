package com.mycompany.projectm3;

import java.util.HashMap;

public class ATMExtractOperation extends Operation {
    private HashMap<Integer, Integer> bills;
    public ATMExtractOperation(Account source, float amount, HashMap<Integer, Integer> usedBills){
        super(source, null, amount);
        bills = usedBills;
    }
}
