package com.mycompany.projectm3;

import java.util.HashMap;

public class ATMBillManager {
    private HashMap<Integer, Integer> bills;
    private int max_available;

    public ATMBillManager(){
        bills = new HashMap<Integer, Integer>();
        bills.put(10, 45);
        bills.put(20, 50);
        bills.put(50, 30);
        bills.put(100, 15);
        bills.put(200, 5);
        max_available = calcMaxAvailable();
    }

    public HashMap<Integer, Integer> getBills(){
        return bills;
    }

    public int getBills(int amount){
        if (bills.containsKey(amount)){
            return bills.get(amount);
        }
        return -1;

    }

    public int extractBill(int amount){
        if (bills.get(amount) == 0 || !bills.containsKey(amount)){
            return -1;
        }
        bills.put(amount, bills.get(amount) - 1);
        return bills.get(amount);

    }

    public int addBill(int amount){
        if (!bills.containsKey(amount)){
            return -1;
        }
        bills.put(amount, bills.get(amount) + 1);
        return bills.get(amount);
    }
    
    public int calcMaxAvailable(){
        int total = 0;
        for (int key : bills.keySet()) {
            total += bills.get(key);
        }
        this.max_available = total;
        return total;
    }
}
