package com.mycompany.projectm3.Bills;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Makes the calculations for the bills
 */
public class BillCalculator {
    /**
     * Calculates the number of bills required for a specific amount
     * @param availableBills
     * @param amount
     * @return HashMap<Integer, Integer> with the bills required or null if the amount is larger than the available bills
     */
    public static HashMap<Integer, Integer> calculate(HashMap<Integer, Integer> availableBills, int amount){
        HashMap<Integer, Integer> usedBills = new HashMap<>();
        ArrayList<Integer> billValues = new ArrayList<>(availableBills.keySet());
        billValues.sort(Collections.reverseOrder());

        for (int billValue : billValues) {
            int billCount = availableBills.get(billValue);

            int billsToWithdraw = Math.min(amount / billValue, billCount);
            if (billsToWithdraw > 0) {
                usedBills.put(billValue, billsToWithdraw);
                amount -= billsToWithdraw * billValue;
            }

            if (amount == 0) {
                break;
            }
        }

        return (amount == 0) ? usedBills : null;
    }
}
