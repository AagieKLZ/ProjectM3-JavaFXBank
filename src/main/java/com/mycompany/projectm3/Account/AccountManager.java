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
                acc = new CurrentAccount(this.accountList.size(), 0.0F, owner);
                this.accountList.add(acc);
                saveToFile();
                return acc;
            case "savings":
                acc = new SavingAccount(this.accountList.size(), 0, owner);
                this.accountList.add(acc);
                saveToFile();
                return acc;
            default:
                return null;
        }
    }

    /**
     * Saves the account list to a file
     */
    public void saveToFile(){
        AccountFileReader accountFileReader = new AccountFileReader();
        accountFileReader.writeLines(this.accountList);
    }

    /**
     * Returns the account list
     * @return ArrayList accountList
     */
    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    /**
     * Returns an account by its id
     * @param accNumber account id
     * @return Account object or null if the account does not exist
     */
    public Account getAccountById(long accNumber){
        for (Account account : this.accountList){
            if (account.getAccNumber() == accNumber){
                return account;
            }
        }
        return null;
    }
}
