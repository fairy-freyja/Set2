package com.example.fairy.set;

import java.util.List;

/** генератор кода Ctrl+j
 * Created by fairy on 09.01.15.
 */
public class FieldDrawer {

    public void toConsole(Field f){
        List<Card> field = f.getField();
        Color[] colorArr = new Color[3];
        Fill[] fillArr = new Fill[3];
        Quantity[] quantityArr = new Quantity[3];
        Shape[] shapeArr = new Shape[3];


        for (int i = 0; i < field.size(); i++) {
            Card current  = field.get(i);

            if(i<field.size()) {
                colorArr[i % 3] = current.getColor();
                fillArr[i % 3] = current.getFill();
                quantityArr[i % 3] = current.getQuantity();
                shapeArr[i % 3] = current.getShape();
            }

            if(i%3 == 2) {  // print before each 4 card
                for (int j = 0; j < colorArr.length; j++) {
                    if (colorArr[j] == Color.Red && j == 0){
                        System.out.print("color: " + colorArr[j] + "\t" + "\t" +  "\t" + "| ");
                    } else {
                        System.out.print("color: " + colorArr[j] + "\t" + "\t" + "| ");
                    }
                }
                System.out.println();

                for (int j = 0; j < fillArr.length; j++) {
                    if(fillArr[j]==Fill.Blank) {
                        System.out.print("fill: " + fillArr[j] + "\t" + "\t" + "\t" + "|");
                    } else {
                        System.out.print("fill: " + fillArr[j] + "\t" + "\t" + "|");
                    }
                }
                System.out.println();

                for (int j = 0; j < quantityArr.length; j++) {
                    if(quantityArr[j]==Quantity.Three) {
                        System.out.print("quantity: " + quantityArr[j] + "\t" + "\t" + "|");
                    } else {
                        System.out.print("quantity: " + quantityArr[j] + "\t" + "\t" + "|");

                    }
                }
                System.out.println();

                for (int j = 0; j < shapeArr.length; j++) {
                    if (shapeArr[j]==Shape.Oval){
                        System.out.print("shape: " + shapeArr[j] + "\t" + "\t" + "\t" + "|");
                    } else if (shapeArr[j]==Shape.Diamond){
                        System.out.print("shape: " + shapeArr[j]  + "\t" + "\t" + "|");
                    } else {
                        System.out.print("shape: " + shapeArr[j]  + "\t" + "|");
                    }
                }
                System.out.println();
                System.out.println("___________________________________________________________");
            }



        }
    }
}
