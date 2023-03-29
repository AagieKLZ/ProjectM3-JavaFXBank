package com.mycompany.projectm3;

import java.util.ArrayList;

public class CurrentAccount extends Account{
    private ArrayList<Card> cards;
    public void addCard(Card card){
        this.cards.add(card);
    }
    public void deleteCard(Card card){
        this.cards.remove(0);
    }
}
