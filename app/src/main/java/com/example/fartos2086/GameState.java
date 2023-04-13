package com.example.fartos2086;

import java.io.Serializable;

public class GameState implements Serializable {
    private int cardPosition;
    private String cardName;

    public GameState(int cardPosition, String cardName) {
        this.cardPosition = cardPosition;
        this.cardName = cardName;
    }

    public GameState() {

    }

    public int getCardPosition() {
        return cardPosition;
    }

    public void setCardPosition(int cardPosition) {
        this.cardPosition = cardPosition;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}