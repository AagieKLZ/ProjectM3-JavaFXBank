package com.mycompany.projectm3.Operation;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.lib.TimeHandler;

/**
 * Represents an ATM operation (withdraw, deposit, transfer)
 */
public class Operation {
    private String oppType;
    private Account source;
    private Account target;
    private float amount;
    private long timestamp;

    /**
     * Constructor for operations created by the ATM
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

    /**
     * Constructor for operations loaded from file
     * @param oppType
     * @param source
     * @param target
     * @param amount
     * @param timestamp
     */
    public Operation(String oppType, Account source, Account target, float amount, long timestamp) {
        this.oppType = oppType;
        this.source = source;
        this.target = target;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    /**
     * Checks if the operation belongs to the given account
     * @param account
     * @return true if the operation belongs to the account
     */
    public boolean belongs(Account account){
        return this.source.equals(account) || this.target.equals(account);
    }

    /**
     * Gets the type of the operation
     * @return Type of the operation
     */
    public String getOppType() {
        return oppType;
    }

    /**
     * Gets the source account of the operation
     * @return Source account of the operation
     */
    public Account getSource() {
        return source;
    }

    /**
     * Gets the target account of the operation
     * @return Target account of the operation
     */
    public Account getTarget() {
        return target;
    }

    /**
     * Gets the amount of money being transferred
     * @return Amount of money being transferred
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Gets the timestamp of the operation
     * @return
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Converts the operation to a string
     * @return String with the operation to be saved in the file
     */
    @Override
    public String toString() {
        if (this.source == null){
            return String.format("%s,%d,%d,%f,%d", this.oppType, -1, this.target.getAccountId(), this.amount, this.timestamp);
        } else if (this.target == null){
            return String.format("%s,%d,%d,%f,%d", this.oppType, this.source.getAccountId(), -1, this.amount, this.timestamp);
        }
        return String.format("%s,%d,%d,%f,%d", this.oppType, this.source.getAccountId(), this.target.getAccountId(), this.amount, this.timestamp);
    }
}

