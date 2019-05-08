package com.novikov.beans.rooms;

import com.novikov.beans.Room;
import com.novikov.beans.Toy;

import java.util.List;

public class AdultRoom extends Room {
    public AdultRoom(int age, List<Toy> toys) {
        super(age, toys);
    }

    public AdultRoom(int age, int money) {
        super(money, age);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdultRoom{");
        sb.append("toys=").append(super.getToys());
        sb.append(", age=").append(super.getAge());
        sb.append(", money=").append(super.getMoney());
        sb.append(", ID=").append(super.getID());
        sb.append('}');
        return sb.toString();
    }
}
