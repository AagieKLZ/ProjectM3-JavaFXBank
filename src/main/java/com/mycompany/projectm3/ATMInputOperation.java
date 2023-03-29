package com.mycompany.projectm3;


import java.util.HashMap;

public class ATMInputOperation extends Operation {
    private HashMap<Integer, Integer> bills;
    public ATMInputOperation(Account target, float amount, HashMap<Integer, Integer> usedBills){
        super(null, target, amount);
        bills = usedBills;
    }
}
