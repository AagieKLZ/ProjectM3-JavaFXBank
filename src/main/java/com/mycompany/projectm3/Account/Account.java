package com.mycompany.projectm3.Account;

import com.mycompany.projectm3.FileReader.UserFileReader;
import com.mycompany.projectm3.Operation.Operation;
import com.mycompany.projectm3.User.User;

import java.util.ArrayList;

/**
 * Represents an ATM account
 * */
public class Account {
    protected int account_id;
    protected float interest;
    protected float balance;
    protected ArrayList<Operation> operations;
    protected User owner;
    protected int ownerId;

    /**
     * Constructor for Account
     * @param account_id the account id
     * @param balance the account balance
     * @param owner the account owner
     * */
    public Account(int account_id, float balance, User owner){
        this.account_id = account_id;
        this.balance = balance;
        this.owner = owner;
    }

    /**
     * Constructor for Account from file
     * @param account_id the account id
     * @param balance the account balance
     * @param ownerId the owner id
     * */
    public Account(int account_id, float balance, int ownerId){
        this.account_id = account_id;
        this.balance = balance;
        this.ownerId = ownerId;
        ArrayList<User> users = new UserFileReader().readLines();
        for (User user : users){
            if (user.getId() == ownerId){
                this.owner = user;
                break;
            }
        }
    }

    /**
     * Registers an operation in the account
     * @param operation
     */
    public void registerOperation(Operation operation){
        this.operations.add(operation);
    }

    /**
     * Returns the account movements
     * @return the account movements
     */
    public ArrayList<Operation> getMovements(){
        /* TODO */
        return new ArrayList<Operation>();
    }

    /**
     * Returns the account owner
     * @return the account owner
     */
    public int getOwnerId(){
        return this.ownerId;
    }

    /**
     * Returns the account owner
     * @param newInterest
     */
    public void setInterest(float newInterest){
        this.interest = newInterest;
    }

    /**
     * Returns the account balance
     * @return the account balance
     */
    public float getBalance(){
        return this.balance;
    }

    /**
     * Inserts money in the account
     * @param amount
     * @return
     */
    public float addMoney(float amount){
        this.balance = this.balance + amount;
        return this.balance;
    }

    /**
     * Extracts money from the account
     * @param amount
     * @return
     */
    public float extractMoney(float amount){
        this.balance = this.balance - amount;
        return this.balance;
    }

    /**
     * Returns the account id
     * @return the account id
     */
    public int getAccountId(){
        return this.account_id;
    }

    /**
     * Sets the account owner
     * @param owner
     */
    public void setOwner(User owner){
        this.owner = owner;
    }

    /**
     * Equals method to compare accounts
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Account)){
            return false;
        }
        Account acc = (Account) obj;
        return acc.getAccountId() == this.account_id || obj == this;
    }

    /**
     * Returns the account as a string to be written in a file
     * @return the account as a string
     */
    @Override
    public String toString() {
        return String.format("%d,%f,%f,%d", this.account_id, this.balance, this.interest, this.owner.getId());
    }
}
