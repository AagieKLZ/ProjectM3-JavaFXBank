package com.mycompany.projectm3;

import java.util.Date;

public class Card {
    private final long card_number;
    private final int security_number;
    private final Date expiration_date;
    private int PIN;
    private boolean valid = true;

    public Card(int chosenPin){
        PIN = chosenPin;
        security_number = RandomNumberGenerator.generateSecurityNumber();
        card_number = RandomNumberGenerator.generateCardNumber();
        expiration_date = DateCalculator.addYears(1);
    }

    public boolean isValid(){
        boolean validation = DateCalculator.isValid(this.expiration_date);
        this.valid = validation;
        return this.valid;
    }

    public long getCardNumber(){
        return this.card_number;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Card)){
            return false;
        }
        Card c = (Card) obj;
        return c == this || this.card_number == c.getCardNumber();
    }
}
