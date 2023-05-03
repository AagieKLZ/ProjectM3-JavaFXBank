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
    public Account createAccount(String accountType){
        Account acc;
        switch (accountType.toLowerCase()){
            case "current":
                acc = new CurrentAccount(1, 0.0F, 1, RandomNumberGenerator.generateCardNumber());
                this.accountList.add(acc);
                return acc;
            case "savings":
                acc = new SavingAccount(1, 0, 1, RandomNumberGenerator.generateCardNumber());
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
        accountFileReader.writeLines(this.accountList);
    }
}
