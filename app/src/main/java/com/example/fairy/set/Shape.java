package com.example.fairy.set;
/**
 * Created by fairy on 06.01.15.
 */
public enum Shape implements Property<Shape> {
    Oval, Squiggles, Diamond;
    public static Shape complementary(Shape one, Shape two){
        return one == two ? one : Shape.values()[((one.ordinal() + two.ordinal()) * 2) % 3];
    }
}
