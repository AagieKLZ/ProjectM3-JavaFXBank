package com.mycompany.projectm3.ATM;

import com.mycompany.projectm3.Account.AccountManager;
import com.mycompany.projectm3.Account.CardManager;
import com.mycompany.projectm3.Bills.ATMBillManager;
import com.mycompany.projectm3.Operation.OperationManager;
import com.mycompany.projectm3.User.User;
import com.mycompany.projectm3.User.UserManager;

public class ATM {
    public AccountManager accountManager;
    public ATMBillManager billManager;
    public OperationManager oppManager;
    public AccountManager accManager;
    public UserManager userManager;
    public CardManager cardManager;
    User user = null;

    public ATM(){
        this.billManager = new ATMBillManager();
        this.user = new User("test", "test", 5);
        this.oppManager = new OperationManager();
        this.accManager = new AccountManager();
        this.userManager = new UserManager();
        this.cardManager = new CardManager();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
