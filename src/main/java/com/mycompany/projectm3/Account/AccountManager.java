package com.mycompany.projectm3.Account;

import com.mycompany.projectm3.FileReader.AccountFileReader;
import com.mycompany.projectm3.User.User;
import com.mycompany.projectm3.lib.RandomNumberGenerator;

import java.util.ArrayList;

/**
 * @author Carlos Carpio
 * @version 1.0
 * Creates and manages accounts
 */
public class AccountManager {
    private ArrayList<Account> accountList;
    private AccountFileReader accountFileReader;

    /**
     * Constructor
     */
    public AccountManager() {
        this.accountFileReader = new AccountFileReader();
        this.accountList = this.accountFileReader.readLines();
        if (this.accountList == null){
            this.accountList = new ArrayList<>();
        }
    }

    /**
     * Assigns an account to a user
     * @param account
     * @param user
     */
    public void assign(Account account, User user){
        user.openAccount(account);
        account.setOwner(user);
    }

    /**
     * Creates an account of the specified type (current or savings)
     * @param accountType
     * @return Account object or null if the type is not valid
     */
    public Account createAccount(String accountType, User owner){
        Account acc;
        switch (accountType.toLowerCase()){
            case "current":
                acc = new CurrentAccount(this.accountList.size() + 1, 0.0F, owner);
                this.accountList.add(acc);
                return acc;
            case "savings":
                acc = new SavingAccount(this.accountList.size() + 1, 0, owner);
                this.accountList.add(acc);
                return acc;
            default:
                return null;
        }
    }

    /**
     * Returns the account list
     * @return ArrayList<Account>
     */
    public void saveToFile(){
        AccountFileReader accountFileReader = new AccountFileReader();
        accountFileReader.writeLines(this.accountList, "generate");
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public Account getAccountById(long accNumber){
        for (Account account : this.accountList){
            if (account.getAccNumber() == accNumber){
                return account;
            }
        }
        return null;
    }
}
