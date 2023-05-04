package com.mycompany.projectm3.ATM;

import com.mycompany.projectm3.Account.*;
import com.mycompany.projectm3.Bills.ATMBillManager;
import com.mycompany.projectm3.Operation.Operation;
import com.mycompany.projectm3.Operation.OperationManager;
import com.mycompany.projectm3.User.User;
import com.mycompany.projectm3.User.UserManager;

import java.util.ArrayList;

/**
 * Main class of the ATM package. It contains all the managers and the user that is logged in.
 */
public class ATM {
    public ATMBillManager billManager;
    public OperationManager oppManager;
    public AccountManager accManager;
    public UserManager userManager;
    public CardManager cardManager;
    User user = null;

    /**
     * Constructor of the ATM class. It creates all the managers and assigns the cards and operations to the accounts after they're read from file.
     */
    public ATM(){
        this.billManager = new ATMBillManager();
        this.user = null;
        this.oppManager = new OperationManager();
        this.accManager = new AccountManager();
        this.userManager = new UserManager();
        this.cardManager = new CardManager();
        assignCards();
        assignOperations();
    }

    /**
     * Assigns the cards to the accounts after they're read from file.
     */
    private void assignCards() {
        ArrayList<Card> cards = this.cardManager.getCards();
        for (Account acc : this.accManager.getAccountList()) {
            if (acc instanceof CurrentAccount) {
                for (Card card : cards) {
                    if (card.getAcc_id() == acc.getAccountId()) {
                        ((CurrentAccount) acc).addCard(card);
                    }
                }
            }
        }
    }

    /**
     * Assigns the operations to the accounts after they're read from file.
     */
    private void assignOperations(){
        ArrayList<Operation> operations = this.oppManager.getOperations();
        for (Account acc : this.accManager.getAccountList()) {
            for (Operation operation : operations) {
                if (operation.belongs(acc)) {
                    acc.addOperation(operation);
                }
            }
        }
    }

    /**
     * Getter for the user.
     * @return The user that is logged in.
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for the user.
     * @param user The user that is logged in.
     */
    public void setUser(User user) {
        this.user = user;
    }
}
