package com.mycompany.projectm3.Account;

import java.util.ArrayList;

public class CurrentAccount extends Account {
    private ArrayList<Card> cards;
    public void addCard(Card card){
        this.cards.add(card);
    }
    public void deleteCard(Card card){
        for (int i = 0; i <
        this.cards.size(); i++){
            if (this.cards.get(i).equals(card)){
                this.cards.remove(i);
                break;
            }
        }
    }
}
