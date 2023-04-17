package com.mycompany.projectm3.Account;

import com.mycompany.projectm3.lib.DateCalculator;
import com.mycompany.projectm3.lib.RandomNumberGenerator;

import java.util.Date;

public class Card {
    private long cardNumber;
    private int securityNumber;
    private Date expirationDate;
    private CurrentAccount account;
    private int PIN;
    private boolean valid = true;

    public Card(int chosenPin, CurrentAccount account){
        this.PIN = chosenPin;
        this.account = account;
        this.securityNumber = RandomNumberGenerator.generateSecurityNumber();
        this.cardNumber = RandomNumberGenerator.generateCardNumber();
        this.expirationDate = DateCalculator.addYears(1);
    }

    public Card(long cardNumber, int securityNumber, Date expirationDate, int PIN, boolean valid) {
        this.cardNumber = cardNumber;
        this.securityNumber = securityNumber;
        this.expirationDate = expirationDate;
        this.PIN = PIN;
        this.valid = valid;
    }

    public void setSecurityNumber(int securityNumber){
        this.securityNumber = securityNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public void setValid(boolean valid) {
        this.valid = this.isValid();
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isValid(){
        boolean validation = DateCalculator.isValid(this.expirationDate);
        this.valid = validation;
        return this.valid;
    }

    public long getCardNumber(){
        return this.cardNumber;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Card)){
            return false;
        }
        Card c = (Card) obj;
        return c == this || this.cardNumber == c.getCardNumber();
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%s,%d,%d", this.cardNumber, this.securityNumber, DateCalculator.timeToString(this.expirationDate), this.PIN, this.account.getAccountId());
    }
}
