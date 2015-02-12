package com.example.fairy.set;

/**
 * Created by fairy on 06.01.15.
 */
public class Card {
    private Color color;
    private Fill fill;
    private Quantity quantity;
    private Shape shape;
    private String pictureLink;

    public Card(Color color, Fill fill, Quantity quantity, Shape shape) {
        this.color = color;
        this.fill = fill;
        this.quantity = quantity;
        this.shape = shape;
//        try {
        pictureLink = setPictureLink();
//        } catch (Exception e){
//            System.out.println("IN CARD CLASS OLOLO" + e.getMessage());
//        }
    }


    public static Card fromInt(int num) throws NoSuchFieldException, IllegalAccessException {
        int colorCode = num % 3;
        Color color = null;
        if (colorCode == 0) {
            color = Color.Green;
        } else if (colorCode == 1) {
            color = Color.Red;
        } else {
            color = Color.Violet;
        }
        num = num / 3;

        int fillCode = num % 3;
        Fill fill = null;
        if (fillCode == 0) {
            fill = fill.Blank;
        } else if (fillCode == 1) {
            fill = fill.Stroke;
        } else if (fillCode == 2) {
            fill = fill.Filled;
        }
        num = num / 3;

        int quantityCode = num % 3;
        Quantity quantity = null;
        if (quantityCode == 0) {
            quantity = Quantity.One;
        } else if (quantityCode == 1) {
            quantity = Quantity.Two;
        } else if (quantityCode == 2) {
            quantity = Quantity.Three;
        }
        num = num / 3;

        int shapeCode = num % 3;
        Shape shape = null;
        if (shapeCode == 0) {
            shape = Shape.Oval;
        } else if (shapeCode == 1) {
            shape = Shape.Diamond;
        } else if (shapeCode == 2) {
            shape = Shape.Squiggles;
        }

        return new Card(color, fill, quantity, shape);
    }

    public Color getColor() {
        return color;
    }

    public Fill getFill() {
        return fill;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Shape getShape() {
        return shape;
    }

    public String getPicLink() {
        return pictureLink;
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != Card.class) {
            return false;
        }
        Card otherCard = (Card) other;

        return color == otherCard.color && shape == otherCard.shape && quantity == otherCard.quantity && fill == otherCard.fill;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s:%s", color, shape, quantity, fill);
    }


    public String setPictureLink() {
        String result;
        result = this.getColor().toString().toLowerCase() + "_" + this.getShape().toString().toLowerCase() + "_" + this.getFill().toString().toLowerCase() + "_" + this.getQuantity().toString().toLowerCase();
        return result;
    }


}
