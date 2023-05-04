package com.mycompany.projectm3.Account;

import com.mycompany.projectm3.FileReader.AccountFileReader;
import com.mycompany.projectm3.lib.DateCalculator;
import com.mycompany.projectm3.lib.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Carlos Carpio
 * Represents a card that can be used to access an account
 */
public class Card {
    private long cardNumber;
    private int securityNumber;
    private Date expirationDate;
    private Account account;
    private int PIN;
    private int acc_id;
    private boolean valid = true;

    /**
     * Creates a new card with a random card number and security number. The expiration date is set to one year from the current date. The card is linked to the account that is passed in.
     * @param chosenPin the PIN that the user wants to use
     * @param account the account that the card will be linked to
     */
    public Card(int chosenPin, CurrentAccount account){
        this.PIN = chosenPin;
        this.account = account;
        this.securityNumber = RandomNumberGenerator.generateSecurityNumber();
        this.cardNumber = RandomNumberGenerator.generateCardNumber();
        this.expirationDate = DateCalculator.addYears(1);
        this.acc_id = account.getAccountId();
    }

    /**
     * Constructor for a card that is being loaded from a file
     * @param cardNumber
     * @param securityNumber
     * @param expirationDate
     * @param PIN
     * @param acc_id
     */
    public Card(long cardNumber, int securityNumber, Date expirationDate, int PIN, int acc_id) {
        this.cardNumber = cardNumber;
        this.securityNumber = securityNumber;
        this.expirationDate = expirationDate;
        this.PIN = PIN;
        this.acc_id = acc_id;
        this.valid = this.isValid();
        ArrayList<Account> accounts = new AccountFileReader().readLines();
        for (Account account : accounts){
            if (account.getAccountId() == acc_id){
                this.account = account;
            }
        }
    }

    /**
     * Returns the id of the account that the card is linked to
     * @return the id of the account that the card is linked to
     */
    public int getAcc_id() {
        return acc_id;
    }


    /**
     * Sets the PIN of the card
     * @param PIN the PIN that the user wants to use
     */
    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    /**
     * Returns the security number of the card
     * @return the security number of the card
     */
    public int getSecurityNumber() {
        return securityNumber;
    }

    /**
     * Sets the validity of the card
     * @param valid true if the card is valid, false otherwise
     */
    public void setValid(boolean valid) {
        this.valid = this.isValid();
    }

    /**
     * Sets the expiration date of the card
     * @param expirationDate the expiration date of the card
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Checks if the card is valid by checking if the expiration date is valid
     * @return true if the card is valid, false otherwise
     */
    public boolean isValid(){
        boolean validation = DateCalculator.isValid(this.expirationDate);
        this.valid = validation;
        return this.valid;
    }

    /**
     * Returns the expiration date of the card
     * @return the expiration date of the card
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Returns the card number
     * @return the card number
     */
    public long getCardNumber(){
        return this.cardNumber;
    }

    /**
     * Equals method for a card
     * @param obj
     * @return true if the card numbers are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Card)){
            return false;
        }
        Card c = (Card) obj;
        return c == this || this.cardNumber == c.getCardNumber();
    }

    /**
     * Returns a string representation of the card to be saved in a file
     * @return a string representation of the card
     */
    @Override
    public String toString() {
        if (this.account == null){
            return String.format("%d,%d,%s,%d,%d", this.cardNumber, this.securityNumber, DateCalculator.timeToString(this.expirationDate), this.PIN, 0);
        }
        return String.format("%d,%d,%s,%d,%d", this.cardNumber, this.securityNumber, DateCalculator.timeToString(this.expirationDate), this.PIN, this.account.getAccountId());
    }

    /**
     * Returns the account that the card is linked to
     * @return the account that the card is linked to
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Returns the PIN of the card
     * @return the PIN of the card
     */
    public int getPIN() {
        return PIN;
    }

    /**
     * Sets the account that the card is linked to
     * @param account the account that the card is linked to
     */
    public void setAccount(CurrentAccount account) {
        this.account = account;
    }
}
