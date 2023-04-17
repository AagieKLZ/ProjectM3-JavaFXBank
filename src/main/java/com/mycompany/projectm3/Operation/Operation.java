package com.mycompany.projectm3.Operation;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.lib.TimeHandler;

/**
 *
 */
public class Operation {
    private String oppType;
    private Account source;
    private Account target;
    private float amount;
    private long timestamp;

    /**
     * @param source Input account for the operation
     * @param target Target account for the operation
     * @param amount Amount of money being transferred
     */
    public Operation(String oppType, Account source, Account target, float amount) {
        this.oppType = oppType;
        this.source = source;
        this.target = target;
        this.amount = amount;
        this.timestamp = TimeHandler.getCurrentTimestamp();
    }

    public Operation(String oppType, Account source, Account target, float amount, long timestamp) {
        this.oppType = oppType;
        this.source = source;
        this.target = target;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public boolean belongs(Account account){
        return this.source.equals(account) || this.target.equals(account);
    }

    public String getOppType() {
        return oppType;
    }

    public Account getSource() {
        return source;
    }

    public Account getTarget() {
        return target;
    }

    public float getAmount() {
        return amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("%s,%d,%d,%f,%d", this.oppType, this.source.getAccountId(), this.target.getAccountId(), this.amount, this.timestamp);
    }
}

