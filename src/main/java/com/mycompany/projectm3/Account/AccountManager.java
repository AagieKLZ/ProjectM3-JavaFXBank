package com.mycompany.projectm3.Account;

import com.mycompany.projectm3.FileReader.AccountFileReader;
import com.mycompany.projectm3.User.User;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accountList;
    private AccountFileReader accountFileReader;

    public AccountManager() {
        this.accountFileReader = new AccountFileReader();
        this.accountList = this.accountFileReader.readLines();
    }

    public void assign(Account account, User user){
        user.openAccount(account);
        account.setOwner(user);
    }

    public Account createAccount(String accountType){
        Account acc;
        switch (accountType.toLowerCase()){
            case "current":
                acc = new CurrentAccount();
                this.accountList.add(acc);
                return acc;
            case "savings":
                acc = new SavingAccount();
                this.accountList.add(acc);
                return acc;
            default:
                return null;
        }
    }

    public void saveToFile(){
        AccountFileReader accountFileReader = new AccountFileReader();
        accountFileReader.writeLines(this.accountList);
    }
}
