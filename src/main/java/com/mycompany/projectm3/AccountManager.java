package com.mycompany.projectm3;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accountList;

    public void assign(Account account, User user){
        user.openAccount();
    }

    public Account createAccount(String accountType){
        Account acc;
        switch (accountType.toLowerCase()){
            case "current":
                acc = new CurrentAccount();
                accountList.add(acc);
                return acc;
            case "savings":
                acc = new SavingAccount();
                accountList.add(acc);
                return acc;
            default:
                return null;
        }
    }

    public void readAccountList(){

    }
}
