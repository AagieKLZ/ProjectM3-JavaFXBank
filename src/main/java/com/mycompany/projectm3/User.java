/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectm3;

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

    public User(String inpName, int inpId){
        name = inpName;
        id = inpId;
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
            if (this.accounts.get(i).account_id == id){
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

    public void setName(String name) {
        this.name = name;
    }
    public void setAccounts(ArrayList<Account> accounts)  {
        this.accounts = accounts;
    }
}
