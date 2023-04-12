package com.mycompany.projectm3;

import java.util.ArrayList;

public class Account {
    protected int account_id;
    protected float interest;
    protected float balance;
    protected ArrayList<Operation> operations;
    public void registerOperation(Operation operation){}
    public ArrayList<Operation> getMovements(){
        return new ArrayList<Operation>();
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

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Account)){
            return false;
        }
        Account acc = (Account) obj;
        return acc.getAccountId() == this.account_id || obj == this;
    }

}
