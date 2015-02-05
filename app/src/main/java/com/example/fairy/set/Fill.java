package com.example.fairy.set;
/**
 * Created by fairy on 06.01.15.
 */
public enum Fill implements Property<Fill> {
    Blank, Stroke, Filled;
    public static Fill complementary(Fill one, Fill two){
        return one == two ? one : Fill.values()[((one.ordinal() + two.ordinal()) * 2) % 3];
    }
}
