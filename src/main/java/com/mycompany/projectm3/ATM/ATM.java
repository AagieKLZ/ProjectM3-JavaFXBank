package com.mycompany.projectm3.ATM;

import com.mycompany.projectm3.Account.*;
import com.mycompany.projectm3.Bills.ATMBillManager;
import com.mycompany.projectm3.Operation.Operation;
import com.mycompany.projectm3.Operation.OperationManager;
import com.mycompany.projectm3.User.User;
import com.mycompany.projectm3.User.UserManager;

import java.util.ArrayList;

public class ATM {
    public ATMBillManager billManager;
    public OperationManager oppManager;
    public AccountManager accManager;
    public UserManager userManager;
    public CardManager cardManager;
    User user = null;

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

    private void assignOperations(){
        ArrayList<Operation> operations = this.oppManager.getOperations();
        System.out.println(operations);
        for (Account acc : this.accManager.getAccountList()) {
            for (Operation operation : operations) {
                if (operation.belongs(acc)) {
                    acc.addOperation(operation);
                }
            }
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
