package com.mycompany.projectm3;

/**
 *
 */
public class Operation {
    private final String oppType;
    private final Account source;
    private final Account target;
    private final float amount;
    private final int timestamp;

    /**
     * @param inpSource Input account for the operation
     * @param inpTarget Target account for the operation
     * @param inpAmount Amount of money being transferred
     */
    public Operation(String type, Account inpSource, Account inpTarget, float inpAmount ){
        oppType = type;
        source = inpSource;
        target = inpTarget;
        amount = inpAmount;
        timestamp = TimeHandler.getCurrentTimestamp();
    }

    public boolean belongs(Account account){
        return this.source.equals(account) || this.target.equals(account);
    }
}

