package com.novikov.beans.rooms;

import com.novikov.beans.Room;

public class AdultRoom extends Room {
    public AdultRoom(int age) {
        super(age);
    }

    public AdultRoom(int money, int age) {
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
