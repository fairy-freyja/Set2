package com.example.fairy.set;

/**
 * Created by fairy on 06.01.15.
 */
public enum Color implements Property<Color> {
    Red, Green, Violet;

    public static Color complementary(Color one, Color two) {
        return one == two ? one : Color.values()[((one.ordinal() + two.ordinal()) * 2) % 3];
    }


}
