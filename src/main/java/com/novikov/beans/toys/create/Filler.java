package com.novikov.beans.toys.create;

import com.novikov.beans.Toy;

import java.util.ArrayList;

public class Filler {
    public static ArrayList<Toy> fillIn(int money){
        ArrayList<Toy> toys = new ArrayList<>();
        while (money > 0){
            toys.add(Creator.createToy());
            for (Toy t : toys){
                money -= t.getValue();
            }
        }
        return  toys;
    }
}
