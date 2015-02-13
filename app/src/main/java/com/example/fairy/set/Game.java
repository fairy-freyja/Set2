package com.example.fairy.set;

import java.io.IOException;
import java.util.*;

/**
 * Created by fairy on 09.01.15.
 */
public class Game {

    private Deck deck;
    private Field field;


    public Game() throws NoSuchFieldException, IllegalAccessException {
        deck = new Deck();
        deck.shuffle();
        field = new Field(deck);
    }


    public static int findNumberSet(Field field) {
        List<Card> cards = field.getField();

        int result = 0;
        for (int i = 0; i < cards.size(); i++) {
            Card first = cards.get(i);
            for (int j = 0; j < cards.size(); j++) {
                if (j == i) {
                    continue;
                }
                Card second = cards.get(j);
                for (int k = 0; k < cards.size(); k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    Card third = cards.get(k);
                    if (isSet(first, second, third)) {
                        result++;
                    }
                }
            }
        }

        return result / 6;

    }

    public static Card needForSet(Card first, Card second) throws NoSuchFieldException, IllegalAccessException {
        return new Card(Color.complementary(first.getColor(), second.getColor()), Fill.complementary(first.getFill(), second.getFill()), Quantity.complementary(first.getQuantity(), second.getQuantity()), Shape.complementary(first.getShape(), second.getShape()));
    }

    public static boolean isSet(Card first, Card second, Card third) {
        boolean colorSet = canBeSet(first.getColor(), second.getColor(), third.getColor());
        boolean shapeSet = canBeSet(first.getShape(), second.getShape(), third.getShape());
        boolean fillSet = canBeSet(first.getFill(), second.getFill(), third.getFill());
        boolean quantitySet = canBeSet(first.getQuantity(), second.getQuantity(), third.getQuantity());

        return colorSet && shapeSet && fillSet && quantitySet;
    }

    private static <T extends Property<T>> boolean canBeSet(T p1, T p2, T p3) {
        return (p1 == p2 && p1 == p3) || (p1 != p2 && p1 != p3 && p2 != p3);
    }


    public void makeStep(List<Card> cards) {
        int[] indexCardsinSet = {field.getField().indexOf(cards.get(0)), field.getField().indexOf(cards.get(1)), field.getField().indexOf(cards.get(2))};
        field.removeTreeCards(indexCardsinSet[0], indexCardsinSet[1], indexCardsinSet[2]);
        if (field.getField().size() == 9) {
            field.addThreeCards(deck, indexCardsinSet);
        }
    }

    public void addThreeCards() {
        field.addThreeCards(deck);
    }

    public Card getCardFromField(int i) {
        return field.getCard(i);
    }

    public Deck getDeck() {
        return deck;
    }

    public Field getField() {
        return field;
    }

    public int deckSize(){
        return deck.size();
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Deck deck = new Deck();
        //    deck.shuffle();
        Field field = new Field(deck);
        FieldDrawer fieldDrawer = new FieldDrawer();
        fieldDrawer.toConsole(field);

        System.out.println(findNumberSet(field));

        // надо написать тест для метода isSet
        boolean setTrue = false;
        while (!setTrue) {
            Scanner sc = new Scanner(System.in);
            int first = sc.nextInt();
            int second = sc.nextInt();
            int third = sc.nextInt();


            setTrue = isSet(field.getField().get(first), field.getField().get(second), field.getField().get(third));
            System.out.println("your set is " + setTrue);
            if (setTrue) {
                field.removeTreeCards(first, second, third);
            }
        }

        field.addThreeCards(deck);
        fieldDrawer.toConsole(field);
        System.out.println(findNumberSet(field));


    }

}
