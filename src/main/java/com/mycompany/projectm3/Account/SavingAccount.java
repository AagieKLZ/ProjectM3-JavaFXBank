package com.mycompany.projectm3.Account;
import com.mycompany.projectm3.User.User;

/**
 * Represents a saving account in the ATM
 */
public class SavingAccount extends Account {

    /**
     * Constructor for SavingAccount from file
     * @param account_id Account id
     * @param balance Balance of the account
     * @param ownerId Owner id
     * @param accNumber Account number
     */
    public SavingAccount(int account_id, float balance, int ownerId, long accNumber){
        super(account_id, balance, ownerId, accNumber);
        this.accType = "Savings";
    }

    /**
     * Constructor for SavingAccount
     * @param account_id Account id
     * @param balance Balance of the account
     * @param owner Owner of the account
     */
    public SavingAccount(int account_id, float balance, User owner){
        super(account_id, balance, owner);
        this.accType = "Savings";
    }
}
