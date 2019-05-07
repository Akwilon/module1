package com.novikov.beans;

import com.novikov.beans.toys.create.Filler;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public abstract class Room  implements Serializable {

    private List<Toy> toys;
    private int age;
    private int money;
    private int ID;

    public Room(int age) {
        setMoney(1000);
        setAge(age);
        toys = Filler.fillIn(this.money);
        this.ID = Math.abs(hashCode());
    }

    public Room(int money, int age) {
        setMoney(money);
        setAge(age);
        toys = Filler.fillIn(this.money);
        this.ID = Math.abs(hashCode());
    }

    public List<? extends Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    public void addToy(Toy toy){
        toys.add(toy);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money > 0) {
            this.money = money;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public int getID() {
        return ID;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (age != room.age) return false;
        if (money != room.money) return false;
        if (ID != room.ID) return false;
        return toys != null ? toys.equals(room.toys) : room.toys == null;

    }

    @Override
    public int hashCode() {
        int result = toys != null ? toys.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + money;
        result = 31 * result + ID;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("toys=").append(toys);
        sb.append(", age=").append(age);
        sb.append(", money=").append(money);
        sb.append(", ID=").append(ID);
        sb.append('}');
        return sb.toString();
    }
}
