package com.novikov.beans.rooms;

import com.novikov.beans.Room;

public class YoungRoom extends Room {
    public YoungRoom(int age) {
        super(age);
    }

    public YoungRoom(int money, int age) {
        super(money, age);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("YoungRoom{");
        sb.append("toys=").append(super.getToys());
        sb.append(", age=").append(super.getAge());
        sb.append(", money=").append(super.getMoney());
        sb.append(", ID=").append(super.getID());
        sb.append('}');
        return sb.toString();
    }
}
