package com.novikov.beans.toys.create;

import com.novikov.beans.Color;
import com.novikov.beans.Size;
import com.novikov.beans.Toy;
import com.novikov.beans.toys.Ball;
import com.novikov.beans.toys.Car;
import com.novikov.beans.toys.Cube;
import com.novikov.beans.toys.Doll;

import java.lang.reflect.Array;
import java.util.Random;

public class Creator {
    private static Random random = new Random();
    private static Size size;


    public static Toy createToy() {
        int key = random.nextInt(4);
        switch (key) {
            case 0:
                return new Car(Creator.randomSize(), Creator.randomColor(), Creator.randomPrice(size));
            case 1:
                return new Cube(Creator.randomSize(), Creator.randomColor(), Creator.randomPrice(size));
            case 2:
                return new Doll(Creator.randomSize(), Creator.randomColor(), Creator.randomPrice(size));
            default:
                return new Ball(Creator.randomSize(), Creator.randomColor(), Creator.randomPrice(size));
        }
    }

    private static Size randomSize() {
        int pickSize = random.nextInt(Size.values().length);
        size = Size.values()[pickSize];
        return Size.values()[pickSize];
    }

    private static Color randomColor() {
        int pickColor = random.nextInt(Color.values().length);
        return Color.values()[pickColor];
    }

    private static int randomPrice(Size size) {
        switch (size) {
            case LITTLE:
                return 3;
            case BIG:
                return 7;
            case MIDDLE:
                return 5;
            default:
                return 9;
        }

    }

}
