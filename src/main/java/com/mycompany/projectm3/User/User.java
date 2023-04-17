/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectm3.User;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.lib.PasswordHasher;

import java.util.ArrayList;

/**
 *
 * @author alumne
 */
public class User {
    private String name;
    private int id;
    private boolean isLocked  = false;
    private ArrayList<Account> accounts;
    private String password;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setPassword(String pw){
        this.password = PasswordHasher.hash(pw);
    }

    public void openAccount(Account acc){
        this.accounts.add(acc);
    }
    public void closeAccount(int id){
        boolean exists = false;
        for (int i = 0; i < this.accounts.size(); i++){
            if (this.accounts.get(i).getAccountId() == id){
                this.accounts.remove(i);
                break;
            }
        }
    }
    public void lock() {
        this.isLocked = true;
    }
    public void unlock() {
        this.isLocked = false;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAccounts(ArrayList<Account> accounts)  {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return String.format("%s,%d,%s,%s", this.name, this.id, this.password, this.isLocked);
    }
}
