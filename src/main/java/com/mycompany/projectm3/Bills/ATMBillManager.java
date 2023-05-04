package com.mycompany.projectm3.Bills;

import com.mycompany.projectm3.FileReader.BillFileReader;

import java.util.HashMap;

/**
 * Manages the bills in the ATM
 */
public class ATMBillManager {
    private HashMap<Integer, Integer> bills;
    private int max_available;

    /**
     * Constructor for ATMBillManager. Reads the bills from the file and calculates the max available. If the max available is 0, it sets the default bills.
     */
    public ATMBillManager(){
        BillFileReader billFileReader = new BillFileReader();
        this.bills = billFileReader.readLines();
        if (this.bills == null){
            this.bills = new HashMap<>();
        }
        this.max_available = calcMaxAvailable();
        if (this.max_available == 0 || this.bills == null){
            bills.put(10, 45);
            bills.put(20, 50);
            bills.put(50, 30);
            bills.put(100, 15);
            bills.put(200, 5);
            this.bills = bills;
            this.max_available = calcMaxAvailable();
        }
    }

    /**
     * Returns the bills available in the ATM
     * @return HashMap<Integer, Integer> bills
     */
    public HashMap<Integer, Integer> getBills(){
        return bills;
    }

    /**
     * Returns the amount of bills available for a specific amount
     * @param amount
     * @return number of bills or -1 if the amount is not available
     */
    public int getBills(int amount){
        if (bills.containsKey(amount)){
            return bills.get(amount);
        }
        return -1;
    }

    public void setBills(HashMap<Integer, Integer> bills) {
        this.bills = bills;
    }

    /**
     * Extracts a bill from the ATM
     * @param amount
     * @return number of bills or -1 if the amount is not available
     */
    public int extractBill(int amount){
        if (bills.get(amount) == 0 || !bills.containsKey(amount)){
            return -1;
        }
        bills.put(amount, bills.get(amount) - 1);
        return bills.get(amount);

    }

    /**
     * Adds a bill to the ATM
     * @param amount
     * @return number of bills or -1 if the amount is not available
     */
    public int addBill(int amount){
        if (!bills.containsKey(amount)){
            return -1;
        }
        bills.put(amount, bills.get(amount) + 1);
        return bills.get(amount);
    }

    /**
     * Calculates the max available amount of money in the ATM
     * @return max available amount of money
     */
    public int calcMaxAvailable(){
        int total = 0;
        for (int key : bills.keySet()) {
            total += bills.get(key);
        }
        return total;
    }

    /**
     * Gets the max available amount of money in the ATM
     * @return max available amount of money
     */
    public int getMaxAvailable(){
        return max_available;
    }

    /**
     * Saves the bills in the ATM to the file
     */
    public void saveBills(){
        BillFileReader billFileReader = new BillFileReader();
        billFileReader.writeLines(this.bills);
    }

    public void extractBills(HashMap<Integer, Integer> bills){
        for (int key : bills.keySet()) {
            for (int i = 0; i < bills.get(key); i++) {
                extractBill(key);
            }
        }
    }
}
