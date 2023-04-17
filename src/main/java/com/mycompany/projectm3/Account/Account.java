package com.mycompany.projectm3.Account;

import com.mycompany.projectm3.FileReader.UserFileReader;
import com.mycompany.projectm3.Operation.Operation;
import com.mycompany.projectm3.User.User;

import java.util.ArrayList;

public class Account {
    protected int account_id;
    protected float interest;
    protected float balance;
    protected ArrayList<Operation> operations;
    protected User owner;
    protected int ownerId;

    public void registerOperation(Operation operation){}

    public ArrayList<Operation> getMovements(){
        /* TODO */
        return new ArrayList<Operation>();
    }

    public Account(int account_id, float balance, User owner){
        this.account_id = account_id;
        this.balance = balance;
        this.owner = owner;
    }

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

    public int getOwnerId(){
        return this.ownerId;
    }

    public void setInterest(float newInterest){
        this.interest = newInterest;
    }

    public float getBalance(){
        return this.balance;
    }

    public float addMoney(float amount){
        this.balance = this.balance + amount;
        return this.balance;
    }

    public float extractMoney(float amount){
        this.balance = this.balance - amount;
        return this.balance;
    }

    public int getAccountId(){
        return this.account_id;
    }

    public void setOwner(User owner){
        this.owner = owner;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Account)){
            return false;
        }
        Account acc = (Account) obj;
        return acc.getAccountId() == this.account_id || obj == this;
    }

    @Override
    public String toString() {
        return String.format("%d,%f,%f,%d", this.account_id, this.balance, this.interest, this.owner.getId());
    }
}
