package com.example.fairy.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fairy on 07.01.15.
 */
public class Field {
    private List<Card> field;

    public Field(List<Card> cards) {
        field = cards;
    }

    public Field(Deck deck) {
        this.field = new ArrayList<Card>(15);
        for (int i = 0; i < 12; i++) {
            field.add(deck.drawCard());
        }
    }

    public void addThreeCards(Deck deck) {
        // а есть ли вообще в колоде три карты?
        // сейчас, если карт в колоде недостаточно метод выкладывает сколько может.

        for (int i = 0; i < 3 && i < deck.size(); i++) {
            field.add(deck.drawCard());
        }
    }

    public void addThreeCards(Deck deck, int[] index) {
        // а есть ли вообще в колоде три карты?
        // сейчас, если карт в колоде недостаточно метод выкладывает сколько может.

        for (int i = 0; i < 3 && i < deck.size() && i < index.length; i++) {
            field.add(index[i], deck.drawCard());
        }
    }

    public void removeTreeCards(int first, int second, int third) {

        int[] idx = {first, second, third};
        Arrays.sort(idx);
        field.remove(idx[2]);
        field.remove(idx[1]);
        field.remove(idx[0]);
    }

    public List<Card> getField() {
        return field;

    }

    public Card getCard(int i) {
        return field.get(i);
    }

    public int size() {
        return field.size();
    }

}
