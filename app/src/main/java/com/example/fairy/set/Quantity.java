package com.example.fairy.set;
/**
 * Created by fairy on 06.01.15.
 */
public enum Quantity implements Property<Quantity> {
    One, Two, Three;
    public static Quantity complementary(Quantity one, Quantity two){
        return one == two ? one : Quantity.values()[((one.ordinal() + two.ordinal()) * 2) % 3];
    }
}
