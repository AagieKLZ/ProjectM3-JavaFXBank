/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectm3.User;

import com.mycompany.projectm3.Account.Account;

import java.util.ArrayList;

/**
 * Represents a user of the system.
 * @author alumne
 */
public class User {
    private String name;
    private int id;
    private boolean isLocked  = false;
    private String email;
    private ArrayList<Account> accounts;
    private String password;

    /**
     * Creates a new user
     * @param email
     * @param name
     * @param id
     */
    public User(String email, String name, int id) {
        this.email = email;
        this.name = name;
        this.id = id;
        this.accounts = new ArrayList<>();
    }

    /**
     * Sets the password of the user.
     * @param pw
     */
    public void setPassword(String pw){
        this.password = pw;
    }

    /**
     * Creates a new account for the user.
     * @param acc
     */
    public void openAccount(Account acc){
        this.accounts.add(acc);
    }

    /**
     * Closes an account of the user.
     * @param id
     */
    public void closeAccount(int id){
        boolean exists = false;
        for (int i = 0; i < this.accounts.size(); i++){
            if (this.accounts.get(i).getAccountId() == id){
                this.accounts.remove(i);
                break;
            }
        }
    }

    /**
     * Locks the user access.
     */
    public void lock() {
        this.isLocked = true;
    }

    /**
     * Unlocks the user access.
     */
    public void unlock() {
        this.isLocked = false;
    }

    /**
     * Gets the password of the user.
     * @return String password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the name of the user.
     * @return String name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the id of the user.
     * @return int id
     */
    public int getId(){
        return this.id;
    }

    /**
     * Sets the name of the user.
     * @param name String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the accounts of the user.
     * @param accounts ArrayList accounts
     */
    public void setAccounts(ArrayList<Account> accounts)  {
        this.accounts = accounts;
    }
    
    /**
     * Gets the user email
     * @return email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the user email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    

    /**
     * Returns if the user is locked.
     * @return boolean
     */
    public boolean isLocked() {
        return isLocked;
    }

    /**
     * Sets the user locked
     * @param locked locked
     */
    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    /**
     * Returns the accounts of the user.
     * @return ArrayList accounts
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * Returns the string representation of the user.
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%d,%s,%s", this.email, this.name, this.id, this.password, this.isLocked);
    }

    /**
     * Returns if the user is equal to another user object.
     * @param obj User
     * @return boolean
     */
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof User)){
            return false;
        }
        User user = (User) obj;
        return user.getEmail() == this.email || obj == this;
    }
}
