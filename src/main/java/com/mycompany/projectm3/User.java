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
    private ArrayList<String> accounts;
    
    public void openAccount(){}
    public void closeAccount(){}
    public void lock() {
        this.isLocked = true;
    }
    public void unlock() {
        this.isLocked = false;
    }
}
