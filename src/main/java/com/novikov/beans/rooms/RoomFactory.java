package com.novikov.beans.rooms;

import com.novikov.beans.Room;
import com.novikov.beans.Toy;

import java.util.List;

public class RoomFactory {
    private final static RoomFactory instance = new RoomFactory();

    private RoomFactory() {
    }




    public static Room createRoom(int age, int money) {
        Room res;
        if (age < 18) {
        res = new YoungRoom(age, money);
        return res;
        } else {
            res = new AdultRoom(age,money);
            return res;
        }
    }

    public static Room createRoom(int age, List<Toy> toys) {
        Room res;
        if (age < 18) {
            res = new YoungRoom(age,toys);
            return res;
        } else {
            res = new AdultRoom(age,toys);
            return res;
        }
    }


}
