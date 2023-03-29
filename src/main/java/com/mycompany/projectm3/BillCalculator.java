package com.mycompany.projectm3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BillCalculator {
    public HashMap<Integer, Integer> calculate(HashMap<Integer, Integer> availableBills, int amount){
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
