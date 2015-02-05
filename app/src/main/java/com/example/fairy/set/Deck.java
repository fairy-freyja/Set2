package com.example.fairy.set;

import java.util.*;


public class Deck {
    private List<Card> deck = new ArrayList<Card>(81);

    public Deck() throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < 81; i++) {
            deck.add(Card.fromInt(i));
        }
    }

    public void shuffle(){
       Collections.shuffle(deck);
    }


    public Card drawCard(){
        Card current = this.deck.get(0);
        this.deck.remove(0);
        return current;
    }

    public int size(){
        return deck.size();
    }

}
