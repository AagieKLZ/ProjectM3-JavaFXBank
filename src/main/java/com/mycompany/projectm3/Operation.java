package com.mycompany.projectm3;

/**
 *
 */
public class Operation {
    protected Account source;
    protected Account target;
    protected float amount;

    /**
     * @param inpSource Input account for the operation
     * @param inpTarget Target account for the operation
     * @param inpAmount Amount of money being transferred
     */
    public Operation(Account inpSource, Account inpTarget, float inpAmount ){
        source = inpSource;
        target = inpTarget;
        amount = inpAmount;
    }
}

