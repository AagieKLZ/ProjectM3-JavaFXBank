package com.mycompany.projectm3.Account;
import com.mycompany.projectm3.User.User;

public class SavingAccount extends Account {
    public SavingAccount(int account_id, float balance, int ownerId, long accNumber){
        super(account_id, balance, ownerId, accNumber);
        this.accType = "Savings";
    }

    public SavingAccount(int account_id, float balance, User owner){
        super(account_id, balance, owner);
        this.accType = "Savings";
    }
}
